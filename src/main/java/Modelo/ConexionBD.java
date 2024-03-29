/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import javax.swing.JOptionPane;

/**
 *
 * @author yumii
 */
public class ConexionBD {
    private MongoClient cliente;
    private final String user = System.getenv("MONGO_USER");
    private final String password = System.getenv("MONGO_PASSWORD");
    private final String uri = String.format("mongodb+srv://%s:%s@cluster0.9icd7ew.mongodb.net/?retryWrites=true&w=majority", user, password);
    
    
    public MongoClient crearConexion() {
        try {
            cliente = MongoClients.create(uri);
            return cliente;
        } catch (Exception e) {
            //System.out.println("Error al conectar a la base de datos MongoDB: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se ha podido crear la conexión con la base de datos.", null, JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void cerrarConexion(MongoClient client){
        if (client != null) {
            client.close();
        }
    }
    
}
