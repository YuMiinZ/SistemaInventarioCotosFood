/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Vista.Clases.MenuBoton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author yumii
 */
public class JF_ModificarEmpleado extends javax.swing.JFrame {
    private boolean menuAbierto = false;
    
    private MenuBoton menu;

    /**
     * Creates new form JF_Principal
     */
    public JF_ModificarEmpleado() {
        initComponents();
        customComponents();
        eventComponents();
        menu = new MenuBoton(300, getContentPane().getHeight() - 97, this);
        menu.cerrarMenu();
        
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
        lblTelefono = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
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
        cmboxEmpleado = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        lblEmpleado = new javax.swing.JLabel();
        cmboxTipoSangre = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1747, 1291));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTelefono.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblTelefono.setText("Teléfono");
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, 470, -1));

        lblNombre.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 470, -1));

        txtNombre.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 470, 38));

        btnEliminar.setBackground(new java.awt.Color(221, 59, 59));
        btnEliminar.setFont(new Font ("Montserrat", Font.BOLD,30));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 660, 199, 50));

        lblTitulo.setFont(new Font("HeadlandOne", Font.BOLD, 64));
        lblTitulo.setForeground(new java.awt.Color(0, 72, 121));
        lblTitulo.setText("Modificar Empleado");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

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

        txtTelefono.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 630, 470, 38));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconoRegresar.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 40, 40));

        lblVacaciones.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblVacaciones.setText("Vacaciones");
        jPanel1.add(lblVacaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 740, 470, -1));

        txtVacaciones.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtVacaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVacacionesActionPerformed(evt);
            }
        });
        jPanel1.add(txtVacaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 790, 470, 38));

        lblFechaCarnetAlimentos2.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblFechaCarnetAlimentos2.setText("carnet de manipulación");
        jPanel1.add(lblFechaCarnetAlimentos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 210, 590, -1));

        txtFechaCarnetAlimentos.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtFechaCarnetAlimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaCarnetAlimentosActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaCarnetAlimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 260, 470, 38));

        lblFechaCarnetAlimentos.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblFechaCarnetAlimentos.setText("Fecha de vencimiento de");
        jPanel1.add(lblFechaCarnetAlimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 170, 610, -1));

        lblAlergias.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblAlergias.setText("Alergias");
        jPanel1.add(lblAlergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 330, 470, -1));

        txtAlergias.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(txtAlergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 380, 470, 38));

        lblTipoSangre.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblTipoSangre.setText("Tipo de Sangre");
        jPanel1.add(lblTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 490, 470, -1));

        lblFechaIngreso.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblFechaIngreso.setText("Fecha de Ingreso");
        jPanel1.add(lblFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 650, 470, -1));

        txtFechaIngreso.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtFechaIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaIngresoActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 700, 470, 38));

        cmboxEmpleado.setFont(new Font ("Montserrat", Font.PLAIN,26));
        cmboxEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Juan Mora Rojas", "Nathalia Salazar", "Mario Murillo", "Emily Cascabel" }));
        cmboxEmpleado.setSelectedIndex(-1);
        cmboxEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 470, 40));

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

        lblEmpleado.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblEmpleado.setText("Empleado");
        jPanel1.add(lblEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 470, -1));

        cmboxTipoSangre.setFont(new Font ("Montserrat", Font.PLAIN,26));
        cmboxTipoSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+" }));
        cmboxTipoSangre.setSelectedIndex(-1);
        cmboxTipoSangre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxTipoSangreActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 540, 470, 40));

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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

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

    private void cmboxEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxEmpleadoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cmboxTipoSangreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxTipoSangreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxTipoSangreActionPerformed

    private void customComponents(){
        setButtonIcon(btnMenu, "src/main/resources/Imagenes/IconoMenu.png");
        setButtonIcon(btnRegresar, "src/main/resources/Imagenes/IconoRegresar.png");

}

    
    private void eventComponents() {
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menuAbierto) {
                    menu.cerrarMenu();
                } else {
                    menu.mostrarMenu();
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
            java.util.logging.Logger.getLogger(JF_ModificarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_ModificarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_ModificarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_ModificarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new JF_ModificarEmpleado().setVisible(true);
            }
        });
    }
    
    private void setButtonIcon(JButton button, String imagePath){
        ImageIcon image = new ImageIcon(imagePath);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT));
        button.setIcon(icon);
        button.repaint();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmboxEmpleado;
    private javax.swing.JComboBox<String> cmboxTipoSangre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAlergias;
    private javax.swing.JLabel lblCotosFood;
    private javax.swing.JLabel lblEmpleado;
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
