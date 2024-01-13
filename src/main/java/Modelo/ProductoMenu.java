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
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author yumii
 */
public class ProductoMenu {
    ObjectId id;
    String nombre, estado, tipoProducto;
    double precio, costoElaboracion;
    List<Ingrediente> listaIngredientes;

    public ProductoMenu() {}
    
    public ProductoMenu(ObjectId id, String nombre, String estado, String tipoProducto, double precio, double costoElaboracion,List<Ingrediente> listaIngredientes){
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.tipoProducto = tipoProducto;
        this.precio = precio;
        this.costoElaboracion = costoElaboracion;
        this.listaIngredientes = listaIngredientes;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCostoElaboracion() {
        return costoElaboracion;
    }

    public void setCostoElaboracion(double costoElaboracion) {
        this.costoElaboracion = costoElaboracion;
    }

    public List<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }
    

    public static class Ingrediente {
        private double cantidad;
        private ObjectId idProductoInventario;

        public Ingrediente() {
        }
        
        public Ingrediente(double cantidad, ObjectId idProductoInventario){
            this.cantidad = cantidad;
            this.idProductoInventario = idProductoInventario;
        }

        public double getCantidad() {
            return cantidad;
        }

        public void setCantidad(double cantidad) {
            this.cantidad = cantidad;
        }

        public ObjectId getIdProductoInventario() {
            return idProductoInventario;
        }

        public void setIdProductoInventario(ObjectId productoInventario) {
            this.idProductoInventario = productoInventario;
        }
    }
    
    public void registrarProductoMenu(String nombre, String estado, String tipoProducto, double precio, double costoElaboracion, 
                                        List<Ingrediente> listaIngredientes, MongoClient cliente) {

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood"); 
        MongoCollection<Document> coleccion = db.getCollection("Producto_Menu");
        
        List<Document> listaDocumentosIngredientes = new ArrayList<>();

        // Convertir cada Ingrediente a Document
        for (Ingrediente ingrediente : listaIngredientes) {
            Document docIngrediente = new Document()
                .append("Cantidad", ingrediente.getCantidad())
                .append("idProductoInventario", ingrediente.getIdProductoInventario());

            listaDocumentosIngredientes.add(docIngrediente);
        }

        Document producto = new Document("Nombre", nombre)
            .append("Estado", estado)
            .append("Tipo_Producto", tipoProducto)
            .append("Precio", precio)
            .append("Costo_de_Elaboracion", costoElaboracion)
            .append("Ingredientes", listaDocumentosIngredientes);

        coleccion.insertOne(producto);

    }
    
    public void modificarProductoMenu(ObjectId id, String nombre, String estado, String tipoProducto, double precio, double costoElaboracion, 
                                        List<Ingrediente> listaIngredientes, MongoClient cliente) {

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Menu");
        
        List<Document> listaDocumentosIngredientes = new ArrayList<>();

        // Convertir cada Ingrediente a Document
        for (Ingrediente ingrediente : listaIngredientes) {
            Document docIngrediente = new Document()
                .append("Cantidad", ingrediente.getCantidad())
                .append("idProductoInventario", ingrediente.getIdProductoInventario());

            listaDocumentosIngredientes.add(docIngrediente);
        }

        Document filtro = new Document("_id", id);

        Document datosActualizar = new Document("Nombre", nombre)
            .append("Estado", estado)
            .append("Tipo_Producto", tipoProducto)
            .append("Precio", precio)
            .append("Costo_de_Elaboracion", costoElaboracion)
            .append("Ingredientes", listaDocumentosIngredientes);

        Document updateDocumento = new Document("$set", datosActualizar);

        coleccion.updateOne(filtro, updateDocumento);

    }
    
    public void eliminarProductoMenu(ObjectId id, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Menu");

        Document filtro = new Document("_id", id);
        coleccion.deleteOne(filtro);

    }
    
    public List<ProductoMenu> getListaProductosMenu(MongoClient cliente) {

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Menu");

        List<ProductoMenu> listaProductos = new ArrayList<>();

        FindIterable<Document> productos = coleccion.find();

        for (Document documento : productos) {
            
            List<Document> listaIngredientesDocumento = (List<Document>) documento.get("Ingredientes");
            List<Ingrediente> listaIngredientes = new ArrayList<>();

            for (Document ingredienteDocumento : listaIngredientesDocumento) {
                Ingrediente ingrediente = new Ingrediente(ingredienteDocumento.getDouble("Cantidad"),ingredienteDocumento.getObjectId("idProductoInventario"));
                listaIngredientes.add(ingrediente);
            }
            ProductoMenu producto = new ProductoMenu(documento.getObjectId("_id"),documento.getString("Nombre"),documento.getString("Estado"), documento.getString("Tipo_Producto"), documento.getDouble("Precio"),documento.getDouble("Costo_de_Elaboracion"), listaIngredientes);
            listaProductos.add(producto);
        }

        return listaProductos;
    }
    
    public ProductoMenu ObtenerProductoporNombre(String nombre, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Menu");

        Document doc = coleccion.find(eq("Nombre", nombre)).first();
        
        List<Document> listaIngredientesDocumento = (List<Document>) doc.get("Ingredientes");
        List<Ingrediente> listaIngredientes = new ArrayList<>();

        for (Document ingredienteDocumento : listaIngredientesDocumento) {
            Ingrediente ingrediente = new Ingrediente(ingredienteDocumento.getDouble("Cantidad"),ingredienteDocumento.getObjectId("idProductoInventario"));
            listaIngredientes.add(ingrediente);
        }
        ProductoMenu producto = new ProductoMenu(doc.getObjectId("_id"), doc.getString("Nombre"), doc.getString("Estado"), doc.getString("Tipo_Producto"), doc.getDouble("Precio"),doc.getDouble("Costo_de_Elaboracion"), listaIngredientes);
        return producto;
    }
    
