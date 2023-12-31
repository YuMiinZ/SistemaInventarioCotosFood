/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Clases;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author yumii
 */
public class ManejadorComponentes {
    private List<JLabel> listaLabels;
    private List<JTextField> listaTextos;

    public ManejadorComponentes() {
        listaLabels = new ArrayList<>();
        listaTextos = new ArrayList<>();
    }

    public void agregarLabel(JLabel lbl) {
        listaLabels.add(lbl);
    }
    
    public void agregarText(JTextField txt) {
        listaTextos.add(txt);
    }

    public void ocultarLabels() {
        for (JLabel label : listaLabels) {
            label.setVisible(false);
        }
    }
    
    public void mostrarLabels() {
        for (JLabel lbl : listaLabels) {
            lbl.setVisible(true);
        }
    }
    
    public void limpiarCampos(){
        ocultarLabels();
        
        for (JTextField txt : listaTextos) {
            txt.setText("");
        }
    }
    
}
