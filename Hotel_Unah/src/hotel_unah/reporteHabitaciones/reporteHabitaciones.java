
package hotel_unah.reporteHabitaciones;


import hotel_unah.Conexion;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class reporteHabitaciones extends javax.swing.JDialog {

    public reporteHabitaciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
public DefaultTableModel modelo(){
        return null;
    }
    //c
    //valida si habitaciones ocupadas para no abrir el Dialog si no hubo, luego de solucionar la logica, quedo como obsoleto este codigo sin embargo se podria cambiar si mi resolucion
    // de el inciso fuese incorrecto
    public int validarReservaciones(Date primerFecha, Date segundaFecha){
        
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM reservas INNER JOIN habitaciones ON reservas.habitacion_id=habitaciones.id WHERE fecha_entrada BETWEEN ? AND ? OR fecha_salida BETWEEN ? AND ?;");
            stmt.setString(1, primerFecha.toString());
                stmt.setString(2, segundaFecha.toString());
                stmt.setString(3, primerFecha.toString());
                stmt.setString(4, segundaFecha.toString());
                ResultSet resultset = stmt.executeQuery();
               
                if (!resultset.next()) {
                    JOptionPane.showMessageDialog(null, "No hubo Actividad Alguna entre ese rango de fechas");
                    int salida = 1;
                    conn.cerrarConexion();
                    return salida;
                }
        } catch (SQLException e) {
            
        }
        return 0;
        
    }
    
    DefaultTableModel modelo = new DefaultTableModel(){
        
    };
    
    //hace una consulta donde compara las fechas con la tabla de reservacion y la une con la tabla habitaciones, la de reservacion compara si hubo reservacion alguna,
    // y en la de habitaciones se extrae el estado de la misma
    public void llenarTablaOcupadasLimpieza(Date primerFecha, Date segundaFecha){
    
        
        
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
            
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM reservas INNER JOIN habitaciones ON reservas.habitacion_id=habitaciones.id WHERE fecha_entrada BETWEEN ? AND ? OR fecha_salida BETWEEN ? AND ?;");
                
                stmt.setString(1, primerFecha.toString());
                stmt.setString(2, segundaFecha.toString());
                stmt.setString(3, primerFecha.toString());
                stmt.setString(4, segundaFecha.toString());
                ResultSet resultset = stmt.executeQuery();
               
            modelo = new DefaultTableModel() {

                //deshabilitar la edición de las filas
                public boolean isCellEditable(int row, int col) {
                    return false;
                }

            };

            modelo.addColumn("id");
            modelo.addColumn("numero_habitacion");
            modelo.addColumn("tipo");
            modelo.addColumn("estado");
            modelo.addColumn("precio_por_noche");
            

            tblOcupacion.setModel(modelo);
            
            
            
            while (resultset.next()) {
                Vector fila = new Vector();
                
                fila.addElement(resultset.getString(7));
                fila.addElement(resultset.getString(8));
                fila.addElement(resultset.getString(9));
                fila.addElement(resultset.getString(10));
                fila.addElement(resultset.getString(11));
                
                 
                modelo.addRow(fila);
            }
           
             habitacionesDisponibles(tblOcupacion);
            conn.cerrarConexion();
            
                
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return;
        }
    
    }
    //luego de hacer la busqueda si ha encontrado actividad, por logica independientemente del estado de la habitacion en la tabla actual, la habitacion en ese tiempo estuvo disponible, 
    //por eso se muestra, llenando un arreglo con los datos de los ID de las habitaciones que se generan de la base de datos luego de la primera consulta y luego con ese arreglo
    //se concatena el querry para qque busque en la tabla las habitaciones que no esten ocupads o en limpieza que por logica estuvieron disponibles
    public void habitacionesDisponibles(JTable tblOcupacion){
        
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
            
            int filas = tblOcupacion.getRowCount();
            String[] id = new String[tblOcupacion.getRowCount()];
            String query_concatenado="habitaciones.id<>";
            for (int i = 0; i < filas; i++) {
                id[i]=tblOcupacion.getValueAt(i, 0).toString();
                
                query_concatenado=query_concatenado+id[i]+" AND habitaciones.id<>";
            }
            
           PreparedStatement agregarFaltantes=conexion.prepareStatement("SELECT * FROM habitaciones WHERE "+query_concatenado+"0");
            
           ResultSet query = agregarFaltantes.executeQuery();
            
            while (query.next()) {                
                Vector fila = new Vector();
                
                fila.addElement(query.getString(1));
                fila.addElement(query.getString(2));
                fila.addElement(query.getString(3));
                fila.addElement("disponible");
                fila.addElement(query.getString(5));
                
                modelo.addRow(fila);
            }
                
                
        } catch (SQLException e) {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tblOcupacion = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblOcupacion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblOcupacion);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Reportes de Ocupacion");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(151, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(612, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.setRootPane(null); // estoy destruyendo los elementos en la UI
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(reporteHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reporteHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reporteHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reporteHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                reporteHabitaciones dialog = new reporteHabitaciones(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblOcupacion;
    // End of variables declaration//GEN-END:variables
}
