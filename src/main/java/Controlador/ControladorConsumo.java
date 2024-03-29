/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.Consumo_Cliente;
import Modelo.Consumo_Empleado;
import com.mongodb.client.MongoClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author TomasPC
 */
public class ControladorConsumo {
    private Consumo_Cliente cliente = new Consumo_Cliente();
    private Consumo_Empleado Empleado = new Consumo_Empleado();
    private boolean resultado = false;
    
    
    public ControladorConsumo(){}
    
    /**
     *
     * @param NumMesa
     * @return 
     */
    public List<Consumo_Cliente> ConsultarCliente(ObjectId NumMesa){
        ConexionBD conexion = new ConexionBD();
        MongoClient clienteE = conexion.crearConexion();
        List<Consumo_Cliente> clientes = cliente.ConsumoClienteEspecifico(NumMesa, clienteE);
        conexion.cerrarConexion(clienteE);
        return clientes;
    }
    
    public List<Consumo_Empleado> ConsultarEmpleado(ObjectId NumEmpleado){
        ConexionBD conexion = new ConexionBD();
        MongoClient clienteE = conexion.crearConexion();
        List<Consumo_Empleado> empeleados = Empleado.ConsumoEmpleadoEspecifico(NumEmpleado, clienteE);
        conexion.cerrarConexion(clienteE);
        return empeleados;
    }
    
    public boolean CrearCliente(ObjectId comanda, ObjectId mesa, double monto, Date fecha){
        ConexionBD conexion = new ConexionBD();
        MongoClient clienteE = conexion.crearConexion();
        if (cliente.NuevaCompra(comanda, mesa, monto, fecha, clienteE)){
            resultado = true;
        }
        conexion.cerrarConexion(clienteE);
        return resultado;
    }
    
    public boolean CrearEmpleado(ObjectId comanda, ObjectId mesa, double monto){
        ConexionBD conexion = new ConexionBD();
        MongoClient clienteE = conexion.crearConexion();
        if (Empleado.Nuevo_Consumo_Empleado(comanda, mesa, monto, clienteE)){
            resultado = true;
        }
        conexion.cerrarConexion(clienteE);
        return resultado;
    }
    
    public boolean ElminarCuentaCliente(ObjectId idMesa, ObjectId idComanda){
        ConexionBD conexion = new ConexionBD();
        MongoClient clienteE = conexion.crearConexion();
        if (cliente.eliminar(idMesa, idComanda, clienteE)){
            resultado = true;
        }
        conexion.cerrarConexion(clienteE);
        return resultado;
    }
    
    public boolean ElminarCuentaEmpleado(ObjectId idEmpleado, ObjectId idComanda){
        ConexionBD conexion = new ConexionBD();
        MongoClient clienteE = conexion.crearConexion();
        if (Empleado.eliminar(idEmpleado, idComanda, clienteE)){
            resultado = true;
        }
        conexion.cerrarConexion(clienteE);
        return resultado;
    }
    
    public boolean Pagar(ObjectId cuenta, String opcion){
        ConexionBD conexion = new ConexionBD();
        MongoClient clienteE = conexion.crearConexion();
        if (cliente.Pagar(cuenta, opcion, clienteE)){
            resultado = true;
        }
        conexion.cerrarConexion(clienteE);
        return resultado;
    }
    
    public List<Object> obtenerListaObjetosConsumoCliente( List<Consumo_Cliente> listaConsumo){
        List<Object> listaObjetos = new ArrayList<>();        
        for (Consumo_Cliente Consumo : listaConsumo) {
            listaObjetos.add((Object) Consumo);
        }
        return listaObjetos;
    }
    
    public List<Object> obtenerListaObjetosConsumoEmpleado( List<Consumo_Empleado> listaConsumo){
        List<Object> listaObjetos = new ArrayList<>();        
        for (Consumo_Empleado Consumo : listaConsumo) {
            listaObjetos.add((Object) Consumo);
        }
        return listaObjetos;
    }
    

    
    public List<String[]> LlenarTablaClientes(List<Consumo_Cliente> clientes){ 
        List<String[]> consumo = new ArrayList<>();
        if(clientes != null ){
            for (Consumo_Cliente lista : clientes){
                String[] info = new String[2];
                info[0] = ""+(clientes.indexOf(lista)+1);
                info[1] = ""+lista.getMonto();
                consumo.add(info);
            }
        }
        
        return consumo;
    }
    
    public List<String[]> LlenarTablaEmpleado(List<Consumo_Empleado> empleados){ 
        List<String[]> consumo = new ArrayList<>();
        for (Consumo_Empleado lista : empleados){
            String[] info = new String[2];
            info[0] = ""+(empleados.indexOf(lista)+1);
            info[1] = ""+lista.getMontoTotal();
            consumo.add(info);
        }
        return consumo;
    }
    
    
}
