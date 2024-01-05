/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Clases;

import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author yumii
 */
public class FuncionesGenerales {

    public FuncionesGenerales() {
    }
    
    public void seleccionarEnComboBox(JComboBox<String> comboBox, String opcion) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(opcion)) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public boolean validarCampo(Object valor, int indice, ManejadorComponentes manejadorComponentes) {
        boolean esValido = true;
        if (valor == null || valor.toString().isEmpty()) {
            manejadorComponentes.mostrarLabel(indice);
            esValido = false;
        } else {
            manejadorComponentes.ocultarLabel(indice);
        }
        return esValido;
    }
    
    public boolean validarNumeroPositivo(double valor, int indice, ManejadorComponentes manejadorComponentes) {
        boolean esValido = true;
        if (valor < 0) {
            manejadorComponentes.mostrarLabel(indice);
            esValido = false;
        } else {
            manejadorComponentes.ocultarLabel(indice);
        }
        return esValido;
    }

    public boolean validarEnteroPositivo(int valor, int indice, ManejadorComponentes manejadorComponentes) {
        boolean esValido = true;
        if (valor < 0) {
            manejadorComponentes.mostrarLabel(indice);
            esValido = false;
        } else {
            manejadorComponentes.ocultarLabel(indice);
        }
        return esValido;
    }
    
    public boolean validarTabla(JTable tabla, int indice, ManejadorComponentes manejadorComponentes) {
        boolean esValido = validarTabla(tabla);
        if (!esValido) {
            manejadorComponentes.mostrarLabel(indice);
        } else {
            manejadorComponentes.ocultarLabel(indice);
        }
        return esValido;
    }
    
        /**
     * Para que retorne true se debe de cumplir estas condiciones: 
     * 1. Que la tabla al menos 1 fila de datos.
     * 2. Que exista al menos 1 fila con datos correctos, es decir, el usuario
     * debe de haber escogido el ingrediente y haber ingresado la cantidad de dicho ingrediente
     * @param tablaIngredientes
     * @return 
     */
    public boolean validarTabla(JTable tablaIngredientes) {
        boolean tablaNoVacia = false;
        boolean datosValidos = false;

        int rowCount = tablaIngredientes.getRowCount();
        if (rowCount == 0) {
            return false;
        } else {
            tablaNoVacia = true;
        }

        for (int i = 0; i < rowCount; i++) {
            Object ingrediente = tablaIngredientes.getValueAt(i, 0);
            Object cantidad = tablaIngredientes.getValueAt(i, 1);
            if (ingrediente != null && !ingrediente.toString().isEmpty() && cantidad instanceof Double) {
                if ((double) cantidad > 0.0) {
                    datosValidos = true;
                    break;
                }
            }
        }

        return !(!tablaNoVacia || !datosValidos);
    }
}
