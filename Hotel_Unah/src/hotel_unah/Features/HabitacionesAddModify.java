/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package hotel_unah.Features;

import javax.swing.JOptionPane;

/**
 *
 * @author axel2
 */
public class HabitacionesAddModify extends javax.swing.JDialog {

    /**
     * Creates new form HabitacionesAddModify
     */
    boolean isModify;
    public HabitacionesAddModify(java.awt.Frame parent, boolean modal, boolean modificacion) {
        super(parent, modal);
        initComponents();
        if(modificacion){
            jlAddModifyHabitacion.setText("Actualizar Habitación");
            btnAddModify.setText("Actualizar");
        }
        else{
            jlAddModifyHabitacion.setText("Agregar Habitación");
            btnAddModify.setText("Guardar");
        }
        
        isModify = modificacion;
    }

     public String GetNumeroHabitacion(){
        return txtNumeroHabitacion.getText();
    }
    public String GetPrecioNoche(){
        return txtPrecioNoche.getText();
    }
    public int GetEstadoHabitacion(){
        return cbEstadoHabitacion.getSelectedIndex();
    }
    
     public int GetTipoHabitacion(){
        return cbTipoHabitacion.getSelectedIndex();
    }
    
    public void setNumeracionHabitacion(String numeroHabitacion){
        txtNumeroHabitacion.setText(numeroHabitacion);
    }
    
    public void setPrecioNoche(String PrecioNoche){
        txtPrecioNoche.setText(PrecioNoche);
    }
    
    public void setEstadoHabitacion(int estado){
        cbEstadoHabitacion.setSelectedIndex(estado);
    }
    
    public void setTipoHabitacion(int tipo){
        cbTipoHabitacion.setSelectedIndex(tipo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancel = new javax.swing.JButton();
        jlAddModifyHabitacion = new javax.swing.JLabel();
        txtNumeroHabitacion = new javax.swing.JTextField();
        jlNumeroHabitacion = new javax.swing.JLabel();
        cbTipoHabitacion = new javax.swing.JComboBox<>();
        jlTipoHabitacion = new javax.swing.JLabel();
        cbEstadoHabitacion = new javax.swing.JComboBox<>();
        jlEstadoHabitacion = new javax.swing.JLabel();
        txtPrecioNoche = new javax.swing.JTextField();
        jlPrecioNoche = new javax.swing.JLabel();
        btnAddModify = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancelar_Reserva.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jlAddModifyHabitacion.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jlAddModifyHabitacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlAddModifyHabitacion.setText("jLabel1");
        jlAddModifyHabitacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jlNumeroHabitacion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlNumeroHabitacion.setText("Numero habitación");

        cbTipoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo...", "Individual", "Doble", "Suite" }));

        jlTipoHabitacion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlTipoHabitacion.setText("Tipo habitación");

        cbEstadoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un estado...", "Disponible", "Ocupada", "En limpieza" }));

        jlEstadoHabitacion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlEstadoHabitacion.setText("Estado habitación");

        jlPrecioNoche.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlPrecioNoche.setText("Precio por noche");

        btnAddModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/disquete.png"))); // NOI18N
        btnAddModify.setText("jButton1");
        btnAddModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddModifyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(btnAddModify, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlNumeroHabitacion))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlTipoHabitacion)
                                    .addComponent(cbTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEstadoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlEstadoHabitacion))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlPrecioNoche)
                                    .addComponent(txtPrecioNoche, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jlAddModifyHabitacion)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlAddModifyHabitacion)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNumeroHabitacion)
                    .addComponent(jlTipoHabitacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbTipoHabitacion)
                    .addComponent(txtNumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEstadoHabitacion)
                    .addComponent(jlPrecioNoche))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbEstadoHabitacion)
                    .addComponent(txtPrecioNoche, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddModify, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setRootPane(null);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddModifyActionPerformed
        int tipoIndex = cbEstadoHabitacion.getSelectedIndex();
        int estadoIndex = cbTipoHabitacion.getSelectedIndex();
        double precioNoche;
        String NumeroHabitacion;
        try{
            precioNoche = Double.parseDouble(txtPrecioNoche.getText());
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "El precio por noche debe ser un número","Datos incorrectos",JOptionPane.WARNING_MESSAGE);
            return;
        }

        NumeroHabitacion = txtNumeroHabitacion.getText();

        if(tipoIndex == 0){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo para la habitación","Producto incorrecto",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(estadoIndex == 0){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un estado para la habitación","Producto incorrecto",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (precioNoche <= 0) {
            JOptionPane.showMessageDialog(this, "El precio por noche debe ser mayor a cero","Cantidad incorrecta",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (NumeroHabitacion.isBlank()) {
            JOptionPane.showMessageDialog(this, "El numero de habitación es requerido","Precio incorrecto",JOptionPane.WARNING_MESSAGE);
            return;
        }

        //CONFIRMAR QUE DESEA GUARDAR
        String mensaje;
        if(isModify)
        mensaje = "¿Desea actualizar esta habitación?";
        else
        mensaje = "¿Desea agregar esta habitación?";
        int respuesta = JOptionPane.showConfirmDialog(this, mensaje);
        System.out.println(respuesta);

        //NOTIFICAR AL PADRE LO QUE SE QUIERE HACER
        if(respuesta == 0){
            this.setVisible(false);

        }
    }//GEN-LAST:event_btnAddModifyActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //Activar color de fondo
        this.getContentPane().setBackground(this.getBackground());
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
            java.util.logging.Logger.getLogger(HabitacionesAddModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HabitacionesAddModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HabitacionesAddModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HabitacionesAddModify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HabitacionesAddModify dialog = new HabitacionesAddModify(new javax.swing.JFrame(), true, false);
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
    private javax.swing.JButton btnAddModify;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> cbEstadoHabitacion;
    private javax.swing.JComboBox<String> cbTipoHabitacion;
    private javax.swing.JLabel jlAddModifyHabitacion;
    private javax.swing.JLabel jlEstadoHabitacion;
    private javax.swing.JLabel jlNumeroHabitacion;
    private javax.swing.JLabel jlPrecioNoche;
    private javax.swing.JLabel jlTipoHabitacion;
    private javax.swing.JTextField txtNumeroHabitacion;
    private javax.swing.JTextField txtPrecioNoche;
    // End of variables declaration//GEN-END:variables
}
