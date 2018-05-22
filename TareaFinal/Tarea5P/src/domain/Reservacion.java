/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author daniela
 */
public class Reservacion {

    private String nombre;
    private String correo;
    private String numero;
    private String cedula;
    private String fecha;
    private String hora;

    public Reservacion() {
    }

    public Reservacion(String nombre, String correo, String numero, String cedula, String fecha, String hora) {
        this.nombre = nombre;
        this.correo = correo;
        this.numero = numero;
        this.cedula = cedula;
        this.fecha = fecha;
        this.hora = hora;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Reservacion{" + "nombre=" + nombre + ", correo=" + correo + ", numero=" + numero + ", cedula=" + cedula + ", fecha=" + fecha + ", hora=" + hora + '}';
    }  

}
