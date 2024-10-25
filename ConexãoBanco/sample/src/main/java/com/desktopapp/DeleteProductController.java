package com.desktopapp;

import java.net.URL;

import com.desktopapp.implementations.DatabaseProductRepository;
import com.desktopapp.model.Produto;
import com.desktopapp.repositories.ProductRepository;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeleteProductController {

    private Produto selectedProduct;
    private ObservableList<Produto> lista;

    public static Scene CreateScene(Produto produto, ObservableList<Produto> lista) throws Exception
    {
        URL sceneUrl = DeleteProductController.class
            .getResource("DeleteProductScene.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        DeleteProductController controller = loader.getController();
        
        controller.selectedProduct = produto;
        controller.lista = lista;

        controller.delProdLabel.setText("Você está deletando o produto: " + produto.getName());

        return scene;
    }

    @FXML
    public void confirmDelete() throws Exception {
        ProductRepository repo = new DatabaseProductRepository();
        repo.delete(selectedProduct);

        Stage crrStage = (Stage)this.btnnDelProd.getScene().getWindow();
        crrStage.close();

        Stage newStage = new Stage();
        Scene newScene = MessageController.CreateScene("O produto " + selectedProduct.getName() + " foi excluído!");
        newStage.setScene(newScene);
        newStage.show();
    }

    @FXML
    public void cancelDelete() {
        Stage crrStage = (Stage)this.btnnDelProd.getScene().getWindow();
        crrStage.close();
    }

    @FXML
    private Button bttnCancel;

    @FXML
    private Button btnnDelProd;

    @FXML
    private Text delProdLabel;
}
