/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_unah;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luih
 */
public class Conexion {
    

    
    private Conexion(){}
    //establecer credenciales
    
    private static Connection conn;
    
    private static Conexion instancia;
    
    private static final String url = "jdbc:mysql://localhost/hotel_unah";
    
    private static final String user = "root";
    
    private static final String password = "Lizyb123";
    
    //establecer conexion
    
    public Connection conectar(){
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn=DriverManager.getConnection(url,user,password);
            
            //JOptionPane.showMessageDialog(null, "Conexion Exitosa !!");
            
            return conn;
        
        }catch(Exception e){
        
            JOptionPane.showMessageDialog(null,"Error: "+ e);
        
        }
        
        return conn;
        
    }
    
    //cerrar conexion
    
    public void cerrarConexion() throws SQLException{
            try{
            
                   conn.close();
                   //JOptionPane.showMessageDialog(null, "Conexion Cerrada");
            }catch(Exception e){
            
                JOptionPane.showMessageDialog(null,"Error"+ e);
                conn.close();
            }finally{
                conn.close();
            }
            
            
    }
    
    public static Conexion getInstance(){
        
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
}
