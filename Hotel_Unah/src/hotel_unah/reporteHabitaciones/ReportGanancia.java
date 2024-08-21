package hotel_unah.reporteHabitaciones;

import hotel_unah.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReportGanancia extends javax.swing.JDialog {

    public ReportGanancia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }

    public void ReporteG(Date fechaInicial, Date fechaFinal){
        
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
            
            PreparedStatement mostrar = conexion.prepareStatement("SELECT reservas.id, clientes.nombre, habitaciones.numero_habitacion, habitaciones.precio_por_noche, habitaciones.tipo, checkins.fecha_checkin, checkouts.fecha_checkout FROM reservas INNER JOIN clientes ON reservas.cliente_id = clientes.id INNER JOIN habitaciones ON reservas.habitacion_id = habitaciones.id LEFT JOIN checkins ON reservas.id = checkins.reserva_id LEFT JOIN checkouts ON checkins.id = checkouts.checkin_id WHERE (checkins.fecha_checkin BETWEEN ? AND ?) OR (checkouts.fecha_checkout BETWEEN ? AND ?);");
            
            
            mostrar.setString(1, fechaInicial.toString());
            mostrar.setString(2, fechaFinal.toString());
            mostrar.setString(3, fechaInicial.toString());
            mostrar.setString(4, fechaFinal.toString());
            ResultSet datitos = mostrar.executeQuery();
               
            DefaultTableModel datos = new DefaultTableModel();

            datos.addColumn("id");
            datos.addColumn("nombre");
            datos.addColumn("Habitacion");
            datos.addColumn("tipo_Habitacion");
            datos.addColumn("fecha_checkin");
            datos.addColumn("fecha_checkout");
            datos.addColumn("precio_por_noche");
            datos.addColumn("dias_totales");           
            
            tablaGanancia.setModel(datos);
            
            if (!datitos.isBeforeFirst()) { 
            JOptionPane.showMessageDialog(null, "No hay registros de checkouts en el rango de fechas especificado.");
            return;
            //no supe como detener la desde aqui, luego de verificar los datos
            }
 
            while (datitos.next()) {
                Vector fila = new Vector();
                
                fila.addElement(datitos.getString("id"));
                fila.addElement(datitos.getString("nombre"));
                fila.addElement(datitos.getString("numero_habitacion"));
                fila.addElement(datitos.getString("tipo"));
                fila.addElement(datitos.getString("fecha_checkin"));
                fila.addElement(datitos.getString("fecha_checkout"));
                fila.addElement(datitos.getString("precio_por_noche"));
                
                LocalDate fechaEntrada = datitos.getDate("fecha_checkin").toLocalDate();
                LocalDate fechaSalida = datitos.getDate("fecha_checkout").toLocalDate();
                long dias = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
                
                fila.addElement(dias);
                                                
                datos.addRow(fila);
            }
            
            conn.cerrarConexion();  
                
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }  
    
    public void calcularTotal(Date fechaInicial, Date fechaFinal){
        
        try{ 
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
            
            PreparedStatement ganancia = conexion.prepareStatement("SELECT habitaciones.precio_por_noche, checkins.fecha_checkin, checkouts.fecha_checkout FROM reservas "
                    + "INNER JOIN clientes ON reservas.cliente_id = clientes.id INNER JOIN habitaciones ON reservas.habitacion_id = habitaciones.id LEFT JOIN checkins ON reservas.id = checkins.reserva_id "
                    + "LEFT JOIN checkouts ON checkins.id = checkouts.checkin_id WHERE (checkins.fecha_checkin BETWEEN ? AND ?) OR (checkouts.fecha_checkout BETWEEN ? AND ?);");
                        
            ganancia.setString(1, fechaInicial.toString());
            ganancia.setString(2, fechaFinal.toString());
            ganancia.setString(3, fechaInicial.toString());
            ganancia.setString(4, fechaFinal.toString());
            ResultSet gan = ganancia.executeQuery();
            
            double total = 0;
                       
            while (gan.next()) {
                LocalDate fechaEntrada = gan.getDate("fecha_checkin").toLocalDate();
                LocalDate fechaSalida = gan.getDate("fecha_checkout").toLocalDate();
                long dias = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
                
                double precio = gan.getDouble("precio_por_noche");
                
                total += precio*dias;
            }
            
            lblTotal.setText(total+" Lps");
            
            conn.cerrarConexion();
            
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGanancia = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaGanancia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaGanancia);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ganancias Generadas");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Total:");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTotal.setText("0.00 Lps.");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setRootPane(null); 
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReportGanancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportGanancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportGanancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportGanancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReportGanancia dialog = new ReportGanancia(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaGanancia;
    // End of variables declaration//GEN-END:variables
}
