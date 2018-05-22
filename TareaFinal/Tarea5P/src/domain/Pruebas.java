/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import file.FileManagerJson;

import domain.Mesa;
import static domain.Objectos.MESA;
import static domain.Objectos.PLATILLOS;
import static domain.Objectos.PREMIOS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ValeriaLeivaQuirós
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            FileManagerJson fmj = new FileManagerJson();
            // mesa
            ArrayList<Object> mesas = new ArrayList<>();
            Mesa mesa1 = new Mesa("vacia", 0);
            mesa1.setPremio(20);
            Mesa mesa2 = new Mesa("vacia", 1);
            Mesa mesa3 = new Mesa("vacia", 2);
            mesas.add(mesa1);
            mesas.add(mesa2);
            mesas.add(mesa3);
            fmj.insertToFile(mesas);
            ArrayList<Object> mesas2 = new ArrayList<>();
            mesas2 = fmj.getObjectsFromFile(MESA);
            for (int i = 0; i < mesas2.size(); i++) {
                System.out.println(mesas2.get(i).toString());

            }
            // premios
            ArrayList< Object> premios = new ArrayList<>();
            Premios premio1 = new Premios(10);
            Premios premio2 = new Premios(20);
            premios.add(premio1);
            premios.add(premio2);
            fmj.insertToFile(premios);
            ArrayList<Object> premios2 = new ArrayList<>();
            premios2 = fmj.getObjectsFromFile(PREMIOS);
            for (int i = 0; i < premios2.size(); i++) {
                System.out.println(premios2.get(i).toString());

            }
            /// platillos
            ArrayList<Object> platillos = new ArrayList<>();
            Platillo platillo1 = new Platillo(5000, "Camarones", "1");
            Platillo platillo2 = new Platillo(1200, "Patacones", "2");
            Platillo platillo3 = new Platillo(1200, "Fideos", "3");
            Platillo platillo4 = new Platillo(1200, "Helado", "4");
            Platillo platillo5 = new Platillo(4000, "Gordon blue", "1");
            platillos.add(platillo1);
            platillos.add(platillo2);
            platillos.add(platillo3);
            platillos.add(platillo4);
            platillos.add(platillo5);
            fmj.insertToFile(platillos);
            ArrayList<Object> platillos2 = new ArrayList<>();
            platillos2 = fmj.getObjectsFromFile(PLATILLOS);

            for (int i = 0; i < platillos2.size(); i++) {
                System.out.println(platillos2.get(i).toString());

            }

//    
        } catch (ParseException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
