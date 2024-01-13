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
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author TomasPC
 */
public class Comanda {
    private ObjectId id;
    private List <String> Platillos_Bebida;
    private String Notes;
    private Double Monto;

    public Comanda(List<String> Platillos_Bebida, String Notes, Double Monto){
        this.Platillos_Bebida = Platillos_Bebida;
        this.Notes = Notes;
        this.Monto = Monto;
    }


    public Comanda(ObjectId id, List<String> Platillos_Bebida, String Notes, Double Monto) {
        this.id = id;
        this.Platillos_Bebida = Platillos_Bebida;
        this.Notes = Notes;
        this.Monto = Monto;
    }

    public Comanda(){}

    public List<String> getPlatillos_Bebida() {
        return Platillos_Bebida;
    }

    public String getNotes() {
        return Notes;
    }

    public Double getMonto() {
        return Monto;
    }

    public ObjectId getId() {
        return id;
    }
    
    public Comanda BuscarComanda(ObjectId id, MongoClient cliente){
        
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Comanda");

        Document doc = coleccion.find(eq("_id", id)).first();    
        Comanda comanda = new Comanda(doc.getObjectId("_id"), doc.getList("ListaProductosConsumo", String.class), doc.getString("Notas"), doc.getDouble("Monto"));
        
        return comanda;
    }
    
    public Comanda UltimaComanda(MongoClient cliente){
        List<Comanda> Comandas = new ArrayList<>();
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Comanda");

        FindIterable<Document> documento = coleccion.find();
        for (Document doc : documento){
            Comanda comanda = new Comanda(doc.getObjectId("_id"), doc.getList("ListaProductosConsumo", String.class), doc.getString("Notas"), doc.getDouble("Monto"));
            Comandas.add(comanda);
        }
        
        return Comandas.get(Comandas.size()-1);
    }

    public boolean RegistrarComanda(double Monto, List<String> Platillos_Bebida, String Notes, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Comanda");

        Document Comanda = new Document("ListaProductosConsumo", Platillos_Bebida)
                            .append("Notas", Notes)
                            .append("Monto", Monto);

        InsertOneResult result = coleccion.insertOne(Comanda);
        return !result.toString().isEmpty();
    }

    public boolean eliminarComanda(ObjectId id,  MongoClient cliente){
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Comanda");

        Document filtro = new Document("_id", id);
        DeleteResult result = coleccion.deleteOne(filtro);
        return !result.toString().isEmpty();
    }
}
