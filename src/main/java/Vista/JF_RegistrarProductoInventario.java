/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Vista.Clases.MenuBoton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author yumii
 */
public class JF_RegistrarProductoInventario extends javax.swing.JFrame {
    
    private MenuBoton menu;


    /**
     * Creates new form JF_Principal
     */
    public JF_RegistrarProductoInventario() {
        initComponents();
        menu = new MenuBoton(300, getContentPane().getHeight() - 185, this);
        customComponents();
        eventComponents();

        
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
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
        jPanel1.setMinimumSize(new java.awt.Dimension(2160, 1440));
        jPanel1.setPreferredSize(new java.awt.Dimension(2160, 1440));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProveedor.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblProveedor.setText("Proveedor");
        jPanel1.add(lblProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, 470, -1));

        lblNombre.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 470, -1));

        txtNombre.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 470, 38));

        btnAgregar.setBackground(new java.awt.Color(0, 72, 121));
        btnAgregar.setFont(new Font ("Montserrat", Font.BOLD,30));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 950, 199, 50));

        lblTitulo.setFont(new Font("HeadlandOne", Font.BOLD, 64));
        lblTitulo.setForeground(new java.awt.Color(25, 25, 25));
        lblTitulo.setText("Registrar Producto Inventario");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        jPanel2.setBackground(new java.awt.Color(152, 194, 70));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(2222, 125));

        btnMenu.setBorderPainted(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.setMaximumSize(new java.awt.Dimension(71, 78));

        lblCotosFood.setFont(new Font("Montserrat", Font.BOLD, 40));
        lblCotosFood.setForeground(new java.awt.Color(25, 25, 25));
        lblCotosFood.setText("Cotos Food");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCotosFood)
                .addContainerGap(2128, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCotosFood, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2290, 120));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoRegresar.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.setMaximumSize(new java.awt.Dimension(71, 78));
        btnRegresar.setMinimumSize(new java.awt.Dimension(72, 7));
        btnRegresar.setPreferredSize(new java.awt.Dimension(72, 7));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 71, 78));

        lblPrecio.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblPrecio.setText("Precio");
        jPanel1.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 670, 470, -1));

        lblCantidad.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblCantidad.setText("Cantidad");
        jPanel1.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 830, 510, -1));

        lblCantMinima.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblCantMinima.setText("Cantidad Mínima");
        jPanel1.add(lblCantMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 350, 470, -1));

        txtCantMinima.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(txtCantMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 400, 470, 38));

        lblDiaCompra.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblDiaCompra.setText("Día de Compra");
        jPanel1.add(lblDiaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 510, 470, -1));

        lblEstado.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblEstado.setText("Estado");
        jPanel1.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 670, 470, -1));

        cmboxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Congelado", "Producción" }));
        cmboxEstado.setSelectedIndex(-1);
        cmboxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 720, 470, 40));

        txtUnidadMedida.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtUnidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadMedidaActionPerformed(evt);
            }
        });
        jPanel1.add(txtUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 880, 470, 38));

        lblUnidadMedida.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblUnidadMedida.setText("Unidad de Medida");
        jPanel1.add(lblUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 830, 510, -1));

        spnPrecio.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(spnPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 720, 470, 40));

        cmboxProveedor.setFont(new Font ("Montserrat", Font.PLAIN,26));
        cmboxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 560, 470, 40));

        cmboxDiaCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes" }));
        cmboxDiaCompra.setSelectedIndex(-1);
        cmboxDiaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxDiaCompraActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxDiaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 560, 470, 40));

        spnCantidad.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(spnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 880, 470, 40));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        menu.setButtonIcon(btnMenu, "/Imagenes/IconoMenu.png");
        menu.setButtonIcon(btnRegresar, "/Imagenes/IconoRegresar.png");
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jScrollPane1, BorderLayout.CENTER);
        
        pack();
}

    
    private void eventComponents() {
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menu.menuAbierto) {
                    menu.cerrarMenu();
                } else {
                    menu.mostrarMenu();
                }
            }
        });
        
        btnRegresar.addActionListener(e -> { regresar();});
    }
    
    private void regresar(){
        try {
            JF_Inventario ventana = new JF_Inventario();
            ventana.setVisible(true);
            this.dispose(); 
        } catch (Exception ex) {
            ex.printStackTrace();
            // Maneja cualquier excepción que pueda ocurrir al crear la ventana
        }
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
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmboxDiaCompra;
    private javax.swing.JComboBox<String> cmboxEstado;
    private javax.swing.JComboBox<String> cmboxProveedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
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
