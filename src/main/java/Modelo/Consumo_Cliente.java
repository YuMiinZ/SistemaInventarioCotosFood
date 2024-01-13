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
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
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
    private ProductoMenu producto = new ProductoMenu();
    private ProductoInventario ingrediente = new ProductoInventario();
    
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

    public ObjectId getId() {
        return id;
    }

    public String getEstado() {
        return Estado;
    }

    public Date getFecha() {
        return fecha;
    }
    
    public boolean NuevaCompra(ObjectId ID_Comanda, ObjectId ID_Mesa, Double Monto, Date fecha, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Cliente");

        Document Consumo_Cliente = new Document("ID_Comanda", ID_Comanda)
                            .append("ID_Mesa", ID_Mesa)
                            .append("Estado", "Sin Pagar")
                            .append("MontoTotal", Monto)
                            .append("Fecha", fecha);
        InsertOneResult result = coleccion.insertOne(Consumo_Cliente);
        return !result.toString().isEmpty();
    }
    
    public boolean ModificarConsumo(ObjectId id, ObjectId ID_Comanda, ObjectId ID_Mesa, Double Monto, Date fecha, String Texto, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Cliente");
        
        
        Document filtro = new Document("_id", id);
        Document Consumo_Cliente = new Document("ID_Comanda", ID_Comanda)
                            .append("ID_Mesa", ID_Mesa)
                            .append("Estado", Texto)
                            .append("MontoTotal", Monto)
                            .append("Fecha", fecha);

        
        Document updateDocumento = new Document("$set", Consumo_Cliente);
        UpdateResult result = coleccion.updateOne(filtro, updateDocumento);
        return !result.toString().isEmpty();
    }
    
    public boolean eliminar(ObjectId idMesa, ObjectId idComanda, MongoClient cliente){
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Cliente");

        Bson filter = Filters.and(Filters.eq("ID_Mesa", idMesa), Filters.eq("ID_Comanda", idComanda));
        DeleteResult result =  coleccion.deleteOne(filter);
        return !result.toString().isEmpty();
    }
    public Consumo_Cliente ConsumoCliente(ObjectId idConsumo, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Cliente");
        Bson filter = Filters.and(Filters.eq("_id", idConsumo));
        Document documento = coleccion.find(filter).first();
        Consumo_Cliente comanda = new Consumo_Cliente(documento.getObjectId("_id"), documento.getObjectId("ID_Comanda"),  documento.getObjectId("ID_Mesa"), documento.getString("Estado"), documento.getDouble("MontoTotal"), documento.getDate("Fecha"));

        
        return comanda;
    }
    
    public List<Consumo_Cliente> ConsumoClienteEspecifico(ObjectId idMesa, MongoClient cliente){
        List<Consumo_Cliente> consumo = new ArrayList();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Consumo_Cliente");
        Bson filter = Filters.and(Filters.eq("ID_Mesa", idMesa), Filters.eq("Estado", "Sin Pagar"));
        FindIterable<Document> iterable = coleccion.find(filter);
        
        for (Document documento: iterable){
            Consumo_Cliente comanda = new Consumo_Cliente(documento.getObjectId("_id"), documento.getObjectId("ID_Comanda"),  documento.getObjectId("ID_Mesa"), documento.getString("Estado"), documento.getDouble("MontoTotal"), documento.getDate("Fecha"));
            consumo.add(comanda);
        }
        return consumo;
    }
    
    public List<Consumo_Cliente> ReporteVentas(Date fechaI, Date fechaF, MongoClient cliente){
        List<Consumo_Cliente> consumo = new ArrayList();

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
        return consumo;
    }
    
    public boolean Pagar(ObjectId cuenta, String opcion, MongoClient cliente){
        boolean result = false;
        String Id = null;
        switch (opcion){
            case "Consumo_Cliente" -> Id = "ID_Mesa";
            case "Consumo_Empleado" -> Id = "ID_Empleado";
            default -> {break;}
        }
        ProductoMenu platillos; 
        ProductoInventario IngredienteP;
        Consumo_Empleado empleado;
        Consumo_Cliente consumo;

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection(opcion);
        AggregateIterable<Document> iterable = coleccion.aggregate(Arrays.asList(new Document("$match",
                                                                                 new Document(Id, cuenta)),                   // Aqui va el id de la mesa o del empleado
                                                                                 new Document("$lookup", 
                                                                                 new Document("from", "Comanda").append("localField", "ID_Comanda").append("foreignField", "_id").append("as","comandaInfo")),
                                                                                 new Document("$unwind", "$comandaInfo"), new Document("$project", new Document("ListaProductosConsumo", "$comandaInfo.ListaProductosConsumo"))));
        for (Document doc: iterable){
            Object productos = doc.get("ListaProductosConsumo");
            List<Object> listaProductosConsumo = (List<Object>) productos;
            
            for (Object nombres : listaProductosConsumo ){
                platillos = producto.ObtenerProductoporNombre(nombres.toString(), cliente);
                
                for (ProductoMenu.Ingrediente ingredientes : platillos.listaIngredientes){
                    IngredienteP = ingrediente.getProductoInventario(ingredientes.getIdProductoInventario(), cliente);
                    ingrediente.modificarProductoInventario(IngredienteP.getId(), IngredienteP.getNombre(), IngredienteP.getPrecio(), IngredienteP.getIdProveedor(), IngredienteP.getEstado(), 
                            (IngredienteP.getCantidad() - ingredientes.getCantidad()), IngredienteP.getUnidad_Medida(), IngredienteP.getDiaCompra(), IngredienteP.getCantidadMinima(), cliente);
                }
            }
            
            switch (opcion){
                case "Consumo_Cliente" -> {consumo = new Consumo_Cliente().ConsumoCliente(doc.getObjectId("_id"), cliente); if(ModificarConsumo(consumo.getId(), consumo.getID_Comanda(), cuenta, consumo.getMonto(), consumo.getFecha(), "Pagado", cliente)){ result = true;}}
                case "Consumo_Empleado" -> {empleado = new Consumo_Empleado().ConsumoEspecifico(doc.getObjectId("_id"), cliente); if (empleado.ModificarConsumoEmpelado(empleado.getID_Comanda(), empleado.getID_Empleado(), empleado.getMontoTotal(), "Pagado", cliente)){ result = true;}}
                default -> {break;}
            }
        }
        return result;
    }
}
