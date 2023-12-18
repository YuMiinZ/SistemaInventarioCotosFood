/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author yumii
 */
public class JF_RegistrarProductoInventario extends javax.swing.JFrame {
    private boolean menuAbierto = false;
    
    private JPopupMenu menu = new JPopupMenu();
    private JMenuItem[] inventarioItems;
    private JMenuItem[] empleadoItems;
    private JMenuItem[] reportesItems;
    private JMenuItem notificacionesMenu;
    private JMenuItem consumoClienteMenu;
    private JMenuItem menuMenu;

    /**
     * Creates new form JF_Principal
     */
    public JF_RegistrarProductoInventario() {
        initComponents();
        customComponents();
        eventComponents();
        crearMenu();
        cerrarMenu();
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblProveedor = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        lblCotosFood = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        lblPrecio = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblCantMinima = new javax.swing.JLabel();
        txtCantMinima = new javax.swing.JTextField();
        lblDiaCompra = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        cmboxEstado = new javax.swing.JComboBox<>();
        txtUnidadMedida = new javax.swing.JTextField();
        lblUnidadMedida = new javax.swing.JLabel();
        spnPrecio = new javax.swing.JSpinner();
        cmboxProveedor = new javax.swing.JComboBox<>();
        cmboxDiaCompra = new javax.swing.JComboBox<>();
        spnCantidad = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1747, 1291));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProveedor.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblProveedor.setText("Proveedor");
        jPanel1.add(lblProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 470, -1));

        lblNombre.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 470, -1));

        txtNombre.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 470, 38));

        btnAgregar.setBackground(new java.awt.Color(0, 72, 121));
        btnAgregar.setFont(new Font ("Montserrat", Font.BOLD,30));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 780, 199, 50));

        lblTitulo.setFont(new Font("HeadlandOne", Font.BOLD, 64));
        lblTitulo.setForeground(new java.awt.Color(0, 72, 121));
        lblTitulo.setText("Registrar Producto Inventario");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        jPanel2.setBackground(new java.awt.Color(57, 145, 151));
        jPanel2.setMinimumSize(new java.awt.Dimension(1747, 105));

        btnMenu.setBorderPainted(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblCotosFood.setFont(new Font("Montserrat", Font.BOLD, 28));
        lblCotosFood.setForeground(new java.awt.Color(255, 255, 255));
        lblCotosFood.setText("Cotos Food");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCotosFood)
                .addContainerGap(1602, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblCotosFood, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoRegresar.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 40, 40));

        lblPrecio.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblPrecio.setText("Precio");
        jPanel1.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 470, -1));

        lblCantidad.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblCantidad.setText("Cantidad");
        jPanel1.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 660, 510, -1));

        lblCantMinima.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblCantMinima.setText("Cantidad Mínima");
        jPanel1.add(lblCantMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 180, 470, -1));

        txtCantMinima.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(txtCantMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 230, 470, 38));

        lblDiaCompra.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblDiaCompra.setText("Día de Compra");
        jPanel1.add(lblDiaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 340, 470, -1));

        lblEstado.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblEstado.setText("Estado");
        jPanel1.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 500, 470, -1));

        cmboxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Congelado", "Producción" }));
        cmboxEstado.setSelectedIndex(-1);
        cmboxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 550, 470, 40));

        txtUnidadMedida.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtUnidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadMedidaActionPerformed(evt);
            }
        });
        jPanel1.add(txtUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 710, 470, 38));

        lblUnidadMedida.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblUnidadMedida.setText("Unidad de Medida");
        jPanel1.add(lblUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 660, 510, -1));

        spnPrecio.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(spnPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 470, 40));

        cmboxProveedor.setFont(new Font ("Montserrat", Font.PLAIN,26));
        cmboxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 470, 40));

        cmboxDiaCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes" }));
        cmboxDiaCompra.setSelectedIndex(-1);
        cmboxDiaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxDiaCompraActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxDiaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 390, 470, 40));

        spnCantidad.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(spnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 710, 470, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cmboxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxEstadoActionPerformed

    private void txtUnidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadMedidaActionPerformed

    private void cmboxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxProveedorActionPerformed

    private void cmboxDiaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxDiaCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxDiaCompraActionPerformed

    private void customComponents(){
        setButtonIcon(btnMenu, "src/main/resources/Imagenes/IconoMenu.png");
        setButtonIcon(btnRegresar, "src/main/resources/Imagenes/IconoRegresar.png");

}

    
    private void eventComponents() {
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menuAbierto) {
                    cerrarMenu();
                } else {
                    mostrarMenu();
                }
                menuAbierto = !menuAbierto; // Cambia el estado del menú
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_RegistrarProductoInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_RegistrarProductoInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_RegistrarProductoInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_RegistrarProductoInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_RegistrarProductoInventario().setVisible(true);
            }
        });
    }
   

    private void cerrarMenu() {
        menu.setVisible(false); // Cierra el menú si está visible
    }
    
    private void mostrarMenu() {
        menu.show(this, 7, 84);
        menu.setVisible(true); // Cierra el menú si está visible

    }

    private void crearMenu() {
        menu.setUI(new MenuPersonalizado());

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

        menu.add(notificacionesMenu);
        menu.add(inventarioSubMenu);
        menu.add(consumoClienteMenu);
        menu.add(menuMenu);
        menu.add(empleadoSubMenu);
        menu.add(reportesSubMenu);

        menu.setPreferredSize(new Dimension(300, getContentPane().getHeight() - 97));
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

    
    private void setButtonTransparent(){
        btnMenu.setOpaque(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setBorderPainted(false);
    }
    
    private void setButtonIcon(JButton button, String imagePath){
        ImageIcon image = new ImageIcon(imagePath);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT));
        button.setIcon(icon);
        button.repaint();
    }
    
    private void setImageLabel(JLabel lblName, String imagePath) {
        ImageIcon image = new ImageIcon(imagePath);
        Image scaledImage = image.getImage().getScaledInstance(lblName.getWidth(), lblName.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        lblName.setIcon(scaledIcon);
        this.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmboxDiaCompra;
    private javax.swing.JComboBox<String> cmboxEstado;
    private javax.swing.JComboBox<String> cmboxProveedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCantMinima;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCotosFood;
    private javax.swing.JLabel lblDiaCompra;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUnidadMedida;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JSpinner spnPrecio;
    private javax.swing.JTextField txtCantMinima;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
