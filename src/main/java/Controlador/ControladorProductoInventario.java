/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ProductoInventario;
import Modelo.Proveedor;
import Vista.Clases.ManejadorComponentes;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author yumii
 */
public class ControladorProductoInventario {
    private final ProductoInventario consultas = new ProductoInventario();
    private ManejadorComponentes manejadorComponentes;

    public ControladorProductoInventario(){ 
    }
    
    public ControladorProductoInventario(ManejadorComponentes manejador){ 
        this.manejadorComponentes = manejador; 
    }
    
    

    public boolean registrarProductoInventario(String nombre, int indexProveedor, double precio, int cantidad, int cantMinima, Object diaCompra,
                                                Object estado, String unidadMedida, List<Proveedor> listaProveedores){
        
        if(validarDatos(nombre, indexProveedor, precio, cantidad, cantMinima, diaCompra, estado, unidadMedida)){
            consultas.registrarProductoInventario(nombre, precio, listaProveedores.get(indexProveedor).getId(), estado.toString(), cantidad, 
                                                  unidadMedida, diaCompra.toString(), cantMinima);
            
            manejadorComponentes.limpiarCamposTexto();
            manejadorComponentes.limpiarCmbox();
            manejadorComponentes.limpiarSpinner();
            return true;
        }
        return false;
    }
    
    public boolean modificarProductoInventario(ObjectId id, String nombre, int indexProveedor, double precio, int cantidad, int cantMinima, 
                                                Object diaCompra,
                                                Object estado, String unidadMedida, List<Proveedor> listaProveedores){
        
         if(validarDatos(nombre, indexProveedor, precio, cantidad, cantMinima, diaCompra, estado, unidadMedida)){
            consultas.modificarProductoInventario(id, nombre, precio, listaProveedores.get(indexProveedor).getId(), estado.toString(), cantidad, 
                                                  unidadMedida, diaCompra.toString(), cantMinima);
            
            return true;
        }
        return false;
        
    }
    
    public boolean validarDatos(String nombre, int proveedor, double precio, int cantidad, int cantMinima, Object diaCompra,
                            Object estado, String unidadMedida) {
        boolean datosValidos = true;

        if (nombre.isEmpty()) {
            manejadorComponentes.mostrarLabel(0);
            datosValidos = false;
        } else {
            manejadorComponentes.ocultarLabel(0);
        }

        if (proveedor == -1) {
            manejadorComponentes.mostrarLabel(1);
            datosValidos = false;
        } else {
            manejadorComponentes.ocultarLabel(1);
        }

        if (precio < 0) {
            manejadorComponentes.mostrarLabel(2);
            datosValidos = false;
        } else {
            manejadorComponentes.ocultarLabel(2);
        }

        if (cantidad < 0) {
            manejadorComponentes.mostrarLabel(3);
            datosValidos = false;
        } else {
            manejadorComponentes.ocultarLabel(3);
        }

        if (cantMinima < 0) {
            manejadorComponentes.mostrarLabel(4);
            datosValidos = false;
        } else {
            manejadorComponentes.ocultarLabel(4);
        }

        if (diaCompra == null) {
            manejadorComponentes.mostrarLabel(5);
            datosValidos = false;
        } else {
            manejadorComponentes.ocultarLabel(5);
        }

        if (estado == null) {
            manejadorComponentes.mostrarLabel(6);
            datosValidos = false;
        } else {
            manejadorComponentes.ocultarLabel(6);
        }

        if (unidadMedida.isEmpty()) {
            manejadorComponentes.mostrarLabel(7);
            datosValidos = false;
        } else {
            manejadorComponentes.ocultarLabel(7);
        }

        return datosValidos;
    }
    
    public List<ProductoInventario> obtenerListaProductosInventario(){
        return consultas.getListaProductosInventario();
    }
    
    
    public List<Object> obtenerListaObjetosProductosInventario( List<ProductoInventario> listaProductoInventario){
        List<Object> listaObjetos = new ArrayList<>();        
        for (ProductoInventario producto : listaProductoInventario) {
            listaObjetos.add((Object) producto);
        }
        return listaObjetos;
    }
    
    public List<String[]> obtenerDatosTabla(List<ProductoInventario> listaProductos) {
        List<String[]> resultados = new ArrayList<>();

        for (ProductoInventario producto : listaProductos) {
            String[] infoProducto = new String[2];
            infoProducto[0] = producto.getNombre();
            infoProducto[1] = producto.getCantidad() + " " + producto.getUnidad_Medida();

            resultados.add(infoProducto);
        }

        return resultados;
    }
    
    public void eliminarProductoInventario(ObjectId id){
        consultas.eliminarProductoInventario(id);
    }
}
