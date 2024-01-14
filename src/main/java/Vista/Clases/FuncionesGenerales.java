/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    public boolean validarFecha(String fecha, int indice, ManejadorComponentes manejadorComponentes) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);
        try {
            Date fechaConvertida = formatoFecha.parse(fecha);
             manejadorComponentes.ocultarLabel(indice);
            return true;
        } catch (ParseException e) {
            manejadorComponentes.mostrarLabel(indice);
            return false;
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
    
    public boolean validarTelefono(String telefono,int indice, ManejadorComponentes manejadorComponentes) {
    if (!telefono.matches("\\d{8}")) {
        manejadorComponentes.mostrarLabel(indice);
        return false;
    } else {
        manejadorComponentes.ocultarLabel(indice);
        return true;
    }
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
    
    
    /**
     * Validación de ambas tablas de la comanda (platillos y bebidas)
     * Retornará true si cualquiera de las variables booleanas contiene un true y sino un false idicando que ambas no cumplen
     * con las validaciones y es false.
     * @param tablaPlatillos
     * @param tablaBebidas
     * @return 
     */
    public boolean validarTablaComandas(JTable tablaPlatillos, JTable tablaBebidas) {
        boolean datosValidosPlatillos = validarTablaDatosEspecificaComanda(tablaPlatillos);
        boolean datosValidosBebidas = validarTablaDatosEspecificaComanda(tablaBebidas);

        return datosValidosPlatillos || datosValidosBebidas;
    }
    
    /**
     * Validación específica de las tablas de las comandas, realiza las siguientes validaciones:
     * 1. Permite que al menos una fila sea null y continua con la segunda validación
     * 2. Busca al menos una fila con datos válidos y retorna true
     * 3. Si encontró al menos una fila con null, pero no encontró ninguna con datos válidos retorna false, indicando
     *    que no hay filas con datos válidos.
     * @param tabla
     * @return 
     */
    public boolean validarTablaDatosEspecificaComanda(JTable tabla) {
        int rowCount = tabla.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            Object dato = tabla.getValueAt(i, 0);
            Object cantidad = tabla.getValueAt(i, 1);

            if (dato == null && cantidad == null) {
                continue; 
            }

            if (dato != null && !dato.toString().isEmpty() && cantidad instanceof Double) {
                if ((double) cantidad > 0.0) {
                    return true; 
                }
            }
        }

        return false; 
    }
}
