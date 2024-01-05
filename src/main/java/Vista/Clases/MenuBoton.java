package Vista.Clases;


import Modelo.ProductoInventario;
import Modelo.ProductoMenu;
import Vista.JF_ComandasEmpleado;
import Vista.JF_ComandasMesa;
import Vista.JF_CompraDia;
import Vista.JF_CompraProveedor;
import Vista.JF_Inventario;
import Vista.JF_ListaConsumoEmpleado;
import Vista.JF_ListaCuentas;
import Vista.JF_Menu;
import Vista.JF_ModificarEmpleado;
import Vista.JF_ModificarProductoInventario;
import Vista.JF_ModificarProductoMenu;
import Vista.JF_ModificarProveedor;
import Vista.JF_Notificaciones;
import Vista.JF_Principal;
import Vista.JF_RegistrarEmpleado;
import Vista.JF_RegistrarProveedor;
import Vista.JF_Reportes;
import Vista.JF_VerComandaEmpleado;
import Vista.JF_VerComandaMesa;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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
    private  JMenuItem[] inventarioItems;
    private  JMenuItem[] empleadoItems;
    private  JMenuItem[] reportesItems;
    private  JMenuItem notificacionesMenu;
    private  JMenuItem consumoClienteMenu;
    private  JMenuItem menuMenu;
    public boolean menuAbierto = false;
    private JFrame dad;

    public MenuBoton() {
    }
    
    
    private void addMenuItemWithSeparator(JMenu menu, JMenuItem menuItem) {
        applyStyles(menuItem);
        menu.add(menuItem);

        JPanel spacePanel = new JPanel();
        spacePanel.setPreferredSize(new Dimension(0, 16));
        spacePanel.setBackground(new Color(152, 194, 70));
        menu.add(spacePanel);
    }

    private void applyStyles(JMenuItem menuItem) {
        menuItem.setForeground(new Color(25, 25, 25));
        menuItem.setBackground(new Color(152, 194, 70));
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
    public MenuBoton(int x, int y, JFrame dad, List<String[]> notificaciones){
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
        programarMenu(notificaciones);
        agregarFocusListener();
    }
    
    private void agregarFocusListener() {
        dad.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (menuAbierto) {
                    cerrarMenu();
                }
            }
        });
        
        dad.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                if (menuAbierto) {
                    cerrarMenu();
                }
            }
        });
    }
    
    public  void cerrarMenu() {
        this.setVisible(false); // Cierra el menú si está visible
        menuAbierto = false;
    }
    
    public void mostrarMenu() {
        this.show(dad, 11, 153);
        this.setVisible(true); // Cierra el menú si está visible
        menuAbierto = true;
    }
    
    private void programarMenu(List<String[]> notificaciones){
        for (JMenuItem item : inventarioItems) {
            item.addActionListener(e -> abrirVentanas(item.getText(), "", notificaciones));
        }

        for (JMenuItem item : empleadoItems) {
            item.addActionListener(e -> abrirVentanas(item.getText(), "", notificaciones));
        }

        for (JMenuItem item : reportesItems) {
            item.addActionListener(e -> abrirVentanas(item.getText(), "", notificaciones));
        }
        
        notificacionesMenu.addActionListener(e -> abrirVentana(JF_Notificaciones.class, "", 0, notificaciones));
        consumoClienteMenu.addActionListener(e -> abrirVentana(JF_ListaCuentas.class, "", 0, notificaciones));
        menuMenu.addActionListener(e -> abrirVentana(JF_Menu.class, "", 0, notificaciones));
    }
    
    private void abrirVentana(Class<?> ventanaClass, String reporte, Object dato, List<String[]> notificaciones) {
        try {
            JFrame ventana;
            System.out.println(ventanaClass.toString());
            if (ventanaClass.equals(JF_Reportes.class)){
                ventana = (JFrame) ventanaClass.getDeclaredConstructor(String.class, List.class).newInstance(reporte, notificaciones);
            }

            else if (ventanaClass.equals(JF_ComandasEmpleado.class) || ventanaClass.equals(JF_ComandasMesa.class)){
                ventana = (JFrame) ventanaClass.getDeclaredConstructor(String.class, List.class).newInstance((String) dato.toString(), notificaciones);
            }
            else if (ventanaClass.equals(JF_ModificarProductoInventario.class)){
                ventana = (JFrame) ventanaClass.getDeclaredConstructor(ProductoInventario.class, List.class).newInstance((ProductoInventario) dato, notificaciones);
            }
            else if (ventanaClass.equals(JF_ModificarProductoMenu.class)){
                ventana = (JFrame) ventanaClass.getDeclaredConstructor(ProductoMenu.class, List.class).newInstance((ProductoMenu) dato, notificaciones);
            }
            else{
                ventana = (JFrame) ventanaClass.getDeclaredConstructor(List.class).newInstance(notificaciones);
            }
            ventana.setVisible(true);
            dad.dispose(); 

        } catch (Exception ex) {
            ex.printStackTrace();
            // Maneja cualquier excepción que pueda ocurrir al crear la ventana
        }
    }
    
    public void abrirVentanas(String nombreMenu, Object dato, List<String[]> notificaciones) {
        switch (nombreMenu) {
            case "Lista de inventario" -> abrirVentana(JF_Inventario.class, nombreMenu, dato, notificaciones);
            case "Compra por día" -> abrirVentana(JF_CompraDia.class, nombreMenu, dato, notificaciones);
            case "Compra por proveedor" -> abrirVentana(JF_CompraProveedor.class, nombreMenu, dato, notificaciones);
            case "Registrar proveedor" -> abrirVentana(JF_RegistrarProveedor.class, nombreMenu, dato, notificaciones);
            case "Editar proveedor" -> abrirVentana(JF_ModificarProveedor.class, nombreMenu, dato, notificaciones);
            case "Registrar empleado" -> abrirVentana(JF_RegistrarEmpleado.class, nombreMenu, dato, notificaciones);
            case "Editar empleado" -> abrirVentana(JF_ModificarEmpleado.class, nombreMenu, dato, notificaciones);
            case "Consumo empleado" -> abrirVentana(JF_ListaConsumoEmpleado.class, nombreMenu, dato, notificaciones);
            case "Reporte de ventas" -> abrirVentana(JF_Reportes.class, nombreMenu, dato, notificaciones);
            case "Reporte de costo de mercadería más vendida" -> abrirVentana(JF_Reportes.class, nombreMenu, dato, notificaciones);
            case "Reporte de productos estancados" -> abrirVentana(JF_Reportes.class, nombreMenu, dato, notificaciones);
            case "Reporte de cantidad de productos mínimos" -> abrirVentana(JF_Reportes.class, nombreMenu, dato, notificaciones);
            case "Comandas empleado" -> abrirVentana(JF_ComandasEmpleado.class, nombreMenu, dato, notificaciones);
            case "Comandas mesa" -> abrirVentana(JF_ComandasMesa.class, nombreMenu, dato, notificaciones);            
            case "Ver Comanda empleado" -> abrirVentana(JF_VerComandaEmpleado.class, nombreMenu, dato, notificaciones);
            case "Ver Comanda mesa" -> abrirVentana(JF_VerComandaMesa.class, nombreMenu, dato, notificaciones);
            case "Editar producto inventario" -> abrirVentana(JF_ModificarProductoInventario.class, nombreMenu, dato, notificaciones);
            case "Editar producto Menu" -> abrirVentana(JF_ModificarProductoMenu.class, nombreMenu, dato, notificaciones);
            default -> {
            }
        }
        cerrarMenu();
    }
    public void setButtonIcon(JButton button, String imagePath){
        ImageIcon image = new ImageIcon(getClass().getResource(imagePath));
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT));
        button.setIcon(icon);
        button.repaint();
    }

    
    public void regresarVentanaPrincipal(List<String[]> notificaciones){
        abrirVentana(JF_Principal.class, "", "", notificaciones);
    }
}
