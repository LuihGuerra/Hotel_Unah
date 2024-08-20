/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package hotel_unah;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Luih
 */
public class Administracion_Clientes_Dialog extends javax.swing.JDialog {
DefaultTableModel modelo = new DefaultTableModel();
    /**
     * Creates new form Administracion_Clientes_Dialog
     */
    public Administracion_Clientes_Dialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }
public String getNombre_Cliente(){
    return txtNombre.getText();
}

public String getDni_Cliente(){
    return txtDni.getText();
}
public String getTelefono_Cliente(){
    return txtTelefono.getText();
}
public String getDireccion_Cliente(){
    return txtDireccion.getText();
}
public String getEmail_Cliente(){
    return txtEmail.getText();
}


public void setNombre_Cliente(String nombre){
    txtNombre.setText(nombre);
}
public void setDni_Cliente(String dni){
    txtDni.setText(dni);
}
public void setTelefono_Cliente(String telefono){
    txtTelefono.setText(telefono);
}
public void setDireccion_Cliente(String direccion){
    txtDireccion.setText(direccion);
}
public void setEmail_Cliente(String email){
    txtEmail.setText(email);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
public void buscarDni(String dni) {
   try {

            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();

            PreparedStatement consulta = conexion.prepareStatement("SELECT dni FROM clientes WHERE dni = ?");

            consulta.setString(1, dni);

            ResultSet resultado = consulta.executeQuery();

            if (resultado.next()) {
               JOptionPane.showMessageDialog(null, "Ya Existe este DNI");
               
               btnGuardarClientes.setEnabled(false);
               
            } else {
                //JOptionPane.showMessageDialog(null, "No Existe este DNI");
                btnGuardarClientes.setEnabled(true);
                
            }
            conn.cerrarConexion();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            
            
        } finally {
            try {
                Conexion conn = Conexion.getInstance();
                conn.cerrarConexion();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

        

    }


    public void actualizar_tabla_clientes(JTable tblClientes) {

        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();

            PreparedStatement llenarTabla = conexion.prepareStatement("SELECT * FROM clientes");

            ResultSet consulta = llenarTabla.executeQuery();

            modelo = new DefaultTableModel() {

                //deshabilitar la edición de las filas
                public boolean isCellEditable(int row, int col) {
                    return false;
                }

            };

            modelo.addColumn("id");
            modelo.addColumn("nombre");
            modelo.addColumn("direccion");
            modelo.addColumn("telefono");
            modelo.addColumn("email");
            modelo.addColumn("dni");

            tblClientes.setModel(modelo);

            while (consulta.next()) {
                Vector fila = new Vector();

                fila.addElement(consulta.getString(1));
                fila.addElement(consulta.getString(2));
                fila.addElement(consulta.getString(3));
                fila.addElement(consulta.getString(4));
                fila.addElement(consulta.getString(5));
                fila.addElement(consulta.getString(6));

                modelo.addRow(fila);
            }
            conn.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    } 
    public void OcultarBotonModificar(){
        
        btnGuardarClientesModificar.setVisible(false);
       
    }
    public void OcultarBotonGuardar(){
        //Dimension d = new Dimension();
        //d.height=40;
        //d.width=500;
        btnGuardarClientes.setVisible(false);
        //btnGuardarClientesModificar.setPreferredSize(d);
    }
    public void modificar_cliente(String id_ClienteModificar) {
        
        
       
        
        Conexion conn = Conexion.getInstance();
        

        
             
        try {

            Connection conexion = conn.conectar();

            PreparedStatement modificar = conexion.prepareStatement
                    ("UPDATE clientes SET "
                    + "nombre='"+getNombre_Cliente()+"',"
                    + "direccion='"+getDireccion_Cliente()+"',"
                    + "telefono='"+getTelefono_Cliente()+"',"
                    + "email='"+getEmail_Cliente()+"',"
                    + "dni='"+getDni_Cliente()+"' "
                    + "WHERE id='"+id_ClienteModificar+"';");

            
           
                Object [] opciones = {"SI", "NO"};
                int respuesta = JOptionPane.showOptionDialog(this, "Desea modificar al Cliente?","Modificar Cliente" ,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, opciones, opciones[1]);
                if (respuesta==-1) {
                     //Por si hace cosas raras el boton "x"
                }else{
               if (respuesta==0) {
                modificar.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente Modificado Correctamente");

            
            conn.cerrarConexion();
               this.dispose();
               }else{return;}}

           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede modificar este cliente porque eso interfiere con la integridad de los datos "+e);
        }
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAdministracionClientes = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        btnGuardarClientes = new javax.swing.JButton();
        btnCancelarClientes = new javax.swing.JButton();
        btnGuardarClientesModificar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblAdministracionClientes.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblAdministracionClientes.setText("Administración de Clientes");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("DNI:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Direccion:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Telefono:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Email:");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombre.setName("Gestion De Clientes"); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtDni.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDniFocusLost(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        txtDireccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblCliente.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblCliente.setText("Gestion de Clientes");

        btnGuardarClientes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGuardarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/disquete.png"))); // NOI18N
        btnGuardarClientes.setText("Guardar");
        btnGuardarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClientesActionPerformed(evt);
            }
        });

        btnCancelarClientes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancelar_Reserva.png"))); // NOI18N
        btnCancelarClientes.setText("Cancelar");
        btnCancelarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarClientesActionPerformed(evt);
            }
        });

        btnGuardarClientesModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnGuardarClientesModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/disquete.png"))); // NOI18N
        btnGuardarClientesModificar.setText("Guardar");
        btnGuardarClientesModificar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnGuardarClientesModificarStateChanged(evt);
            }
        });
        btnGuardarClientesModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClientesModificarActionPerformed(evt);
            }
        });

        txtId.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(lblCliente)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblAdministracionClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnGuardarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarClientesModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdministracionClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblCliente)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarClientesModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClientesActionPerformed
        // TODO add your handling code here:
       try{
        
        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El nombre del Cliente no puede estar vacio",
                    "Nombre Invalido",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }
           
        if (txtDni.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El DNI no puede estar vacio",
                    "DNI Invalido",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }
        Object [] opciones = {"SI", "NO"};
       int respuesta = JOptionPane.showOptionDialog(null, "Desea Agregar/Modificar","Agregar/Modificar" ,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, opciones, opciones[1 ]);
                //guardar en la tabla
        if (respuesta == 0) {
            this.setVisible(false);
        }else{
            
        }
       
       }catch(HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
       
         
    }//GEN-LAST:event_btnGuardarClientesActionPerformed
