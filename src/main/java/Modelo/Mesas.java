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
import com.mongodb.client.result.InsertOneResult;
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
    
    public boolean CrearMesa(int Numero, MongoClient cliente){
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Mesa");
        
        Document Mesa = new Document("Numero_Mesa", Numero);
        
        InsertOneResult result = coleccion.insertOne(Mesa);
        return !result.toString().isEmpty();
    }
    
    public List<Mesas> TodasMesas(MongoClient cliente){
        List<Mesas> Tmesas = new ArrayList();
        
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Mesa");
        FindIterable<Document> iterable = coleccion.find();

        for (Document documento: iterable){
            Mesas mesa = new Mesas(documento.getObjectId("_id"), documento.getInteger("Numero_Mesa"));
            Tmesas.add(mesa);
            
        }
        return Tmesas;
    }
    
    public Mesas MesaEspecifica(ObjectId id, MongoClient cliente){
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Mesa");
        
        Document doc = coleccion.find(eq("_id", id)).first();
        Mesas mesa = new Mesas(doc.getObjectId("_id"), doc.getInteger("Numero_Mesa"));        
        return mesa;
        
    }
}
