/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorComanda;
import Controlador.ControladorConsumo;
import Controlador.ControladorProductoMenu;
import Modelo.Empleado;
import Modelo.ProductoMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Clases.MenuBoton;
import Vista.Clases.TablaPersonalizada;
import Vista.Clases.TablaSpinnerPersonalizada;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TomasPC
 */
public class JF_NuevaComandaEmpleado extends javax.swing.JFrame {
    private MenuBoton menu;
    private Empleado empleadoE;
    private ControladorComanda comanda = new ControladorComanda();
    private ControladorProductoMenu productos = new ControladorProductoMenu();
    private ControladorConsumo Empleado = new ControladorConsumo();
    private ControladorProductoMenu Menu = new ControladorProductoMenu(); 
    private List<ProductoMenu> Platillo;
    private List<ProductoMenu> Bebida;
    private java.util.List<String[]> notificaciones;
    /**
     * Creates new form NuevaComanda
     * @param empleadoE
     * @param notificaciones
     */
    public JF_NuevaComandaEmpleado(Empleado empleadoE, java.util.List<String[]> notificaciones) {
        this.notificaciones = notificaciones;
        initComponents();
        this.empleadoE = empleadoE;
        jLabel1.setText(jLabel1.getText() + " - Empleado " + empleadoE.getNombre());
        menu = new MenuBoton(300, getContentPane().getHeight() - 185, this, notificaciones);
        customComponents();
        eventComponents();
    }
    private void customComponents(){
        menu.setButtonIcon(jButton1, "/Imagenes/IconoMenu.png");
        menu.setButtonIcon(jButton2, "/Imagenes/IconoRegresar.png");
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jScrollPane1, BorderLayout.CENTER);
        
        
        TablaPersonalizada.setScrollPaneProperties(jScrollPane1);
        DefaultTableModel model = obtenerModelo(tablePlatilllos, Platillos);
        DefaultTableModel model2 = obtenerModelo(tableBebidas, Bebidas);
        TablaPersonalizada.setTableProperties(tablePlatilllos, model, false);
        TablaPersonalizada.setTableProperties(tableBebidas, model2, false);
        
        
        pack();
        cargarOpcionesMenu();
    }
    
    private DefaultTableModel obtenerModelo(JTable table, JComboBox<String> combo) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Ingrediente");
        model.addColumn("Cantidad");


        table.setModel(model);
        table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(combo)); // Editor para la columna del JComboBox
        table.getColumnModel().getColumn(1).setCellEditor(new TablaSpinnerPersonalizada.SpinnerEditor()); // Editor para la columna de cantidad con JSpinner
        table.getColumnModel().getColumn(1).setCellRenderer(new TablaSpinnerPersonalizada.SpinnerRenderer()); // Renderizador para la columna de cantidad con JSpinner

        TablaSpinnerPersonalizada.setCellBorders(table);
        return model;
    }
    
    
    private void agregarOpciones(JComboBox<String> opcion, List<ProductoMenu> productos){
        opcion.removeAllItems();
        opcion.addItem(null);
        for (ProductoMenu producto : productos){
            opcion.addItem(producto.getNombre());
        }
    }
    
    private void cargarOpcionesMenu(){
        Platillo = Menu.Platillos();
        Bebida = Menu.Bebidas();
        agregarOpciones(Platillos, Platillo);
        agregarOpciones(Bebidas, Bebida);
    }

    
    private void eventComponents() {
        jButton1.addActionListener(new ActionListener() {
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Platillos = new javax.swing.JComboBox<>();
        Bebidas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBebidas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePlatilllos = new javax.swing.JTable();
        btnAgregarPlatillo = new javax.swing.JButton();
        btnAgregarBebida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextField1 = new javax.swing.JTextArea();
        lblNotaTablaIngredientes = new javax.swing.JLabel();
        lblNotaTablaIngredientes1 = new javax.swing.JLabel();

        Platillos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Bebidas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1747, 1291));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel1.setMinimumSize(new java.awt.Dimension(2160, 1440));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setDefaultCapable(false);
        jButton2.setMaximumSize(new java.awt.Dimension(71, 78));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 71, 78));

        jPanel2.setBackground(new java.awt.Color(152, 194, 70));

        jLabel3.setFont(new Font("Montserrat", Font.BOLD, 40));
        jLabel3.setForeground(new java.awt.Color(25, 25, 25));
        jLabel3.setText("Cotos Food");

        jButton1.setToolTipText("");
        jButton1.setContentAreaFilled(false);
        jButton1.setDefaultCapable(false);
        jButton1.setMaximumSize(new java.awt.Dimension(71, 78));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2160, -1));

        jLabel4.setFont(new Font("Montserrat", 0, 36));
        jLabel4.setText("Platillos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        jLabel5.setFont(new Font("Montserrat", 0, 36));
        jLabel5.setText("Bebidas");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, -1, -1));

        jLabel6.setFont(new Font("Montserrat", 0, 36));
        jLabel6.setText("Notas");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 250, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 72, 121));
        jButton3.setFont(new Font ("Montserrat", Font.BOLD,30));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Agregar");
        jButton3.setMaximumSize(new java.awt.Dimension(525, 71));
        jButton3.setMinimumSize(new java.awt.Dimension(525, 71));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 820, 199, 50));

        tableBebidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Bebidas", "Cantidad"
            }
        ));
        jScrollPane2.setViewportView(tableBebidas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 470, 210));

        tablePlatilllos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Platillos", "Cantidad"
            }
        ));
        jScrollPane3.setViewportView(tablePlatilllos);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 470, 210));

        btnAgregarPlatillo.setBackground(new java.awt.Color(0, 72, 121));
        btnAgregarPlatillo.setFont(new Font ("Montserrat", Font.BOLD,18));
        btnAgregarPlatillo.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarPlatillo.setText("Agregar Platillo");
        btnAgregarPlatillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPlatilloActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarPlatillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 230, 40));

        btnAgregarBebida.setBackground(new java.awt.Color(0, 72, 121));
        btnAgregarBebida.setFont(new Font ("Montserrat", Font.BOLD,18));
        btnAgregarBebida.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarBebida.setText("Agregar Bebida");
        btnAgregarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarBebidaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 550, 230, 40));

        jLabel1.setFont(new Font("HeadlandOne", Font.BOLD, 64));
        jLabel1.setForeground(new java.awt.Color(25, 25, 25));
        jLabel1.setText("Nueva Comanda");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 1820, -1));

        jTextField1.setColumns(20);
        jTextField1.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jTextField1.setRows(5);
        jTextField1.setName("jTextField1"); // NOI18N
        jScrollPane5.setViewportView(jTextField1);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 290, 470, 210));

        lblNotaTablaIngredientes.setText("Para quitar una bebida, solo deje vacío el campo platillo o la cantidad en 0");
        jPanel1.add(lblNotaTablaIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 800, 470, -1));

        lblNotaTablaIngredientes1.setText("Para quitar un platillo, solo deje vacío el campo platillo o la cantidad en 0");
        jPanel1.add(lblNotaTablaIngredientes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 470, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 2824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new JF_ComandasEmpleado(this.empleadoE, notificaciones).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAgregarPlatilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPlatilloActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tablePlatilllos.getModel();
        model.addRow(new Object[]{"", 0});
    }//GEN-LAST:event_btnAgregarPlatilloActionPerformed

    private void btnAgregarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarBebidaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableBebidas.getModel();
        model.addRow(new Object[]{"", 0});
    }//GEN-LAST:event_btnAgregarBebidaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ArrayList<String> Productos = new ArrayList<>();
        ProductoMenu producto;
        double MontoTotal = 0;
        //DefaultTableModel model = (DefaultTableModel) tablePlatilllos.getModel();
        //DefaultTableModel model2 = (DefaultTableModel) tableBebidas.getModel();
        for (int i = 0; i < tablePlatilllos.getRowCount(); i++){
            producto = Menu.ObtenerProductoNombre(tablePlatilllos.getModel().getValueAt(i, 0).toString());
            for (int j = 0; j < Double.parseDouble(tablePlatilllos.getModel().getValueAt(i, 1).toString()); j++){
                Productos.add(producto.getNombre());
                MontoTotal += producto.getPrecio();
            }
        }

        for (int i = 0; i < tableBebidas.getRowCount(); i++){
            producto = Menu.ObtenerProductoNombre(tableBebidas.getModel().getValueAt(i, 0).toString());
            for (int j = 0; j < Double.parseDouble(tableBebidas.getModel().getValueAt(i, 1).toString()); j++){
                Productos.add(producto.getNombre());
                MontoTotal += producto.getPrecio();
            }
        }

        comanda.AgregarComanda(MontoTotal, Productos, jTextField1.getText());
        Empleado.CrearEmpleado(comanda.UltimaComanda().getId(), empleadoE.getId(), MontoTotal);

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(JF_NuevaComandaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_NuevaComandaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_NuevaComandaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_NuevaComandaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_NuevaComandaEmpleado(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Bebidas;
    private javax.swing.JComboBox<String> Platillos;
    private javax.swing.JButton btnAgregarBebida;
    private javax.swing.JButton btnAgregarPlatillo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextField1;
    private javax.swing.JLabel lblNotaTablaIngredientes;
    private javax.swing.JLabel lblNotaTablaIngredientes1;
    private javax.swing.JTable tableBebidas;
    private javax.swing.JTable tablePlatilllos;
    // End of variables declaration//GEN-END:variables
}
