/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea5p;

import domain.ClaseObservadora;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ValeriaLeivaQuirós
 */
public class MenuController implements Initializable {

    @FXML
    private Button ocupar;

    @FXML
    private Button reservar;

    @FXML
    private Button cancelarReservacion;

    ClaseObservadora claseObservadora;

    @FXML
    void cancelarReservacion(ActionEvent event) throws IOException {
        if (claseObservadora.getMesa().getEstado().equalsIgnoreCase("reservada")) {
            Parent root = FXMLLoader.load(getClass().getResource("Cancelar.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Cancelar Reservacion");
            stage.setScene(scene);
            stage.show();

        }
    }

    @FXML
    void ocupar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Ocupado.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Ocupar");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void reservar(ActionEvent event) throws IOException {
        if (claseObservadora.getMesa().getEstado().equalsIgnoreCase("vacia")) {
            Parent root = FXMLLoader.load(getClass().getResource("Reservacion.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Reservar");
            stage.setScene(scene);
            stage.show();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
