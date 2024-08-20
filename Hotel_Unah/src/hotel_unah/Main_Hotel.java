/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel_unah;
import hotel_unah.CheckInCheckOut.CheckInCheckOut;
import hotel_unah.Features.HabitacionesAddModify;
import hotel_unah.Models.Habitacion;
import hotel_unah.Models.HabitacionEntity;
import hotel_unah.Services.HabitacionService;
import hotel_unah.reporteHabitaciones.ReportGanancia;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import hotel_unah.reporteHabitaciones.reporteHabitaciones;
import java.util.Date;




import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luih
 */
public class Main_Hotel extends javax.swing.JFrame {
    DefaultTableModel modelHabitaciones = new DefaultTableModel();
    HabitacionService habitacionService = new HabitacionService();
    /**
     * Creates new form Main_Hotel
     */
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo1 = new DefaultTableModel();

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
        ventanaClientes.OcultarBotonModificar();
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
            ventanaClientes.setID(registro.elementAt(0).toString().trim());
            ventanaClientes.setNombre_Cliente(registro.elementAt(1).toString().trim());
            ventanaClientes.setDireccion_Cliente(registro.elementAt(2).toString().trim());
            ventanaClientes.setTelefono_Cliente(registro.elementAt(3).toString().trim());
            ventanaClientes.setEmail_Cliente(registro.elementAt(4).toString().trim());
            ventanaClientes.setDni_Cliente(registro.elementAt(5).toString().trim());
            ventanaClientes.OcultarBotonGuardar();
    
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
             Object [] opciones = {"SI", "NO"};
            int respuesta = JOptionPane.showOptionDialog(this, "Desea Eliminar Este Cliente?","Eliminar" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,null, opciones, opciones[1]);
            if (respuesta == -1){
            return;
            }
            if (respuesta == 0) {
                eliminar.setString(1, id_ClienteEliminar);
                eliminar.executeUpdate();
                actualizar_tabla_clientes();
                JOptionPane.showConfirmDialog(null, "Cliente Eliminar");
                
            }
            conn.cerrarConexion();
            

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar este Cliente porque eso interfiere con la integridad de los datos :) ");

        }
    }
    
    //Habitaciones
     private void CargarTable(){
        List<Habitacion> habitacionesObtener = habitacionService.getHabitaciones();
        modelHabitaciones = new DefaultTableModel(null, Habitacion.columnas);
        
        tbHabitaciones.setModel(modelHabitaciones);
        
        for (int i = 0; i < habitacionesObtener.size(); i++) {
            modelHabitaciones.addRow(habitacionesObtener.get(i).toVector());
        }
       
    }
     
        private int IndiceTipoHabitacion(String tipo){
        return switch (tipo) {
            case "individual" -> 1;
            case "doble" -> 2;
            case "suite" -> 3;
            default -> 1;
        };
     }
     
     private int IndiceEstadoHabitacion(String estado){
        return switch (estado) {
            case "disponible" -> 1;
            case "ocupada" -> 2;
            case "en limpieza" -> 3;
            default -> 1;
        };
     }
     
     /*-------------------------------------------------------------------------------------------------------------------------------
                                                          GESTION DE RESERVAS
    -------------------------------------------------------------------------------------------------------------------------------*/

    /*-------------------------------------------------------------------------
                                    CREATE
    -------------------------------------------------------------------------*/
    public void agregarReserva(java.sql.Date fechaEntrada, java.sql.Date fechaSalida, int clienteId, int habitacionId, String estado) {
    Connection conexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        Conexion conn = Conexion.getInstance();
        conexion = conn.conectar();

        // Verificar si ya existe una reserva para el cliente y habitación en el rango de fechas
        String checkQuery = "SELECT COUNT(*) FROM reservas WHERE habitacion_id = ? AND ((fecha_entrada <= ? AND fecha_salida >= ?) OR (fecha_entrada <= ? AND fecha_salida >= ?))";
        ps = conexion.prepareStatement(checkQuery);
        ps.setInt(1, habitacionId);
        ps.setDate(2, fechaSalida);
        ps.setDate(3, fechaEntrada);
        ps.setDate(4, fechaSalida);
        ps.setDate(5, fechaEntrada);

        rs = ps.executeQuery();
        rs.next();
        int count = rs.getInt(1);

        if (count > 0) {
            JOptionPane.showMessageDialog(null, "Ya existe una reserva para la habitación en el rango de fechas especificado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Insertar la nueva reserva
        String query = "INSERT INTO reservas (cliente_id, habitacion_id, fecha_entrada, fecha_salida, estado) VALUES (?, ?, ?, ?, ?)";
        ps = conexion.prepareStatement(query);

        ps.setInt(1, clienteId);
        ps.setInt(2, habitacionId);
        ps.setDate(3, fechaEntrada);
        ps.setDate(4, fechaSalida);
        ps.setString(5, estado);

        ps.executeUpdate();

        // Actualizar el estado de la habitación a 'ocupada'
        String updateQuery = "UPDATE habitaciones SET estado = 'ocupada' WHERE id = ?";
        ps = conexion.prepareStatement(updateQuery);
        ps.setInt(1, habitacionId);
        ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Reserva agregada correctamente.");

        // Actualizar la tabla de reservas en la interfaz
        actualizar_tabla_reservas();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al agregar la reserva: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

   /*-------------------------------------------------------------------------
                                    UPDATE
    -------------------------------------------------------------------------*/  
    public void actualizar_tabla_reservas() {
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();

            String query = "SELECT * FROM reservas";
            PreparedStatement stmt = conexion.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            modelo1 = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
            };

            modelo1.addColumn("id");
            modelo1.addColumn("cliente_id");
            modelo1.addColumn("habitacion_id");
            modelo1.addColumn("fecha_entrada");
            modelo1.addColumn("fecha_salida");
            modelo1.addColumn("estado");

            tblReservas.setModel(modelo1);

            while (rs.next()) {
                Vector<Object> fila = new Vector<>();
                fila.add(rs.getInt("id"));
                fila.add(rs.getInt("cliente_id"));
                fila.add(rs.getInt("habitacion_id"));
                fila.add(rs.getTimestamp("fecha_entrada"));
                fila.add(rs.getTimestamp("fecha_salida"));
                fila.add(rs.getString("estado"));
                modelo1.addRow(fila);
            }

            conn.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la tabla de reservas: " + e.getMessage());
        }
    }

    public void agregarReservaATabla(java.sql.Date fechaEntrada, java.sql.Date fechaSalida) {
    // Convertir las fechas a un formato legible, si es necesario
    String fechaEntradaFormateada = new SimpleDateFormat("yyyy-MM-dd").format(fechaEntrada);
    String fechaSalidaFormateada = new SimpleDateFormat("yyyy-MM-dd").format(fechaSalida);

    // Añadir una nueva fila a la tabla con los detalles de la reserva
    DefaultTableModel model = (DefaultTableModel) tblReservas.getModel();
    model.addRow(new Object[]{null, null, null, fechaEntradaFormateada, fechaSalidaFormateada, null});
    }
        
/*-------------------------------------------------------------------------
                                    DELETE
    -------------------------------------------------------------------------*/
    
    public void cancelarReserva(int reservaId, int habitacionId) {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            Conexion conn = Conexion.getInstance();
            conexion = conn.conectar();

            // Eliminar la reserva
            String deleteQuery = "DELETE FROM reservas WHERE id = ?";
            ps = conexion.prepareStatement(deleteQuery);
            ps.setInt(1, reservaId);
            ps.executeUpdate();

            // Actualizar el estado de la habitación a 'disponible'
            String updateQuery = "UPDATE habitaciones SET estado = 'disponible' WHERE id = ?";
            ps = conexion.prepareStatement(updateQuery);
            ps.setInt(1, habitacionId);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Reserva cancelada correctamente.");

            // Actualizar la tabla de reservas en la interfaz
            actualizar_tabla_reservas();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cancelar la reserva: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    private void manejarCancelarReserva() {
        // Obtener el ID de la reserva seleccionada en la tabla
        int selectedRow = tblReservas.getSelectedRow();

        if (selectedRow != -1) {
            int reservaId = (int) tblReservas.getValueAt(selectedRow, 0); // Suponiendo que la columna 0 tiene el ID de la reserva
            int habitacionId = (int) tblReservas.getValueAt(selectedRow, 2); // Suponiendo que la columna 2 tiene el ID de la habitación

            int confirmation = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cancelar esta reserva?", "Confirmar Cancelación", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                cancelarReserva(reservaId, habitacionId);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una reserva para cancelar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
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
        jScrollPane7 = new javax.swing.JScrollPane();
        tbHabitaciones = new javax.swing.JTable();
        jlHabitaciones = new javax.swing.JLabel();
        jtBuscar = new javax.swing.JTextField();
        btnBuscarHabitaciones = new javax.swing.JButton();
        btnAgregarHabitaciones = new javax.swing.JButton();
        btnModificarHabitaciones = new javax.swing.JButton();
        btnEliminarHabitaciones = new javax.swing.JButton();
        btRegresar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnNuevaReserva = new javax.swing.JButton();
        btnModificarReserva = new javax.swing.JButton();
        btnCancelarReserva = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblOcupacion = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnReporteHabitaciones = new javax.swing.JButton();
        jdcPrimerFecha = new com.toedter.calendar.JDateChooser();
        jdcSegundaFecha = new com.toedter.calendar.JDateChooser();
        lblGanancia = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jdcFechaI = new com.toedter.calendar.JDateChooser();
        jdcFechaF = new com.toedter.calendar.JDateChooser();
        btnReporteGanacias = new javax.swing.JButton();
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClientesModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClientesNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClientesEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(159, 159, 159))
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

        tbHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tbHabitaciones);

        jlHabitaciones.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jlHabitaciones.setText("Habitaciones");

        btnBuscarHabitaciones.setText("Buscar");
        btnBuscarHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHabitacionesActionPerformed(evt);
            }
        });

        btnAgregarHabitaciones.setText("Agregar");
        btnAgregarHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHabitacionesActionPerformed(evt);
            }
        });

        btnModificarHabitaciones.setText("Modificar");
        btnModificarHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarHabitacionesActionPerformed(evt);
            }
        });

        btnEliminarHabitaciones.setText("Eliminar");
        btnEliminarHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarHabitacionesActionPerformed(evt);
            }
        });

        btRegresar.setText("X");
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlHabitaciones)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarHabitaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnModificarHabitaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarHabitaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlHabitaciones)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarHabitaciones)
                    .addComponent(btRegresar))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAgregarHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Administración de Habitaciones", jPanel2);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("GESTION DE RESERVAS");

        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblReservas);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reserva (2).png"))); // NOI18N

        btnNuevaReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reserva.png"))); // NOI18N
        btnNuevaReserva.setText(" Nuevo");
        btnNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaReservaActionPerformed(evt);
            }
        });

        btnModificarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/contrato.png"))); // NOI18N
        btnModificarReserva.setText(" Modificar");

        btnCancelarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        btnCancelarReserva.setText(" Cancelar");
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                        .addGap(70, 70, 70)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevaReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(305, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(btnNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jTabbedPane1.addTab("Gestión de Reservas", jPanel3);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Fecha Final");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("Informes y Reportes ");

        lblOcupacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblOcupacion.setText("Reportes de Ocupacion");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Segunda Fecha");

        btnReporteHabitaciones.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReporteHabitaciones.setText("Generar Reporte");
        btnReporteHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteHabitacionesActionPerformed(evt);
            }
        });

        jdcPrimerFecha.setDateFormatString("y-MM-dd");

        jdcSegundaFecha.setDateFormatString("y-MM-dd");

        lblGanancia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGanancia.setText("Reporte de Ganancia");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Primer Fecha");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Fecha Inicial");

        jdcFechaI.setDateFormatString("yyyy-MM-dd");

        jdcFechaF.setDateFormatString("yyyy-MM-dd");

        btnReporteGanacias.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReporteGanacias.setText("Generar Reporte");
        btnReporteGanacias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteGanaciasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcPrimerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                        .addGap(46, 46, 46))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jdcSegundaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)))
                                .addComponent(btnReporteHabitaciones))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdcFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReporteGanacias)))
                        .addContainerGap(317, Short.MAX_VALUE))))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(525, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(lblOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(760, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(793, 793, 793)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdcSegundaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcPrimerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(btnReporteHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnReporteGanacias, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(228, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(501, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(127, 127, 127)
                    .addComponent(lblOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(434, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(185, 185, 185)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(376, Short.MAX_VALUE)))
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

        txtBuscarCkeckin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarCkeckinKeyTyped(evt);
            }
        });

        txtBuscarCkeckout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarCkeckoutKeyTyped(evt);
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
        lblBCheckout.setText("Buscar ID Reserva");

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
                    .addComponent(lblBCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(147, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel4Layout.createSequentialGroup()
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
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
        
        //habitaciones
         
         CargarTable();
         
       //CheckIh Ckeck Out
      CheckInCheckOut llenarTablas = new CheckInCheckOut();
      llenarTablas.actualizarCheckOut(tblCheckout);
      llenarTablas.actualizarCheckIn(tblCheckin);
      
      //Reservas
      
      actualizar_tabla_reservas();
       
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
        if (ventanaClientes.getRootPane() == null) {
            tblClientes.updateUI();
            return;
        }
        if (tblClientes.getSelectedRow() == -1) {
                return;
            }
        ventanaClientes.setVisible(true);
        
        actualizar_tabla_clientes();
        

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
            ventanaClientes.setVisible(true);
            actualizar_tabla_clientes();
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
         buscar.buscarCheckin(txtBuscarCkeckout.getText().trim(), tblCheckout);
        
    }//GEN-LAST:event_btnBuscarCheckoutActionPerformed

    private void btnAgregarHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHabitacionesActionPerformed
       HabitacionesAddModify addHabitacion = new HabitacionesAddModify(this, true, false);
        addHabitacion.setVisible(true);
        if(addHabitacion.getRootPane() == null)
        return;

        HabitacionEntity hab = new HabitacionEntity();
        hab.EstadoHabitacion = addHabitacion.GetEstadoHabitacion();
        hab.TipoHabitacion = addHabitacion.GetTipoHabitacion();
        hab.NumeroHabitacion = addHabitacion.GetNumeroHabitacion();
        hab.PrecioPorNoche = Double.parseDouble(addHabitacion.GetPrecioNoche());
        Response respuesta = habitacionService.AddHabitacion(hab);

        if("200".equals(respuesta.getCodigo())){
            JOptionPane.showMessageDialog(this, respuesta.getMessage(), "Agregar habitación",JOptionPane.INFORMATION_MESSAGE);
            CargarTable();
            tbHabitaciones.updateUI();
        }
        else{
            JOptionPane.showMessageDialog(this, respuesta.getMessage(), "Agregar habitación",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarHabitacionesActionPerformed

    private void btnModificarHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarHabitacionesActionPerformed
        int indiceTabla = tbHabitaciones.getSelectedRow();
        if(indiceTabla == -1){
            JOptionPane.showMessageDialog(this, "Debe escoger un registro para editar","Registro incorrecto",JOptionPane.WARNING_MESSAGE);
            return;
        }

        String NumRegistro =  modelHabitaciones.getValueAt(indiceTabla,0).toString();
        String NumeroHabitacion =  modelHabitaciones.getValueAt(indiceTabla,1).toString();
        String TipoHabitacion = modelHabitaciones.getValueAt(indiceTabla,2).toString();
        String EstadoHabitacion = modelHabitaciones.getValueAt(indiceTabla,3).toString();
        String PrecioNoche = modelHabitaciones.getValueAt(indiceTabla,4).toString();

        HabitacionesAddModify addHabitacion = new HabitacionesAddModify(this, true, true);
        addHabitacion.setNumeracionHabitacion(NumeroHabitacion);
        addHabitacion.setEstadoHabitacion(IndiceEstadoHabitacion(EstadoHabitacion));
        addHabitacion.setTipoHabitacion(IndiceTipoHabitacion(TipoHabitacion));
        addHabitacion.setPrecioNoche(PrecioNoche);

        addHabitacion.setVisible(true);
        if(addHabitacion.getRootPane() == null)
        return;

        HabitacionEntity hab = new HabitacionEntity();
        hab.HabitacionId = Integer.parseInt(NumRegistro);
        hab.EstadoHabitacion = addHabitacion.GetEstadoHabitacion();
        hab.TipoHabitacion = addHabitacion.GetTipoHabitacion();
        hab.NumeroHabitacion = addHabitacion.GetNumeroHabitacion();
        hab.PrecioPorNoche = Double.parseDouble(addHabitacion.GetPrecioNoche());
        Response respuesta = habitacionService.UpdateHabitacion(hab);

        if("200".equals(respuesta.getCodigo())){
            JOptionPane.showMessageDialog(this, respuesta.getMessage(), "Actualizar habitación",JOptionPane.INFORMATION_MESSAGE);
            CargarTable();
            tbHabitaciones.updateUI();
        }
        else{
            JOptionPane.showMessageDialog(this, respuesta.getMessage(), "Actualizar habitación",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarHabitacionesActionPerformed

    private void btnEliminarHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHabitacionesActionPerformed
        int indiceTabla = tbHabitaciones.getSelectedRow();
        if(indiceTabla == -1){
            JOptionPane.showMessageDialog(this, "Debe escoger un registro para editar","Registro incorrecto",JOptionPane.WARNING_MESSAGE);
            return;
        }
        String NumRegistro =  modelHabitaciones.getValueAt(indiceTabla,0).toString();
        //Una vez verificamos que escogio una fila confirmamos con el usuario si desea eliminar el registro
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este registro?");
        if(respuesta == 0){
            Response respuestaPeticion = habitacionService.DeleteHabitacion(Integer.parseInt(NumRegistro));
            if("200".equals(respuestaPeticion.getCodigo())){
                JOptionPane.showMessageDialog(this, respuestaPeticion.getMessage(), "Eliminar habitación",JOptionPane.INFORMATION_MESSAGE);
                CargarTable();
                tbHabitaciones.updateUI();
            }
            else{
                JOptionPane.showMessageDialog(this, respuestaPeticion.getMessage(), "Eliminar habitación",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarHabitacionesActionPerformed

    private void btnNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaReservaActionPerformed
        // TODO add your handling code here:
        Gestion_Reservas ventanaReservas = new Gestion_Reservas(this, true, this);
        ventanaReservas.setVisible(true);
    }//GEN-LAST:event_btnNuevaReservaActionPerformed

    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed
        // TODO add your handling code here:
        manejarCancelarReserva();

    }//GEN-LAST:event_btnCancelarReservaActionPerformed

    private void txtBuscarCkeckinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCkeckinKeyTyped
        // TODO add your handling code here:
        // Captura la tecla apretada, valida que este entre los parametros 0,9 y si esta deja el numero y si no, no deja poner algun otro caracter
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57;
        
        if (!numero) {
            evt.consume();
        }
        //no deja sobrepasar el tamaño maximo
        if (txtBuscarCkeckin.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarCkeckinKeyTyped

    private void txtBuscarCkeckoutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCkeckoutKeyTyped
        // TODO add your handling code here:
        // Captura la tecla apretada, valida que este entre los parametros 0,9 y si esta deja el numero y si no, no deja poner algun otro caracter
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57;
        
        if (!numero) {
            evt.consume();
        }
        //no deja sobrepasar el tamaño maximo
        if (txtBuscarCkeckout.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarCkeckoutKeyTyped

    private void btnReporteHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteHabitacionesActionPerformed
        // Reporte de Habitaciones        
        //seleccionar la fecha y ponerla como java.util.Date;       
       Date fecha1 = jdcPrimerFecha.getDate();
       Date fecha2 = jdcSegundaFecha.getDate();   
              //validacion de que las fechas es correcta y no haya ningun error con ella
        try {
            
            if (fecha1==null) {
                JOptionPane.showMessageDialog(null, "Por Favor seleccione una fecha valida");
                return;
            }
            if (fecha2==null) {
                JOptionPane.showMessageDialog(null, "Por Favor seleccione una fecha valida");
                return;
            }
            if (fecha1.after(fecha2)) {
                JOptionPane.showMessageDialog(null, "La fecha final no puede ser menor a la inicial");
                return;
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Por Favor seleccione una fecha valida");
                return;
        }
        //cambiarle el formato
        long d1 =fecha1.getTime();
        long d2 =fecha2.getTime();
        //cambiarla a java.sql.Date; para que tenga el mismo formato que la fecha en la base de datos
        java.sql.Date fecha1Corregida = new java.sql.Date(d1);
        java.sql.Date fecha2Corregida = new java.sql.Date(d2);
        reporteHabitaciones reporte = new reporteHabitaciones(this, true);
        //valida que haya algun tipo de actividad en las reservas, es decir si las habitaciones estuvieron ocupadas en ese tiempo
       // if (reporte.validarReservaciones(fecha1Corregida, fecha2Corregida)==1) {     
       // }else{
            //muestra el reporte de la ocupacion de las habitaciones
        //     reporte.llenarTablaOcupadasLimpieza(fecha1Corregida, fecha2Corregida);
        //reporte.setVisible(true);
        //}
         reporte.llenarTablaOcupadasLimpieza(fecha1Corregida, fecha2Corregida);
         reporte.setVisible(true); 
    }//GEN-LAST:event_btnReporteHabitacionesActionPerformed

    private void btnModificarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarReservaActionPerformed
        // TODO add your handling code here:
         int filaSeleccionada = tblReservas.getSelectedRow();
        
        if (filaSeleccionada != -1) {
        int clienteId = (int) tblReservas.getValueAt(filaSeleccionada, 1);
        int habitacionId = (int) tblReservas.getValueAt(filaSeleccionada, 2);
        java.sql.Date fechaEntrada = (java.sql.Date) tblReservas.getValueAt(filaSeleccionada, 3);
        java.sql.Date fechaSalida = (java.sql.Date) tblReservas.getValueAt(filaSeleccionada, 4);
        String estado = (String) tblReservas.getValueAt(filaSeleccionada, 5);
        Gestion_Reservas gestionReservas = new Gestion_Reservas(this, true, this, clienteId, habitacionId, fechaEntrada, fechaSalida, estado);
        gestionReservas.setVisible(true);
    } else 
    {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una reserva para modificar.");
    }
        
        
    }//GEN-LAST:event_btnModificarReservaActionPerformed

    private void btnBuscarHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHabitacionesActionPerformed
        
        Conexion conn = Conexion.getInstance();
        Connection conexion = conn.conectar();
        String txtnum = jtBuscar.getText();
        
        try{
            
            PreparedStatement consultar = conexion.prepareStatement("SELECT * FROM habitaciones WHERE numero_habitacion = ?");
            consultar.setString(1, txtnum);
            ResultSet hab = consultar.executeQuery();
            
            if(hab.next()){
               JOptionPane.showMessageDialog(null, "La Habitacion se encontro");
               
               DefaultTableModel datos = new DefaultTableModel();
               datos.addColumn("id");
               datos.addColumn("numero_habitacion");
               datos.addColumn("tipo");
               datos.addColumn("estado");
               datos.addColumn("precio_por_noche");
            
               tbHabitaciones.setModel(datos);
            
               Vector fila = new Vector();
               fila.addElement(hab.getString(1));
               fila.addElement(hab.getString(2));
               fila.addElement(hab.getString(3)); 
               fila.addElement(hab.getString(4));
               fila.addElement(hab.getString(5));
            
               datos.addRow(fila);
               conn.cerrarConexion();
               
            }else{
                JOptionPane.showMessageDialog(null, "La Habitacion no se encontro");
            }
                        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                conn.cerrarConexion();
            }catch(SQLException e){
                JOptionPane.showConfirmDialog(null, e);
            }
        }
        
    }//GEN-LAST:event_btnBuscarHabitacionesActionPerformed

    private void btRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegresarActionPerformed
        
        try{
            Conexion conn = Conexion.getInstance();
            Connection conexion =conn.conectar();
        
            PreparedStatement regreTa = conexion.prepareStatement("SELECT * FROM habitaciones");
            ResultSet hab = regreTa.executeQuery();
            
            DefaultTableModel datos = new DefaultTableModel();
            
            datos.addColumn("id");
            datos.addColumn("numero_habitacion");
            datos.addColumn("tipo");
            datos.addColumn("estado");
            datos.addColumn("precio_por_noche");
            
            tbHabitaciones.setModel(datos);  
            
            while(hab.next()){
                Vector fila = new Vector();
               fila.addElement(hab.getString(1));
               fila.addElement(hab.getString(2));
               fila.addElement(hab.getString(3)); 
               fila.addElement(hab.getString(4));
               fila.addElement(hab.getString(5));
            
               datos.addRow(fila);
            }
            
            conn.cerrarConexion();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_btRegresarActionPerformed

    private void btnReporteGanaciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteGanaciasActionPerformed
        
        try{            
            Date fechaInicial = jdcFechaI.getDate();
            Date fechaFinal = jdcFechaF.getDate();   
            
            if (fechaFinal.before(fechaInicial)) {
                JOptionPane.showMessageDialog(null, "La fecha final no puede ser menor a la inicial");     
            }else{
                
                long fF = fechaInicial.getTime();
                long fI = fechaFinal.getTime();
                java.sql.Date fIn = new java.sql.Date(fF);
                java.sql.Date fFi = new java.sql.Date(fI);
        
                ReportGanancia view = new ReportGanancia(this, true);
                view.ReporteG(fIn, fFi);
                view.calcularTotal(fIn, fFi);
                view.setVisible(true);
            }            
            
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Valores Incorrectos");
        }
        
    }//GEN-LAST:event_btnReporteGanaciasActionPerformed

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
    private javax.swing.JButton btRegresar;
    private javax.swing.JButton btnAgregarHabitaciones;
    private javax.swing.JButton btnBuscarCheckin;
    private javax.swing.JButton btnBuscarCheckout;
    private javax.swing.JButton btnBuscarHabitaciones;
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JButton btnClientesBuscar;
    private javax.swing.JButton btnClientesEliminar;
    private javax.swing.JButton btnClientesModificar;
    private javax.swing.JButton btnClientesNuevo;
    private javax.swing.JButton btnEliminarHabitaciones;
    private javax.swing.JButton btnModificarHabitaciones;
    private javax.swing.JButton btnModificarReserva;
    private javax.swing.JButton btnNuevaReserva;
    private javax.swing.JButton btnReporteGanacias;
    private javax.swing.JButton btnReporteHabitaciones;
    private javax.swing.JButton btnResetTable;
    private javax.swing.JComboBox<String> comboBusquedaClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdcFechaF;
    private com.toedter.calendar.JDateChooser jdcFechaI;
    private com.toedter.calendar.JDateChooser jdcPrimerFecha;
    private com.toedter.calendar.JDateChooser jdcSegundaFecha;
    private javax.swing.JLabel jlHabitaciones;
    private javax.swing.JTextField jtBuscar;
    private javax.swing.JLabel lblAdministracionClientes;
    private javax.swing.JLabel lblBCheckout;
    private javax.swing.JLabel lblGanancia;
    private javax.swing.JLabel lblOcupacion;
    private javax.swing.JTable tbHabitaciones;
    private javax.swing.JTable tblCheckin;
    private javax.swing.JTable tblCheckout;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblReservas;
    private javax.swing.JTextField txtBuscarCkeckin;
    private javax.swing.JTextField txtBuscarCkeckout;
    private javax.swing.JTextField txtClientesBuscar;
    // End of variables declaration//GEN-END:variables
}
