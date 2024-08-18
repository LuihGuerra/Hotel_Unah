/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_unah.CheckInCheckOut;

import com.mysql.cj.protocol.Resultset;
import hotel_unah.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luih
 */
public class CheckInCheckOut {
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    
    public void actualizarCheckIn(JTable tblCheckin){
    try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();

            PreparedStatement llenarTabla = conexion.prepareStatement("SELECT * FROM checkins");

            ResultSet consulta = llenarTabla.executeQuery();

            modelo = new DefaultTableModel() {

                //deshabilitar la edición de las filas
                public boolean isCellEditable(int row, int col) {
                    return false;
                }

            };

            modelo.addColumn("id");
            modelo.addColumn("reserva_id");
            modelo.addColumn("fecha_checkin");
           
            tblCheckin.setModel(modelo);

            while (consulta.next()) {
                Vector fila = new Vector();

                fila.addElement(consulta.getString(1));
                fila.addElement(consulta.getString(2));
                fila.addElement(consulta.getString(3));


                modelo.addRow(fila);
            }
            conn.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    
}
    public void actualizarCheckOut(JTable tblCheckout){
    try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();

            PreparedStatement llenarTabla = conexion.prepareStatement("SELECT * FROM checkouts");

            ResultSet consulta = llenarTabla.executeQuery();

            modelo2 = new DefaultTableModel() {

                //deshabilitar la edición de las filas
                public boolean isCellEditable(int row, int col) {
                    return false;
                }

            };

            modelo2.addColumn("id");
            modelo2.addColumn("checkin_id");
            modelo2.addColumn("fecha_checkout");
           
            tblCheckout.setModel(modelo2);

            while (consulta.next()) {
                Vector fila = new Vector();

                fila.addElement(consulta.getString(1));
                fila.addElement(consulta.getString(2));
                fila.addElement(consulta.getString(3));


                modelo2.addRow(fila);
            }
            conn.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    
}
    public void comprobarCheckin(JTextField txtBuscarCkeckin, JTable tblCheckin){
        try{
        Conexion conn = Conexion.getInstance();
        Connection conexion = conn.conectar();
        
        PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM checkins WHERE reserva_id = ?");
        consulta.setString(1, txtBuscarCkeckin.getText().trim());
        ResultSet resultado = consulta.executeQuery();
        
            
            if (resultado.next()) {
                JOptionPane.showMessageDialog(null, "Ya hizo Checkin");
                conn.cerrarConexion();
            }else{
                conn.cerrarConexion();
                buscarCheckinReserva(txtBuscarCkeckin, tblCheckin);
            }
            conn.cerrarConexion();
        }catch(HeadlessException | SQLException e){
        
        }
    }
    public void checkin(String reservaId, String fechaEntrada, String fechaSalida,JTable tblCheckin) throws ParseException{
        JOptionPane.showMessageDialog(null, "Reserva id: "+reservaId+" Fecha de Entrada: "+fechaEntrada+" Fecha Salida: "+fechaSalida);
        try{
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha1=formato.parse(fechaEntrada);
            Date fecha2=formato.parse(fechaSalida);
           LocalDateTime hoy = LocalDateTime.now(); 
           Date fecha3=formato.parse(hoy.toString());
            if ((fecha3.compareTo(fecha1)==1 && fecha3.compareTo(fecha2)==-1) || fecha3.compareTo(fecha1)==0) {
                    JOptionPane.showMessageDialog(null, "Reserva Dentro de tiempo");
                    Conexion conn = Conexion.getInstance();
                    Connection conexion = conn.conectar();
                    PreparedStatement insertar = conexion.prepareStatement("INSERT INTO checkins( reserva_id, fecha_checkin) VALUES (?,CURRENT_TIMESTAMP())"); 
                    insertar.setString(1, reservaId);
                    insertar.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Checkin Realizado con Exito");
                    actualizarCheckIn(tblCheckin);
                    conn.cerrarConexion();
                    
            }else{
                   JOptionPane.showMessageDialog(null, "Reserva Fuera de tiempo");                
            }
 
        }catch(SQLException e){
        
        }
        
    }
    public void cambiarEstadoHabitacion(String habitacion_id){
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
            PreparedStatement actualizar= conexion.prepareStatement("UPDATE habitaciones SET estado ='ocupada' WHERE id=?;"); 
            actualizar.setString(1, habitacion_id);  
            actualizar.executeUpdate();
            conn.cerrarConexion();
            
            
        } catch (SQLException e) {
        }
        
    }
    public void cambiarEstadoReserva(String reservaId){
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
            PreparedStatement actualizar= conexion.prepareStatement("UPDATE reservas SET estado ='confirmada' WHERE id=?;"); 
            actualizar.setString(1, reservaId);
            actualizar.executeUpdate();
            conn.cerrarConexion();
            
            
        } catch (SQLException e) {
        }
    }
    public void buscarCheckinReserva(JTextField txtBuscarCkeckin, JTable tblCheckin){
        try{
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
             
            //PreparedStatement busqueda = conexion.prepareStatement("SELECT * FROM reservas WHERE id = '"+txtBuscarCkeckin.getText().trim()+"'");  
            PreparedStatement busqueda = conexion.prepareStatement("SELECT * FROM reservas INNER JOIN clientes ON reservas.cliente_id=clientes.id INNER JOIN habitaciones ON reservas.habitacion_id=habitaciones.id WHERE reservas.id=?"); 
            busqueda.setString(1, txtBuscarCkeckin.getText().trim());
            ResultSet consulta = busqueda.executeQuery();
                           
            if (consulta.next()) {
                
                
                Object [] opciones = {"CANCELAR RESERVACION", "CANCELAR", "PROCEDER"};
                
               int respuesta = JOptionPane.showOptionDialog(null, 
                        "<html><p>Nombre Cliente: "+ consulta.getString(8)+" </p><br></html>"                       
                       + "<html><p>Numero Reserva: "+ consulta.getString(1)+"</p><br></html>"
                       + "<html><p>Numero Habitacion: "+ consulta.getString(14)+"</p><br></html>"
                       + "<html><p>Fecha de Entrada: "+ consulta.getString(4)+"</p><br></html>"
                       + "<html><p>Fecha de Salida: "+ consulta.getString(5)+"</p><br></html>", 
                       "Reserva Econtrada", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, opciones, opciones[1]);
               if (respuesta==-1) {
                     //Por si hace cosas raras el boton "x"
                }else{
               if (respuesta==0) {
                    Object [] opciones3={"Si", "No"};
                    int respuesta3 = JOptionPane.showOptionDialog(null, "Seguro que quiere Cancelar la Reservacion?", 
                            "Cancelar Reservacion", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, opciones3, opciones3[1]);
                        if (respuesta3 == 0) {
                            //Proceder con la Cancelacion de la reservacion
                            cancelarReserva(consulta.getString(1));
                            JOptionPane.showMessageDialog(null, "Reservacion Cancelada");
                        }
                        if (respuesta3 == -1) {
                             //Por si hace cosas raras el boton "x"
                        }
                }else{if (respuesta==1) {
                        return;
                    } else {
                       Object [] opciones2={"Si", "No"};
                        int respuesta2 = JOptionPane.showOptionDialog(null, "Proceder con el Check-In?", "Check-In", 
                                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, opciones2, opciones2[1]);
                        if (respuesta2 == 0) {
                            //Proceder con el ckeckin
                            JOptionPane.showMessageDialog(null, "Checkin Hecho");
                            this.checkin(consulta.getString(1),consulta.getString(4),consulta.getString(5), tblCheckin);
                            this.cambiarEstadoHabitacion(consulta.getString(3));
                            this.cambiarEstadoReserva(consulta.getString(1));
                            conn.cerrarConexion();
                        }
                        if (respuesta2 == -1) {
                            //Por si hace cosas raras el boton "x"
                            
                        }
                    }
}
               }
                           
   
            }else{
                JOptionPane.showMessageDialog(null, "Reserva no Encontrada", "Reserva no Econtrada", 0);
            }
        conn.cerrarConexion();
        }catch(HeadlessException | SQLException | ParseException e){
        
        
        
        }
            
    
    }
    
    
    public void comprobarCheckout(String reservaId, JTable tblCheckout){
    
        try {
            Conexion conn = Conexion.getInstance();
        Connection conexion = conn.conectar();
        
        PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM checkouts INNER JOIN checkins ON checkouts.checkin_id=checkins.id WHERE checkins.reserva_id=?");
        
        consulta.setString(1, reservaId);
        ResultSet resultado =  consulta.executeQuery();
        
        if (resultado.next()) {
                JOptionPane.showMessageDialog(null, "Ya hizo Checkout");
                conn.cerrarConexion();
            }else{
                conn.cerrarConexion();
               //Lo que sigue
               Object [] opciones = {"SI", "NO"};
            int respuesta = JOptionPane.showOptionDialog(null, "Desea hacer el Checkout?","Checkout" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,null, opciones, opciones[1]);
            if (respuesta == -1){
            return;
            }
            if (respuesta == 0) {
            }
                JOptionPane.showMessageDialog(null, "Checkout Realizado Correctamente");
                
               checkout(reservaId,getCheckinID(reservaId), tblCheckout);
               finalizarReserva(reservaId);
               fechasCheckinsCheckouts(reservaId);
               conn.cerrarConexion();
            }
            conn.cerrarConexion();
        
        } catch (HeadlessException | SQLException e) {
        }
    
    }public void fechasCheckinsCheckouts(String reservasId){
    
            try {
                Conexion conn = Conexion.getInstance();
                Connection conexion = conn.conectar();
                
                PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM checkins INNER JOIN checkouts ON checkins.id=checkouts.checkin_id WHERE checkins.reserva_id=?");
                consulta.setString(1, reservasId);
                
                ResultSet resultado = consulta.executeQuery();
                
                if (resultado.next()) {
                    
                  precioporNoche(resultado.getString(3), resultado.getString(6), reservasId);  
                    
                }
                conn.cerrarConexion();
            } catch (SQLException e) {
                
                
            }
    
    }
    public void precioporNoche(String fechaCheckin, String fechaCheckout, String reservasId){
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion= conn.conectar();
            
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM habitaciones INNER JOIN reservas ON habitaciones.id=reservas.habitacion_id WHERE reservas.id=?");
           consulta.setString(1, reservasId);
            
            ResultSet resultado = consulta.executeQuery();
            
           
            if (resultado.next()) {
                
                totalPorHospedaje(fechaCheckin, fechaCheckout, reservasId, resultado.getString(5));
                conn.cerrarConexion();
            }
            conn.cerrarConexion();
                    
        } catch (SQLException e) {
        }
    
    }
    
    public void totalPorHospedaje(String fechaCheckin, String fechaCheckout, String reservasId, String precioNoche){
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion= conn.conectar();
            
            PreparedStatement consulta = conexion.prepareStatement("SELECT DATEDIFF (?, ?);");
            
            consulta.setString(1, fechaCheckout);
            consulta.setString(2, fechaCheckin);
            
            ResultSet resultado = consulta.executeQuery();
            
            if (resultado.next()) {
                System.out.println("Dias Diferencia "+resultado.getString(1));
                
                double total = Double.parseDouble(resultado.getString(1))*Double.parseDouble(precioNoche);
                System.out.println("Total "+ total );
                
                factura(fechaCheckin, fechaCheckout, reservasId, precioNoche, total, resultado.getString(1));
                conn.cerrarConexion();
            }
            conn.cerrarConexion();
        } catch (SQLException e) {
        }
    
    
    }
    public void factura(String fechaCheckin, String fechaCheckout, String reservasId, String precioNoche, double total, String dias){
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion= conn.conectar();
            
            PreparedStatement busqueda = conexion.prepareStatement("SELECT * FROM reservas INNER JOIN clientes ON reservas.cliente_id=clientes.id INNER JOIN habitaciones ON reservas.habitacion_id=habitaciones.id WHERE reservas.id=?"); 
            busqueda.setString(1, reservasId);
            ResultSet consulta = busqueda.executeQuery();
            
             if (consulta.next()) {
             
             Object [] opciones = {"OK"};
                
               int respuesta = JOptionPane.showOptionDialog(null, 
                        "<html><p>Nombre Cliente: "+ consulta.getString(8)+" </p><br></html>"                       
                       + "<html><p>Numero Reserva: "+ consulta.getString(1)+"</p><br></html>"
                       + "<html><p>Numero Habitacion: "+ consulta.getString(14)+"</p><br></html>"
                       + "<html><p>Fecha de Entrada: "+ consulta.getString(4)+"</p><br></html>"
                       + "<html><p>Fecha de Salida: "+ consulta.getString(5)+"</p><br></html>"
                       + "<html><p>Fecha Checkin: "+ fechaCheckin+"</p><br></html>"
                       + "<html><p>Fecha Checkout: "+ fechaCheckout+"</p><br></html>"
                       + "<html><p>Dias Hospedados: "+ dias+"</p><br></html>"
                       + "<html><p>Precio por noche: "+ precioNoche+"</p><br></html>"
                       + "<html><p>Total: "+ total+" USD</p><br></html>", 
                       "Factura", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, opciones, opciones[0]);
               if (respuesta==-1) {
                     //Por si hace cosas raras el boton "x"
                     conn.cerrarConexion();
                     return;
                }else{
               if (respuesta==0) {
                  conn.cerrarConexion();
                   return;
               }
               conn.cerrarConexion();
               }
               conn.cerrarConexion();
             }
        } catch (Exception e) {
        }
    
    
    }
    public String getCheckinID(String reservaId){
    
        try {
            Conexion conn = Conexion.getInstance();
        Connection conexion = conn.conectar();
        
        PreparedStatement consulta = conexion.prepareStatement("SELECT id FROM checkins WHERE checkins.reserva_id=?");
        consulta.setString(1, reservaId);
        ResultSet resultado = consulta.executeQuery();
        
            if (resultado.next()) {
                return resultado.getString(1);
            }
        } catch (SQLException e) {
            
        }
            return null;
    
    }
    public void checkout(String reservaId, String checkinId, JTable tblCheckout){
        try {
            Conexion conn = Conexion.getInstance();
        Connection conexion = conn.conectar();
        
        PreparedStatement insertar = conexion.prepareStatement("INSERT INTO checkouts (checkin_id, fecha_checkout) VALUES (?,CURRENT_TIMESTAMP())");
        insertar.setString(1, checkinId);
        insertar.executeUpdate();
        JOptionPane.showMessageDialog(null, "Checkout Realizado con Exito");
            buscarHabitacion(reservaId);
            actualizarCheckOut(tblCheckout);
            conn.cerrarConexion();
        
        } catch (HeadlessException | SQLException e) {
        }
    
    
    }
    public void buscarHabitacion(String reservasId){
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM reservas INNER JOIN checkins ON reservas.id=checkins.reserva_id WHERE checkins.reserva_id=?");
            consulta.setString(1, reservasId);
            ResultSet resultado= consulta.executeQuery();
            if (resultado.next()) {
                cambiarEstadoHabitacionLimpieza(resultado.getString(3));
            }
            
            conn.cerrarConexion();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    public void buscarCheckin(String reservasId, JTable tblCheckout){
    
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
            
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM checkins WHERE checkins.reserva_id=?");
            consulta.setString(1, reservasId);
            ResultSet resultado= consulta.executeQuery();
            
            if (resultado.next()) {
                comprobarCheckout(reservasId, tblCheckout);
                conn.cerrarConexion();
            }else{
                JOptionPane.showMessageDialog(null, "No ha hecho Checkin");
                
                conn.cerrarConexion();
                return;
            }
            conn.cerrarConexion();
        } catch (SQLException e) {
        }
    
    
    }
    public void cambiarEstadoHabitacionLimpieza(String habitacionId){
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
            PreparedStatement actualizar= conexion.prepareStatement("UPDATE habitaciones SET estado ='en limpieza' WHERE id=?;"); 
            actualizar.setString(1, habitacionId);
            actualizar.executeUpdate();
            conn.cerrarConexion();
            
            
        } catch (SQLException e) {
        }
    
    }
    public void finalizarReserva(String reservaId){
        try {
            Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
            PreparedStatement actualizar= conexion.prepareStatement("UPDATE reservas SET reservas.estado ='finalizada' WHERE reservas.id=?;"); 
            actualizar.setString(1, reservaId);
            actualizar.executeUpdate();
            conn.cerrarConexion();
            
            
        } catch (SQLException e) {
        }
    }
    
    public void cancelarReserva(String reservaId){
    
        try {
             Conexion conn = Conexion.getInstance();
            Connection conexion = conn.conectar();
            PreparedStatement actualizar= conexion.prepareStatement("UPDATE reservas SET reservas.estado ='cancelada' WHERE reservas.id=?;"); 
            actualizar.setString(1, reservaId);
            actualizar.executeUpdate();
            conn.cerrarConexion();
        } catch (SQLException e) {
            
        }
    
    }
}
