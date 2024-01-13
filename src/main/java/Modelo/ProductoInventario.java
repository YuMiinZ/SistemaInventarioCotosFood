/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author yumii
 */
public class ProductoInventario {
    private ObjectId id, idProveedor;
    private String nombre, estado, unidad_medida, diaCompra;
    private double precio, cantidad;
    private int cantidadMinima;

    public ProductoInventario() {}
    
    public ProductoInventario(ObjectId id, ObjectId idProveedor, String nombre, String estado, String unidad_medida, String diaCompra, double precio, double cantidad, int cantidadMinima){
        this.id = id;
        this.cantidad = cantidad;
        this.cantidadMinima = cantidadMinima;
        this.diaCompra = diaCompra;
        this.estado = estado;
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.precio = precio;
        this.unidad_medida = unidad_medida;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(ObjectId idProveedor) {
        this.idProveedor = idProveedor;
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

    public String getUnidad_Medida() {
        return unidad_medida;
    }

    public void setUnidad_Medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public String getDiaCompra() {
        return diaCompra;
    }

    public void setDiaCompra(String diaCompra) {
        this.diaCompra = diaCompra;
    }
    
    public void registrarProductoInventario(String nombre, double precio, ObjectId idProveedor, String estado, double cantidad, String unidadMedida,
                                            String diaCompra, int cantidadMinima, MongoClient cliente) {

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Inventario");

        Document producto = new Document("Nombre", nombre)
                .append("Precio", precio)
                .append("ID_Proveedor", idProveedor)
                .append("Estado", estado)
                .append("Cantidad", cantidad)
                .append("Unidad_Medida", unidadMedida)
                .append("Dia_Compra", diaCompra)
                .append("Cantidad_Minima", cantidadMinima);

        coleccion.insertOne(producto);

    }
    
    public void modificarProductoInventario(ObjectId id, String nombre, double precio, ObjectId idProveedor, String estado, double cantidad, 
                                            String unidadMedida, String diaCompra, int cantidadMinima, MongoClient cliente) {

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Inventario");

        Document filtro = new Document("_id", id);
        Document datosActualizar = new Document("Nombre", nombre)
                .append("Precio", precio)
                .append("ID_Proveedor", idProveedor)
                .append("Estado", estado)
                .append("Cantidad", cantidad)
                .append("Unidad_Medida", unidadMedida)
                .append("Dia_Compra", diaCompra)
                .append("Cantidad_Minima", cantidadMinima);
        Document updateDocumento = new Document("$set", datosActualizar);

        coleccion.updateOne(filtro, updateDocumento);

    }
    
    public void eliminarProductoInventario(ObjectId id, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Inventario");

        Document filtro = new Document("_id", id);
        coleccion.deleteOne(filtro);
    }
    
    public ProductoInventario getProductoInventario(ObjectId id, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Inventario");

        Bson filter = Filters.and(Filters.eq("_id", id));
        Document productoDoc = coleccion.find(filter).first();
        
        ProductoInventario producto = new ProductoInventario(productoDoc.getObjectId("_id"), productoDoc.getObjectId("ID_Proveedor"), productoDoc.getString("Nombre"),productoDoc.getString("Estado"), productoDoc.getString("Unidad_Medida"), 
                productoDoc.getString("Dia_Compra"), productoDoc.getDouble("Precio"), productoDoc.getDouble("Cantidad"),productoDoc.getInteger("Cantidad_Minima"));
        
        return producto;
    }
    
    public List<ProductoInventario> getListaProductosInventario(MongoClient cliente) {

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Inventario");

        FindIterable<Document> productos = coleccion.find();
        MongoCursor<Document> cursor = productos.iterator();

        List<ProductoInventario> listaProductos = new ArrayList<>();
        while (cursor.hasNext()) {
            Document productoDoc = cursor.next();

            ProductoInventario producto = new ProductoInventario(productoDoc.getObjectId("_id"), productoDoc.getObjectId("ID_Proveedor"), productoDoc.getString("Nombre"),productoDoc.getString("Estado"), productoDoc.getString("Unidad_Medida"),
                    productoDoc.getString("Dia_Compra"), productoDoc.getDouble("Precio"), productoDoc.getDouble("Cantidad"),productoDoc.getInteger("Cantidad_Minima"));

            listaProductos.add(producto);
        }

        return listaProductos;
    }
    
    public List<ProductoInventario> ReporteMinimo(MongoClient cliente){
        List<ProductoInventario> listaMinimos = new ArrayList<>();
        List<ProductoInventario> listaProductos = getListaProductosInventario(cliente);
        
        for (ProductoInventario producto: listaProductos){
            if (producto.getCantidad() <= producto.getCantidadMinima()){
                listaMinimos.add(producto);
            }
        }
        return listaMinimos;
    }
    
    public List<String[]> obtenerInfoTabla(List<ProductoInventario> listaProductos) {
        List<String[]> resultados = new ArrayList<>();

        for (ProductoInventario producto : listaProductos) {
            String[] infoProducto = new String[2];
            infoProducto[0] = producto.getNombre();
            infoProducto[1] = producto.getCantidad() + " " + producto.getUnidad_Medida();
            resultados.add(infoProducto);
        }

        return resultados;
    }
}
