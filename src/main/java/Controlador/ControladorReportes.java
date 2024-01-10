/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Consumo_Cliente;
import Modelo.ProductoInventario;
import Modelo.ProductoMenu;
import java.util.ArrayList;
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
        return inventario.ReporteMinimo();
    }
    
    public List<ProductoMenu> ReporteProductosEstancados(){
        return producto.ReporteProductosEstancados();
    }
    
    public List<String[]> LlenarTablaMenu(List<ProductoMenu> menu, int opcion){
        //System.out.println(menu.isEmpty());
        List<String[]> producto = new ArrayList<>();
        for (ProductoMenu lista : menu){
            String[] info = new String[2];
            info[0] = lista.getNombre();
            switch (opcion){
                case 0 -> info[1] = ""+lista.getPrecio();
                case 1 -> info[1] = ""+lista.getCostoElaboracion();
                default -> {break;}
            }
            producto.add(info);
        }
        return producto;
    }
    
    public List<String[]> LlenarTablaProductos(List<ProductoInventario> productos){ 
        List<String[]> minimos = new ArrayList<>();
        for (ProductoInventario producto : productos){
            String[] info = new String[2];
            info[0] = producto.getNombre();
            info[1] = ""+producto.getCantidad();
            minimos.add(info);
        }
        return minimos;
    }
    
}
