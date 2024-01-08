/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ProductoInventario;
import Modelo.ProductoMenu;
import Modelo.ProductoMenu.Ingrediente;
import Vista.Clases.FuncionesGenerales;
import Vista.Clases.ManejadorComponentes;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import org.bson.types.ObjectId;

/**
 *
 * @author yumii
 */
public class ControladorProductoMenu {
    private ProductoMenu consultas = new ProductoMenu();
    private ManejadorComponentes manejadorComponentes;
    FuncionesGenerales funcionesGenerales = new FuncionesGenerales();

    public ControladorProductoMenu() {
    }
    
    public ControladorProductoMenu(ManejadorComponentes manejador){ 
        this.manejadorComponentes = manejador; 
    }
    
    public void eliminarProductoMenu(ObjectId id){
        consultas.eliminarProductoMenu(id);
    }
    
    public boolean modificarProductoMenu(ObjectId id, String nombre, double precio, double costoElaboracion, Object tipoProducto, 
                                        JTable tableIngredientes, Object estado, List<ProductoInventario> listaProductosInventario){
        
        if(validarDatos(nombre, precio, costoElaboracion, tipoProducto, tableIngredientes, estado)){
            List<Ingrediente> listaIngredientes = obtenerDatosTabla(tableIngredientes, listaProductosInventario);
            consultas.modificarProductoMenu(id, nombre, estado.toString(), tipoProducto.toString(), precio, costoElaboracion, listaIngredientes);
            return true;
        }
        
        return false;
    }
    
    public List<ProductoMenu> obtenerListaProductosMenu(){
        return consultas.getListaProductosMenu();
    }
    
    public List<String> obtenerDatosTabla(List<ProductoMenu> listaProductos) {
        List<String> resultados = new ArrayList<>();
        String infoProducto;
        for (ProductoMenu producto : listaProductos) {
            infoProducto = producto.getNombre();
            resultados.add(infoProducto);
        }

        return resultados;
    }
    
    public List<Object> obtenerListaObjetosProductosMenu( List<ProductoMenu> listaProductosMenu){
        List<Object> listaObjetos = new ArrayList<>();        
        for (ProductoMenu producto : listaProductosMenu) {
            listaObjetos.add((Object) producto);
        }
        return listaObjetos;
    }
    

    public boolean registrarProductoMenu(String nombre, double precio, double costoElaboracion, Object tipoProducto, JTable tableIngredientes, 
                                        Object estado, List<ProductoInventario> listaProductosInventario) {
        
        if(validarDatos(nombre, precio, costoElaboracion, tipoProducto, tableIngredientes, estado)){
            List<Ingrediente> listaIngredientes = obtenerDatosTabla(tableIngredientes, listaProductosInventario);
            
            consultas.registrarProductoMenu(nombre, estado.toString(), tipoProducto.toString() , precio, costoElaboracion, listaIngredientes);
            manejadorComponentes.limpiarCamposTexto();
            manejadorComponentes.limpiarCmbox();
            manejadorComponentes.limpiarSpinner();
            tableIngredientes.removeAll();
            return true;
        }
        return false;
    }
    
    public ObjectId obtenerIdProducto(List<ProductoInventario> listaProductosInventario, String nombreProducto) {
        for (ProductoInventario producto : listaProductosInventario) {
                if(producto.getNombre().equals(nombreProducto)){
                    return producto.getId();
                }
            }
        return null;
    }
    
    public String obtenerNombreProducto(List<ProductoInventario> listaProductosInventario, ObjectId idProducto){
        for(ProductoInventario producto :  listaProductosInventario){
            if(producto.getId().equals(idProducto)){
                return producto.getNombre();
            }
        }
        return null;
    }
    
    public List<Ingrediente> obtenerDatosTabla(JTable tabla, List<ProductoInventario> listaProductos){
        List<Ingrediente> listaIngredientes = new ArrayList<>();
        int rowCount = tabla.getRowCount();
        double valorCantidad;
        for (int i = 0; i <rowCount; i++) {
            Object ingrediente = tabla.getValueAt(i, 0);
            Object cantidad = tabla.getValueAt(i, 1);
            
            if (ingrediente != null && !ingrediente.toString().isEmpty() && cantidad instanceof Double) {
                valorCantidad = (double) cantidad;
                if (valorCantidad > 0.0) {
                    Ingrediente datoIngrediente = new Ingrediente();
                    datoIngrediente.setIdProductoInventario(obtenerIdProducto(listaProductos, ingrediente.toString()));
                    datoIngrediente.setCantidad(valorCantidad);
                    listaIngredientes.add(datoIngrediente);
                }
            }
        }
        
        return listaIngredientes;
    }
    
    public boolean validarDatos(String nombre, double precio, double costoElaboracion, Object tipoProducto, JTable tableIngredientes, Object estado){
        boolean datosValidos = true;

        datosValidos &= funcionesGenerales.validarCampo(nombre, 0, manejadorComponentes);
        datosValidos &= funcionesGenerales.validarNumeroPositivo(precio, 1, manejadorComponentes);
        datosValidos &= funcionesGenerales.validarNumeroPositivo(costoElaboracion, 2, manejadorComponentes);
        datosValidos &= funcionesGenerales.validarCampo(tipoProducto, 3, manejadorComponentes);
        datosValidos &= funcionesGenerales.validarCampo(estado, 5, manejadorComponentes);
        datosValidos &= funcionesGenerales.validarTabla(tableIngredientes, 4, manejadorComponentes);

        return datosValidos;
    }

}