/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author yumii
 */
public class pruebaFunciones {
    
    public static void main(String[] args) {
        Empleado consultas = new Empleado();
        ObjectId objectId = new ObjectId("6592336a4a890f17050e9ccf");
        String nuevoNombre = "Nuevo Nombre";
        String nuevoTelefono = "987654321";
        String nuevasAlergias = "Alergias actualizadas";
        String nuevoTipoSangre = "B+";
        int nuevasVacaciones = 21;
        Date nuevaFechaIngreso = new Date(); // Nueva fecha actual
        Date nuevaFechaVencimientoCarnet = new Date();

        consultas.modificarEmpleado(objectId, nuevoNombre, nuevoTelefono, nuevasAlergias, nuevoTipoSangre, nuevasVacaciones,
            nuevaFechaIngreso, nuevaFechaVencimientoCarnet);
        System.out.println("Registro exitoso");
        
    }
}
