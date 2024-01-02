/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Clases;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author yumii
 */
public class ManejadorComponentes {
    private List<JLabel> listaLabels;
    private List<JTextField> listaTextos;
    private List<JComboBox> listaCmbox;
    private List<JSpinner> listaSpinner;

    public ManejadorComponentes() {
        listaLabels = new ArrayList<>();
        listaTextos = new ArrayList<>();
        listaCmbox = new ArrayList<>();
        listaSpinner = new ArrayList<>();
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
    public void ocultarLabel(int index) {
        if (index >= 0 && index < listaLabels.size()) {
            listaLabels.get(index).setVisible(false);
        }
    }
    
    public void mostrarLabels() {
        for (JLabel lbl : listaLabels) {
            lbl.setVisible(true);
        }
    }
    
    public void mostrarLabel(int index) {
        if (index >= 0 && index < listaLabels.size()) {
            listaLabels.get(index).setVisible(true);
        }
    }
    
    public void limpiarCamposTexto(){
        ocultarLabels();
        
        for (JTextField txt : listaTextos) {
            txt.setText("");
        }
    }
    
    public void agregarComboBox(JComboBox cmbox){
        listaCmbox.add(cmbox);
    }
    
    public void limpiarCmbox(){        
        for (JComboBox cmbox : listaCmbox) {
            cmbox.setSelectedIndex(-1);
        }
    }
    
    public void agregarSpinner(JSpinner spn){
        listaSpinner.add(spn);
    }
    
    public void limpiarSpinner(){        
        for (JSpinner spn : listaSpinner) {
            spn.setValue(0);
        }
    }
}
