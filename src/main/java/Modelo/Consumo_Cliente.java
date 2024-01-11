/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author TomasPC
 */
public class Consumo_Cliente {
    private ObjectId id;
    private ObjectId ID_Comanda;
    private ObjectId ID_Mesa;
    private String Estado;
    private double monto;
    private Date fecha;
    
    public Consumo_Cliente(){}

    public Consumo_Cliente(ObjectId ID_Comanda, ObjectId ID_Mesa, String Estado, double monto, Date fecha){
        this.ID_Comanda = ID_Comanda;
        this.ID_Mesa = ID_Mesa;
        this.Estado = Estado;
        this.monto = monto;
        this.fecha = fecha;
    }
    
    public Consumo_Cliente(ObjectId id, ObjectId ID_Comanda, ObjectId ID_Mesa, String Estado, double monto, Date fecha){
        this.id = id;
        this.ID_Comanda = ID_Comanda;
        this.ID_Mesa = ID_Mesa;
        this.Estado = Estado;
        this.monto = monto;
        this.fecha = fecha;
    }

    public ObjectId getID_Comanda() {
        return ID_Comanda;
    }

    public ObjectId getID_Mesa() {
        return ID_Mesa;
    }

    public double getMonto() {
        return monto;
    }
    
    public void NuevaCompra(ObjectId ID_Comanda, ObjectId ID_Mesa, Double Monto, Date fecha){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Cliente");

        Document Consumo_Cliente = new Document("ID_Comanda", ID_Comanda)
                            .append("ID_Mesa", ID_Mesa)
                            .append("Estado", "Sin Pagar")
                            .append("MontoTotal", Monto)
                            .append("Fecha", fecha);

        coleccion.insertOne(Consumo_Cliente);
        conexion.cerrarConexion(cliente);
    }
    
    
    public List<Consumo_Cliente> ConsumoClienteEspecifico(ObjectId idMesa){
        List<Consumo_Cliente> consumo = new ArrayList();
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Cliente");
        Bson filter = Filters.and(Filters.eq("ID_Mesa", idMesa), Filters.eq("Estado", "Sin Pagar"));
        FindIterable<Document> iterable = coleccion.find(filter);
        
        for (Document documento: iterable){
            Consumo_Cliente comanda = new Consumo_Cliente(documento.getObjectId("_id"), documento.getObjectId("ID_Comanda"),  documento.getObjectId("ID_Mesa"), documento.getString("Estado"), documento.getDouble("MontoTotal"), documento.getDate("Fecha"));
            consumo.add(comanda);
        }
        conexion.cerrarConexion(cliente);
        return consumo;
    }
    public List<Consumo_Cliente> ReporteVentas(Date fechaI, Date fechaF){
        List<Consumo_Cliente> consumo = new ArrayList();
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Cliente");
        AggregateIterable<Document> iterable = coleccion.aggregate(Arrays.asList(new Document("$match", 
                                                                                new Document("$and", Arrays.asList(
                                                                                new Document("Fecha", new Document("$gte", fechaI).append("$lte", fechaF)),
                                                                                new Document("Estado", "Pagado"))))));
        
        for (Document documento: iterable){
            Consumo_Cliente comanda = new Consumo_Cliente(documento.getObjectId("_id"), documento.getObjectId("ID_Comanda"),  documento.getObjectId("ID_Mesa"), documento.getString("Estado"), documento.getDouble("MontoTotal"), documento.getDate("Fecha"));
            consumo.add(comanda);
        }
        conexion.cerrarConexion(cliente);
        return consumo;
    }
}
