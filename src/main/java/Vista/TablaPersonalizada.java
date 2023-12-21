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

    public static void setTableProperties(JTable table, DefaultTableModel model, boolean boton) {
        String columnName = null;
        
        table.setBackground(Color.WHITE);
        table.setBorder(null);
        table.setShowGrid(false);
        table.setFillsViewportHeight(true);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setPreferredSize(new Dimension(0, 0));

        table.setModel(model);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setFont(new Font("Montserrat", Font.PLAIN, 20));
        
        int countColumn = table.getColumnCount();
        
        if(countColumn == 2 && boton){
            table.getColumnModel().getColumn(0).setPreferredWidth(950);
            columnName = table.getColumnName(1);
        } else if (countColumn == 2 && !boton){
            table.getColumnModel().getColumn(0).setPreferredWidth(950);
        } else if (countColumn == 3 && boton){
            table.getColumnModel().getColumn(0).setPreferredWidth(475);
            table.getColumnModel().getColumn(1).setPreferredWidth(475);
            columnName = table.getColumnName(2);
        }

        if( columnName != null){
            table.getColumn(columnName).setCellRenderer(new ButtonRenderer());
        }
        



        table.setRowHeight(table.getRowHeight() + 30);
    }
}