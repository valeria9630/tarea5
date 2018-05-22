/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import com.google.gson.Gson;
import domain.Mesa;
import static domain.Objectos.MESA;
import static domain.Objectos.PLATILLOS;
import static domain.Objectos.PREMIOS;
import domain.Platillo;
import domain.Premios;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ValeriaLeivaQuirós
 */
public class FileManagerJson {

    final String pathMesa = "src\\mesas.json";
    final String pathPlatillos = "src\\platillos.json";
    final String pathPremios = "src\\premios.json";

    FileWriter file;

    public FileManagerJson() {

    }

    public void insertToFile(ArrayList<Object> objeto) throws IOException {

        Gson gson = new Gson();
        String g = "";
        String c = gson.toJson(g);
        String jsonObject;
        if (objeto.get(0) instanceof Mesa) {
            for (int i = 0; i < objeto.size(); i++) {
                jsonObject = gson.toJson(objeto.get(i), Mesa.class);

                try (FileWriter fileWriter = new FileWriter(pathMesa, true)) {

                    fileWriter.write(jsonObject + "\r\n");
                }
            }
        }
        if (objeto.get(0) instanceof Platillo) {
            for (int i = 0; i < objeto.size(); i++) {
                jsonObject = gson.toJson(objeto.get(i), Platillo.class);

                try (FileWriter fileWriter = new FileWriter(pathPlatillos, true)) {

                    fileWriter.write(jsonObject + "\r\n");
                }
            }
        }
        if (objeto.get(0) instanceof Premios) {
            for (int i = 0; i < objeto.size(); i++) {
                jsonObject = gson.toJson(objeto.get(i), Premios.class);

                try (FileWriter fileWriter = new FileWriter(pathPremios, true)) {

                    fileWriter.write(jsonObject + "\r\n");
                }
            }
        }

    }

    public ArrayList<Object> getObjectsFromFile(Enum tipoObject) throws org.json.simple.parser.ParseException, IOException {
        Gson gson = new Gson();
        ArrayList<Object> objects = new ArrayList<>();

        String line = null;
        if (tipoObject.equals(MESA)) {
            FileReader fileReader = new FileReader(pathMesa);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {

                Mesa m = gson.fromJson(line, Mesa.class);

                objects.add(m);
            }

            bufferedReader.close();
        }
        if (tipoObject.equals(PLATILLOS)) {
            FileReader fileReader = new FileReader(pathPlatillos);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {

                Platillo p = gson.fromJson(line, Platillo.class);

                objects.add(p);
            }

            bufferedReader.close();
        }
        if (tipoObject.equals(PREMIOS)) {
            FileReader fileReader = new FileReader(pathPremios);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {

                Premios p = gson.fromJson(line, Premios.class);

                objects.add(p);
            }

            bufferedReader.close();
        }

        return objects;
    }

    public void deleteFile(Enum tipoObject) throws java.text.ParseException {
        if (tipoObject.equals(MESA)) {
            File fileDelete = new File(pathMesa);

            fileDelete.delete();

        } else {

            File fileDelete = new File(pathPlatillos);

            fileDelete.delete();
        }
    }

}
