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
public class Mesas {
    private ObjectId id;
    private int NumeroMesa;
    
    public Mesas() {}   
    
    public Mesas(int Numero){
        this.NumeroMesa = Numero;
    }    

    public int getNumeroMesa() {
        return NumeroMesa;
    }

    public ObjectId getId() {
        return id;
    }
    
    public Mesas(ObjectId id, int Numero){
        this.id = id;
        this.NumeroMesa = Numero;
    }
    
    public void CrearMesa(int Numero){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Mesa");
        
        Document Mesa = new Document("Numero_Mesa", Numero);
        
        coleccion.insertOne(Mesa);
        conexion.cerrarConexion(cliente);
    }
    
    public List<Mesas> TodasMesas(){
        List<Mesas> Tmesas = new ArrayList();
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Mesa");
        FindIterable<Document> iterable = coleccion.find();

        for (Document documento: iterable){
            Mesas mesa = new Mesas(documento.getObjectId("_id"), documento.getInteger("Numero_Mesa"));
            Tmesas.add(mesa);
            
        }
        conexion.cerrarConexion(cliente);
        return Tmesas;
    }
    
    public Mesas MesaEspecifica(ObjectId id){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Mesa");
        
        Document doc = coleccion.find(eq("_id", id)).first();
        Mesas mesa = new Mesas(doc.getObjectId("_id"), doc.getInteger("Numero_Mesa"));
        conexion.cerrarConexion(cliente);
        
        return mesa;
        
    }
}
