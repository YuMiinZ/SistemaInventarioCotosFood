/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Consumo_Cliente;
import Modelo.Consumo_Empleado;
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
    
    public ControladorConsumo(){}
    
    /**
     *
     * @param NumMesa
     * @return 
     */
    public List<Consumo_Cliente> ConsultarCliente(ObjectId NumMesa){
        return cliente.ConsumoClienteEspecifico(NumMesa);
    }
    
    public void CrearCliente(ObjectId comanda, ObjectId mesa, double monto, Date fecha){
        cliente.NuevaCompra(comanda, mesa, monto, fecha);
    }
    
    public void CrearEmpleado(ObjectId comanda, ObjectId mesa, double monto){
        Empleado.Nuevo_Consumo_Empleado(comanda, mesa, monto);
    }
    
    public void ElminarCuentaCliente(ObjectId idMesa, ObjectId idComanda){
        cliente.eliminar(idMesa, idComanda);
    }
    
    public void ElminarCuentaEmpleado(ObjectId idEmpleado, ObjectId idComanda){
        Empleado.eliminar(idEmpleado, idComanda);
    }
    
    public void Pagar(ObjectId cuenta, String opcion){
        cliente.Pagar(cuenta, opcion);
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
    
    public List<Consumo_Empleado> ConsultarEmpleado(ObjectId NumEmpleado){
        return Empleado.ConsumoEmpleadoEspecifico(NumEmpleado);
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