    public List<ProductoMenu> ProductosenMenu(List<String> productos, MongoClient cliente){
        ArrayList<ProductoMenu> ProductosComanda = new ArrayList<>();
        for (String doc: productos){
            ProductosComanda.add(ObtenerProductoporNombre(doc, cliente));
        }
        return ProductosComanda;
    }
    
    public List<ProductoMenu> ProductosEstancados(List<String> productos, MongoClient cliente){
        ArrayList<ProductoMenu> ProductosComanda = new ArrayList<>();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Menu");
        
        FindIterable<Document> Menu = coleccion.find(new Document("Nombre", new Document("$nin", productos)));
        
        for (Document doc: Menu){
             List<Document> listaIngredientesDocumento = (List<Document>) doc.get("Ingredientes");
            List<Ingrediente> listaIngredientes = new ArrayList<>();

            for (Document ingredienteDocumento : listaIngredientesDocumento) {
                Ingrediente ingrediente = new Ingrediente(ingredienteDocumento.getDouble("Cantidad"),ingredienteDocumento.getObjectId("idProductoInventario"));
                listaIngredientes.add(ingrediente);
            }
            ProductoMenu producto = new ProductoMenu(doc.getObjectId("_id"), doc.getString("Nombre"), doc.getString("Estado"), doc.getString("Tipo_Producto"), doc.getDouble("Precio"),doc.getDouble("Costo_de_Elaboracion"), listaIngredientes);
            ProductosComanda.add(producto);
        }
        return ProductosComanda;
    }
    
    public ProductoMenu getProducto(String nombre, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Menu");
        
        Document doc = coleccion.find(eq("Nombre", nombre)).first();

            
        List<Document> listaIngredientesDocumento = (List<Document>) doc.get("Ingredientes");
        List<Ingrediente> listaIngredientes = new ArrayList<>();

        for (Document ingredienteDocumento : listaIngredientesDocumento) {
            Ingrediente ingrediente = new Ingrediente(ingredienteDocumento.getDouble("Cantidad"),ingredienteDocumento.getObjectId("idProductoInventario"));
            listaIngredientes.add(ingrediente);
        }
        ProductoMenu producto = new ProductoMenu(doc.getObjectId("_id"), doc.getString("Nombre"), doc.getString("Estado"), doc.getString("Tipo_Producto"), doc.getDouble("Precio"),doc.getDouble("Costo_de_Elaboracion"), listaIngredientes);
        return producto;
    }
    
    
    public List<ProductoMenu> PlatillosyBebidas(String tipo, MongoClient cliente){
        ArrayList<ProductoMenu> ProductosComanda = new ArrayList<>();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Menu");
        
        FindIterable<Document> Menu = coleccion.find(eq("Tipo_Producto", tipo));
        for (Document doc: Menu){
            List<Document> listaIngredientesDocumento = (List<Document>) doc.get("Ingredientes");
            List<Ingrediente> listaIngredientes = new ArrayList<>();

            for (Document ingredienteDocumento : listaIngredientesDocumento) {
                Ingrediente ingrediente = new Ingrediente(ingredienteDocumento.getDouble("Cantidad"),ingredienteDocumento.getObjectId("idProductoInventario"));
                listaIngredientes.add(ingrediente);
            }
            ProductoMenu producto = new ProductoMenu(doc.getObjectId("_id"), doc.getString("Nombre"), doc.getString("Estado"), doc.getString("Tipo_Producto"), doc.getDouble("Precio"),doc.getDouble("Costo_de_Elaboracion"), listaIngredientes);
            ProductosComanda.add(producto);
        }
        return ProductosComanda;
    }    
    
    private List<Document> ProductosEnComandas(MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        List<Document> coleccion = new ArrayList<>();
        MongoCollection<Document> ProductoComanda = db.getCollection("Comanda");
        
        AggregateIterable<Document> Menu = ProductoComanda.aggregate(Arrays.asList(new Document("$lookup", 
                                                        new Document("from", "Consumo_Cliente").append("localField", "_id").append("foreignField", "ID_Comanda").append("as","comandaInfo")),
                                                        new Document("$unwind", "$comandaInfo")));
        Menu.into(coleccion);
        return coleccion;
    }
    
    public List<ProductoMenu> ReporteProductosEstancados(MongoClient cliente){
        List<ProductoMenu> productos;
        List<String> temporal = new ArrayList<>();
        List<Document> coleccion = ProductosEnComandas(cliente);
        for (Document doc: coleccion){
            for (String nombres : doc.getList("ListaProductosConsumo", String.class)){
                temporal.add(nombres);
            }
        }
        productos = ProductosEstancados(temporal, cliente);
        return productos;
    }
    
    private List<String> ProductoMasRepetido(List<String> productos){
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String element : productos) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        Collections.sort(productos, (o1, o2) -> frequencyMap.get(o2) - frequencyMap.get(o1));

        return productos;
    }
    
    public List<ProductoMenu> ReporteCostoProductosMasVendidos(MongoClient cliente){
        List<ProductoMenu> productos;
        List<String> temporal = new ArrayList<>();
        List<Document> coleccion = ProductosEnComandas(cliente);
        for (Document doc: coleccion){
            for (String nombres : doc.getList("ListaProductosConsumo", String.class)){
                temporal.add(nombres);
            }
        }
        productos = ProductosenMenu(ProductoMasRepetido(temporal), cliente);
        return productos;
    }
    
}
