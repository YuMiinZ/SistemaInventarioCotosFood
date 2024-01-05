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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author yumii
 */
public class ProductoInventario {
    private ObjectId id, idProveedor;
    private String nombre, estado, unidad_medida, diaCompra;
    private double precio;
    private int cantidad, cantidadMinima;

    public ProductoInventario() {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
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
    
    public void registrarProductoInventario(String nombre, double precio, ObjectId idProveedor, String estado, int cantidad, String unidadMedida,
                                            String diaCompra, int cantidadMinima) {
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

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

        conexion.cerrarConexion(cliente);
    }
    
    public void modificarProductoInventario(ObjectId id, String nombre, double precio, ObjectId idProveedor, String estado, int cantidad, 
                                            String unidadMedida, String diaCompra, int cantidadMinima) {
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

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

        conexion.cerrarConexion(cliente);
    }
    
    public void eliminarProductoInventario(ObjectId id){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Inventario");

        Document filtro = new Document("_id", id);
        coleccion.deleteOne(filtro);

        conexion.cerrarConexion(cliente);
    }
    
    public List<ProductoInventario> getListaProductosInventario() {
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Inventario");

        FindIterable<Document> productos = coleccion.find();
        MongoCursor<Document> cursor = productos.iterator();

        List<ProductoInventario> listaProductos = new ArrayList<>();
        while (cursor.hasNext()) {
            Document productoDoc = cursor.next();

            ProductoInventario producto = new ProductoInventario();
            producto.setId(productoDoc.getObjectId("_id"));
            producto.setNombre(productoDoc.getString("Nombre"));
            producto.setPrecio(productoDoc.getDouble("Precio"));
            producto.setIdProveedor(productoDoc.getObjectId("ID_Proveedor"));
            producto.setEstado(productoDoc.getString("Estado"));
            producto.setCantidad(productoDoc.getInteger("Cantidad"));
            producto.setUnidad_Medida(productoDoc.getString("Unidad_Medida"));
            producto.setDiaCompra(productoDoc.getString("Dia_Compra"));
            producto.setCantidadMinima(productoDoc.getInteger("Cantidad_Minima"));

            listaProductos.add(producto);
        }

        conexion.cerrarConexion(cliente);
        return listaProductos;
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
