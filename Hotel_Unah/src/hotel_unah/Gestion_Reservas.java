/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */  
package hotel_unah;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
/**
 *
 * @author Lizy Bustillo
 */
public class Gestion_Reservas extends javax.swing.JDialog {
    DefaultComboBoxModel<String> modelo;
    private final Main_Hotel mainHotel;
    private JDateChooser jDateChooserEntrada;
    private JDateChooser jDateChooserSalida;

    private int reservaId;
    /**
     * Creates new form Gestion_Reservas_Dialog
     */
    public Gestion_Reservas(java.awt.Frame parent, boolean modal,Main_Hotel mainHotel,int clienteId, int habitacionId,Date fechaEntrada,Date fechaSalida,String estado) {
        super(parent, modal);
        this.mainHotel = mainHotel;
        this.reservaId = reservaId; 
        initComponents();
        cbxClientes.setSelectedItem(String.valueOf(clienteId));
        cbxHabitaciones.setSelectedItem(String.valueOf(habitacionId));
        jDateChooserEntrada.setDate(fechaEntrada);
        jDateChooserSalida.setDate(fechaSalida);
        cbxEstado.setSelectedItem(estado);
    }
    public Gestion_Reservas(java.awt.Frame parent, boolean modal,Main_Hotel mainHotel) {
        super(parent, modal);
        this.mainHotel = mainHotel;
        initComponents();
        
    }
       
    
    private void cargarClientesEnComboBox() {
    Connection conexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        Conexion conn = Conexion.getInstance();
        conexion = conn.conectar();

        String sql = "SELECT id FROM Clientes";
        ps = conexion.prepareStatement(sql);
        rs = ps.executeQuery();

        cbxClientes.removeAllItems();

        cbxClientes.addItem("Seleccione una opcion");

        while (rs.next()) {
            int idCliente = rs.getInt("id");
            cbxClientes.addItem(String.valueOf(idCliente));
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cerrar la conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
  }
    
    private void cargarHabitacionesEnComboBox() {
    Connection conexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        Conexion conn = Conexion.getInstance();
        conexion = conn.conectar();

        String sql = "SELECT id FROM Habitaciones WHERE estado = 'en limpieza' OR estado = 'disponible'";
        ps = conexion.prepareStatement(sql);
        rs = ps.executeQuery();

        cbxHabitaciones.removeAllItems();
        
        cbxHabitaciones.addItem("Seleccione una opcion");

        while (rs.next()) {
            int idHabitacion = rs.getInt("id");
            cbxHabitaciones.addItem(String.valueOf(idHabitacion));
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar habitaciones: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cerrar la conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

   private void guardarReserva() {
    try {
        int clienteId = Integer.parseInt((String) cbxClientes.getSelectedItem());
        int habitacionId = Integer.parseInt((String) cbxHabitaciones.getSelectedItem());
        java.sql.Date fechaEntrada = new java.sql.Date(jDateChooserEntrada.getDate().getTime());
        java.sql.Date fechaSalida = new java.sql.Date(jDateChooserSalida.getDate().getTime());
        String estado = (String) cbxEstado.getSelectedItem();

        Conexion conn = Conexion.getInstance();
        Connection conexion = conn.conectar();
        String sql = "UPDATE reservas SET cliente_id = ?, habitacion_id = ?, fecha_entrada = ?, fecha_salida = ?, estado = ? WHERE id = ?";
        PreparedStatement pst = conexion.prepareStatement(sql);
        pst.setInt(1, clienteId);
        pst.setInt(2, habitacionId);
        pst.setDate(3, fechaEntrada);
        pst.setDate(4, fechaSalida);
        pst.setString(5, estado);
        pst.setInt(6, reservaId);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Reserva modificada con éxito.");
        dispose();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al modificar la reserva: " + ex.getMessage());
    }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        fechaEnt = new com.toedter.calendar.JCalendar();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fechaSal = new com.toedter.calendar.JCalendar();
        btnSalir = new javax.swing.JButton();
        btnAgregarReserva = new javax.swing.JButton();
        cbxHabitaciones = new javax.swing.JComboBox<>();
        cbxClientes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATOS DE RESERVA");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("Cliente ID:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setText("Habitacion ID:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setText("Estado de reserva:");

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/calendario.png"))); // NOI18N

        fechaEnt.setDecorationBordersVisible(true);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setText("Fecha de salida:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setText("Fecha de salida:");

        fechaSal.setDecorationBordersVisible(true);

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancelar_Reserva.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAgregarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/disquete.png"))); // NOI18N
        btnAgregarReserva.setText("Guardar");
        btnAgregarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarReservaActionPerformed(evt);
            }
        });

        cbxHabitaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaSal, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(btnAgregarReserva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(jLabel3)
                    .addContainerGap(653, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1)))))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(fechaEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaSal, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(229, 229, 229)
                    .addComponent(jLabel3)
                    .addContainerGap(230, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();

     modelo.addElement("Seleccione una opción");
     modelo.addElement("Confirmada");
     modelo.addElement("Pendiente");
     modelo.addElement("Cancelada");

    if (cbxEstado != null) {
        cbxEstado.setModel(modelo);
    } else {
        System.out.println("cbxEstado no está inicializado.");
    }

    cargarClientesEnComboBox();
    cargarHabitacionesEnComboBox();
    }//GEN-LAST:event_formWindowOpened

    private void btnAgregarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarReservaActionPerformed
        // TODO add your handling code here:
        guardarReserva();
    }//GEN-LAST:event_btnAgregarReservaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.setRootPane(null);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(Gestion_Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            Main_Hotel mainHotel = new Main_Hotel(); 
            int reservaId = 0; 
            int clienteId = 0; 
            Date fechaEntrada = new Date(); 
            Date fechaSalida = new Date(); 
            String estado = "confirmada"; 
    
    Gestion_Reservas dialog = new Gestion_Reservas(new javax.swing.JFrame(), true, mainHotel, reservaId, clienteId, fechaEntrada, fechaSalida, estado);
    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
        }
    });
    dialog.setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarReserva;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxClientes;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxHabitaciones;
    private com.toedter.calendar.JCalendar fechaEnt;
    private com.toedter.calendar.JCalendar fechaSal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
