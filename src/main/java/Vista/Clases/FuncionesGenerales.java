/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Clases;

import javax.swing.JComboBox;

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
}
