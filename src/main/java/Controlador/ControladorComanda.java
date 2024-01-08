/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Comanda;
import java.util.ArrayList;
import javax.swing.JTextField;
import org.bson.types.ObjectId;

/**
 *
 * @author TomasPC
 */
public class ControladorComanda {
    private Comanda comanda = new Comanda();
    private ControladorProductoMenu menu = new ControladorProductoMenu();

    public ControladorComanda(ObjectId id){
       comanda = comanda.BuscarComanda(id);
    }
    
    public Comanda BuscarComanda(ObjectId id){
        return comanda.BuscarComanda(id);
    }
    
    public void AgreagarComanda(ArrayList<String> Platillos_Bebida, String Notes){
        comanda.RegistrarComanda(Platillos_Bebida, Notes);
    }
    
    public void EliminarComanda(ObjectId id){
        comanda.eliminarComanda(id);
    }
    
    public void rellenarInfo(ArrayList<JTextField> textos){
        for(JTextField campo: textos){
            switch(campo.getName()){
                case "Platillos" -> campo.setText(String.join(", ", comanda.getPlatillos_Bebida())); 
                case "Bebidas" -> campo.setText(String.join(", ", comanda.getPlatillos_Bebida()));                 
                case "Notas" -> campo.setText(comanda.getNotes()); 
            }
            campo.repaint();
        }
    }
    
    
}
