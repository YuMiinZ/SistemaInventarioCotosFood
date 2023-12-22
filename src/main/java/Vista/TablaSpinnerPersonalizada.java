/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author yumii
 */
public class TablaSpinnerPersonalizada {

    public static void setSpinnerColumn(JTable table, int columnIndex) {
        table.getColumnModel().getColumn(columnIndex).setCellEditor(new SpinnerEditor());
        table.getColumnModel().getColumn(columnIndex).setCellRenderer(new SpinnerRenderer());
        table.getColumnModel().getColumn(0).setPreferredWidth(500);
        //setCellBorders(table);
    }

    static class SpinnerEditor extends DefaultCellEditor {
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

    static class SpinnerRenderer extends DefaultTableCellRenderer {
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
}