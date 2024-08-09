/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_unah;

/**
 *
 * @author axel2
 */
public class Response {
    
    private boolean Ok;
    private String Codigo;
    private String Mensaje;

    public void Success(boolean ok, String codigo, String mensaje) {
        this.Ok = ok;
        this.Codigo = codigo;
        this.Mensaje = mensaje;
    }

    public void Fault(boolean ok, String codigo, String mensaje) {
        this.Ok = ok;
        this.Codigo = codigo;
        this.Mensaje = mensaje;
    }
    
     public String getMessage() {
        return this.Mensaje;
    }

    public String getCodigo() {
        return this.Codigo;
    }

    public boolean getOk() {
        return this.Ok;
    }
}

