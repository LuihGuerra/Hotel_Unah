/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel_unah;
import com.toedter.calendar.JCalendar;
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

        // Verificar si ya existe una reserva para la habitación en el rango de fechas
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
                                    MODIFICAR
    -------------------------------------------------------------------------*/
   
    private void modificarFechaReserva() {
        int filaSeleccionada = tblReservas.getSelectedRow();
        if (filaSeleccionada >= 0) {
            modificarFechaDialog modificarFechaDialog = new modificarFechaDialog(this, true);
             modificarFechaDialog.setVisible(true);
           if(modificarFechaDialog.getRootPane()==null) return;
                
            Date nuevaFechaEntrada = modificarFechaDialog.getFechaEntrada();
            Date nuevaFechaSalida = modificarFechaDialog.getFechaSalida();

            if (nuevaFechaEntrada != null && nuevaFechaSalida != null) {
                // Aquí debes actualizar las fechas en tu base de datos y en la tabla
                String idReserva = tblReservas.getValueAt(filaSeleccionada, 0).toString();
                actualizarReservaEnBD(idReserva, nuevaFechaEntrada, nuevaFechaSalida);
                actualizar_tabla_reservas();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una reserva.");
        }
    }
    
    //--------------------------------------------------------------
    
    private void actualizarReservaEnBD(String idReserva, Date nuevaFechaEntrada, Date nuevaFechaSalida) {
    Connection conexion = null;
    PreparedStatement ps = null;
    
    try {
        // Establecer conexión utilizando tu clase Conexion
        conexion = Conexion.getInstance().conectar();

        // SQL para actualizar la reserva
        String sql = "UPDATE reservas SET fecha_entrada = ?, fecha_salida = ? WHERE id = ?";
        ps = conexion.prepareStatement(sql);

        // Convertir las fechas de Date a java.sql.Date
        java.sql.Date sqlFechaEntrada = new java.sql.Date(nuevaFechaEntrada.getTime());
        java.sql.Date sqlFechaSalida = new java.sql.Date(nuevaFechaSalida.getTime());

        // Configurar los parámetros de la consulta
        ps.setDate(1, sqlFechaEntrada);
        ps.setDate(2, sqlFechaSalida);
        ps.setString(3, idReserva);

        // Ejecutar la actualización
        int filasActualizadas = ps.executeUpdate();

        if (filasActualizadas > 0) {
            JOptionPane.showMessageDialog(this, "Reserva actualizada correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar la reserva.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al actualizar la reserva en la base de datos.");
    } finally {
        try {
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
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
            String deleteQuery = "UPDATE reservas SET estado='cancelada' WHERE reservas.id=?";
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

    public void buscar_tabla_reservas() {
    try {
        Conexion conn = Conexion.getInstance();
        Connection conexion = conn.conectar();
        String cmbBusqueda = comboBusquedaReservas.getSelectedItem().toString();
        String txtBuscar = txtReservasBuscar.getText();

        // Mensaje de depuración: Imprimir valor del JComboBox
        System.out.println("Valor seleccionado en JComboBox: " + cmbBusqueda);

        try {
            String query = "";
            switch (cmbBusqueda) {
                case "id":
                    query = "SELECT id, cliente_id, habitacion_id, fecha_entrada, fecha_salida, estado FROM reservas WHERE id = ?";
                    break;
                case "cliente_id":
                    query = "SELECT id, cliente_id, habitacion_id, fecha_entrada, fecha_salida, estado FROM reservas WHERE cliente_id = ?";
                    break;
                case "habitacion_id":
                    query = "SELECT id, cliente_id, habitacion_id, fecha_entrada, fecha_salida, estado FROM reservas WHERE habitacion_id = ?";
                    break;
                case "estado":
                    query = "SELECT id, cliente_id, habitacion_id, fecha_entrada, fecha_salida, estado FROM reservas WHERE estado = ?";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Tipo de búsqueda no válido: " + cmbBusqueda);
                    return;
            }

            PreparedStatement consulta = conexion.prepareStatement(query);
            consulta.setString(1, txtBuscar);

            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                JOptionPane.showMessageDialog(null, cmbBusqueda + " encontrado.");
                btnResetTable1.setVisible(true);

                DefaultTableModel modelo1 = new DefaultTableModel() {
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

                do {
                    Vector<String> fila = new Vector<>();
                    fila.addElement(resultado.getString("id"));
                    fila.addElement(resultado.getString("cliente_id"));
                    fila.addElement(resultado.getString("habitacion_id"));
                    fila.addElement(resultado.getString("fecha_entrada"));
                    fila.addElement(resultado.getString("fecha_salida"));
                    fila.addElement(resultado.getString("estado"));
                    modelo1.addRow(fila);
                } while (resultado.next());

            } else {
                JOptionPane.showMessageDialog(null, "No existe reserva con este " + cmbBusqueda + ".");
                btnResetTable1.setVisible(false);
            }
            
            // Limpiar el cuadro de texto después de la consulta
            txtReservasBuscar.setText("");

            conn.cerrarConexion();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                conn.cerrarConexion();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

    } catch (HeadlessException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbHabitaciones = new javax.swing.JTable();
        jlHabitaciones = new javax.swing.JLabel();
        jtBuscar = new javax.swing.JTextField();
        btnBuscarHabitaciones = new javax.swing.JButton();
        btnAgregarHabitaciones = new javax.swing.JButton();
        btnModificarHabitaciones = new javax.swing.JButton();
        btnEliminarHabitaciones = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnResethabitaciones = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnNuevaReserva = new javax.swing.JButton();
        btnModificarReserva = new javax.swing.JButton();
        btnCancelarReserva = new javax.swing.JButton();
        txtReservasBuscar = new javax.swing.JTextField();
        comboBusquedaReservas = new javax.swing.JComboBox<>();
        btnReservasBuscar = new javax.swing.JButton();
        btnResetTable1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblOcupacion = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnReporteHabitaciones = new javax.swing.JButton();
        jdcPrimerFecha = new com.toedter.calendar.JDateChooser();
        jdcSegundaFecha = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jdcFecha1 = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jdcFecha2 = new com.toedter.calendar.JDateChooser();
        btnReporteGanacias = new javax.swing.JToggleButton();
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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 153));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        tblClientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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

        btnClientesNuevo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnClientesNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo (1).png"))); // NOI18N
        btnClientesNuevo.setText("Nuevo");
        btnClientesNuevo.setFocusPainted(false);
        btnClientesNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesNuevoActionPerformed(evt);
            }
        });

        btnClientesModificar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnClientesModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar (1).png"))); // NOI18N
        btnClientesModificar.setText("Modificar");
        btnClientesModificar.setFocusPainted(false);
        btnClientesModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesModificarActionPerformed(evt);
            }
        });

        btnClientesEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnClientesEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/usuario.png"))); // NOI18N
        btnClientesEliminar.setText("Eliminar");
        btnClientesEliminar.setFocusPainted(false);
        btnClientesEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesEliminarActionPerformed(evt);
            }
        });

        lblAdministracionClientes.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblAdministracionClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdministracionClientes.setText("Administración de Clientes");

        btnClientesBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnClientesBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnClientesBuscar.setText("Buscar");
        btnClientesBuscar.setFocusPainted(false);
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
        comboBusquedaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBusquedaClientesActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cliente.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClientesModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClientesNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClientesEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtClientesBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBusquedaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClientesBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnResetTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAdministracionClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblAdministracionClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResetTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientesBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBusquedaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClientesBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnClientesNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnClientesModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnClientesEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Administración de Clientes", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        tbHabitaciones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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

        jlHabitaciones.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jlHabitaciones.setText("Administracion de Habitaciones");

        btnBuscarHabitaciones.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBuscarHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnBuscarHabitaciones.setText("Buscar");
        btnBuscarHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHabitacionesActionPerformed(evt);
            }
        });

        btnAgregarHabitaciones.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAgregarHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar-archivo.png"))); // NOI18N
        btnAgregarHabitaciones.setText("Agregar");
        btnAgregarHabitaciones.setFocusPainted(false);
        btnAgregarHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHabitacionesActionPerformed(evt);
            }
        });

        btnModificarHabitaciones.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnModificarHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar (1).png"))); // NOI18N
        btnModificarHabitaciones.setText("Modificar");
        btnModificarHabitaciones.setFocusPainted(false);
        btnModificarHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarHabitacionesActionPerformed(evt);
            }
        });

        btnEliminarHabitaciones.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEliminarHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        btnEliminarHabitaciones.setText("Eliminar");
        btnEliminarHabitaciones.setFocusPainted(false);
        btnEliminarHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarHabitacionesActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/hotel (1).png"))); // NOI18N

        btnResethabitaciones.setBackground(new java.awt.Color(255, 0, 0));
        btnResethabitaciones.setText("x");
        btnResethabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResethabitacionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnResethabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jlHabitaciones))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnModificarHabitaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarHabitaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jlHabitaciones))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3)))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResethabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAgregarHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Administración de Habitaciones", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Gestion de Reservas");

        tblReservas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/calendario.png"))); // NOI18N

        btnNuevaReserva.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNuevaReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reserva (3).png"))); // NOI18N
        btnNuevaReserva.setText(" Nuevo");
        btnNuevaReserva.setFocusPainted(false);
        btnNuevaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaReservaActionPerformed(evt);
            }
        });

        btnModificarReserva.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnModificarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar (1).png"))); // NOI18N
        btnModificarReserva.setText(" Modificar");
        btnModificarReserva.setFocusPainted(false);
        btnModificarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarReservaActionPerformed(evt);
            }
        });

        btnCancelarReserva.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar (4).png"))); // NOI18N
        btnCancelarReserva.setText(" Cancelar");
        btnCancelarReserva.setFocusPainted(false);
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
            }
        });

        comboBusquedaReservas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "cliente_id", "habitacion_id", "estado" }));

        btnReservasBuscar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnReservasBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnReservasBuscar.setText("Buscar");
        btnReservasBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservasBuscarActionPerformed(evt);
            }
        });

        btnResetTable1.setBackground(new java.awt.Color(255, 0, 0));
        btnResetTable1.setText("x");
        btnResetTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTable1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(300, 300, 300))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(txtReservasBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBusquedaReservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReservasBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnResetTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(btnNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel8))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReservasBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBusquedaReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReservasBuscar)
                    .addComponent(btnResetTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jTabbedPane1.addTab("Gestión de Reservas", jPanel3);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Primer Fecha");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setText("Informes y Reportes ");

        lblOcupacion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblOcupacion.setText("Reportes de Ocupacion");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Segunda Fecha");

        btnReporteHabitaciones.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnReporteHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Registros.png"))); // NOI18N
        btnReporteHabitaciones.setText("Generar Reporte");
        btnReporteHabitaciones.setFocusPainted(false);
        btnReporteHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteHabitacionesActionPerformed(evt);
            }
        });

        jdcPrimerFecha.setDateFormatString("y-MM-dd");

        jdcSegundaFecha.setDateFormatString("y-MM-dd");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reporte-de-negocios.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Reporte de Ganancias");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Primer Fecha");

        jdcFecha1.setDateFormatString("y-MM-dd");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Segunda Fecha");

        jdcFecha2.setDateFormatString("y-MM-dd");

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
                .addGap(322, 322, 322)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(0, 360, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(462, 462, 462))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jdcFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jdcFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblOcupacion)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jdcPrimerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jdcSegundaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnReporteGanacias)
                                    .addComponent(btnReporteHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(lblOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdcPrimerFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcSegundaFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReporteHabitaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdcFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReporteGanacias, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(186, 186, 186))
        );

        jTabbedPane1.addTab("Informes y Reportes", jPanel5);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

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

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
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

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("Check-out ");

        btnBuscarCheckin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarCheckin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnBuscarCheckin.setText("Buscar Reserva");
        btnBuscarCheckin.setFocusPainted(false);
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

        btnBuscarCheckout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarCheckout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnBuscarCheckout.setText("Buscar ");
        btnBuscarCheckout.setFocusPainted(false);
        btnBuscarCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCheckoutActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setText("Check-in");

        lblBCheckout.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBCheckout.setText("Buscar ID Check-in");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check_9576046.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-out_9576053.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane4)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtBuscarCkeckout, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarCheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtBuscarCkeckin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarCkeckin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarCkeckout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );

        jTabbedPane1.addTab("Check-in y Check-out", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
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
      btnResetTable1.setVisible(false);
     
    }//GEN-LAST:event_formWindowOpened

    private void btnBuscarCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCheckoutActionPerformed
        // TODO add your handling code here:

        CheckInCheckOut buscar =  new CheckInCheckOut();
        buscar.buscarCheckin(txtBuscarCkeckout.getText().trim(), tblCheckout);

    }//GEN-LAST:event_btnBuscarCheckoutActionPerformed

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

    private void btnBuscarCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCheckinActionPerformed
        // Checks

        CheckInCheckOut buscar =  new CheckInCheckOut();
        buscar.comprobarCheckin(txtBuscarCkeckin, tblCheckin);
        //buscar.buscarCheckinReserva(txtBuscarCkeckin);
    }//GEN-LAST:event_btnBuscarCheckinActionPerformed

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

    private void btnResetTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTableActionPerformed
        //Administarcions de Clientes
        actualizar_tabla_clientes();
        btnResetTable.setVisible(false);
    }//GEN-LAST:event_btnResetTableActionPerformed

    private void btnClientesBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesBuscarActionPerformed
        //Administarcions de Clientes
        buscar_tabla_clientes();

    }//GEN-LAST:event_btnClientesBuscarActionPerformed

    private void btnClientesEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesEliminarActionPerformed
        //Administarcions de Clientes
        eliminar_Cliente();

    }//GEN-LAST:event_btnClientesEliminarActionPerformed

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

    private void btnClientesNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesNuevoActionPerformed
        //Administarcions de Clientes
        ingresar_nuevo_cliente();

    }//GEN-LAST:event_btnClientesNuevoActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        //Administarcions de Clientes
        if (evt.getClickCount() == 2) {
            Administracion_Clientes_Dialog ventanaClientes = new Administracion_Clientes_Dialog(this, true);
            llenarDialogClientes(ventanaClientes);
            ventanaClientes.setVisible(true);
            actualizar_tabla_clientes();
        }
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnReservasBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservasBuscarActionPerformed
        // TODO add your handling code here:
        buscar_tabla_reservas();
       
    }//GEN-LAST:event_btnReservasBuscarActionPerformed

    private void comboBusquedaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBusquedaClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBusquedaClientesActionPerformed

    private void btnNuevaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaReservaActionPerformed
        // TODO add your handling code here:
        Gestion_Reservas ventanaReservas = new Gestion_Reservas(this, true, this);
        ventanaReservas.setVisible(true);
    }//GEN-LAST:event_btnNuevaReservaActionPerformed

    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed
        // TODO add your handling code here:
        manejarCancelarReserva();
    }//GEN-LAST:event_btnCancelarReservaActionPerformed

    private void btnModificarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarReservaActionPerformed
        // TODO add your handling code here:
         modificarFechaReserva();
    }//GEN-LAST:event_btnModificarReservaActionPerformed

    private void btnResetTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTable1ActionPerformed
        // TODO add your handling code here:
        actualizar_tabla_reservas();
        btnResetTable1.setVisible(false);
    }//GEN-LAST:event_btnResetTable1ActionPerformed

    private void btnReporteGanaciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteGanaciasActionPerformed

        try{
            Date fechaInicial = jdcFecha1.getDate();
            Date fechaFinal = jdcFecha2.getDate();

            if (fechaInicial==null) {
                JOptionPane.showMessageDialog(null, "Por Favor seleccione una fecha valida");
                return;
            }
            if (fechaFinal==null) {
                JOptionPane.showMessageDialog(null, "Por Favor seleccione una fecha valida");
                return;
            }
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
                view.setLocation(700, 200);
                view.setVisible(true);
                
            }

        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Valores Incorrectos");
        }

    }//GEN-LAST:event_btnReporteGanaciasActionPerformed

    private void btnBuscarHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHabitacionesActionPerformed
        // TODO add your handling code here:
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

    private void btnResethabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResethabitacionesActionPerformed
        // TODO add your handling code here:
        CargarTable();
    }//GEN-LAST:event_btnResethabitacionesActionPerformed

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
    private javax.swing.JToggleButton btnReporteGanacias;
    private javax.swing.JButton btnReporteHabitaciones;
    private javax.swing.JButton btnReservasBuscar;
    private javax.swing.JButton btnResetTable;
    private javax.swing.JButton btnResetTable1;
    private javax.swing.JButton btnResethabitaciones;
    private javax.swing.JComboBox<String> comboBusquedaClientes;
    private javax.swing.JComboBox<String> comboBusquedaReservas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdcFecha1;
    private com.toedter.calendar.JDateChooser jdcFecha2;
    private com.toedter.calendar.JDateChooser jdcPrimerFecha;
    private com.toedter.calendar.JDateChooser jdcSegundaFecha;
    private javax.swing.JLabel jlHabitaciones;
    private javax.swing.JTextField jtBuscar;
    private javax.swing.JLabel lblAdministracionClientes;
    private javax.swing.JLabel lblBCheckout;
    private javax.swing.JLabel lblOcupacion;
    private javax.swing.JTable tbHabitaciones;
    private javax.swing.JTable tblCheckin;
    private javax.swing.JTable tblCheckout;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblReservas;
    private javax.swing.JTextField txtBuscarCkeckin;
    private javax.swing.JTextField txtBuscarCkeckout;
    private javax.swing.JTextField txtClientesBuscar;
    private javax.swing.JTextField txtReservasBuscar;
    // End of variables declaration//GEN-END:variables
}
