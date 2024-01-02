/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Vista.Clases.MenuBoton;
import Vista.Clases.TablaPersonalizada;
import Vista.Clases.TablaSpinnerPersonalizada;
import static Vista.Clases.TablaSpinnerPersonalizada.llenarTabla2columnas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yumii
 */
public class JF_Menu extends javax.swing.JFrame {
    
    private MenuBoton menu;

    /**
     * Creates new form JF_Principal
     */
    public JF_Menu() {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        lblCotosFood = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMenu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(2160, 1440));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(2160, 1440));
        jPanel1.setMinimumSize(new java.awt.Dimension(1747, 1291));
        jPanel1.setPreferredSize(new java.awt.Dimension(2160, 1440));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setBackground(new java.awt.Color(0, 72, 121));
        btnAgregar.setFont(new Font ("Montserrat", Font.BOLD,30));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Nuevo Producto");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 820, 290, 50));

        lblTitulo.setFont(new Font("HeadlandOne", Font.BOLD, 64));
        lblTitulo.setForeground(new java.awt.Color(25, 25, 25));
        lblTitulo.setText("Menú");
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
                .addGap(28, 28, 28)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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

        jPanel3.setBackground(new java.awt.Color(152, 194, 70));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 122));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 1070, 60));

        tableMenu.setFont(new Font ("Montserrat", Font.PLAIN,20));
        tableMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Rice and Beans", "Editar"},
                {"Chifrijo", "Editar"},
                {"Coca Cola", "Editar"},
                {"Pescado Empanizado", "Editar"}
            },
            new String [] {
                "Producto", "Editar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableMenu.setAlignmentX(0.0F);
        tableMenu.setAlignmentY(0.0F);
        tableMenu.setColumnSelectionAllowed(true);
        tableMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableMenu.setMaximumSize(new java.awt.Dimension(2147483647, 80));
        tableMenu.setMinimumSize(new java.awt.Dimension(30, 80));
        tableMenu.setPreferredSize(new java.awt.Dimension(150, 80));
        jScrollPane1.setViewportView(tableMenu);
        tableMenu.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 1070, 460));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    
    private void customComponents(){
        menu.setButtonIcon(btnMenu, "/Imagenes/IconoMenu.png");
        menu.setButtonIcon(btnRegresar, "/Imagenes/IconoRegresar.png");
        TablaPersonalizada.setScrollPaneProperties(jScrollPane1);
        DefaultTableModel model = llenarTabla2columnas("Editar producto Menu", "Editar");
        TablaPersonalizada.setTableProperties(tableMenu, model, true);
        
        tableMenu.getColumn("Editar").setCellEditor(new TablaSpinnerPersonalizada.ButtonEditor(new JCheckBox(), "Editar", tableMenu, "Editar producto Menu", this));
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jScrollPane2, BorderLayout.CENTER);
        
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
        
        btnAgregar.addActionListener(e -> { abrirVentanaAgregar();});
        
    }
    
    private void abrirVentanaAgregar(){
        try {
            JF_RegistrarProductoMenu ventana = new JF_RegistrarProductoMenu();
            ventana.setVisible(true);
            this.dispose(); 
        } catch (Exception ex) {
            ex.printStackTrace();
            // Maneja cualquier excepción que pueda ocurrir al crear la ventana
        }
    }

    // Clase para definir la acción al hacer clic en el botón de la celda
    
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
            java.util.logging.Logger.getLogger(JF_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new JF_Menu().setVisible(true);
            }
        });
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCotosFood;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tableMenu;
    // End of variables declaration//GEN-END:variables
}
