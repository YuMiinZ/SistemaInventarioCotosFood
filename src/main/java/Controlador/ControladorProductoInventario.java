/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.ProductoInventario;
import Modelo.Proveedor;
import Vista.Clases.FuncionesGenerales;
import Vista.Clases.ManejadorComponentes;
import com.mongodb.client.MongoClient;
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
    FuncionesGenerales funcionesGenerales = new FuncionesGenerales();

    public ControladorProductoInventario(){ 
    }
    
    public ControladorProductoInventario(ManejadorComponentes manejador){ 
        this.manejadorComponentes = manejador; 
    }
    
    public boolean verificarNombreProducto(List<ProductoInventario> lista, String nombreVerificar, int opcion, String nombreActual){
        for(ProductoInventario producto : lista){
            if(producto.getNombre().equals(nombreVerificar) && opcion == 0){
                return true;
            } else if (opcion == 1) {
                if(nombreVerificar.equals(nombreActual)){
                    return false;
                } else {
                    if (producto.getNombre().equals(nombreVerificar)){
                        return true;
                    }
                   
                }
            }
        }
        return false;
    }

    public boolean registrarProductoInventario(String nombre, int indexProveedor, double precio, double cantidad, int cantMinima, Object diaCompra,
                                                Object estado, String unidadMedida, List<Proveedor> listaProveedores){
        boolean result = false;
        if(validarDatos(nombre, indexProveedor, precio, cantidad, cantMinima, diaCompra, estado, unidadMedida)){
            ConexionBD conexion = new ConexionBD();
            MongoClient cliente = conexion.crearConexion();
            if (consultas.registrarProductoInventario(nombre, precio, listaProveedores.get(indexProveedor).getId(), estado.toString(), cantidad, 
                                                  unidadMedida, diaCompra.toString(), cantMinima, cliente)){
                result = true;
            }
            conexion.cerrarConexion(cliente);
            
            manejadorComponentes.limpiarCamposTexto();
            manejadorComponentes.limpiarCmbox();
            manejadorComponentes.limpiarSpinner();
        }
        return result;
    }
    
    public boolean modificarProductoInventario(ObjectId id, String nombre, int indexProveedor, double precio, double cantidad, int cantMinima, 
                                                Object diaCompra,
                                                Object estado, String unidadMedida, List<Proveedor> listaProveedores){
        boolean result = false;
         if(validarDatos(nombre, indexProveedor, precio, cantidad, cantMinima, diaCompra, estado, unidadMedida)){
             ConexionBD conexion = new ConexionBD();
            MongoClient cliente = conexion.crearConexion();
            if (consultas.modificarProductoInventario(id, nombre, precio, listaProveedores.get(indexProveedor).getId(), estado.toString(), cantidad, 
                                                  unidadMedida, diaCompra.toString(), cantMinima, cliente)){
                result = true;
            }
            conexion.cerrarConexion(cliente);
        }
        return result;
        
    }
    
    public boolean validarDatos(String nombre, int proveedor, double precio, double cantidad, int cantMinima,
                            Object diaCompra, Object estado, String unidadMedida) {
        boolean datosValidos = true;

        datosValidos &= funcionesGenerales.validarCampo(nombre, 0, manejadorComponentes);
        datosValidos &= funcionesGenerales.validarEnteroPositivo(proveedor, 1, manejadorComponentes);
        datosValidos &= funcionesGenerales.validarNumeroPositivo(precio, 2, manejadorComponentes);
        datosValidos &= funcionesGenerales.validarNumeroPositivo(cantidad, 3, manejadorComponentes);
        datosValidos &= funcionesGenerales.validarEnteroPositivo(cantMinima, 4, manejadorComponentes);
        datosValidos &= funcionesGenerales.validarCampo(diaCompra, 5, manejadorComponentes);
        datosValidos &= funcionesGenerales.validarCampo(estado, 6, manejadorComponentes);
        datosValidos &= funcionesGenerales.validarCampo(unidadMedida, 7, manejadorComponentes);

        return datosValidos;
    }
    
    public List<ProductoInventario> obtenerListaProductosInventario(){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        List<ProductoInventario> productos = consultas.getListaProductosInventario(cliente);
        conexion.cerrarConexion(cliente);
        return productos;
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
    
    public boolean eliminarProductoInventario(ObjectId id){
        boolean result = false;
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        if (consultas.eliminarProductoInventario(id, cliente)){
            result = true;
        }
        conexion.cerrarConexion(cliente);
        return result;
    }
}
