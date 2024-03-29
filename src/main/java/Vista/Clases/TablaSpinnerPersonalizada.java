/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Clases;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.util.List;

/**
 *
 * @author yumii
 */
public class TablaSpinnerPersonalizada {
    

    public static class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
        private final JSpinner spinner;
        private int fila;
        
        public SpinnerEditor() {
            spinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 1.0));
            ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setHorizontalAlignment(JTextField.RIGHT);
            spinner.addChangeListener(e -> {
                if (fila >= 0) {
                    fireEditingStopped(); // Detiene la edición de la celda
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            fila = row;
            spinner.setValue(value);
            return spinner;
        }

        @Override
        public Object getCellEditorValue() {
            return spinner.getValue();
        }
    }

    // Clase SpinnerRenderer
    public static class SpinnerRenderer extends DefaultTableCellRenderer {
        private final JSpinner spinner;

        public SpinnerRenderer() {
            spinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, Double.MAX_VALUE, 1.0));
            spinner.setBorder(null);
            spinner.setFocusable(false);
            spinner.setOpaque(true);
            ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setHorizontalAlignment(JTextField.RIGHT);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            spinner.setValue(value);
            return spinner;
        }
    }
    
    public static DefaultTableModel crearColumnas(int cantidad){
        DefaultTableModel model = new DefaultTableModel();
        for (int i = 0; i < cantidad; i++) {
             model.addColumn("Vacio");
        }
        
        return model;
    }
    
    private static boolean validarDatos(Object datos) {
        return datos != null;
    }
 
    // Esta funcion se puede usar para llenar las tablas solo que debe de llamar al controlador 
    public static DefaultTableModel llenarTabla2columnas(List<String> datos, String Text) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Columna 1");
        model.addColumn(Text);
        
        if(validarDatos(datos)){
            for (String dato : datos) {
                model.addRow(new Object[]{dato, Text});
            }
        }
        
        return model;
    }
    
    // Esta funcion se puede usar para llenar las tablas solo que debe de llamar al controlador 
    public static DefaultTableModel llenarTabla2columnas(List<String[]> datos) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Columna 1");
        model.addColumn("Columna 2");
        
        if(validarDatos(datos)){
            for (String[] dato : datos) {
                model.addRow(new Object[]{dato[0], dato[1]});
            }
        }
        

        return model;
    }
    
     public static DefaultTableModel llenarTabla3columnas(List<String[]> datos, String Text) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Columna 1");
        model.addColumn("Columna 2");
        model.addColumn(Text);

        if(validarDatos(datos)){
            for (String[] dato : datos) {
                model.addRow(new Object[]{dato[0], dato[1], Text});
            }
        }
        return model;
    }
    public static void setCellBorders(JTable table) {
        table.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
    }

    static class CustomTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            ((JComponent) c).setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK)); // Solo línea inferior
            return c;
        }
        
    }
    public static class ButtonEditor extends DefaultCellEditor {
        protected JButton button;

        public ButtonEditor(JCheckBox checkBox, String Text, JTable tabla, String NombreTabla, JFrame dad, java.util.List<Object> lista, 
                            List<String[]> notificaciones) {
            super(checkBox);
            button = new JButton(Text);
            button.setOpaque(true);

            button.addActionListener(e -> {
                if(button.getText().equals("Eliminar")){
                    int dialogResult = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar esta fila?", null, JOptionPane.YES_NO_OPTION);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        int row = tabla.convertRowIndexToModel(tabla.getEditingRow());
                        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                        model.removeRow(row);
                        model.fireTableDataChanged();
                        TableCellEditor editor = tabla.getCellEditor();
                        if (editor != null) {
                            editor.cancelCellEditing();
                        }
                    }
                } else {
                    MenuBoton opcion = new MenuBoton(0, 0, dad, notificaciones);
                    opcion.abrirVentanas(NombreTabla, lista.get(tabla.convertRowIndexToModel(tabla.getEditingRow())), notificaciones);
                }
                
            });
            button.setFocusPainted(false);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }
        
        @Override
        public Object getCellEditorValue() {
            return button.getText();
        }
        
    }
}
    