public String getID(){
return txtId.getText().trim();
}
public void setID(String id){
txtId.setText(id);
}
    private void btnCancelarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarClientesActionPerformed
        // TODO add your handling code here:
        this.setRootPane(null); // estoy destruyendo los elementos en la UI
        this.dispose();
    }//GEN-LAST:event_btnCancelarClientesActionPerformed

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtDniKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //Activar color de fondo
        this.getContentPane().setBackground(this.getBackground());
        
        txtId.setVisible(false);
        
    }//GEN-LAST:event_formWindowOpened

    private void txtDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusLost
        // TODO add your handling code here:
        buscarDni(txtDni.getText());
        
        
    }//GEN-LAST:event_txtDniFocusLost

    private void btnGuardarClientesModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClientesModificarActionPerformed
        // TODO add your handling code here:
        try {
            if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El nombre del Cliente no puede estar vacio",
                    "Nombre Invalido",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }
           
        if (txtDni.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El DNI no puede estar vacio",
                    "DNI Invalido",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }
        
        } catch (HeadlessException e) {
        }
        modificar_cliente(this.getID());
    }//GEN-LAST:event_btnGuardarClientesModificarActionPerformed

    private void btnGuardarClientesModificarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnGuardarClientesModificarStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarClientesModificarStateChanged

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        
        // Captura la tecla apretada, valida que este entre los parametros 0,9 y si esta deja el numero y si no, no deja poner algun otro caracter
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57;
        
        if (!numero) {
            evt.consume();
        }
        //no deja sobrepasar el tamaño maximo
        if (txtTelefono.getText().trim().length() == 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        //lo contrario que el anterior para validar que no entre ningun numero
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57;
        
        if (numero) {
            evt.consume();
        }
        //no deja sobrepasar el tamaño maximo
        if (txtNombre.getText().trim().length() == 99) {
            evt.consume();
        }
       
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        // TODO add your handling code here:
        //no deja sobrepasar el tamaño maximo
        if (txtDni.getText().trim().length() == 19) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniKeyTyped

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
            java.util.logging.Logger.getLogger(Administracion_Clientes_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administracion_Clientes_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administracion_Clientes_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administracion_Clientes_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Administracion_Clientes_Dialog dialog = new Administracion_Clientes_Dialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelarClientes;
    private javax.swing.JButton btnGuardarClientes;
    private javax.swing.JButton btnGuardarClientesModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblAdministracionClientes;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
