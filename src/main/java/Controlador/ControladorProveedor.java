/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Proveedor;
import Vista.Clases.FuncionesGenerales;
import Vista.JF_RegistrarProveedor;
import Vista.Clases.ManejadorComponentes;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import org.bson.types.ObjectId;

/**
 *
 * @author yumii
 */
public class ControladorProveedor {

    private final Proveedor consultas = new Proveedor();
    private ManejadorComponentes manejador;
    FuncionesGenerales funcionesGenerales = new FuncionesGenerales();

    public ControladorProveedor() {
    }
        
    public ControladorProveedor (ManejadorComponentes manejador){ 
        this.manejador = manejador; 
    }
    
    public boolean registrarProveedor(String nombre, String telefono){
        if(validarDatos(nombre, telefono)){
            manejador.limpiarCamposTexto();
            consultas.registrarProveedor(nombre, telefono);
            return true;
        } else {
            return false;
        }
    }
    
    
    public boolean validarDatos(String nombre, String telefono){
        boolean datosValidos = true;

        datosValidos &= funcionesGenerales.validarCampo(nombre, 0, manejador);
        datosValidos &= funcionesGenerales.validarTelefono(telefono, 1, manejador);
        
        return datosValidos;
    }
    
    public List<Proveedor> obtenerListaProveedores(){
        return consultas.getListaProveedores();
    }
    
    public boolean modificarProveedor(ObjectId id, String nombre, String telefono){
        if(validarDatos(nombre, telefono)){
            consultas.modificarProveedor(id, nombre, telefono);
            return true;
        } else {
            return false;
        }
    }
    
    public void eliminarProveedor(ObjectId id){
        consultas.eliminarProveedor(id);
    }
}
