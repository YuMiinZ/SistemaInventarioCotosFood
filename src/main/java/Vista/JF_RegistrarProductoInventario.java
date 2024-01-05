/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorProductoInventario;
import Controlador.ControladorProveedor;
import Modelo.Proveedor;
import Vista.Clases.ManejadorComponentes;
import Vista.Clases.MenuBoton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
/**
 *
 * @author yumii
 */
public class JF_RegistrarProductoInventario extends javax.swing.JFrame {
    
    private MenuBoton menu;
    private ManejadorComponentes manejadorComponentes = new ManejadorComponentes();
    private final ControladorProveedor controladorProveedor = new ControladorProveedor(manejadorComponentes);

    private java.util.List<Proveedor> listaProveedores;

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
        lblDiaCompra = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        cmboxEstado = new javax.swing.JComboBox<>();
        txtUnidadMedida = new javax.swing.JTextField();
        lblUnidadMedida = new javax.swing.JLabel();
        spnPrecio = new javax.swing.JSpinner();
        cmboxProveedor = new javax.swing.JComboBox<>();
        cmboxDiaCompra = new javax.swing.JComboBox<>();
        spnCantidad = new javax.swing.JSpinner();
        lblErrorCantidadMinima = new javax.swing.JLabel();
        lblErrorNombre = new javax.swing.JLabel();
        lblErrorProveedor = new javax.swing.JLabel();
        lblErrorPrecio = new javax.swing.JLabel();
        lblErrorCantidad = new javax.swing.JLabel();
        lblErrorEstado = new javax.swing.JLabel();
        lblErrorDiaCompra = new javax.swing.JLabel();
        lblErrorUnidadMedida = new javax.swing.JLabel();
        spnCantidadMinima = new javax.swing.JSpinner();

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

        lblDiaCompra.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblDiaCompra.setText("Día de Compra");
        jPanel1.add(lblDiaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 510, 470, -1));

        lblEstado.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblEstado.setText("Estado");
        jPanel1.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 670, 470, -1));

        cmboxEstado.setFont(new Font ("Montserrat", Font.PLAIN,12));
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
        spnPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        jPanel1.add(spnPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 720, 470, 40));

        cmboxProveedor.setFont(new Font ("Montserrat", Font.PLAIN,12));
        cmboxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 560, 470, 40));

        cmboxDiaCompra.setFont(new Font ("Montserrat", Font.PLAIN,12));
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

        lblErrorCantidadMinima.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorCantidadMinima.setText("La cantidad mínima del producto debe ser un número mayor o igual a 0");
        jPanel1.add(lblErrorCantidadMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 440, 460, -1));

        lblErrorNombre.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorNombre.setText("El nombre no puede estar vacío");
        jPanel1.add(lblErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 460, -1));

        lblErrorProveedor.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorProveedor.setText("Debe de seleccionar el proveedor");
        jPanel1.add(lblErrorProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 600, 460, -1));

        lblErrorPrecio.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorPrecio.setText("El precio debe ser un número mayor o igual a 0");
        jPanel1.add(lblErrorPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 760, 460, -1));

        lblErrorCantidad.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorCantidad.setText("La cantidad debe ser un número mayor o igual a 0");
        jPanel1.add(lblErrorCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 920, 460, -1));

        lblErrorEstado.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorEstado.setText("Debe de seleccionar el estado del producto");
        jPanel1.add(lblErrorEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 760, 460, -1));

        lblErrorDiaCompra.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorDiaCompra.setText("Debe de seleccionar el día de compra programado para el producto");
        jPanel1.add(lblErrorDiaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 600, 460, -1));

        lblErrorUnidadMedida.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorUnidadMedida.setText("La unidad de medida no puede estar vacía");
        jPanel1.add(lblErrorUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 920, 460, -1));

        spnCantidadMinima.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(spnCantidadMinima, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 400, 470, 40));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1942, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        ControladorProductoInventario controlador = new ControladorProductoInventario(manejadorComponentes);
        
        if (controlador.registrarProductoInventario(txtNombre.getText(), cmboxProveedor.getSelectedIndex(), (double) spnPrecio.getValue(), 
                                                    (int) spnCantidad.getValue(), (int) spnCantidadMinima.getValue(), 
                                                    cmboxDiaCompra.getSelectedItem(), cmboxEstado.getSelectedItem(), txtUnidadMedida.getText(), 
                                                    listaProveedores)) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            spnPrecio.setValue(0.0);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        regresar();
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

        manejadorComponentes.agregarLabel(lblErrorNombre);
        manejadorComponentes.agregarLabel(lblErrorProveedor);
        manejadorComponentes.agregarLabel(lblErrorPrecio);
        manejadorComponentes.agregarLabel(lblErrorCantidad);
        manejadorComponentes.agregarLabel(lblErrorCantidadMinima);
        manejadorComponentes.agregarLabel(lblErrorDiaCompra);
        manejadorComponentes.agregarLabel(lblErrorEstado);
        manejadorComponentes.agregarLabel(lblErrorUnidadMedida);
        manejadorComponentes.ocultarLabels();
        
        manejadorComponentes.agregarText(txtNombre);
        manejadorComponentes.agregarText(txtUnidadMedida);
        
        manejadorComponentes.agregarComboBox(cmboxProveedor);
        manejadorComponentes.agregarComboBox(cmboxDiaCompra);
        manejadorComponentes.agregarComboBox(cmboxEstado);
        
        manejadorComponentes.agregarSpinner(spnPrecio);
        manejadorComponentes.agregarSpinner(spnCantidad);
        manejadorComponentes.agregarSpinner(spnCantidadMinima);
        
        cargarOpciones();
    }
    
    private void agregarOpciones(){
        cmboxProveedor.removeAllItems();
        for (Proveedor proveedor : listaProveedores) {
            cmboxProveedor.addItem(proveedor.getNombre()); 
        }
    }
    
    private void cargarOpciones(){
        listaProveedores = controladorProveedor.obtenerListaProveedores(); 
        agregarOpciones();
        manejadorComponentes.limpiarCamposTexto();
        cmboxProveedor.setSelectedIndex(-1);
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
    private javax.swing.JLabel lblErrorCantidad;
    private javax.swing.JLabel lblErrorCantidadMinima;
    private javax.swing.JLabel lblErrorDiaCompra;
    private javax.swing.JLabel lblErrorEstado;
    private javax.swing.JLabel lblErrorNombre;
    private javax.swing.JLabel lblErrorPrecio;
    private javax.swing.JLabel lblErrorProveedor;
    private javax.swing.JLabel lblErrorUnidadMedida;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUnidadMedida;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JSpinner spnCantidadMinima;
    private javax.swing.JSpinner spnPrecio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
