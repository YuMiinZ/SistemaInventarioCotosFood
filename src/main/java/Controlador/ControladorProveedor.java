/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Proveedor;
import Vista.JF_RegistrarProveedor;
import Vista.Clases.ManejadorComponentes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;

/**
 *
 * @author yumii
 */
public class ControladorProveedor {

    Proveedor consultas = new Proveedor();
    ManejadorComponentes manejador;
        

    public ControladorProveedor (ManejadorComponentes manejador){ 
        this.manejador = manejador; 
    }
    
    
    
    public boolean validarDatos(String nombre, String telefono, JF_RegistrarProveedor ventana){
        if (nombre.isEmpty() && !telefono.matches("\\d{8}")) {
            manejador.mostrarLabels();
            return false;
        } else if (nombre.isEmpty()) {
            ventana.lblErrorNombre.setVisible(true);
            ventana.lblErrorTelefono.setVisible(false);
            return false;
        } else if (!telefono.matches("\\d{8}")) {
            ventana.lblErrorTelefono.setVisible(true);
            ventana.lblErrorNombre.setVisible(false);
            return false;
        }
        manejador.limpiarCampos();
        return consultas.registrarProveedor(nombre, telefono);
    }
    
}
