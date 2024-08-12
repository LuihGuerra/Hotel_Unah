/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_unah.AdministracionClientes;

import hotel_unah.Conexion;
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
public class AdministracionClientes {
    DefaultTableModel modelo = new DefaultTableModel();
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
}
