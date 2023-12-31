/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;


/**
 *
 * @author yumii
 */
public class pruebas {
    public static void main(String[] args) {
        Proveedor consultas = new Proveedor(); // Crear una instancia de ConsultasBD
        
        
        //consultas.registrarProveedor("Martín", "11115555");
        //consultas.consultarProveedores();
        List<Proveedor> proveedores = consultas.getListaProveedores(); // Obtener la lista
        
        for (Proveedor proveedor : proveedores) {
            System.out.println("ID: " + proveedor.getId());
            System.out.println("Nombre: " + proveedor.getNombre());
            System.out.println("Teléfono: " + proveedor.getTelefono());
            System.out.println("-----------------------------");
        }
    }
}
