/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.Consumo_Cliente;
import Modelo.ProductoInventario;
import Modelo.ProductoMenu;
import com.mongodb.client.MongoClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author TomasPC
 */
public class ControladorReportes {
    private ProductoInventario inventario = new ProductoInventario();
    private Consumo_Cliente consumo = new Consumo_Cliente();
    private ProductoMenu producto = new ProductoMenu();
    
    
    public ControladorReportes(){}
    
    public List<ProductoInventario> ReporteMinimos(){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        List<ProductoInventario> productos = inventario.ReporteMinimo(cliente);
        conexion.cerrarConexion(cliente);
        return productos;
    }
    
    public List<ProductoMenu> ReporteProductosEstancados(){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        List<ProductoMenu> productos = producto.ReporteProductosEstancados(cliente);
        conexion.cerrarConexion(cliente);
        return productos;
    }
    
    public List<Consumo_Cliente> ReporteVentas(Date fechaI, Date fechaF){
        ConexionBD conexion = new ConexionBD();
        MongoClient clienteE = conexion.crearConexion();
        List<Consumo_Cliente> clientes = consumo.ReporteVentas(fechaI, fechaF, clienteE);
        conexion.cerrarConexion(clienteE);
        return clientes;
    }
    
    public List<ProductoMenu> ReporteCostoMasVendidos(){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        List<ProductoMenu> productos = producto.ReporteCostoProductosMasVendidos(cliente);
        conexion.cerrarConexion(cliente);
        return productos;
    }
    
    public List<String[]> LlenarTablaMenu(List<ProductoMenu> menu, int opcion){
        List<String[]> productos = new ArrayList<>();
        for (ProductoMenu lista : menu){
            String[] info = new String[2];
            info[0] = lista.getNombre();
            switch (opcion){
                case 0 -> info[1] = "₡ "+lista.getPrecio();
                case 1 -> info[1] = "₡ "+lista.getCostoElaboracion();
                default -> {break;}
            }
            productos.add(info);
        }
        return productos;
    }
    
    public List<String[]> LlenarTablaProductos(List<ProductoInventario> inventario){ 
        List<String[]> minimos = new ArrayList<>();
        for (ProductoInventario productos : inventario){
            String[] info = new String[2];
            info[0] = productos.getNombre();
            info[1] = ""+productos.getCantidad();
            minimos.add(info);
        }
        return minimos;
    }
    
}
