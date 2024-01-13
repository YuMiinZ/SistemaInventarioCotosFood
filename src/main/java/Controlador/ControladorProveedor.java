/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.Proveedor;
import Vista.Clases.FuncionesGenerales;
import Vista.Clases.ManejadorComponentes;
import com.mongodb.client.MongoClient;
import java.util.List;
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
            ConexionBD conexion = new ConexionBD();
            MongoClient cliente = conexion.crearConexion();
            consultas.registrarProveedor(nombre, telefono, cliente);
            conexion.cerrarConexion(cliente);
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
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        List<Proveedor>  proveedor = consultas.getListaProveedores(cliente);
        conexion.cerrarConexion(cliente);
        return proveedor;
    }
    
    public boolean modificarProveedor(ObjectId id, String nombre, String telefono){
        if(validarDatos(nombre, telefono)){
            ConexionBD conexion = new ConexionBD();
            MongoClient cliente = conexion.crearConexion();
            consultas.modificarProveedor(id, nombre, telefono, cliente);
            return true;
        } else {
            return false;
        }
    }
    
    public void eliminarProveedor(ObjectId id){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        consultas.eliminarProveedor(id, cliente);
        conexion.cerrarConexion(cliente);
    }
}
