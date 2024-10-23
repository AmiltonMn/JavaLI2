package com.desktopapp;

import java.net.URL;
import java.util.*;
import java.util.stream.Gatherer.Integrator;

import com.desktopapp.model.Produto;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProductsController implements Initializable {

    private ArrayList<Produto> Lista = new ArrayList<>();

    Produto crrProduct;
    
    public static Scene CreateScene() throws Exception
    {
        URL sceneUrl = MainController.class
            .getResource("ProductsScreen.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        return scene;
    }

    @FXML
    protected TableView<Produto> table;

    @FXML
    protected TableColumn<Produto, Integer> idCol;

    @FXML
    protected TableColumn<Produto, String> nameCol;

    @FXML
    protected TableColumn<Produto, Integer> quantityCol;

    @FXML
    protected TableColumn<Produto, Float> valueCol;

    @FXML
    protected Button bttnCadProd;

    @FXML
    protected Button bttnEdit;

    @FXML
    protected Button bttnDelete;

    @FXML
    protected TextField inputNameProd;

    @FXML
    protected TextField inputQuantityProd;

    @FXML
    protected TextField inputValueProd;

    @FXML
    protected Text produtoSelecionado;

    @FXML 
    protected void cadastrarProduto() {

        if (this.inputValueProd.getText().equals("") || this.inputQuantityProd.getText().equals("") || this.inputNameProd.getText().equals("")) {
            System.out.println("Por favor preencha todos os campos!");
        } else {
            Produto newProduct = new Produto();

            newProduct.setName(inputNameProd.getText());
            newProduct.setQuantity(Integer.valueOf(inputQuantityProd.getText()));
            newProduct.setValueX(Float.valueOf(inputValueProd.getText()));

            System.out.println(inputNameProd.getText());
            System.out.println(inputQuantityProd.getText());
            System.out.println(inputValueProd.getText());

            Context ctx = new Context();

            ctx.begin();
            ctx.save(newProduct);
            ctx.commit();

            Lista.add(newProduct);
            this.table.setItems(FXCollections.observableArrayList(produtos()));
        }
    }

    public ObservableList<Produto> produtos() {
        Context ctx = new Context();
        int cont = 1;
        ObservableList<Produto> Lista2 = FXCollections.observableArrayList();
        while (true) {
            Produto produto = ctx.find(Produto.class, (Object)cont);
            if (produto == null) {
                break;
            }
            Lista2.add(produto);
            cont ++;
        }
        return Lista2;
    }

    @FXML
    protected void loginPage() throws Exception {
        Stage crrStage = (Stage)bttnCadProd.getScene().getWindow();
        crrStage.close();

        Stage newStage = new Stage();
        Scene newScene = MainController.CreateScene();
        newStage.setScene(newScene);
        newStage.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        idCol.setCellValueFactory(
            new PropertyValueFactory<>("id")
        );

        nameCol.setCellValueFactory(
            new PropertyValueFactory<>("name")
        );

        quantityCol.setCellValueFactory(
            new PropertyValueFactory<>("quantity")
        );

        valueCol.setCellValueFactory(
            new PropertyValueFactory<>("valueX")
        );

        bttnEdit.setDisable(true);
        bttnDelete.setDisable(true);

        this.table.setItems(FXCollections.observableArrayList(produtos()));
    }

    @FXML
    public void selecionarProduto() {

        @SuppressWarnings("unchecked")
        TablePosition<Produto, ?> cell = (TablePosition<Produto, ?>)table.getSelectionModel().getSelectedCells().get(0);

        if (cell != null)
        {
            crrProduct = table.getItems().get(cell.getRow());
            produtoSelecionado.setText("Produto selecionado: " + crrProduct.getId());  

            bttnEdit.setDisable(false);
            bttnDelete.setDisable(false);
        }
    }
}
