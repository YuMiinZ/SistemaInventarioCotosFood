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

        FindIterable<Document> iterable = coleccion.find();
        for (Document documento : iterable) {
            System.out.println(documento);
        }
        
        conexion.cerrarConexion(cliente);
    }
    
    public boolean registrarProveedor (String nombre, String telefono){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Proveedor");

        Document proveedor = new Document("Nombre", nombre)
                                .append("Telefono", telefono);

        coleccion.insertOne(proveedor);
        System.out.println("Proveedor insertado correctamente");
        
        conexion.cerrarConexion(cliente);
        return true;
    }

}
