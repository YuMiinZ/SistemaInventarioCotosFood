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
public class JF_RegistrarEmpleado extends javax.swing.JFrame {
    
    private MenuBoton menu;

    /**
     * Creates new form JF_Principal
     */
    public JF_RegistrarEmpleado() {
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
        lblVacaciones = new javax.swing.JLabel();
        txtVacaciones = new javax.swing.JTextField();
        lblFechaCarnetAlimentos2 = new javax.swing.JLabel();
        txtFechaCarnetAlimentos = new javax.swing.JTextField();
        lblFechaCarnetAlimentos = new javax.swing.JLabel();
        lblAlergias = new javax.swing.JLabel();
        txtAlergias = new javax.swing.JTextField();
        lblTipoSangre = new javax.swing.JLabel();
        lblFechaIngreso = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JTextField();
        cmboxTipoSangre = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1747, 1291));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(2160, 1440));
        jPanel1.setPreferredSize(new java.awt.Dimension(2160, 1440));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTelefono.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblTelefono.setText("Teléfono");
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 560, 470, -1));

        lblNombre.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 470, -1));

        txtNombre.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 470, 38));

        btnAgregar.setBackground(new java.awt.Color(0, 72, 121));
        btnAgregar.setFont(new Font ("Montserrat", Font.BOLD,30));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 880, 199, 50));

        lblTitulo.setFont(new Font("HeadlandOne", Font.BOLD, 64));
        lblTitulo.setForeground(new java.awt.Color(25, 25, 25));
        lblTitulo.setText("Registrar Empleado");
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
                .addGap(29, 29, 29)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCotosFood)
                .addContainerGap(2127, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCotosFood, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2290, 120));

        txtTelefono.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 610, 470, 38));

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

        lblVacaciones.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblVacaciones.setText("Vacaciones");
        jPanel1.add(lblVacaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 720, 470, -1));

        txtVacaciones.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtVacaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVacacionesActionPerformed(evt);
            }
        });
        jPanel1.add(txtVacaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 770, 470, 38));

        lblFechaCarnetAlimentos2.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblFechaCarnetAlimentos2.setText("carnet de manipulación");
        jPanel1.add(lblFechaCarnetAlimentos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 920, 590, -1));

        txtFechaCarnetAlimentos.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtFechaCarnetAlimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaCarnetAlimentosActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaCarnetAlimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 970, 470, 38));

        lblFechaCarnetAlimentos.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblFechaCarnetAlimentos.setText("Fecha de vencimiento de");
        jPanel1.add(lblFechaCarnetAlimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 880, 610, -1));

        lblAlergias.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblAlergias.setText("Alergias");
        jPanel1.add(lblAlergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 400, 470, -1));

        txtAlergias.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(txtAlergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 450, 470, 38));

        lblTipoSangre.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblTipoSangre.setText("Tipo de Sangre");
        jPanel1.add(lblTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 560, 470, -1));

        lblFechaIngreso.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblFechaIngreso.setText("Fecha de Ingreso");
        jPanel1.add(lblFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 720, 470, -1));

        txtFechaIngreso.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtFechaIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaIngresoActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 770, 470, 38));

        cmboxTipoSangre.setFont(new Font ("Montserrat", Font.PLAIN,26));
        cmboxTipoSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+" }));
        cmboxTipoSangre.setSelectedIndex(-1);
        cmboxTipoSangre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxTipoSangreActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 610, 470, 40));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtVacacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVacacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVacacionesActionPerformed

    private void txtFechaCarnetAlimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaCarnetAlimentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaCarnetAlimentosActionPerformed

    private void txtFechaIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaIngresoActionPerformed

    private void cmboxTipoSangreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxTipoSangreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxTipoSangreActionPerformed

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
        
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.regresarVentanaPrincipal();
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
            java.util.logging.Logger.getLogger(JF_RegistrarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_RegistrarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_RegistrarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_RegistrarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new JF_RegistrarEmpleado().setVisible(true);
            }
        });
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmboxTipoSangre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlergias;
    private javax.swing.JLabel lblCotosFood;
    private javax.swing.JLabel lblFechaCarnetAlimentos;
    private javax.swing.JLabel lblFechaCarnetAlimentos2;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoSangre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVacaciones;
    private javax.swing.JTextField txtAlergias;
    private javax.swing.JTextField txtFechaCarnetAlimentos;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtVacaciones;
    // End of variables declaration//GEN-END:variables
}
