/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Vista.Clases.ManejadorComponentes;
import Controlador.ControladorProveedor;
import Vista.Clases.MenuBoton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author yumii
 */
public class JF_RegistrarProveedor extends javax.swing.JFrame {
    private MenuBoton menu;
    private ManejadorComponentes manejadorComponentes = new ManejadorComponentes();
    private java.util.List<String[]> notificaciones; 
    /**
     * Creates new form JF_Principal
     */
    public JF_RegistrarProveedor(java.util.List<String[]> notificaciones) {
        this.notificaciones = notificaciones;
        initComponents();
        menu = new MenuBoton(300, getContentPane().getHeight() - 185, this, notificaciones);
        customComponents();
        eventComponents();

        
        this.setExtendedState(JF_RegistrarProveedor.MAXIMIZED_BOTH);
        
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
        lblTelefono = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        lblCotosFood = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        lblErrorTelefono = new javax.swing.JLabel();
        lblErrorNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1747, 1291));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(2160, 1440));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTelefono.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblTelefono.setText("Telefono");
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 470, -1));

        lblNombre.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 470, -1));

        txtNombre.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 470, 38));

        btnAgregar.setBackground(new java.awt.Color(0, 72, 121));
        btnAgregar.setFont(new Font ("Montserrat", Font.BOLD,30));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, 199, 50));

        lblTitulo.setFont(new Font("Montserrat", Font.BOLD, 64));
        lblTitulo.setForeground(new java.awt.Color(25, 25, 25));
        lblTitulo.setText("Registrar Proveedor");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jPanel2.setBackground(new java.awt.Color(152, 194, 70));
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
                .addGap(29, 29, 29)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCotosFood)
                .addContainerGap(2127, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblCotosFood, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2290, 120));

        txtTelefono.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 470, 38));

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

        lblErrorTelefono.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorTelefono.setText("El número telefónico debe ser de 8 números");
        jPanel1.add(lblErrorTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 460, -1));

        lblErrorNombre.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorNombre.setText("El nombre no puede estar vacío");
        jPanel1.add(lblErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 460, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        ControladorProveedor controlador = new ControladorProveedor(manejadorComponentes);
        if (controlador.registrarProveedor(txtNombre.getText(), txtTelefono.getText())) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        menu.regresarVentanaPrincipal(notificaciones);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void customComponents(){
        menu.setButtonIcon(btnMenu, "/Imagenes/IconoMenu.png");
        menu.setButtonIcon(btnRegresar, "/Imagenes/IconoRegresar.png");
        
        manejadorComponentes.agregarLabel(lblErrorNombre);
        manejadorComponentes.agregarLabel(lblErrorTelefono);
        manejadorComponentes.ocultarLabels();
        
        manejadorComponentes.agregarText(txtNombre);
        manejadorComponentes.agregarText(txtTelefono);
        
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
            java.util.logging.Logger.getLogger(JF_RegistrarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_RegistrarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_RegistrarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_RegistrarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_RegistrarProveedor(null).setVisible(true);
            }
        });
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCotosFood;
    private javax.swing.JLabel lblErrorNombre;
    public javax.swing.JLabel lblErrorTelefono;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
