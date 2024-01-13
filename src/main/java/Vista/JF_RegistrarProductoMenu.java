/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorProductoInventario;
import Controlador.ControladorProductoMenu;
import Modelo.ProductoInventario;
import Vista.Clases.ManejadorComponentes;
import Vista.Clases.TablaSpinnerPersonalizada;
import Vista.Clases.MenuBoton;
import Vista.Clases.TablaPersonalizada;
import Vista.Clases.TablaSpinnerPersonalizada.SpinnerEditor;
import Vista.Clases.TablaSpinnerPersonalizada.SpinnerRenderer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author yumii
 */
public class JF_RegistrarProductoMenu extends javax.swing.JFrame {
    private MenuBoton menu;
    private ManejadorComponentes manejadorComponentes = new ManejadorComponentes();
    private final ControladorProductoInventario controladorProductoInventario = new ControladorProductoInventario();
    private java.util.List<ProductoInventario> listaProductosInventario;
    private java.util.List<String[]> notificaciones;
    
    /**
     * Creates new form JF_Principal
     */
    public JF_RegistrarProductoMenu(java.util.List<String[]> notificaciones) {
        this.notificaciones = notificaciones;
        initComponents();
        menu = new MenuBoton(300, getContentPane().getHeight() - 185, this, notificaciones);
        customComponents();
        eventComponents();

        
        this.setExtendedState(JF_RegistrarProductoMenu.MAXIMIZED_BOTH);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmboxIngredientes = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblPrecio = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAgregarIngredientes = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        lblCotosFood = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        lblCostoElaboracion = new javax.swing.JLabel();
        lblIngredientes = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        cmboxEstado = new javax.swing.JComboBox<>();
        spnCostoElaboracion = new javax.swing.JSpinner();
        spnPrecio = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableIngredientes = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        cmboxTipoProducto = new javax.swing.JComboBox<>();
        lblTipoProducto = new javax.swing.JLabel();
        lblErrorNombre = new javax.swing.JLabel();
        lblNotaTablaIngredientes = new javax.swing.JLabel();
        lblErrorPrecio = new javax.swing.JLabel();
        lblErrorCostoElaboracion = new javax.swing.JLabel();
        lblErrorEstado = new javax.swing.JLabel();
        lblErrorTipoProducto = new javax.swing.JLabel();
        lblErrorTablaIngredientes = new javax.swing.JLabel();

        cmboxIngredientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {null, "Arroz", "Frijoles", "Tomate", "Lechuga" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1747, 1291));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(2160, 1440));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPrecio.setFont(new Font ("Montserrat", Font.BOLD,34));
        lblPrecio.setText("Precio");
        jPanel1.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 470, -1));

        lblNombre.setFont(new Font ("Montserrat", Font.BOLD,34));
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 470, -1));

        txtNombre.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 470, 38));

        btnAgregarIngredientes.setBackground(new java.awt.Color(0, 72, 121));
        btnAgregarIngredientes.setFont(new Font ("Montserrat", Font.BOLD,18));
        btnAgregarIngredientes.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarIngredientes.setText("Agregar Ingrediente");
        btnAgregarIngredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarIngredientesActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 260, 230, 40));

        lblTitulo.setFont(new Font("Montserrat", Font.BOLD, 64));
        lblTitulo.setForeground(new java.awt.Color(25, 25, 25));
        lblTitulo.setText("Registrar Producto al Menú");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jPanel2.setBackground(new java.awt.Color(152, 194, 70));
        jPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(2222, 125));

        btnMenu.setBorderPainted(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                .addGap(22, 22, 22)
                .addComponent(lblCotosFood, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        lblCostoElaboracion.setFont(new Font ("Montserrat", Font.BOLD,34));
        lblCostoElaboracion.setText("Costo Elaboración");
        jPanel1.add(lblCostoElaboracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 470, -1));

        lblIngredientes.setFont(new Font ("Montserrat", Font.BOLD,34));
        lblIngredientes.setText("Ingredientes");
        jPanel1.add(lblIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, 470, -1));

        lblEstado.setFont(new Font ("Montserrat", Font.BOLD,34));
        lblEstado.setText("Estado");
        jPanel1.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 580, 470, -1));

        cmboxEstado.setFont(new Font ("Montserrat", Font.PLAIN,20));
        cmboxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "No Disponible" }));
        cmboxEstado.setSelectedIndex(-1);
        cmboxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 620, 470, 40));

        spnCostoElaboracion.setFont(new Font ("Montserrat", Font.PLAIN,26));
        spnCostoElaboracion.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        jPanel1.add(spnCostoElaboracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, 470, 40));

        spnPrecio.setFont(new Font ("Montserrat", Font.PLAIN,26));
        spnPrecio.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        jPanel1.add(spnPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 470, 40));

        tableIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ingrediente", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tableIngredientes);
        if (tableIngredientes.getColumnModel().getColumnCount() > 0) {
            tableIngredientes.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(cmboxIngredientes));
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 300, 470, 210));

        btnAgregar.setBackground(new java.awt.Color(0, 72, 121));
        btnAgregar.setFont(new Font ("Montserrat", Font.BOLD,30));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 700, 199, 50));

        cmboxTipoProducto.setFont(new Font ("Montserrat", Font.PLAIN,20));
        cmboxTipoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Platillo", "Bebida" }));
        cmboxTipoProducto.setSelectedIndex(-1);
        cmboxTipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxTipoProductoActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxTipoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 710, 470, 40));

        lblTipoProducto.setFont(new Font ("Montserrat", Font.BOLD,34));
        lblTipoProducto.setText("Tipo Producto");
        jPanel1.add(lblTipoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 670, 470, -1));

        lblErrorNombre.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorNombre.setText("El nombre no puede estar vacío");
        jPanel1.add(lblErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 460, -1));

        lblNotaTablaIngredientes.setText("Para eliminar un ingrediente, solo deje vacío el campo ingrediente o la cantidad en 0");
        jPanel1.add(lblNotaTablaIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 510, 530, -1));

        lblErrorPrecio.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorPrecio.setText("El precio debe ser un número mayor o igual a 0");
        jPanel1.add(lblErrorPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 460, -1));

        lblErrorCostoElaboracion.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorCostoElaboracion.setText("El costo de elaboración debe ser un número mayor o igual a 0");
        jPanel1.add(lblErrorCostoElaboracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 610, 460, -1));

        lblErrorEstado.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorEstado.setText("Debe de seleccionar el estado del producto");
        jPanel1.add(lblErrorEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 660, 460, -1));

        lblErrorTipoProducto.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorTipoProducto.setText("Debe de seleccionar el tipo del producto");
        jPanel1.add(lblErrorTipoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 750, 460, -1));

        lblErrorTablaIngredientes.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorTablaIngredientes.setText("Debe de seleccionar al menos 1 ingrediente y su cantidad");
        jPanel1.add(lblErrorTablaIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 530, 460, -1));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1995, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarIngredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIngredientesActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableIngredientes.getModel();
        model.addRow(new Object[]{"", 0}); 
    }//GEN-LAST:event_btnAgregarIngredientesActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        regresar();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cmboxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxEstadoActionPerformed


    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        ControladorProductoMenu controlador = new ControladorProductoMenu(manejadorComponentes);
        if (controlador.registrarProductoMenu(txtNombre.getText(), (double) spnPrecio.getValue(), (double) spnCostoElaboracion.getValue(), 
                                                    cmboxTipoProducto.getSelectedItem(), tableIngredientes, cmboxEstado.getSelectedItem(),
                                                    listaProductosInventario)) {
            spnPrecio.setValue(0.0);
            spnCostoElaboracion.setValue(0.0);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cmboxTipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxTipoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxTipoProductoActionPerformed

    private void customComponents(){

        menu.setButtonIcon(btnMenu, "/Imagenes/IconoMenu.png");
        menu.setButtonIcon(btnRegresar, "/Imagenes/IconoRegresar.png");
  
        TablaPersonalizada.setScrollPaneProperties(jScrollPane1);
        DefaultTableModel model = obtenerModelo();
        TablaPersonalizada.setTableProperties(tableIngredientes, model, false);
        tableIngredientes.getColumnModel().getColumn(0).setPreferredWidth(450);
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jScrollPane2, BorderLayout.CENTER);
        pack();
        
        manejadorComponentes.agregarLabel(lblErrorNombre);
        manejadorComponentes.agregarLabel(lblErrorPrecio);
        manejadorComponentes.agregarLabel(lblErrorCostoElaboracion);
        manejadorComponentes.agregarLabel(lblErrorTipoProducto);
        manejadorComponentes.agregarLabel(lblErrorTablaIngredientes);
        manejadorComponentes.agregarLabel(lblErrorEstado);
        
        manejadorComponentes.agregarComboBox(cmboxTipoProducto);
        manejadorComponentes.agregarComboBox(cmboxEstado);
        
        
        manejadorComponentes.agregarSpinner(spnPrecio);
        manejadorComponentes.agregarSpinner(spnCostoElaboracion);
        
        manejadorComponentes.agregarText(txtNombre);
        
        manejadorComponentes.ocultarLabels();
        
        cargarOpcionesIngredientes();
        
    }
    
    private void agregarOpciones(){
        cmboxIngredientes.removeAllItems();
        cmboxIngredientes.addItem(null); 
        for (ProductoInventario producto : listaProductosInventario) {
            cmboxIngredientes.addItem(producto.getNombre()); 
        }
    }
    
    private void cargarOpcionesIngredientes(){
        listaProductosInventario = controladorProductoInventario.obtenerListaProductosInventario();
        agregarOpciones();
    }
    
    private DefaultTableModel obtenerModelo() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Ingrediente");
        model.addColumn("Cantidad");

        DefaultComboBoxModel<String> comboModel = (DefaultComboBoxModel<String>) cmboxIngredientes.getModel();

        tableIngredientes.setModel(model);
        tableIngredientes.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(cmboxIngredientes)); // Editor para la columna del JComboBox
        tableIngredientes.getColumnModel().getColumn(1).setCellEditor(new SpinnerEditor()); // Editor para la columna de cantidad con JSpinner
        tableIngredientes.getColumnModel().getColumn(1).setCellRenderer(new SpinnerRenderer()); // Renderizador para la columna de cantidad con JSpinner

        TablaSpinnerPersonalizada.setCellBorders(tableIngredientes);
        return model;
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
            JF_Menu ventana = new JF_Menu(notificaciones);
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
            java.util.logging.Logger.getLogger(JF_RegistrarProductoMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_RegistrarProductoMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_RegistrarProductoMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_RegistrarProductoMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new JF_RegistrarProductoMenu(null).setVisible(true);
            }
        });
    }
   
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarIngredientes;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmboxEstado;
    private javax.swing.JComboBox<String> cmboxIngredientes;
    private javax.swing.JComboBox<String> cmboxTipoProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCostoElaboracion;
    private javax.swing.JLabel lblCotosFood;
    private javax.swing.JLabel lblErrorCostoElaboracion;
    private javax.swing.JLabel lblErrorEstado;
    private javax.swing.JLabel lblErrorNombre;
    private javax.swing.JLabel lblErrorPrecio;
    private javax.swing.JLabel lblErrorTablaIngredientes;
    private javax.swing.JLabel lblErrorTipoProducto;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIngredientes;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNotaTablaIngredientes;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTipoProducto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSpinner spnCostoElaboracion;
    private javax.swing.JSpinner spnPrecio;
    private javax.swing.JTable tableIngredientes;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
