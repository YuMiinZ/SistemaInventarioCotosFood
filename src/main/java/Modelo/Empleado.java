/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author yumii
 */
public class Empleado {
    private ObjectId id;
    private String nombre, telefono, alergias, tipoSangre;
    private int vacaciones;
    private Date fecha_ingreso, fecha_vencimiento_carnet;
    
    public Empleado() {}
    
    public Empleado(ObjectId id, String nombre, String telefono, String alergias, String tipoSangre, int vacaciones, Date fecha_ingreso, Date fecha_vencimiento_carnet){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.alergias = alergias;
        this.tipoSangre = tipoSangre;
        this.vacaciones = vacaciones;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_vencimiento_carnet = fecha_vencimiento_carnet;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public int getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(int vacaciones) {
        this.vacaciones = vacaciones;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_vencimiento_carnet() {
        return fecha_vencimiento_carnet;
    }

    public void setFecha_vencimiento_carnet(Date fecha_vencimiento_carnet) {
        this.fecha_vencimiento_carnet = fecha_vencimiento_carnet;
    }
    
    public boolean registrarEmpleado(String nombre, String telefono, String alergias, String tipoSangre, int vacaciones, 
                                  Date fechaIngreso, Date fechaVencimientoCarnet, MongoClient cliente){

        
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Empleado");

        Document empleado = new Document("Nombre", nombre)
                                .append("Telefono", telefono)
                                .append("Alergias", alergias)
                                .append("Tipo_de_Sangre", tipoSangre)
                                .append("Vacaciones", vacaciones)
                                .append("Fecha_de_Ingreso", fechaIngreso)
                                .append("Fecha_Vencimiento_Carnet", fechaVencimientoCarnet);

        InsertOneResult result = coleccion.insertOne(empleado);
        return !result.toString().isEmpty();
    }
    
    public Empleado getEmpleado(ObjectId id, MongoClient cliente){
        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Empleado");

        Document doc = coleccion.find(eq("_id", id)).first();    
        Empleado Empleado = new Empleado(doc.getObjectId("_id"), doc.getString("Nombre"), doc.getString("Telefono"), doc.getString("Alergias"), doc.getString("Tipo_de_Sangre"), doc.getInteger("Vacaciones"), doc.getDate("Fecha_de_Ingreso"), doc.getDate("Fecha_Vencimiento_Carnet"));

        return Empleado;
    }
    
    public boolean modificarEmpleado(ObjectId id, String nombre, String telefono, String alergias, String tipoSangre, int vacaciones,
                              Date fechaIngreso, Date fechaVencimientoCarnet, MongoClient cliente) {

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Empleado");

        Document filtro = new Document("_id", id);

        Document datosActualizar = new Document("Nombre", nombre)
                .append("Telefono", telefono)
                .append("Alergias", alergias)
                .append("Tipo_de_Sangre", tipoSangre)
                .append("Vacaciones", vacaciones)
                .append("Fecha_de_Ingreso", fechaIngreso)
                .append("Fecha_Vencimiento_Carnet", fechaVencimientoCarnet);

        Document updateDocumento = new Document("$set", datosActualizar);

        UpdateResult result = coleccion.updateOne(filtro, updateDocumento);
        return !result.toString().isEmpty();
    }
    
    public List<Empleado> getListaEmpleados(MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Empleado");

        FindIterable<Document> iterable = coleccion.find();
        List<Empleado> listaEmpleados = new ArrayList<>();

        for (Document documento : iterable) {
            Empleado empleado = new Empleado();
            empleado.setNombre(documento.getString("Nombre"));
            empleado.setTelefono(documento.getString("Telefono"));
            empleado.setAlergias(documento.getString("Alergias"));
            empleado.setTipoSangre(documento.getString("Tipo_de_Sangre"));
            empleado.setVacaciones(documento.getInteger("Vacaciones"));
            empleado.setFecha_ingreso(documento.getDate("Fecha_de_Ingreso"));
            empleado.setFecha_vencimiento_carnet(documento.getDate("Fecha_Vencimiento_Carnet"));
            
            // Obtener y establecer el ObjectId
            ObjectId objectId = documento.getObjectId("_id");
            empleado.setId(objectId);

            listaEmpleados.add(empleado);
        }


        return listaEmpleados;
    }
    
    public boolean eliminarEmpleado(ObjectId id, MongoClient cliente){

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Empleado");

        Document filtro = new Document("_id", id);
        DeleteResult result = coleccion.deleteOne(filtro);
        return !result.toString().isEmpty();
    }
    
    public List<String[]> getEmpleadosProximosAVencer(MongoClient cliente) {

        MongoDatabase db = cliente.getDatabase("SistemaInventarioCotosFood");
        MongoCollection<Document> coleccion = db.getCollection("Empleado");

        FindIterable<Document> iterable = coleccion.find();
        List<String[]> empleadosProximosAVencer = new ArrayList<>();

        LocalDate hoy = LocalDate.now(); 

        for (Document documento : iterable) {
            String nombreEmpleado = documento.getString("Nombre");
            LocalDate fechaVencimiento = documento.getDate("Fecha_Vencimiento_Carnet").toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            long diffMeses = ChronoUnit.MONTHS.between(hoy, fechaVencimiento);

            if (diffMeses <= 1) {
                String[] empleado = new String[2];
                empleado[0] = nombreEmpleado;
                empleado[1] = fechaVencimiento.toString();
                empleadosProximosAVencer.add(empleado);
            }
        }

        return empleadosProximosAVencer;
    }

}
