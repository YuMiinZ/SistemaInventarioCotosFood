/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.Empleado;
import Vista.Clases.FuncionesGenerales;
import Vista.Clases.ManejadorComponentes;
import com.mongodb.client.MongoClient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author yumii
 */
public class ControladorEmpleado {
    private final Empleado consultas = new Empleado();
    private ManejadorComponentes manejador;
    FuncionesGenerales funcionesGenerales = new FuncionesGenerales();

    public ControladorEmpleado() {}
        
    
    
    public ControladorEmpleado (ManejadorComponentes manejador){ 
        this.manejador = manejador; 
    }
    
    public Empleado obtenerEmpelado(ObjectId id){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        Empleado empleado = consultas.getEmpleado(id, cliente);
        conexion.cerrarConexion(cliente);
        return empleado;
    }
    
    public List<Object> obtenerListaObjetosEmpleado(List<Empleado> Empleados){
        List<Object> listaObjetos = new ArrayList<>();        
        for (Empleado empleado : Empleados) {
            listaObjetos.add((Object) empleado);
        }
        return listaObjetos;
    }
    
    public List<String> LlenarTabla(List<Empleado> Empleados){ 
        List<String> MesaString = new ArrayList<>();
        for (Empleado empleado : Empleados){
            MesaString.add(empleado.getNombre());
        }
        return MesaString;
    }
    
    public boolean registrarEmpleado(String nombre, String telefono, int vacaciones, String fechaVencimientoCarnet, String alergias, Object tipoSangre, 
                                  String fechaIngreso) throws ParseException{
        boolean result = false;
        
       if(validarDatos(nombre, telefono, vacaciones, fechaVencimientoCarnet, alergias, tipoSangre, fechaIngreso)){
           SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
           Date fechaIngresoDate;
           Date fechaVencimientoDate;

           fechaIngresoDate = formatoFecha.parse(fechaIngreso);
           fechaVencimientoDate = formatoFecha.parse(fechaVencimientoCarnet);
           ConexionBD conexion = new ConexionBD();
           MongoClient cliente = conexion.crearConexion();
           if (consultas.registrarEmpleado(nombre, telefono, alergias, tipoSangre.toString(), vacaciones, fechaIngresoDate, fechaVencimientoDate, cliente)){
               result = true;
           }
           conexion.cerrarConexion(cliente);
           manejador.limpiarCamposTexto();
           manejador.limpiarCmbox();
           manejador.limpiarSpinner();
       } 
       return result;
    }
    
    public boolean validarDatos(String nombre, String telefono, int vacaciones, String fechaVencimientoCarnet, String alergias, Object tipoSangre, 
                                  String fechaIngreso){
        
        boolean datosValidos = true;
        
        
        datosValidos &= funcionesGenerales.validarCampo(nombre, 0, manejador);
        datosValidos &= funcionesGenerales.validarTelefono(telefono, 1, manejador);
        datosValidos &= funcionesGenerales.validarEnteroPositivo(vacaciones, 2, manejador);
        datosValidos &= funcionesGenerales.validarFecha(fechaVencimientoCarnet, 3, manejador);
        datosValidos &= funcionesGenerales.validarCampo(alergias, 4, manejador);
        datosValidos &= funcionesGenerales.validarCampo(tipoSangre, 5, manejador);
        datosValidos &= funcionesGenerales.validarFecha(fechaIngreso, 6, manejador);
        
        
        return datosValidos;
    }
    
    public List<Empleado> obtenerListaEmpleados(){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        List<Empleado> empleados = consultas.getListaEmpleados(cliente);
        conexion.cerrarConexion(cliente);
        return empleados;
    }
    
    public boolean modificarEmpleado(ObjectId id, String nombre, String telefono, int vacaciones, String fechaVencimientoCarnet, String alergias, Object tipoSangre, 
                                  String fechaIngreso) throws ParseException{
        boolean result = false;
        if(validarDatos(nombre, telefono, vacaciones, fechaVencimientoCarnet, alergias, tipoSangre, fechaIngreso)){
           SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
           Date fechaIngresoDate;
           Date fechaVencimientoDate;

           fechaIngresoDate = formatoFecha.parse(fechaIngreso);
           fechaVencimientoDate = formatoFecha.parse(fechaVencimientoCarnet);
           ConexionBD conexion = new ConexionBD();
           MongoClient cliente = conexion.crearConexion();
           if (consultas.modificarEmpleado(id, nombre, telefono, alergias, tipoSangre.toString(), vacaciones, fechaIngresoDate, fechaVencimientoDate, cliente)){
               result = true;
           }
           conexion.cerrarConexion(cliente);
       } 
       return result;
    }
    
    public boolean eliminarEmpleado(ObjectId id){
        boolean result = false;
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        if (consultas.eliminarEmpleado(id, cliente)){
            result = true;
        }
        conexion.cerrarConexion(cliente);
        return result;
    }
}
