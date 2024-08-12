/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_unah.Services;
import hotel_unah.Conexion;
import hotel_unah.Models.Habitacion;
import hotel_unah.Models.HabitacionEntity;
import hotel_unah.Response;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author axel2
 */
public class HabitacionService {
   public List<Habitacion> getHabitaciones(){
        Connection con = Conexion.conectar();
        System.out.println(con);
        List<Habitacion> habitaciones = new ArrayList();
        try{
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM habitaciones");
            
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                Habitacion hab = new Habitacion(
                        resultado.getInt("id"),
                        resultado.getString("numero_habitacion"),
                        resultado.getString("tipo"),
                        resultado.getString("estado"),
                        resultado.getDouble("precio_por_noche")
                );
                habitaciones.add(hab);
            }
            return habitaciones;
        }catch(SQLException ex){
            System.out.println("Error:"+ex.getMessage());
        } finally{
            //se ejecuta siempre una vez haya finalizado todo lo del try
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println("Error al cerrar la conexión:"+ex.getMessage());
            }
        }
        return habitaciones;
    }
    
    public Response AddHabitacion(HabitacionEntity habitacion){
        Response result = new Response();
        Connection con = Conexion.conectar();
        try{
            PreparedStatement stmt = con.prepareStatement("INSERT INTO habitaciones(numero_habitacion,tipo,estado,precio_por_noche) VALUE (?,?,?,?)");
            stmt.setString(1, habitacion.NumeroHabitacion);
            stmt.setInt(2, habitacion.TipoHabitacion);
            stmt.setInt(3, habitacion.EstadoHabitacion);
            stmt.setDouble(4, habitacion.PrecioPorNoche);
            int rowsAffected  = stmt.executeUpdate();
            
            if(rowsAffected >= 0)
            {
               result.Success(true, "200", "Habitacion agregada con exito");
            }else{
               result.Fault(true, "400", "Habitacion NO agregada");
            }
        }catch(SQLException ex){
            result.Fault(true, "400", ex.getMessage());
        } finally{
            //se ejecuta siempre una vez haya finalizado todo lo del try
            try{
                con.close();
            }catch(SQLException ex){
                result.Fault(true, "500", ex.getMessage());
            }
        }
        return result;
    } 
    
    public Response UpdateHabitacion(HabitacionEntity habitacion){
        Response result = new Response();
        Connection con = Conexion.conectar();
        System.out.println(habitacion.HabitacionId);
        try{
            PreparedStatement stmt = con.prepareStatement("UPDATE habitaciones SET numero_habitacion = ? ,tipo = ?, estado = ? , precio_por_noche = ? WHERE id = ? ");
            stmt.setString(1, habitacion.NumeroHabitacion);
            stmt.setInt(2, habitacion.TipoHabitacion);
            stmt.setInt(3, habitacion.EstadoHabitacion);
            stmt.setDouble(4, habitacion.PrecioPorNoche);
            stmt.setInt(5,  habitacion.HabitacionId);
            int rowsAffected  = stmt.executeUpdate();
            
            if(rowsAffected >= 0)
            {
               result.Success(true, "200", "Habitacion actualizada con exito");
            }else{
                result.Fault(true, "400", "Habitacion NO actualizada");
            }
            
        }catch(SQLException ex){
            result.Fault(true, "400", ex.getMessage());
        } finally{
            //se ejecuta siempre una vez haya finalizado todo lo del try
            try{
                con.close();
            }catch(SQLException ex){
               result.Fault(true, "500", ex.getMessage());
            }
        }
        return result;
    } 
    
    public Response DeleteHabitacion(int habitacionId){
        Response result = new Response();
        Connection con = Conexion.conectar();
        try{
            PreparedStatement stmt = con.prepareStatement("DELETE FROM Habitaciones WHERE id = ?");
            stmt.setInt(1, habitacionId);
            int rowsAffected  = stmt.executeUpdate();
            
            if(rowsAffected >= 0)
            {
               result.Success(true, "200", "Habitacion eliminada con exito");
            }else{
                result.Fault(true, "400", "Habitacion NO eliminada");
            }
            
        }catch(SQLException ex){
            result.Fault(true, "400", ex.getMessage());
        } finally{
            //se ejecuta siempre una vez haya finalizado todo lo del try
            try{
                con.close();
            }catch(SQLException ex){
               result.Fault(true, "500", ex.getMessage());
            }
        }
        return result;
    } 
}
