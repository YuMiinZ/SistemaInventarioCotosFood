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
import java.util.List;
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

    public ProductoMenu() {
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
                                        List<Ingrediente> listaIngredientes) {
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

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

        conexion.cerrarConexion(cliente);
    }
    
    public void modificarProductoMenu(ObjectId id, String nombre, String estado, String tipoProducto, double precio, double costoElaboracion, 
                                        List<Ingrediente> listaIngredientes) {
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

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

        conexion.cerrarConexion(cliente);
    }
    
    public void eliminarProductoMenu(ObjectId id){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Menu");

        Document filtro = new Document("_id", id);
        coleccion.deleteOne(filtro);

        conexion.cerrarConexion(cliente);
    }
    
    public List<ProductoMenu> getListaProductosMenu() {
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Producto_Menu");

        List<ProductoMenu> listaProductos = new ArrayList<>();

        FindIterable<Document> productos = coleccion.find();

        for (Document documento : productos) {
            ProductoMenu producto = new ProductoMenu();

            producto.setId(documento.getObjectId("_id"));
            producto.setNombre(documento.getString("Nombre"));
            producto.setEstado(documento.getString("Estado"));
            producto.setTipoProducto(documento.getString("Tipo_Producto"));
            producto.setPrecio(documento.getDouble("Precio"));
            producto.setCostoElaboracion(documento.getDouble("Costo_de_Elaboracion"));

            List<Document> listaIngredientesDocumento = (List<Document>) documento.get("Ingredientes");
            List<Ingrediente> listaIngredientes = new ArrayList<>();

            for (Document ingredienteDocumento : listaIngredientesDocumento) {
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setCantidad(ingredienteDocumento.getDouble("Cantidad"));
                ingrediente.setIdProductoInventario(ingredienteDocumento.getObjectId("idProductoInventario"));
                listaIngredientes.add(ingrediente);
            }

            producto.setListaIngredientes(listaIngredientes);
            listaProductos.add(producto);
        }

        conexion.cerrarConexion(cliente);

        return listaProductos;
    }
}
