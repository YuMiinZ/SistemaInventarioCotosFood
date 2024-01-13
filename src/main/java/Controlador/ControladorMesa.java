/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.Mesas;
import com.mongodb.client.MongoClient;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author TomasPC
 */
public class ControladorMesa {
    private Mesas mesa = new Mesas();
    
    public ControladorMesa(){}
    
    public List<Mesas> ConsultarMesas(){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        List<Mesas> mesas = mesa.TodasMesas(cliente);
        conexion.cerrarConexion(cliente);
        return mesas;
    }
    
    public void AgregarMesa(int num){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        mesa.CrearMesa(num, cliente);
        conexion.cerrarConexion(cliente);
    }
    
    public Mesas BuscarMesa(ObjectId id){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        Mesas mesas = mesa.MesaEspecifica(id, cliente);
        conexion.cerrarConexion(cliente);
        return mesas;
    }
    
    public List<Object> obtenerListaObjetosCuentas( List<Mesas> Mesas){
        List<Object> listaObjetos = new ArrayList<>();        
        for (Mesas mesa : Mesas) {
            listaObjetos.add((Object) mesa);
        }
        return listaObjetos;
    }
    
    public List<String> LlenarTabla(List<Mesas> Mesas){ 
        List<String> MesaString = new ArrayList<>();
        for (Mesas Mesa : Mesas){
            MesaString.add("Mesa " + Mesa.getNumeroMesa());
        }
        return MesaString;
    }
}
