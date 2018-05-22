/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author ValeriaLeivaQuirós
 */
public class Premios {

    private float descuento;

    public Premios() {
    }

    public Premios(float descuento) {
        this.descuento = descuento;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Premios{" + "descuento=" + descuento + '}';
    }

}
