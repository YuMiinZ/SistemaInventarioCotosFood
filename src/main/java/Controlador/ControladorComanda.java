/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Comanda;
import Modelo.ConexionBD;
import Modelo.ProductoMenu;
import com.mongodb.client.MongoClient;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
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
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
       comanda = comanda.BuscarComanda(id, cliente);
       conexion.cerrarConexion(cliente);
    }
    
    public Comanda BuscarComanda(ObjectId id){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        Comanda comandaE = comanda.BuscarComanda(id, cliente);
        conexion.cerrarConexion(cliente);
        return comandaE;
    }
    
    public Comanda UltimaComanda(){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        Comanda comandaE = comanda.UltimaComanda(cliente);
        conexion.cerrarConexion(cliente);
        return comandaE;
    }
    
    public void AgregarComanda(double Monto, ArrayList<String> Platillos_Bebida, String Notes){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        comanda.RegistrarComanda(Monto, Platillos_Bebida, Notes, cliente);
        conexion.cerrarConexion(cliente);
        
    }
    
    public void EliminarComanda(ObjectId id){
        ConexionBD conexion = new ConexionBD();
        MongoClient cliente = conexion.crearConexion();
        comanda.eliminarComanda(id, cliente);
        conexion.cerrarConexion(cliente);
    }
    
    public void rellenarInfo(ArrayList<JTextArea> textos){
        List<ProductoMenu> productos = menu.ProductosenMenu(comanda.getPlatillos_Bebida());
        String[] contenido = Platillos_bebidas(productos);
        contenido[0] = contenido[0].replaceAll(", ", "\n");
        contenido[1] = contenido[1].replaceAll(", ", "\n");
        for(JTextArea campo: textos){
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
