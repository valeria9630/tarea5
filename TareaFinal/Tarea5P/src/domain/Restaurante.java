/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author daniela
 */
public class Restaurante {

    private ArrayList<Object> listaMesas;
    private ArrayList<Object> listaMenu;
    private ArrayList<Object> listaPremios;
    private String nombre;
    ControladorRestaurante controladorRestaurante;

    public Restaurante() {

    }

    public ArrayList<Object> getListaMesas() {
        return listaMesas;
    }

    public void setListaMesas(ArrayList<Object> listaMesas) {
        this.listaMesas = listaMesas;
    }

    public ArrayList<Object> getListaMenu() {
        return listaMenu;
    }

    public void setListaMenu(ArrayList<Object> listaMenu) {
        this.listaMenu = listaMenu;
    }

    public ArrayList<Object> getListaPremios() {
        return listaPremios;
    }

    public void setListaPremios(ArrayList<Object> listaPremios) {
        this.listaPremios = listaPremios;
    }

    public void llenarListaMesa(Mesa mesa) {
        listaMesas.add(mesa);
    }
// 
//   public void llenar(){
//        Mesa mesa = new Mesa("vacio", 1);
//        Mesa mesa2 = new Mesa ("vacio,",2);
//        Mesa mesa3 = new Mesa ("vacio,",3);
//        
//        llenarListaMesa(mesa);
//        llenarListaMesa(mesa2);
//        llenarListaMesa(mesa3);
//        
//        System.out.println(listaMesas.get(0));
//   }

    public ControladorRestaurante getControladorRestaurante() {
        return controladorRestaurante;
    }

    public void setControladorRestaurante(ControladorRestaurante controladorRestaurante) {
        this.controladorRestaurante = controladorRestaurante;
    }

}
