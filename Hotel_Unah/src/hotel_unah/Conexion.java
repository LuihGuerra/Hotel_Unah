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
    
    private static final String HOST = "localhost";
    private static final String USER = "admin"; 
    private static final String PORT = "3306";
    private static final String PWD = "@Xel0501200209630";
    private static final String BD = "hotel_unah";
    
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + BD;
    
    public static Connection conectar(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL,USER, PWD);
        
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
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
