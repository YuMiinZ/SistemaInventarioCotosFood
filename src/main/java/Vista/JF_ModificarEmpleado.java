/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.ControladorEmpleado;
import Modelo.Empleado;
import Vista.Clases.FuncionesGenerales;
import Vista.Clases.ManejadorComponentes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Clases.MenuBoton;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author yumii
 */
public class JF_ModificarEmpleado extends javax.swing.JFrame {
    //private boolean menuAbierto = false;
    
    private MenuBoton menu;
    private int index;
    private final ManejadorComponentes manejadorComponentes = new ManejadorComponentes();
    private final ControladorEmpleado controlador = new ControladorEmpleado(manejadorComponentes);
    private java.util.List<Empleado> listaEmpleados;
    private FuncionesGenerales funciones = new FuncionesGenerales();
    private java.util.List<String[]> notificaciones;
    /**
     * Creates new form JF_Principal
     */
    public JF_ModificarEmpleado(java.util.List<String[]> notificaciones) {
        this.notificaciones = notificaciones;
        initComponents();
        menu = new MenuBoton(300, getContentPane().getHeight() - 185, this, notificaciones);
        customComponents();
        eventComponents();

        
        this.setExtendedState(JF_ModificarEmpleado.MAXIMIZED_BOTH);
        
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
        btnEliminar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        lblCotosFood = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        cmboxEmpleado = new javax.swing.JComboBox<>();
        lblEmpleado = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblErrorNombre = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblErrorTelefono = new javax.swing.JLabel();
        lblVacaciones = new javax.swing.JLabel();
        spnVacaciones = new javax.swing.JSpinner();
        lblErrorVacaciones = new javax.swing.JLabel();
        lblFechaCarnetAlimentos2 = new javax.swing.JLabel();
        txtFechaCarnetAlimentos = new javax.swing.JTextField();
        lblErrorFechaCarnetAlimentos = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        lblErrorFechaIngreso = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JTextField();
        lblFechaIngreso = new javax.swing.JLabel();
        lblErrorTipoSangre = new javax.swing.JLabel();
        cmboxTipoSangre = new javax.swing.JComboBox<>();
        lblTipoSangre = new javax.swing.JLabel();
        lblErrorAlergias = new javax.swing.JLabel();
        txtAlergias = new javax.swing.JTextField();
        lblAlergias = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(2160, 1440));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(2160, 1440));
        jPanel1.setPreferredSize(new java.awt.Dimension(2160, 1440));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(218, 46, 44));
        btnEliminar.setFont(new Font ("Montserrat", Font.BOLD,30));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 820, 199, 50));

        lblTitulo.setFont(new Font("HeadlandOne", Font.BOLD, 64));
        lblTitulo.setForeground(new java.awt.Color(25, 25, 25));
        lblTitulo.setText("Modificar Empleado");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

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
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCotosFood, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
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
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 71, 78));

        cmboxEmpleado.setFont(new Font ("Montserrat", Font.PLAIN,20));
        cmboxEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Juan Mora Rojas", "Nathalia Salazar", "Mario Murillo", "Emily Cascabel" }));
        cmboxEmpleado.setSelectedIndex(-1);
        cmboxEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 470, 40));

        lblEmpleado.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblEmpleado.setText("Empleado");
        jPanel1.add(lblEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 470, -1));

        lblNombre.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 470, -1));

        txtNombre.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 470, 38));

        lblErrorNombre.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorNombre.setText("El nombre no puede estar vacío");
        jPanel1.add(lblErrorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 460, -1));

        lblTelefono.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblTelefono.setText("Teléfono");
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 470, -1));

        txtTelefono.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 600, 470, 38));

        lblErrorTelefono.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorTelefono.setText("El número telefónico debe ser de 8 números");
        jPanel1.add(lblErrorTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 640, 460, -1));

        lblVacaciones.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblVacaciones.setText("Vacaciones");
        jPanel1.add(lblVacaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 700, 470, -1));

        spnVacaciones.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(spnVacaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 740, 470, 40));

        lblErrorVacaciones.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorVacaciones.setText("La cantidad de vacaciones que posee el empleado debe ser un número mayor o igual a 0");
        jPanel1.add(lblErrorVacaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 780, 540, -1));

        lblFechaCarnetAlimentos2.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblFechaCarnetAlimentos2.setText("Fecha Vencimiento Carnet");
        jPanel1.add(lblFechaCarnetAlimentos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 270, 590, -1));

        txtFechaCarnetAlimentos.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtFechaCarnetAlimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaCarnetAlimentosActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaCarnetAlimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, 470, 38));

        lblErrorFechaCarnetAlimentos.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorFechaCarnetAlimentos.setText("La fecha debe de seguir el formato dd/mm/aaaa");
        jPanel1.add(lblErrorFechaCarnetAlimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 350, 460, -1));

        btnModificar.setBackground(new java.awt.Color(0, 72, 121));
        btnModificar.setFont(new Font ("Montserrat", Font.BOLD,30));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Guardar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 820, 199, 50));

        lblErrorFechaIngreso.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorFechaIngreso.setText("La fecha debe de seguir el formato dd/mm/aaaa");
        jPanel1.add(lblErrorFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 780, 460, -1));

        txtFechaIngreso.setFont(new Font ("Montserrat", Font.PLAIN,26));
        txtFechaIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaIngresoActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 740, 470, 38));

        lblFechaIngreso.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblFechaIngreso.setText("Fecha de Ingreso");
        jPanel1.add(lblFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 700, 470, -1));

        lblErrorTipoSangre.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorTipoSangre.setText("Debe de seleccionar el tipo de sangre");
        jPanel1.add(lblErrorTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 630, 460, -1));

        cmboxTipoSangre.setFont(new Font ("Montserrat", Font.PLAIN,20));
        cmboxTipoSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+" }));
        cmboxTipoSangre.setSelectedIndex(-1);
        cmboxTipoSangre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxTipoSangreActionPerformed(evt);
            }
        });
        jPanel1.add(cmboxTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 590, 470, 40));

        lblTipoSangre.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblTipoSangre.setText("Tipo de Sangre");
        jPanel1.add(lblTipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 550, 470, -1));

        lblErrorAlergias.setForeground(new java.awt.Color(194, 8, 8));
        lblErrorAlergias.setText("El campo de alergias no puede estar vacía");
        jPanel1.add(lblErrorAlergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 490, 460, -1));

        txtAlergias.setFont(new Font ("Montserrat", Font.PLAIN,26));
        jPanel1.add(txtAlergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, 470, 38));

        lblAlergias.setFont(new Font ("Montserrat", Font.BOLD,36));
        lblAlergias.setText("Alergias");
        jPanel1.add(lblAlergias, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 410, 470, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
         index = cmboxEmpleado.getSelectedIndex();
        if(index!= -1 ){
            int selectedOption = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el empleado?", 
                                                                   null, JOptionPane.YES_NO_OPTION); 
            if (selectedOption == JOptionPane.YES_OPTION) {
                controlador.eliminarEmpleado(listaEmpleados.get(index).getId());
                listaEmpleados.remove(index);
                cmboxEmpleado.removeAllItems();
                cargarOpciones(-1);
                manejadorComponentes.limpiarCmbox();
                manejadorComponentes.limpiarSpinner();
                JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Debe de seleccionar un proveedor para poder eliminarlo", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        menu.regresarVentanaPrincipal(notificaciones);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cmboxEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxEmpleadoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtFechaCarnetAlimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaCarnetAlimentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaCarnetAlimentosActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        ControladorEmpleado controlador = new ControladorEmpleado(manejadorComponentes);
        
        index = cmboxEmpleado.getSelectedIndex();
        if (index == -1 ){
            JOptionPane.showMessageDialog(null, "Debe de seleccionar un empleado para poder realizar las modificaciones", 
                                          null, JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if(controlador.modificarEmpleado(listaEmpleados.get(cmboxEmpleado.getSelectedIndex()).getId(),txtNombre.getText(), txtTelefono.getText(), (int) spnVacaciones.getValue(), txtFechaCarnetAlimentos.getText(),
                        txtAlergias.getText(), cmboxTipoSangre.getSelectedItem(), txtFechaIngreso.getText())){
                    actualizarOpciones();
                    cargarOpciones(index);
                    JOptionPane.showMessageDialog(null, "Modificación exitosa");
                }      
            } catch (ParseException ex) {
                Logger.getLogger(JF_ModificarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtFechaIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaIngresoActionPerformed

    private void cmboxTipoSangreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxTipoSangreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxTipoSangreActionPerformed

    private void actualizarOpciones() throws ParseException{
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaIngresoDate;
        Date fechaVencimientoDate;

        fechaIngresoDate = formatoFecha.parse(txtFechaIngreso.getText());
        fechaVencimientoDate = formatoFecha.parse(txtFechaCarnetAlimentos.getText());
        for (Empleado emp : listaEmpleados) {
            if (emp.getId().equals(listaEmpleados.get(cmboxEmpleado.getSelectedIndex()).getId())) {
                emp.setNombre(txtNombre.getText());
                emp.setTelefono(txtTelefono.getText());
                emp.setVacaciones((int) spnVacaciones.getValue());
                emp.setFecha_vencimiento_carnet(fechaVencimientoDate);
                emp.setAlergias(txtAlergias.getText());
                emp.setTipoSangre(cmboxTipoSangre.getSelectedItem().toString());
                emp.setFecha_ingreso(fechaIngresoDate);
                break;
            }
        }        
    }
  
    private void customComponents(){
        menu.setButtonIcon(btnMenu, "/Imagenes/IconoMenu.png");
        menu.setButtonIcon(btnRegresar, "/Imagenes/IconoRegresar.png");
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(jScrollPane1, BorderLayout.CENTER);
        
        pack();
        
        manejadorComponentes.agregarLabel(lblErrorNombre);
        manejadorComponentes.agregarLabel(lblErrorTelefono);
        manejadorComponentes.agregarLabel(lblErrorVacaciones);
        manejadorComponentes.agregarLabel(lblErrorFechaCarnetAlimentos);
        manejadorComponentes.agregarLabel(lblErrorAlergias);
        manejadorComponentes.agregarLabel(lblErrorTipoSangre);
        manejadorComponentes.agregarLabel(lblErrorFechaIngreso);
        


        manejadorComponentes.agregarText(txtNombre);
        manejadorComponentes.agregarText(txtTelefono);  
        manejadorComponentes.agregarText(txtFechaCarnetAlimentos);
        manejadorComponentes.agregarText(txtAlergias);
        manejadorComponentes.agregarText(txtFechaIngreso);
        
        manejadorComponentes.ocultarLabels();
        manejadorComponentes.agregarComboBox(cmboxTipoSangre);
        
        manejadorComponentes.agregarSpinner(spnVacaciones);
        
        cargarOpciones(-1);
    }
    
    private void agregarOpciones(){
        for (Empleado emp : listaEmpleados) {
            cmboxEmpleado.addItem(emp.getNombre()); 
        }
    }
    
    private void cargarOpciones(int index){
        cmboxEmpleado.removeAllItems();
        if(index == -1){
            listaEmpleados = controlador.obtenerListaEmpleados(); 
            agregarOpciones();
            manejadorComponentes.limpiarCamposTexto();
            cmboxEmpleado.setSelectedIndex(-1);
        } else {
            agregarOpciones();
            cmboxEmpleado.setSelectedIndex(index);
        }
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
        
        cmboxEmpleado.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarDatosEmpleado(evt);
            }
        });
    }
    
    private void cargarDatosEmpleado(java.awt.event.ActionEvent evt){
        int selectedIndex = cmboxEmpleado.getSelectedIndex();
        if (selectedIndex != -1) {
            txtNombre.setText(listaEmpleados.get(selectedIndex).getNombre());
            txtTelefono.setText(listaEmpleados.get(selectedIndex).getTelefono());
            txtAlergias.setText(listaEmpleados.get(selectedIndex).getAlergias());
            spnVacaciones.setValue(listaEmpleados.get(selectedIndex).getVacaciones());
            
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaIngreso = listaEmpleados.get(selectedIndex).getFecha_ingreso();
            Date fechaVencimientoCarnet = listaEmpleados.get(selectedIndex).getFecha_vencimiento_carnet();

            if (fechaIngreso != null) {
                String fechaIngresoString = formatoFecha.format(fechaIngreso);
                txtFechaIngreso.setText(fechaIngresoString);
            }

            if (fechaVencimientoCarnet != null) {
                String fechaVencimientoString = formatoFecha.format(fechaVencimientoCarnet);
                txtFechaCarnetAlimentos.setText(fechaVencimientoString);
            }
            
            String tipoSangreSeleccionado = listaEmpleados.get(selectedIndex).getTipoSangre();
            funciones.seleccionarEnComboBox(cmboxTipoSangre, tipoSangreSeleccionado);
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
                new JF_ModificarEmpleado(null).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmboxEmpleado;
    private javax.swing.JComboBox<String> cmboxTipoSangre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlergias;
    private javax.swing.JLabel lblCotosFood;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblErrorAlergias;
    private javax.swing.JLabel lblErrorFechaCarnetAlimentos;
    private javax.swing.JLabel lblErrorFechaIngreso;
    private javax.swing.JLabel lblErrorNombre;
    private javax.swing.JLabel lblErrorTelefono;
    private javax.swing.JLabel lblErrorTipoSangre;
    private javax.swing.JLabel lblErrorVacaciones;
    private javax.swing.JLabel lblFechaCarnetAlimentos2;
    private javax.swing.JLabel lblFechaIngreso;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoSangre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVacaciones;
    private javax.swing.JSpinner spnVacaciones;
    private javax.swing.JTextField txtAlergias;
    private javax.swing.JTextField txtFechaCarnetAlimentos;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
