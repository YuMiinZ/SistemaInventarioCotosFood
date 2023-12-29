/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mongodb.client.MongoClient;
import javax.swing.JOptionPane;

/**
 *
 * @author yumii
 */
public class pruebaconexion {
    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        MongoClient client = conexionBD.crearConexion();
        
        if (client != null) {
            JOptionPane.showMessageDialog(null, "Conexión establecida correctamente.");
            client.close();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión.");
        }
    }
}
