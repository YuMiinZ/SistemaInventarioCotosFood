/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Mesas;
import Modelo.ProductoInventario;
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
        return mesa.TodasMesas();
    }
    
    public void AgregarMesa(int num){
        mesa.CrearMesa(num);
    }
    
    public Mesas BuscarMesa(ObjectId id){
        return mesa.MesaEspecifica(id);
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
