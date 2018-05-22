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
public class ClaseObservadora {

    public static Mesa mesa;

    public ClaseObservadora() {
    }

    public static Mesa getMesa() {
        return mesa;
    }

    public static void setMesa(Mesa mesa) {
        ClaseObservadora.mesa = mesa;
    }

}
