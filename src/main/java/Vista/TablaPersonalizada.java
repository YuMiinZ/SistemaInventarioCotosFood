/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
/**
 *
 * @author yumii
 */
public class TablaPersonalizada {

    public static void setScrollPaneProperties(JScrollPane scrollPane) {
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBorder(null);
    }

    public static void setTableProperties(JTable table, boolean boton) {
        table.setBackground(Color.WHITE);
        table.setBorder(null);
        table.setShowGrid(false);
        table.setFillsViewportHeight(true);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setPreferredSize(new Dimension(0, 0));

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    if (column == 0 || (column == 1 && !boton)) {
                        setHorizontalAlignment(JLabel.LEFT);
                    } else {
                        setHorizontalAlignment(JLabel.RIGHT);
                    }

                    rendererComponent.setBackground(table.getBackground());

                    if (isSelected) {
                        rendererComponent.setForeground(Color.BLACK);
                    } else {
                        rendererComponent.setForeground(table.getForeground());
                    }

                    return rendererComponent;
                }
            });
            table.getColumnModel().getColumn(i).setPreferredWidth(120);
        }

        table.setRowHeight(table.getRowHeight() + 30);
    }
}