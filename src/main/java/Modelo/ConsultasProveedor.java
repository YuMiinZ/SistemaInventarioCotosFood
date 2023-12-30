/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mongodb.client.*;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author yumii
 */
public class ConsultasProveedor {
    
    public void consultarProveedores() {
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Proveedor");

        // Encontrar todos los documentos en la colección de proveedores
        FindIterable<Document> iterable = coleccion.find();
        for (Document documento : iterable) {
            System.out.println(documento);
        }
        
        conexion.cerrarConexion(cliente);
        /*try {
            // Si el cliente no se ha inicializado, se crea la conexión
            if (cliente == null) {
                crearConexion();
            }

            // Obtener la base de datos
            MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
            MongoCollection<Document> coleccion = db.getCollection("Proveedor");

            // Encontrar todos los documentos en la colección de proveedores
            FindIterable<Document> iterable = coleccion.find();
            for (Document documento : iterable) {
                System.out.println(documento);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar proveedores en la base de datos MongoDB: " + e.getMessage());
        }*/
    }

}
