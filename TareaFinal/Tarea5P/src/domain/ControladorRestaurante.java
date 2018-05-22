/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import static domain.Objectos.MESA;
import static domain.Objectos.PLATILLOS;
import static domain.Objectos.PREMIOS;
import file.FileManagerJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author daniela
 */
public class ControladorRestaurante {

    private static Restaurante restaurante;

    public ControladorRestaurante() {
        try {
            restaurante = new Restaurante();
            llenarListaMenu();
            llenarListaMesas();
            llenarListaPremios();
        } catch (ParseException ex) {
            Logger.getLogger(ControladorRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControladorRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void llenarListaMesas() throws ParseException, IOException {
        ArrayList<Object> listaMesas = new ArrayList<>();
        FileManagerJson fileManagerJson = new FileManagerJson();
        listaMesas = fileManagerJson.getObjectsFromFile(MESA);
        restaurante.setListaMesas(listaMesas);

    }

    public void llenarListaMenu() throws ParseException, IOException {

        ArrayList<Object> platillosMenu = new ArrayList<>();
        FileManagerJson fileManagerJson = new FileManagerJson();
        platillosMenu = fileManagerJson.getObjectsFromFile(PLATILLOS);

        restaurante.setListaMenu(platillosMenu);

    }

    public void llenarListaPremios() throws ParseException, IOException {
        ArrayList<Object> listaPremios = new ArrayList<>();
        FileManagerJson fileManagerJson = new FileManagerJson();
        listaPremios = fileManagerJson.getObjectsFromFile(PREMIOS);

        restaurante.setListaPremios(listaPremios);

    }

    public static Restaurante getRestaurante() {
        return restaurante;
    }

}
