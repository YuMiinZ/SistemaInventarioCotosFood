/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import org.bson.Document;
/**
 *
 * @author TomasPC
 */
public class Reportes {
   private String Name;
   private String Precio;
   
   public List<Reportes> getListProductoVendido(){ //Cambiar por producto Menu
       List<Reportes> listaProductos = null;        
       ConexionBD conexion = new ConexionBD();
       MongoClient cliente = conexion.crearConexion();
       
       MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
       MongoCollection<Document> coleccion = db.getCollection("Proveedor");
       
       return listaProductos;
   }
}
