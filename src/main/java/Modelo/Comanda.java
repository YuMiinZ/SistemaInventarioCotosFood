/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author TomasPC
 */
public class Comanda {
        private ObjectId id;
        private ArrayList <ProductoInventario> Platillos_Bebida;
        private String Notes;
        
        public Comanda(ArrayList<ProductoInventario> Platillos_Bebida, String Notes){
            this.Platillos_Bebida = Platillos_Bebida;
            this.Notes = Notes;
        }
                
        public Comanda(ObjectId id, ArrayList<ProductoInventario> Platillos_Bebida, String Notes){
            this.id = id;
            this.Platillos_Bebida = Platillos_Bebida;
            this.Notes = Notes;
        }
        
        public void RegistrarComanda(ArrayList<ProductoInventario> Platillos_Bebida, String Notes){
            ConexionBD conexion = new ConexionBD();
            MongoClient cliente = conexion.crearConexion();
            
            MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
            MongoCollection<Document> coleccion = db.getCollection("Comanda");
            
            Document Comanda = new Document("ID_Platillos_Bebida", Platillos_Bebida)
                                .append("Notas", Notes);
            
            coleccion.insertOne(Comanda);
            conexion.cerrarConexion(cliente);
        }
        
        public void eliminarComanda(ObjectId id){
            ConexionBD conexion = new ConexionBD();
            MongoClient cliente = conexion.crearConexion();

            MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
            MongoCollection<Document> coleccion = db.getCollection("Comanda");

            Document filtro = new Document("_id", id);
            coleccion.deleteOne(filtro);

            conexion.cerrarConexion(cliente);
        }
}
