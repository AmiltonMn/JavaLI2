package com.desktopapp;
import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.net.URL;

import com.desktopapp.implementations.DatabaseProductRepository;
import com.desktopapp.model.Produto;
import com.desktopapp.model.User;
import com.desktopapp.repositories.ProductRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EditProductController {

    private Produto selectedProduct;
    private ObservableList<Produto> lista;

    public static Scene CreateScene(String resource, Produto produto, ObservableList<Produto> lista) throws Exception
    {
        URL sceneUrl = EditProductController.class
            .getResource(resource);
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        EditProductController controller = loader.getController();
        
        controller.selectedProduct = produto;
        controller.lista = lista;

        controller.selectedProductLabel.setText("Produto selecionado: " + produto.getName());

        return scene;
    }

    @FXML
    public void atualizarProduto() throws IOException {
        ProductRepository repo = new DatabaseProductRepository();

        selectedProduct.setName(prodNewName.getText());
        selectedProduct.setQuantity(Integer.valueOf(prodNewQuantity.getText()));
        selectedProduct.setValueX(Float.valueOf(prodNewValue.getText()));

        repo.update(selectedProduct);
        
    }

    @FXML
    public void cancelarEdicao() {

    }

    @FXML
    protected TextField prodNewName;

    @FXML
    protected TextField prodNewQuantity;

    @FXML
    protected TextField prodNewValue;

    @FXML
    protected Button bttnAtualizar;

    @FXML
    protected Button bttnCancelar;

    @FXML
    protected Text selectedProductLabel;
}