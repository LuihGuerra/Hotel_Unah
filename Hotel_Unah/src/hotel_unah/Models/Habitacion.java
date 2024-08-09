/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_unah.Models;

import java.util.Vector;

/**
 *
 * @author axel2
 */
public class Habitacion {
    public int    HabitacionId;
    public String NumeroHabitacion;
    public String TipoHabitacion;
    public String EstadoHabitacion;
    public double PrecioPorNoche;
    
    public static final String[] columnas = {"Habitacion ID", "Numero Habitacion", "Tipo Habitacion", "Estado Habitacion", "Precio Por Noche"};
    
    public Habitacion(int HabitacionId, String NumeroHabitacion, String TipoHabitacion, String EstadoHabitacion, double PrecioPorNoche) {
        this.HabitacionId = HabitacionId;
        this.NumeroHabitacion = NumeroHabitacion;
        this.TipoHabitacion = TipoHabitacion;
        this.EstadoHabitacion = EstadoHabitacion;
        this.PrecioPorNoche = PrecioPorNoche;
    }
    
    public Vector toVector() {

        Vector temp = new Vector();

        temp.add(HabitacionId);
        temp.add(NumeroHabitacion);
        temp.add(TipoHabitacion);
        temp.add(EstadoHabitacion);
        temp.add(PrecioPorNoche);
        
        return temp;

    }
}
