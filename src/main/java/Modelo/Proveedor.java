/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.util.List;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author yumii
 */
public class Proveedor {
    private ObjectId id;
    private String nombre, telefono;
    
    public Proveedor() {}

    public Proveedor(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public Proveedor(ObjectId id, String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public boolean registrarProveedor (String nombre, String telefono, MongoClient cliente){
        
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Proveedor");

        Document proveedor = new Document("Nombre", nombre)
                                .append("Telefono", telefono);

        InsertOneResult result = coleccion.insertOne(proveedor);
        return !result.toString().isEmpty();
        
    }
    
    public boolean modificarProveedor(ObjectId id, String nombre, String telefono, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Proveedor");

        Document filtro = new Document("_id", id);
        Document datosActualizar = new Document("Nombre", nombre).append("Telefono", telefono);
        Document updateDocumento = new Document("$set", datosActualizar);

        UpdateResult result = coleccion.updateOne(filtro, updateDocumento);
        return !result.toString().isEmpty();
        

    }
    
    public boolean eliminarProveedor(ObjectId id, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Proveedor");

        Document filtro = new Document("_id", id);

        
        DeleteResult result = coleccion.deleteOne(filtro);
        return !result.toString().isEmpty();
    }
    
    public List<Proveedor> getListaProveedores(MongoClient cliente) {
        List<Proveedor> listaProveedores;

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Proveedor");

        FindIterable<Document> iterable = coleccion.find();
        listaProveedores = new ArrayList<>();

        for (Document documento : iterable) {
            ObjectId idProveedor = documento.getObjectId("_id");
            String nombreProveedor = documento.getString("Nombre");
            String telefonoProveedor = documento.getString("Telefono");

            Proveedor proveedor = new Proveedor(idProveedor, nombreProveedor, telefonoProveedor);
            listaProveedores.add(proveedor);
        }

        return listaProveedores;
    }
    
}
