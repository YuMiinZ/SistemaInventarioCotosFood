/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Empleado;
import Vista.Clases.FuncionesGenerales;
import Vista.Clases.ManejadorComponentes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public ControladorEmpleado() {
    }
        
    
    
    public ControladorEmpleado (ManejadorComponentes manejador){ 
        this.manejador = manejador; 
    }

    public boolean registrarEmpleado(String nombre, String telefono, int vacaciones, String fechaVencimientoCarnet, String alergias, Object tipoSangre, 
                                  String fechaIngreso) throws ParseException{
        
       if(validarDatos(nombre, telefono, vacaciones, fechaVencimientoCarnet, alergias, tipoSangre, fechaIngreso)){
           SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
           Date fechaIngresoDate;
           Date fechaVencimientoDate;

           fechaIngresoDate = formatoFecha.parse(fechaIngreso);
           fechaVencimientoDate = formatoFecha.parse(fechaVencimientoCarnet);
           consultas.registrarEmpleado(nombre, telefono, alergias, tipoSangre.toString(), vacaciones, fechaIngresoDate, fechaVencimientoDate);
           manejador.limpiarCamposTexto();
           manejador.limpiarCmbox();
           manejador.limpiarSpinner();
           return true;
       } 
       return false;
    }
    
    public boolean validarFecha(String fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);
        try {
            Date fechaConvertida = formatoFecha.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    public boolean validarDatos(String nombre, String telefono, int vacaciones, String fechaVencimientoCarnet, String alergias, Object tipoSangre, 
                                  String fechaIngreso){
        
        boolean datosValidos = true;
        
        if (nombre.isEmpty()) {
            manejador.mostrarLabel(0);
            datosValidos = false;
        } else {
            manejador.ocultarLabel(0);
        }

        if (!telefono.matches("\\d{8}")) {
            manejador.mostrarLabel(1);
            datosValidos = false;
        } else {
            manejador.ocultarLabel(1);
        }

        if (vacaciones < 0) {
            manejador.mostrarLabel(2);
            datosValidos = false;
        } else {
            manejador.ocultarLabel(2);
        }
        
        if (!validarFecha(fechaVencimientoCarnet)) {
            manejador.mostrarLabel(3);
            datosValidos = false;
        } else {
            manejador.ocultarLabel(3);
        }
        
        if (alergias.isEmpty()) {
            manejador.mostrarLabel(4);
            datosValidos = false;
        } else {
            manejador.ocultarLabel(4);
        }
        
        if (tipoSangre == null) {
            manejador.mostrarLabel(5);
            datosValidos = false;
        } else {
            manejador.ocultarLabel(5);
        }
        
        if (!validarFecha(fechaIngreso)) {
            manejador.mostrarLabel(6);
            datosValidos = false;
        } else {
            manejador.ocultarLabel(6);
        }
        
        return datosValidos;
    }
    
    public List<Empleado> obtenerListaEmpleados(){
        return consultas.getListaEmpleados();
    }
    
    public boolean modificarProveedor(ObjectId id, String nombre, String telefono, int vacaciones, String fechaVencimientoCarnet, String alergias, Object tipoSangre, 
                                  String fechaIngreso) throws ParseException{
        if(validarDatos(nombre, telefono, vacaciones, fechaVencimientoCarnet, alergias, tipoSangre, fechaIngreso)){
           SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
           Date fechaIngresoDate;
           Date fechaVencimientoDate;

           fechaIngresoDate = formatoFecha.parse(fechaIngreso);
           fechaVencimientoDate = formatoFecha.parse(fechaVencimientoCarnet);
           consultas.modificarEmpleado(id, nombre, telefono, alergias, tipoSangre.toString(), vacaciones, fechaIngresoDate, fechaVencimientoDate);
           return true;
       } 
       return false;
    }
    
    public void eliminarEmpleado(ObjectId id){
        consultas.eliminarEmpleado(id);
    }
}
