/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author daniela
 */
public class Mesa {

    private String estado;
    private int numero;
    private Reservacion reservacion;
    private ArrayList<Object> pedido;
    private int premio;

    public Mesa() {
    }

    public Mesa(String estado, int numero) {
        this.estado = estado;
        this.numero = numero;
        this.premio = 0;
        this.pedido = null;
    }

    public Mesa(String estado, int numero, Reservacion reservacion) {
        this.estado = estado;
        this.numero = numero;
        this.reservacion = reservacion;
        this.premio = 0;
        this.pedido = null;
    }

    public Mesa(String estado, int numero, Reservacion reservacion, ArrayList<Object> pedido, int premio) {
        this.estado = estado;
        this.numero = numero;
        this.reservacion = reservacion;
        this.pedido = pedido;
        this.premio = premio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
    }

    public ArrayList<Object> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<Object> pedido) {
        this.pedido = pedido;
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }

//    public Pago getPago() {
//        return pago;
//    }
//
//    public void setPago(Pago pago) {
//        this.pago = pago;
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//    @Override
//    public String toString() {
//        return "Mesa{" + "estado=" + estado + ", numero=" + numero + ", pedido=" + pedido + ", pago=" + pago + ", cliente=" + cliente + '}';
//    }
    @Override
    public String toString() {
        return "Mesa{" + "estado=" + estado + ", numero=" + numero + ", reservacion=" + reservacion + '}';
    }

}
