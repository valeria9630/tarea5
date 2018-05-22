/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea5p;

import domain.ClaseObservadora;
import domain.ControladorRestaurante;
import domain.Mesa;
import domain.Platillo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import domain.Restaurante;
import file.FileManagerJson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.simple.parser.ParseException;

/**
 * FXML Controller class
 *
 * @author ValeriaLeivaQuirós
 */
public class OcupadoController implements Initializable {

    @FXML
    private TableView<Platillo> tablaMenu;
    @FXML
    private TableColumn nombreCL;
    @FXML
    private TableColumn precioCL;
    ObservableList< Platillo> platillos;

    @FXML
    private TableView<Platillo> tablaPedidos;
    @FXML
    private TableColumn nombrePedidoCL;
    @FXML
    private TableColumn precioPedidoCL;

    ObservableList<Platillo> pedidos;
    @FXML
    private Button añadir;

    @FXML
    private Button retirar;

    @FXML
    private Button generarCobro;

    @FXML
    private Button ordenarPedido;
    @FXML
    private Label suma;

    private int posicionMenuTabla;
    private int posicionListaPedidos;
    public Platillo platilloSeleccionado;
    ControladorRestaurante controladorRestaurante;
    Restaurante restaurante;
    ArrayList<Object> listaDePedidos;
    ClaseObservadora claseObservadora;

    @FXML
    private void añadir(ActionEvent event) {
        pedidos.add(platilloSeleccionado);

    }

    @FXML
    private void retirar(ActionEvent event) {
        pedidos.remove(posicionListaPedidos);

    }

    @FXML
    private void generarCobro(ActionEvent event) {
        int suma1 = 0;
        if (claseObservadora.getMesa().getPremio() == 0) {
            for (int i = 0; i < pedidos.size(); i++) {
                suma1 += pedidos.get(i).getPrecio();

            }
            suma.setText("Total a pagar" + suma1 + "");
        }

        if (claseObservadora.getMesa().getPremio() != 0) {
            for (int i = 0; i < pedidos.size(); i++) {
                suma1 += pedidos.get(i).getPrecio();

            }
            suma.setText(suma1 + "");
//
            int totalDescuento = 0;
            totalDescuento = (claseObservadora.getMesa().getPremio() * suma1) / 100;
            int totalFinal = suma1 - totalDescuento;
            suma.setText("Total: " + suma1
                    + "\n con un descuento de: " + claseObservadora.getMesa().getPremio()
                    + "\n total a pagar: " + totalFinal);
        }
    }

    @FXML
    private void ordenarPedido(ActionEvent event) {
        for (int i = 0; i < pedidos.size(); i++) {
            Object platillos = (Platillo) pedidos.get(i);

            listaDePedidos.add(platillos);

        }

        claseObservadora.getMesa().setPedido(listaDePedidos);

    }

    private final ListChangeListener<Platillo> selectorTablaPLatillos
            = new ListChangeListener<Platillo>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Platillo> c) {
            ponerPlatilloSeleccionada();
        }
    };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Platillo getTablaPersonasSeleccionada() {
        if (tablaMenu != null) {
            List<Platillo> tabla = tablaMenu.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Platillo competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    private final ListChangeListener<Platillo> selectorTablaPLatillosPedidos
            = new ListChangeListener<Platillo>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Platillo> c) {
            ponerPlatilloSeleccionada();
        }
    };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Platillo getTablaPedidosSeleccionada() {
        if (tablaPedidos != null) {
            List<Platillo> tabla = tablaPedidos.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Platillo competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerPlatilloSeleccionada() {
        final Platillo platillo = getTablaPersonasSeleccionada();
        posicionMenuTabla = platillos.indexOf(platillo);

        if (platillo != null) {
            platilloSeleccionado = platillo;

//            pedidos.add(platillo);
        }
    }

    /**
     * Método para inicializar la tabla
     */
    private void inicializarTablaPlatillos() {
        nombreCL.setCellValueFactory(new PropertyValueFactory<Platillo, String>("nombre"));
        precioCL.setCellValueFactory(new PropertyValueFactory<Platillo, Double>("precio"));

        platillos = FXCollections.observableArrayList();
        tablaMenu.setItems(platillos);

    }

    private void inicializarTablaPedidos() {
        nombrePedidoCL.setCellValueFactory(new PropertyValueFactory<Platillo, String>("nombre"));
        precioPedidoCL.setCellValueFactory(new PropertyValueFactory<Platillo, Double>("precio"));

        pedidos = FXCollections.observableArrayList();
        tablaPedidos.setItems(pedidos);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaDePedidos = new ArrayList<>();
        restaurante = controladorRestaurante.getRestaurante();
        // Inicializamos la tabla
        this.inicializarTablaPedidos();
        this.inicializarTablaPlatillos();

        // Seleccionar las tuplas de la tabla de las personas
        final ObservableList<Platillo> tablaPersonaSel = tablaMenu.getSelectionModel().getSelectedItems();
        tablaPersonaSel.addListener(selectorTablaPLatillos);
        // Inicializamos la tabla con algunos datos aleatorios
        for (int i = 0; i < controladorRestaurante.getRestaurante().getListaMenu().size(); i++) {
            Platillo p1 = new Platillo();
            p1 = (Platillo) controladorRestaurante.getRestaurante().getListaMenu().get(i);
            System.out.println(p1.toString());

            platillos.add(p1);
        }

        // Seleccionar las tuplas de la tabla de las personas
        final ObservableList<Platillo> tablaPersonaSel2 = tablaPedidos.getSelectionModel().getSelectedItems();
        tablaPersonaSel2.addListener(selectorTablaPLatillosPedidos);

        if (claseObservadora.getMesa().getPedido() != null) {
            Mesa mesaTemp = new Mesa();
            mesaTemp = (Mesa) controladorRestaurante.getRestaurante().getListaMesas().get(claseObservadora.getMesa().getNumero());
            for (int i = 0; i < mesaTemp.getPedido().size(); i++) {
                Platillo p1 = new Platillo();
                p1 = (Platillo) mesaTemp.getPedido().get(i);
                System.out.println(p1.toString());

                pedidos.add(p1);

            }
        }
    }
}
