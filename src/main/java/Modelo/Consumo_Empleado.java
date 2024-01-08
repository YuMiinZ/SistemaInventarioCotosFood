/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
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
    
    
    public void Nuevo_Consumo_Empleado(ObjectId ID_Comanda, ObjectId ID_Empleado, String Estado){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Empleado");

        Document Consumo_Empleado = new Document("ID_Empleado", ID_Empleado)
                            .append("Estado", Estado)
                            .append("ID_Comanda", ID_Comanda);

        coleccion.insertOne(Consumo_Empleado);
        conexion.cerrarConexion(cliente);
    }
    
    public List<Consumo_Empleado> ConsumoEmpleadoEspecifico(ObjectId idEmpleado){
        List<Consumo_Empleado> consumo = new ArrayList();
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Empleado");
        FindIterable<Document> iterable = coleccion.find(eq("ID_Empleado", idEmpleado));
        
        for (Document documento: iterable){
            Consumo_Empleado comanda = new Consumo_Empleado(documento.getObjectId("_id"), documento.getObjectId("ID_Comanda"),  documento.getObjectId("ID_Empleado"), documento.getString("Estado"), documento.getDouble("MontoTotal"));
            consumo.add(comanda);
        }
        
        conexion.cerrarConexion(cliente);
        return consumo;
    }
}
