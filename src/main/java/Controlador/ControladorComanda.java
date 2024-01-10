/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Comanda;
import Modelo.ProductoMenu;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import org.bson.types.ObjectId;

/**
 *
 * @author TomasPC
 */
public class ControladorComanda {
    private Comanda comanda = new Comanda();
    private ControladorProductoMenu menu = new ControladorProductoMenu();
    
    /**
     *
     */
    public ControladorComanda(){}

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
        List<ProductoMenu> productos = menu.ProductosenMenu(comanda.getPlatillos_Bebida());
        String[] contenido = Platillos_bebidas(productos);
        for(JTextField campo: textos){
            switch(campo.getName()){
                case "Platillos" -> campo.setText(contenido[0]); 
                case "Bebidas" -> campo.setText(contenido[1]);                 
                case "Notas" -> campo.setText(comanda.getNotes()); 
            }
            campo.repaint();
        }
    }
    
    private String[] Platillos_bebidas(List<ProductoMenu> productos){
        String[] result = {"", ""};
        for (ProductoMenu producto: productos){
            switch (producto.getTipoProducto()){
                case "Platillo" -> result[0] = result[0].concat(producto.getNombre()+", ");
                case "Bebida" -> result[1] = result[1].concat(producto.getNombre()+", ");   
            }
        }
        return result;
    }
    
    
}
