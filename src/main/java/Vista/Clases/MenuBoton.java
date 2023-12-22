package Vista.Clases;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TomasPC
 */
public class MenuBoton extends JPopupMenu{
    private final JMenuItem[] inventarioItems;
    private final JMenuItem[] empleadoItems;
    private final JMenuItem[] reportesItems;
    private final JMenuItem notificacionesMenu;
    private final JMenuItem consumoClienteMenu;
    private final JMenuItem menuMenu;
    public boolean menuAbierto = false;
    
    private JFrame dad;
    
    
    private void addMenuItemWithSeparator(JMenu menu, JMenuItem menuItem) {
        applyStyles(menuItem);
        menu.add(menuItem);

        JPanel spacePanel = new JPanel();
        spacePanel.setPreferredSize(new Dimension(0, 16));
        spacePanel.setBackground(new Color(57, 145, 151));
        menu.add(spacePanel);
    }

    private void applyStyles(JMenuItem menuItem) {
        menuItem.setForeground(Color.WHITE);
        menuItem.setBackground(new Color(57, 145, 151));
        menuItem.setOpaque(true);
    }
    
    private JMenuItem createMenuItem(String itemName) {
        JMenuItem menuItem = new JMenuItem(itemName);
        menuItem.setFont(new Font("Montserrat", Font.BOLD, 20));
        applyStyles(menuItem);
        return menuItem;
    }

    private JMenu createMenuWithItems(String menuName, JMenuItem[] items) {
        JMenu subMenu = new JMenu(menuName);
        applyStyles(subMenu);

        for (JMenuItem item : items) {
            addMenuItemWithSeparator(subMenu, item);
        }

        return subMenu;
    }
    public MenuBoton(int x, int y, JFrame dad){
        this.dad = dad;
        inventarioItems = new JMenuItem[]{
            createMenuItem("Lista de inventario"),
            createMenuItem("Compra por día"),
            createMenuItem("Compra por proveedor"),
            createMenuItem("Registrar proveedor"),
            createMenuItem("Editar proveedor")
        };
        JMenu inventarioSubMenu = createMenuWithItems("Inventario", inventarioItems);
        inventarioSubMenu.setFont(new Font("Montserrat", Font.BOLD, 24));
        
        empleadoItems = new JMenuItem[]{
            createMenuItem("Registrar empleado"),
            createMenuItem("Editar empleado"),
            createMenuItem("Consumo empleado")
        };
        JMenu empleadoSubMenu = createMenuWithItems("Empleado", empleadoItems);
        empleadoSubMenu.setFont(new Font("Montserrat", Font.BOLD, 24));
        
        reportesItems = new JMenuItem[]{
            createMenuItem("Reporte de ventas"),
            createMenuItem("Reporte de costode mercadería más vendida"),
            createMenuItem("Reporte de productos estancados"),
            createMenuItem("Reporte de cantidad de productos mínimos")
        };
        JMenu reportesSubMenu = createMenuWithItems("Reportes", reportesItems);
        reportesSubMenu.setFont(new Font("Montserrat", Font.BOLD, 24));
        
        notificacionesMenu = createMenuItem("Notificaciones");
        notificacionesMenu.setFont(new Font("Montserrat", Font.BOLD, 24));
        
        consumoClienteMenu = createMenuItem("Consumo cliente");
        consumoClienteMenu.setFont(new Font("Montserrat", Font.BOLD, 24));
        
        menuMenu = createMenuItem("Menú");
        menuMenu.setFont(new Font("Montserrat", Font.BOLD, 24));

        this.add(notificacionesMenu);
        this.add(inventarioSubMenu);
        this.add(consumoClienteMenu);
        this.add(menuMenu);
        this.add(empleadoSubMenu);
        this.add(reportesSubMenu);
        this.setPreferredSize(new Dimension(x, y));
    }
    public  void cerrarMenu() {
        this.setVisible(false); // Cierra el menú si está visible
    }
    
    public void mostrarMenu() {
        this.show(dad, 7, 84);
        this.setVisible(true); // Cierra el menú si está visible
    }
    
    public void programarMenu(){
        for (JMenuItem item : inventarioItems) {
            item.addActionListener(e -> mostrarMensaje(item.getText()));
        }

        for (JMenuItem item : empleadoItems) {
            item.addActionListener(e -> mostrarMensaje(item.getText()));
        }

        for (JMenuItem item : reportesItems) {
            item.addActionListener(e -> mostrarMensaje(item.getText()));
        }
        
        notificacionesMenu.addActionListener(e -> mostrarMensaje(notificacionesMenu.getText()));
        consumoClienteMenu.addActionListener(e -> mostrarMensaje(consumoClienteMenu.getText()));
        menuMenu.addActionListener(e -> mostrarMensaje(menuMenu.getText()));
    }
    
    private void mostrarMensaje(String nombreMenu) {
        JOptionPane.showMessageDialog(this, "Seleccionaste: " + nombreMenu);
        cerrarMenu();
        menuAbierto = !menuAbierto;
    }
}
