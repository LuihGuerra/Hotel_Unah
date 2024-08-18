/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel_unah;
import hotel_unah.CheckInCheckOut.CheckInCheckOut;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.Date;
import hotel_unah.reporteHabitaciones.reporteHabitaciones;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luih
 */
public class Main_Hotel extends javax.swing.JFrame {

    /**
     * Creates new form Main_Hotel
     */
    DefaultTableModel modelo = new DefaultTableModel();

    public Main_Hotel() {
        initComponents();
    }
    
    //Administarcions de Clientes
    public void buscar_tabla_clientes(){
    try{
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
            String cmbBusqueda = comboBusquedaClientes.getSelectedItem().toString();
            String txtBuscar = txtClientesBuscar.getText();
            
            
            try {


            
                if (cmbBusqueda.equals("ID")) {
                    PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM clientes WHERE id = ?");

                    consulta.setString(1, txtBuscar);

                    ResultSet resultado = consulta.executeQuery();
                    if (resultado.next()) {
               JOptionPane.showMessageDialog(null, "ID Enocntrado");
               btnResetTable.setVisible(true);
               
               
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

           
                Vector fila = new Vector();

                fila.addElement(resultado.getString(1));
                fila.addElement(resultado.getString(2));
                fila.addElement(resultado.getString(3));
                fila.addElement(resultado.getString(4));
                fila.addElement(resultado.getString(5));
                fila.addElement(resultado.getString(6));

                modelo.addRow(fila);
            
            conn.cerrarConexion();
               
               
            } else {
                JOptionPane.showMessageDialog(null, "No Existe Cliente con este ID");
                btnResetTable.setVisible(false);
                
            }
                }
                if (cmbBusqueda.equals("Nombre")) {
                    PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM clientes WHERE nombre = ?");
                    

            consulta.setString(1, txtBuscar);

            ResultSet resultado = consulta.executeQuery();
                    if (resultado.next()) {
               JOptionPane.showMessageDialog(null, "Nombre Encontrado");
               btnResetTable.setVisible(true);
               
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
                        Vector primer=new Vector();
                        primer.addElement(resultado.getString(1));
                primer.addElement(resultado.getString(2));
                primer.addElement(resultado.getString(3));
                primer.addElement(resultado.getString(4));
                primer.addElement(resultado.getString(5));
                primer.addElement(resultado.getString(6));

                modelo.addRow(primer);
           while(resultado.next()){
                Vector fila = new Vector();

                fila.addElement(resultado.getString(1));
                fila.addElement(resultado.getString(2));
                fila.addElement(resultado.getString(3));
                fila.addElement(resultado.getString(4));
                fila.addElement(resultado.getString(5));
                fila.addElement(resultado.getString(6));

                modelo.addRow(fila);
           
           }
            
            conn.cerrarConexion();
               
               
            } else {
                JOptionPane.showMessageDialog(null, "No Existe Cliente con este Nombre");
                btnResetTable.setVisible(false);
                
            }
                }
                if (cmbBusqueda.equals("Direccion")) {
                    PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM clientes WHERE direccion = ?");

                    consulta.setString(1, txtBuscar);

                    ResultSet resultado = consulta.executeQuery();
                    if (resultado.next()) {
               JOptionPane.showMessageDialog(null, "Direccion Enocntrada");
               btnResetTable.setVisible(true);
               
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

            Vector primer=new Vector();
                        primer.addElement(resultado.getString(1));
                primer.addElement(resultado.getString(2));
                primer.addElement(resultado.getString(3));
                primer.addElement(resultado.getString(4));
                primer.addElement(resultado.getString(5));
                primer.addElement(resultado.getString(6));

                modelo.addRow(primer);
           while(resultado.next()){
                Vector fila = new Vector();

                fila.addElement(resultado.getString(1));
                fila.addElement(resultado.getString(2));
                fila.addElement(resultado.getString(3));
                fila.addElement(resultado.getString(4));
                fila.addElement(resultado.getString(5));
                fila.addElement(resultado.getString(6));

                modelo.addRow(fila);
           
           }
            
            conn.cerrarConexion();
               
               
            } else {
                JOptionPane.showMessageDialog(null, "No Existe Cliente con esta Direccion");
                btnResetTable.setVisible(false);
                
            }
                }
                if (cmbBusqueda.equals("Email")) {
                    PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM clientes WHERE email = ?");

                    consulta.setString(1, txtBuscar);

                    ResultSet resultado = consulta.executeQuery();
                    if (resultado.next()) {
               JOptionPane.showMessageDialog(null, "Email Enocntrado");
               btnResetTable.setVisible(true);
               
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

           
                 Vector primer=new Vector();
                        primer.addElement(resultado.getString(1));
                primer.addElement(resultado.getString(2));
                primer.addElement(resultado.getString(3));
                primer.addElement(resultado.getString(4));
                primer.addElement(resultado.getString(5));
                primer.addElement(resultado.getString(6));

                modelo.addRow(primer);
           while(resultado.next()){
                Vector fila = new Vector();

                fila.addElement(resultado.getString(1));
                fila.addElement(resultado.getString(2));
                fila.addElement(resultado.getString(3));
                fila.addElement(resultado.getString(4));
                fila.addElement(resultado.getString(5));
                fila.addElement(resultado.getString(6));

                modelo.addRow(fila);
           
           }
            
            conn.cerrarConexion();
               
               
            } else {
                JOptionPane.showMessageDialog(null, "No Existe Cliente con este Email");
                btnResetTable.setVisible(false);
                
            }
                }
                if (cmbBusqueda.equals("Telefono")) {
                    PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM clientes WHERE telefono = ?");

                    consulta.setString(1, txtBuscar);

                    ResultSet resultado = consulta.executeQuery();
                    if (resultado.next()) {
               JOptionPane.showMessageDialog(null, "Telefono Enocntrado");
               btnResetTable.setVisible(true);
               
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

           
                 Vector primer=new Vector();
                        primer.addElement(resultado.getString(1));
                primer.addElement(resultado.getString(2));
                primer.addElement(resultado.getString(3));
                primer.addElement(resultado.getString(4));
                primer.addElement(resultado.getString(5));
                primer.addElement(resultado.getString(6));

                modelo.addRow(primer);
           while(resultado.next()){
                Vector fila = new Vector();

                fila.addElement(resultado.getString(1));
                fila.addElement(resultado.getString(2));
                fila.addElement(resultado.getString(3));
                fila.addElement(resultado.getString(4));
                fila.addElement(resultado.getString(5));
                fila.addElement(resultado.getString(6));

                modelo.addRow(fila);
           
           }
            
            conn.cerrarConexion();
               
               
            } else {
                JOptionPane.showMessageDialog(null, "No Existe Cliente con este Telefono");
                btnResetTable.setVisible(false);
                
            }
                }
                if (cmbBusqueda.equals("Dni")) {
                    PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM clientes WHERE dni = ?");

                    consulta.setString(1, txtBuscar);

                    ResultSet resultado = consulta.executeQuery();
                    if (resultado.next()) {
               JOptionPane.showMessageDialog(null, "DNI Enocntrado");
               btnResetTable.setVisible(true);
               
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

           
                Vector fila = new Vector();

                fila.addElement(resultado.getString(1));
                fila.addElement(resultado.getString(2));
                fila.addElement(resultado.getString(3));
                fila.addElement(resultado.getString(4));
                fila.addElement(resultado.getString(5));
                fila.addElement(resultado.getString(6));

                modelo.addRow(fila);
            
            conn.cerrarConexion();
               
               
            } else {
                btnResetTable.setVisible(false);
                JOptionPane.showMessageDialog(null, "No Existe Cliente con este DNI");
               
                
            }
                }
            conn.cerrarConexion();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            
            
        } finally {
            try {
                
                conn.cerrarConexion();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
                
           
    
    }catch(HeadlessException e){
        JOptionPane.showMessageDialog(null, e);
    }
    
    
    }
    public void actualizar_tabla_clientes() {

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
    public void ingresar_nuevo_cliente() {
        Administracion_Clientes_Dialog ventanaClientes = new Administracion_Clientes_Dialog(this, true);
        
        Conexion conn = Conexion.getInstance();
        
        ventanaClientes.setVisible(true);

        if (ventanaClientes.getRootPane() == null) {
            tblClientes.updateUI();
            return;
        }

        try {

            Connection conexion = conn.conectar();

            PreparedStatement insertar = conexion.prepareStatement("INSERT INTO clientes VALUES(?,?,?,?,?,?) ");

            insertar.setInt(1, 0);
            insertar.setString(2, ventanaClientes.getNombre_Cliente());
            insertar.setString(3, ventanaClientes.getDireccion_Cliente());
            insertar.setString(4, ventanaClientes.getTelefono_Cliente());
            insertar.setString(5, ventanaClientes.getEmail_Cliente());
            insertar.setString(6, ventanaClientes.getDni_Cliente());

            insertar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente Agregado Correctamente");

            actualizar_tabla_clientes();
            conn.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }   
    public void llenarDialogClientes(Administracion_Clientes_Dialog ventanaClientes){
    if (ventanaClientes.getRootPane() == null) {
            tblClientes.updateUI();
            return;
        }
    if (tblClientes.getSelectedRow() == -1) {
                return;
            }
            Vector registro;
            registro = (Vector) modelo.getDataVector().elementAt(tblClientes.getSelectedRow());
            ventanaClientes.setNombre_Cliente(registro.elementAt(1).toString().trim());
            ventanaClientes.setDireccion_Cliente(registro.elementAt(2).toString().trim());
            ventanaClientes.setTelefono_Cliente(registro.elementAt(3).toString().trim());
            ventanaClientes.setEmail_Cliente(registro.elementAt(4).toString().trim());
            ventanaClientes.setDni_Cliente(registro.elementAt(5).toString().trim());
    
    }
    public void modificar_cliente(Administracion_Clientes_Dialog ventanaClientes) {
        
       
        
        Conexion conn = Conexion.getInstance();
        
        ventanaClientes.setVisible(true);

        if (ventanaClientes.getRootPane() == null) {
            tblClientes.updateUI();
            return;
        }
        if (tblClientes.getSelectedRow() == -1) {
                return;
            }
             Vector registro;
            registro = (Vector) modelo.getDataVector().elementAt(tblClientes.getSelectedRow());
            String id_ClienteModificar = registro.elementAt(0).toString().trim();
        try {

            Connection conexion = conn.conectar();

            PreparedStatement modificar = conexion.prepareStatement
                    ("UPDATE clientes SET "
                    + "nombre='"+ventanaClientes.getNombre_Cliente()+"',"
                    + "direccion='"+ventanaClientes.getDireccion_Cliente()+"',"
                    + "telefono='"+ventanaClientes.getTelefono_Cliente()+"',"
                    + "email='"+ventanaClientes.getEmail_Cliente()+"',"
                    + "dni='"+ventanaClientes.getDni_Cliente()+"' "
                    + "WHERE id='"+id_ClienteModificar+"';");

            
           

            modificar.executeUpdate();

            JOptionPane.showMessageDialog(null, "Empleado Modificado Correctamente");

            actualizar_tabla_clientes();
            conn.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede modificar este cliente porque eso interfiere con la integridad de los datos "+e);
        }
        
    }
    public void eliminar_Cliente() {
        Administracion_Clientes_Dialog ventanaClientes = new Administracion_Clientes_Dialog(this, true);
        Conexion conn = Conexion.getInstance();

        if (ventanaClientes.getRootPane() == null) {
            tblClientes.updateUI();
            return;
        }
        try {
            if (tblClientes.getSelectedRow() == -1) {
                return;
            }
            Connection conexion = conn.conectar();
            PreparedStatement eliminar = conexion.prepareStatement("DELETE FROM clientes WHERE id = ? ");

            Vector registro;
            registro = (Vector) modelo.getDataVector().elementAt(tblClientes.getSelectedRow());
            String id_ClienteEliminar = registro.elementAt(0).toString().trim();

            int respuesta = JOptionPane.showConfirmDialog(this, "Quieres eliminar este Cliente?","YES_NO_OPTION", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
            if (respuesta == 0) {
                eliminar.setString(1, id_ClienteEliminar);
                eliminar.executeUpdate();
                actualizar_tabla_clientes();
                
            }
            conn.cerrarConexion();
            

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar este Cliente porque eso interfiere con la integridad de los datos :) ");

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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnClientesNuevo = new javax.swing.JButton();
        btnClientesModificar = new javax.swing.JButton();
        btnClientesEliminar = new javax.swing.JButton();
        lblAdministracionClientes = new javax.swing.JLabel();
        btnClientesBuscar = new javax.swing.JButton();
        txtClientesBuscar = new javax.swing.JTextField();
        btnResetTable = new javax.swing.JButton();
        comboBusquedaClientes = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jdcPrimerFecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jdcSegundaFecha = new com.toedter.calendar.JDateChooser();
        btnReporteHabitaciones = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCheckin = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCheckout = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnBuscarCheckin = new javax.swing.JButton();
        txtBuscarCkeckin = new javax.swing.JTextField();
        txtBuscarCkeckout = new javax.swing.JTextField();
        btnBuscarCheckout = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblBCheckout = new javax.swing.JLabel();
        lblBCheckout1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        btnClientesNuevo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClientesNuevo.setText("Nuevo");
        btnClientesNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesNuevoActionPerformed(evt);
            }
        });

        btnClientesModificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClientesModificar.setText("Modificar");
        btnClientesModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesModificarActionPerformed(evt);
            }
        });

        btnClientesEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClientesEliminar.setText("Eliminar");
        btnClientesEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesEliminarActionPerformed(evt);
            }
        });

        lblAdministracionClientes.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAdministracionClientes.setText("Administración de Clientes");

        btnClientesBuscar.setText("Buscar");
        btnClientesBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesBuscarActionPerformed(evt);
            }
        });

        btnResetTable.setBackground(new java.awt.Color(255, 0, 0));
        btnResetTable.setText("x");
        btnResetTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTableActionPerformed(evt);
            }
        });

        comboBusquedaClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Direccion", "Telefono", "Email", "Dni" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(txtClientesBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(comboBusquedaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnClientesBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnResetTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(lblAdministracionClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClientesModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClientesNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClientesEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblAdministracionClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClientesBuscar)
                    .addComponent(txtClientesBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetTable)
                    .addComponent(comboBusquedaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnClientesNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnClientesModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnClientesEliminar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Administración de Clientes", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jButton4.setText("Nuevo");

        jButton5.setText("Modificar");

        jButton6.setText("Eliminar");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Administración de Habitaciones");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Administración de Habitaciones", jPanel2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jButton7.setText("Nuevo");

        jButton8.setText("Modificar");

        jButton9.setText("Cancelar");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Gestión de Reservas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(70, 70, 70)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gestión de Reservas", jPanel3);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Informes y Reportes ");

        jLabel1.setText("Primer Fecha");

        jLabel8.setText("Segunda Fecha");

        jLabel9.setText("Reportes de Ocupacion");

        btnReporteHabitaciones.setText("Generar Reporte");
        btnReporteHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteHabitacionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdcPrimerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jdcSegundaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(btnReporteHabitaciones))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(404, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(19, 19, 19)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jdcPrimerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jdcSegundaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnReporteHabitaciones)))
                .addContainerGap(379, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Informes y Reportes", jPanel5);

        tblCheckin.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblCheckin);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Buscar ID Reserva");

        tblCheckout.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tblCheckout);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Check-out ");

        btnBuscarCheckin.setText("Buscar Reserva");
        btnBuscarCheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCheckinActionPerformed(evt);
            }
        });

        btnBuscarCheckout.setText("Buscar ");
        btnBuscarCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCheckoutActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Check-in");

        lblBCheckout.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblBCheckout.setText("Busqueda");

        lblBCheckout1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBCheckout1.setText("Escribir el id del Checkin");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane6)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtBuscarCkeckin, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtBuscarCkeckout, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBCheckout1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarCkeckin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCheckin))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblBCheckout1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarCkeckout, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCheckout))
                        .addGap(125, 125, 125))))
        );

        jTabbedPane1.addTab("Check-in y Check-out", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Administarcions de Clientes
        actualizar_tabla_clientes();     
        btnResetTable.setVisible(false);
         
         
       //CheckIh Ckeck Out
      CheckInCheckOut llenarTablas = new CheckInCheckOut();
      llenarTablas.actualizarCheckOut(tblCheckout);
      llenarTablas.actualizarCheckIn(tblCheckin);
       
    }//GEN-LAST:event_formWindowOpened

    private void btnClientesNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesNuevoActionPerformed
        //Administarcions de Clientes     
        ingresar_nuevo_cliente();   
    }//GEN-LAST:event_btnClientesNuevoActionPerformed

    private void btnClientesBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesBuscarActionPerformed
        //Administarcions de Clientes
        buscar_tabla_clientes();
        
    }//GEN-LAST:event_btnClientesBuscarActionPerformed

    private void btnResetTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTableActionPerformed
        //Administarcions de Clientes
        actualizar_tabla_clientes();
        btnResetTable.setVisible(false);
    }//GEN-LAST:event_btnResetTableActionPerformed

    private void btnClientesModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesModificarActionPerformed
        //Administarcions de Clientes
        Administracion_Clientes_Dialog ventanaClientes = new Administracion_Clientes_Dialog(this, true);
        llenarDialogClientes(ventanaClientes);
        modificar_cliente(ventanaClientes);

    }//GEN-LAST:event_btnClientesModificarActionPerformed

    private void btnClientesEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesEliminarActionPerformed
        //Administarcions de Clientes
        eliminar_Cliente();
       

    }//GEN-LAST:event_btnClientesEliminarActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        //Administarcions de Clientes
        if (evt.getClickCount() == 2) {
            Administracion_Clientes_Dialog ventanaClientes = new Administracion_Clientes_Dialog(this, true);
            llenarDialogClientes(ventanaClientes);       
            modificar_cliente(ventanaClientes);
        }
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnBuscarCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCheckinActionPerformed
        // Checks
        
        CheckInCheckOut buscar =  new CheckInCheckOut();
        buscar.comprobarCheckin(txtBuscarCkeckin, tblCheckin);
        //buscar.buscarCheckinReserva(txtBuscarCkeckin);
    }//GEN-LAST:event_btnBuscarCheckinActionPerformed

    private void btnBuscarCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCheckoutActionPerformed
        // TODO add your handling code here:
        
         CheckInCheckOut buscar =  new CheckInCheckOut();
         buscar.comprobarCheckout(txtBuscarCkeckout, tblCheckout);
    }//GEN-LAST:event_btnBuscarCheckoutActionPerformed

    private void btnReporteHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteHabitacionesActionPerformed
           // Reporte de Habitaciones
    
    // seleccionar la fecha y ponerla como java.util.Date;
    Date fecha1 = jdcPrimerFecha.getDate();
    Date fecha2 = jdcSegundaFecha.getDate();
    
    // validación de que las fechas son correctas y no haya ningún error con ella
    try {
        if (fecha1.after(fecha2)) {
            JOptionPane.showMessageDialog(null, "La fecha final no puede ser menor a la inicial");
            return;
        }

        if (fecha1 == null) {
            JOptionPane.showMessageDialog(null, "Por Favor seleccione una fecha válida");
            return;
        }

        if (fecha2 == null) {
            JOptionPane.showMessageDialog(null, "Por Favor seleccione una fecha válida");
            return;
        }
    } catch (HeadlessException e) {
        JOptionPane.showMessageDialog(null, "Por Favor seleccione una fecha válida");
        return;
    }
    
    // cambiarle el formato
    long d1 = fecha1.getTime();
    long d2 = fecha2.getTime();
    
    // cambiarla a java.sql.Date; para que tenga el mismo formato que la fecha en la base de datos
    java.sql.Date fecha1Corregida = new java.sql.Date(d1);
    java.sql.Date fecha2Corregida = new java.sql.Date(d2);
    
    reporteHabitaciones reporte = new reporteHabitaciones(this, true);
    
    // verificar que haya algo de ocupación en las reservas, es decir si las habitaciones estuvieron ocupadas en ese tiempo
    if (reporte.validarReservaciones(fecha1Corregida, fecha2Corregida) == 1) {
        // muestra el reporte de la ocupación de las habitaciones
        reporte.llenarTablaOcupadasLimpieza(fecha1Corregida, fecha2Corregida);
        reporte.setVisible(true);
    } else {
        reporte.llenarTablaOcupadasLimpieza(fecha1Corregida, fecha2Corregida);
        reporte.setVisible(true);
    }
        
        
    }//GEN-LAST:event_btnReporteHabitacionesActionPerformed

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
            java.util.logging.Logger.getLogger(Main_Hotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Hotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Hotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Hotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Hotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCheckin;
    private javax.swing.JButton btnBuscarCheckout;
    private javax.swing.JButton btnClientesBuscar;
    private javax.swing.JButton btnClientesEliminar;
    private javax.swing.JButton btnClientesModificar;
    private javax.swing.JButton btnClientesNuevo;
    private javax.swing.JButton btnReporteHabitaciones;
    private javax.swing.JButton btnResetTable;
    private javax.swing.JComboBox<String> comboBusquedaClientes;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private com.toedter.calendar.JDateChooser jdcPrimerFecha;
    private com.toedter.calendar.JDateChooser jdcSegundaFecha;
    private javax.swing.JLabel lblAdministracionClientes;
    private javax.swing.JLabel lblBCheckout;
    private javax.swing.JLabel lblBCheckout1;
    private javax.swing.JTable tblCheckin;
    private javax.swing.JTable tblCheckout;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtBuscarCkeckin;
    private javax.swing.JTextField txtBuscarCkeckout;
    private javax.swing.JTextField txtClientesBuscar;
    // End of variables declaration//GEN-END:variables
}
