/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author TomasPC
 */
public class Consumo_Empleado {
    private ObjectId id;
    private ObjectId ID_Comanda;
    private ObjectId ID_Empleado;
    private String Estado;
    private double MontoTotal;
    
    
    public Consumo_Empleado(){}
    
    public Consumo_Empleado(ObjectId ID_Comanda, ObjectId ID_Empleado, String Estado, double MontoTotal){
        this.ID_Comanda = ID_Comanda;
        this.ID_Empleado = ID_Empleado;
        this.Estado = Estado;
        this.MontoTotal = MontoTotal;
    }
    
    public Consumo_Empleado(ObjectId id, ObjectId ID_Comanda, ObjectId ID_Empleado, String Estado, double MontoTotal){
        this.id = id;
        this.ID_Comanda = ID_Comanda;
        this.ID_Empleado = ID_Empleado;
        this.Estado = Estado;
        this.MontoTotal = MontoTotal;
    }

    public ObjectId getID_Comanda() {
        return ID_Comanda;
    }

    public double getMontoTotal() {
        return MontoTotal;
    }

    public ObjectId getID_Empleado() {
        return ID_Empleado;
    }
    
    
    public boolean Nuevo_Consumo_Empleado(ObjectId ID_Comanda, ObjectId ID_Empleado, double Monto, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Empleado");

        Document Consumo_Empleado = new Document("ID_Empleado", ID_Empleado)
                            .append("Estado", "Sin Pagar")
                            .append("ID_Comanda", ID_Comanda)
                            .append("MontoTotal", Monto);

        InsertOneResult result =  coleccion.insertOne(Consumo_Empleado);
        return !result.toString().isEmpty();
    }
    
    public boolean ModificarConsumoEmpelado(ObjectId ID_Comanda, ObjectId ID_empleado, Double Monto, String Texto, MongoClient cliente){


        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Empleado");
        
        
        Document filtro = new Document("ID_Comanda", ID_Comanda);
        Document Consumo_Cliente = new Document("ID_Empleado", ID_empleado)
                            .append("Estado", Texto)
                            .append("ID_Comanda", ID_Comanda)
                            .append("MontoTotal", Monto);
        
        Document updateDocumento = new Document("$set", Consumo_Cliente);
        UpdateResult result = coleccion.updateOne(filtro, updateDocumento);
        return !result.toString().isEmpty();
    }
    
    public Consumo_Empleado ConsumoEspecifico(ObjectId id_consumo, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Empleado");
        Bson filter = Filters.and(Filters.eq("_id", id_consumo));
        Document documento = coleccion.find(filter).first();
        Consumo_Empleado comanda = new Consumo_Empleado(documento.getObjectId("_id"), documento.getObjectId("ID_Comanda"),  documento.getObjectId("ID_Empleado"), documento.getString("Estado"), documento.getDouble("MontoTotal"));
        return comanda;
    }
    
    public List<Consumo_Empleado> ConsumoEmpleadoEspecifico(ObjectId idEmpleado, MongoClient cliente){
        List<Consumo_Empleado> consumo = new ArrayList();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Empleado");
        Bson filter = Filters.and(Filters.eq("ID_Empleado", idEmpleado), Filters.eq("Estado", "Sin Pagar"));
        FindIterable<Document> iterable = coleccion.find(filter);
        
        for (Document documento: iterable){
            Consumo_Empleado comanda = new Consumo_Empleado(documento.getObjectId("_id"), documento.getObjectId("ID_Comanda"),  documento.getObjectId("ID_Empleado"), documento.getString("Estado"), documento.getDouble("MontoTotal"));
            consumo.add(comanda);
        }
        
        return consumo;
    }
    
    public boolean eliminar(ObjectId idEmpleado, ObjectId idComanda, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Empleado");

        Bson filter = Filters.and(Filters.eq("ID_Empleado", idEmpleado), Filters.eq("ID_Comanda", idComanda));
        DeleteResult result = coleccion.deleteOne(filter);
        return !result.toString().isEmpty();

    }
}
