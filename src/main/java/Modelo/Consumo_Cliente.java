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
public class Consumo_Cliente {
    private ObjectId id;
    private ObjectId ID_Comanda;
    private ObjectId ID_Mesa;

    public Consumo_Cliente(ObjectId ID_Comanda, ObjectId ID_Mesa){
        this.ID_Comanda = ID_Comanda;
        this.ID_Mesa = ID_Mesa;
    }
    
    public Consumo_Cliente(ObjectId id, ObjectId ID_Comanda, ObjectId ID_Mesa){
        this.id = id;
        this.ID_Comanda = ID_Comanda;
        this.ID_Mesa = ID_Mesa;
    }
    
    public void NuevaCompra(ObjectId ID_Comanda, ObjectId ID_Mesa){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Cliente");

        Document Consumo_Cliente = new Document("ID_Comanda", ID_Comanda)
                            .append("ID_Mesa", ID_Mesa);

        coleccion.insertOne(Consumo_Cliente);
        conexion.cerrarConexion(cliente);
    }
    
    
    public List<Consumo_Cliente> ConsumoClienteEspecifico(ObjectId idMesa){
        List<Consumo_Cliente> consumo = new ArrayList();
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Cliente");
        FindIterable<Document> iterable = coleccion.find(eq("ID_Mesa", idMesa));
        
        for (Document documento: iterable){
            Consumo_Cliente comanda = new Consumo_Cliente(documento.getObjectId("_id"), documento.getObjectId("ID_Comanda"),  documento.getObjectId("ID_Mesa"));
            consumo.add(comanda);
        }
        conexion.cerrarConexion(cliente);
        return consumo;
    }
}
