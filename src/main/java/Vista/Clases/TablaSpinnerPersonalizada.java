/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Clases;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author yumii
 */
public class TablaSpinnerPersonalizada {

    public static class SpinnerEditor extends DefaultCellEditor {
        private final JSpinner spinner;

        public SpinnerEditor() {
            super(new JTextField());
            spinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
            ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setHorizontalAlignment(JTextField.RIGHT);
            editorComponent = spinner;
            delegate = new DefaultCellEditor.EditorDelegate() {
                @Override
                public void setValue(Object value) {
                    spinner.setValue(value);
                }

                @Override
                public Object getCellEditorValue() {
                    return spinner.getValue();
                }
            };
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            spinner.setValue(value);
            return editorComponent;
        }
    }

    public static class SpinnerRenderer extends DefaultTableCellRenderer {
        private final JSpinner spinner = new JSpinner();

        public SpinnerRenderer() {
            super();
            spinner.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
            spinner.setBorder(null);
            spinner.setFocusable(false);
            spinner.setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            spinner.setValue(value);
            return spinner;
        }
    }
    // Esta funcion se puede usar para llenar las tablas solo que debe de llamar al controlador 
    public static DefaultTableModel llenarTabla2columnas(String nombreMenu, String Text) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Columna 1");
        model.addColumn(Text);

        model.addRow(new Object[]{"Vencimiento próximo carné de manipulación de alimentos Juan Mora el 24-12-2023", Text});
        model.addRow(new Object[]{"Dato 2", Text});
        model.addRow(new Object[]{"Dato 3", Text});

        return model;
    }
    
     public static DefaultTableModel llenarTabla3columnas(String nombreMenu, String Text) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Columna 1");
        model.addColumn("Columna 2");
        model.addColumn(Text);

        model.addRow(new Object[]{"Arroz", "300 gramos", Text});
        model.addRow(new Object[]{"Frijoles", "300 gramos", Text});
        model.addRow(new Object[]{"Leche", "3 cajas", Text});

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

        public ButtonEditor(JCheckBox checkBox, String Text, JTable tabla, String NombreTabla, JFrame dad) {
            super(checkBox);
            button = new JButton(Text);
            button.setOpaque(true);

            button.addActionListener(e -> {
                /*int dialogResult = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar esta fila?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    int row = tableCompraProveedor.convertRowIndexToModel(tableCompraProveedor.getEditingRow());
                    ((DefaultTableModel) tableCompraProveedor.getModel()).removeRow(row);
                }*/
                MenuBoton opcion = new MenuBoton(0, 0, dad);
                opcion.abrirVentanas(NombreTabla, tabla.convertRowIndexToModel(tabla.getEditingRow()));
                /*JOptionPane.showMessageDialog(
                null,
                "Fila seleccionada: " + tabla.convertRowIndexToModel(tabla.getEditingRow()));*/
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
    