/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

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
    
    public Comanda BuscarComanda(ObjectId id){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Comanda");

        Document doc = coleccion.find(eq("_id", id)).first();    
        Comanda comanda = new Comanda(doc.getObjectId("_id"), doc.getList("ListaProductosConsumo", String.class), doc.getString("Notas"), doc.getDouble("Monto"));
        conexion.cerrarConexion(cliente);

        return comanda;
    }

    // TODO: Agregar Monto
    public void RegistrarComanda(List<String> Platillos_Bebida, String Notes){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Comanda");

        Document Comanda = new Document("ID_Platillos_Bebida", Platillos_Bebida)
                            .append("Notas", Notes);

        coleccion.insertOne(Comanda);
        conexion.cerrarConexion(cliente);
    }

    public void eliminarComanda(ObjectId id){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Comanda");

        Document filtro = new Document("_id", id);
        coleccion.deleteOne(filtro);

        conexion.cerrarConexion(cliente);
    }
}
