package Vista.Clases;


import Vista.JF_CompraDia;
import Vista.JF_CompraProveedor;
import Vista.JF_Inventario;
import Vista.JF_ListaConsumoEmpleado;
import Vista.JF_ListaCuentas;
import Vista.JF_Menu;
import Vista.JF_ModificarEmpleado;
import Vista.JF_ModificarProveedor;
import Vista.JF_Notificaciones;
import Vista.JF_Principal;
import Vista.JF_RegistrarEmpleado;
import Vista.JF_RegistrarProveedor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
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
public final class MenuBoton extends JPopupMenu{
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
            createMenuItem("Reporte de costo de mercadería más vendida"),
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
        
        programarMenu();
    }
    
    public  void cerrarMenu() {
        this.setVisible(false); // Cierra el menú si está visible
        menuAbierto = false;
    }
    
    public void mostrarMenu() {
        this.show(dad, 7, 84);
        this.setVisible(true); // Cierra el menú si está visible
        menuAbierto = true;
    }
    
    public void programarMenu(){
        for (JMenuItem item : inventarioItems) {
            item.addActionListener(e -> abrirVentanas(item.getText()));
        }

        for (JMenuItem item : empleadoItems) {
            item.addActionListener(e -> abrirVentanas(item.getText()));
        }

        for (JMenuItem item : reportesItems) {
            item.addActionListener(e -> abrirVentanas(item.getText()));
        }
        
        notificacionesMenu.addActionListener(e -> abrirVentana(JF_Notificaciones.class));
        consumoClienteMenu.addActionListener(e -> abrirVentana(JF_ListaCuentas.class));
        menuMenu.addActionListener(e -> abrirVentana(JF_Menu.class));
    }
    
    private void abrirVentana(Class<?> ventanaClass) {
        try {
            JFrame ventana = (JFrame) ventanaClass.getDeclaredConstructor().newInstance();
            ventana.setVisible(true);
            dad.dispose(); 

        } catch (Exception ex) {
            ex.printStackTrace();
            // Maneja cualquier excepción que pueda ocurrir al crear la ventana
        }
    }
    
    private void abrirVentanas(String nombreMenu) {
        if (nombreMenu.equals("Lista de inventario")) {
            abrirVentana(JF_Inventario.class);
        } else if (nombreMenu.equals("Compra por día")) {
            abrirVentana(JF_CompraDia.class);
        } else if (nombreMenu.equals("Compra por proveedor")) {
            abrirVentana(JF_CompraProveedor.class);
        } else if (nombreMenu.equals("Registrar proveedor")) {
            abrirVentana(JF_RegistrarProveedor.class);
        } else if (nombreMenu.equals("Editar proveedor")) {
            abrirVentana(JF_ModificarProveedor.class);
        } 
        
        else if (nombreMenu.equals("Registrar empleado")) {
            abrirVentana(JF_RegistrarEmpleado.class);
        } else if (nombreMenu.equals("Editar empleado")) {
            abrirVentana(JF_ModificarEmpleado.class);
        } else if (nombreMenu.equals("Consumo empleado")) {
            abrirVentana(JF_ListaConsumoEmpleado.class);
        } 
        
        else if (nombreMenu.equals("Reporte de ventas")) {
            //abrirVentana(JF_ModificarProveedor.class);
            JOptionPane.showMessageDialog(this, "Seleccionaste: " + nombreMenu);
        } else if (nombreMenu.equals("Reporte de costo de mercadería más vendida")) {
            //abrirVentana(JF_ModificarProveedor.class);
            JOptionPane.showMessageDialog(this, "Seleccionaste: " + nombreMenu);
        } else if (nombreMenu.equals("Reporte de productos estancados")) {
            //abrirVentana(JF_ModificarProveedor.class);
            JOptionPane.showMessageDialog(this, "Seleccionaste: " + nombreMenu);
        } else if (nombreMenu.equals("Reporte de cantidad de productos mínimos")) {
            //abrirVentana(JF_ModificarProveedor.class);
            JOptionPane.showMessageDialog(this, "Seleccionaste: " + nombreMenu);
        } 
        cerrarMenu();
    }
}
