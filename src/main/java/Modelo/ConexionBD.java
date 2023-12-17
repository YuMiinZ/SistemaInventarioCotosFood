/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;

/**
 *
 * @author yumii
 */
public class ConexionBD {
    
    public MongoClient crearConexion(){
        try {
            MongoClient client = MongoClients.create("mongodb+srv://admin:CotosFoodAdmin@cluster0.9icd7ew.mongodb.net/?retryWrites=true&w=majority");
    
            MongoDatabase db = client.getDatabase("SistemaInventarioCotosFood");

            MongoCollection col = db.getCollection("Proveedor");
            JOptionPane.showMessageDialog(null, "Conexión Exitosa " + db.getName());
            return client;
        } catch(MongoException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión a MongoDB, error: " + e.toString());
            return null;
        }
    }
    
}
