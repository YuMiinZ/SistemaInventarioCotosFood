/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorComanda;
import Controlador.ControladorConsumo;
import Controlador.ControladorProductoMenu;
import Modelo.Mesas;
import Modelo.ProductoMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Clases.MenuBoton;
import Vista.Clases.TablaPersonalizada;
import Vista.Clases.TablaSpinnerPersonalizada;
import java.awt.BorderLayout;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author TomasPC
 */
public class JF_NuevaComanda extends javax.swing.JFrame {
    private MenuBoton menu;
    private Mesas Mesa;
    private ControladorComanda Comanda = new ControladorComanda();
    private ControladorConsumo Cliente = new ControladorConsumo();
    private ControladorProductoMenu Menu = new ControladorProductoMenu(); 
    private List<ProductoMenu> Platillo;
    private List<ProductoMenu> Bebida;
    private List<String[]> notificaciones;
    /**
     * Creates new form NuevaComanda
     * @param Mesa
     * @param notificaciones
     */
    public JF_NuevaComanda(Mesas Mesa, java.util.List<String[]> notificaciones) {
        this.notificaciones = notificaciones;
        initComponents();
        menu = new MenuBoton(300, getContentPane().getHeight() - 185, this, notificaciones);
        this.Mesa = Mesa;
        customComponents();
        eventComponents();
    }
    
    
    private void customComponents(){
        menu.setButtonIcon(jButton1, "/Imagenes/IconoMenu.png");
        menu.setButtonIcon(jButton2, "/Imagenes/IconoRegresar.png");
        jLabel7.setText(""+this.Mesa.getNumeroMesa());
        
        
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePlatilllos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBebidas = new javax.swing.JTable();
        btnAgregarPlatillo = new javax.swing.JButton();
        btnAgregarBebida = new javax.swing.JButton();

        Platillos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Bebidas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1747, 1291));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel1.setMinimumSize(new java.awt.Dimension(2160, 1440));
        jPanel1.setPreferredSize(new java.awt.Dimension(2160, 1440));
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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 129, 71, 78));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new Font("Montserrat", Font.BOLD, 64));
        jLabel1.setForeground(new java.awt.Color(25, 25, 25));
        jLabel1.setText("Nueva Comanda");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, 55));

        jPanel2.setBackground(new java.awt.Color(152, 194, 70));

        jLabel3.setFont(new Font("Montserrat", Font.BOLD, 40));
        jLabel3.setForeground(new java.awt.Color(25, 25, 25));
        jLabel3.setText("Cotos Food");

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
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1817, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2160, -1));

        jLabel2.setFont(new Font("Montserrat", 0, 36));
        jLabel2.setText("Número de Mesa");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        jLabel4.setFont(new Font("Montserrat", 0, 36));
        jLabel4.setText("Platillos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        jLabel5.setFont(new Font("Montserrat", 0, 36));
        jLabel5.setText("Bebidas");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 720, -1, -1));

        jLabel6.setFont(new Font("Montserrat", 0, 36));
        jLabel6.setText("Notas");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 280, -1, -1));

        jTextField1.setMaximumSize(new java.awt.Dimension(661, 290));
        jTextField1.setMinimumSize(new java.awt.Dimension(661, 290));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 360, 734, 222));

        jButton3.setBackground(new java.awt.Color(0, 72, 121));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Agregar");
        jButton3.setMaximumSize(new java.awt.Dimension(525, 71));
        jButton3.setMinimumSize(new java.awt.Dimension(525, 71));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 800, 537, 181));

        jLabel7.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 318, -1, -1));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 470, 210));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 790, 470, 210));

        btnAgregarPlatillo.setBackground(new java.awt.Color(0, 72, 121));
        btnAgregarPlatillo.setFont(new Font ("Montserrat", Font.BOLD,18));
        btnAgregarPlatillo.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarPlatillo.setText("Agregar Platillo");
        btnAgregarPlatillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPlatilloActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarPlatillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 230, 40));

        btnAgregarBebida.setBackground(new java.awt.Color(0, 72, 121));
        btnAgregarBebida.setFont(new Font ("Montserrat", Font.BOLD,18));
        btnAgregarBebida.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarBebida.setText("Agregar Bebida");
        btnAgregarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarBebidaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 750, 230, 40));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 2317, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new JF_ComandasMesa(this.Mesa, notificaciones).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
        
        Comanda.AgreagarComanda(MontoTotal, Productos, jTextField1.getText());
        Cliente.CrearCliente(Comanda.UltimaComanda().getId(), Mesa.getId(), MontoTotal, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(JF_NuevaComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_NuevaComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_NuevaComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_NuevaComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_NuevaComanda(null, null).setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableBebidas;
    private javax.swing.JTable tablePlatilllos;
    // End of variables declaration//GEN-END:variables
}
