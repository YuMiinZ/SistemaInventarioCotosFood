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
    private MongoClient cliente;
    private String url = "mongodb+srv://admin:CotosFoodAdmin@cluster0.9icd7ew.mongodb.net/?retryWrites=true&w=majority";
    
    
    public MongoClient crearConexion() {
        try {
            System.out.println("MongoDB" + cliente);
            cliente = MongoClients.create(url);
            System.out.println("Conexión exitosa a MongoDB");
            return cliente;
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos MongoDB: " + e.getMessage());
            return null;
        }
    }
    
    public void cerrarConexion(MongoClient client){
        if (client != null) {
            client.close();
            cliente.close();
            System.out.println("MongoDB" + cliente);
        }
    }
    
}
