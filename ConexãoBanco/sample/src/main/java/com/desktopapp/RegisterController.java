package com.desktopapp;

import java.net.URL;
import java.util.ResourceBundle;

import com.desktopapp.model.User;

import jakarta.persistence.EntityManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegisterController implements Initializable {

    public static Scene CreateScene() throws Exception
    {
        URL sceneUrl = MainController.class
            .getResource("RegisterScreen.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        return scene;
    }

    @FXML
    protected TextField newUserLogin;

    @FXML
    protected TextField newUserSenha;

    @FXML
    protected TextField confirmaSenha;

    @FXML
    protected Button voltarPageLogin;

    @FXML
    protected Button bttnVisualizarProd;

    @FXML
    protected Button bttnRegistrar;

    @FXML
    protected Pane header;

    @FXML
    protected void registrarUsuario() {

        if (this.newUserLogin.getText() != "" || this.newUserSenha.getText() != "" || this.confirmaSenha.getText() != "") {

            if (this.newUserSenha.getText().equals(this.confirmaSenha.getText())) {
  
                User newUser = new User();
                newUser.setName(newUserLogin.getText());
                newUser.setPassword(newUserSenha.getText());
    
                Context ctx = new Context();
    
                System.out.println("Usuário criado!");

                ctx.begin();
                ctx.save(newUser);
                ctx.commit();

            } else {
                
                System.out.println(newUserSenha.getText());
                System.out.println(confirmaSenha.getText());

                System.out.println("As senhas estao divergentes!");

            }
        } else {
            System.out.println("Campos preenchidos de forma incorreta!");
        }
    }

    @FXML
    protected void loginPage() throws Exception {
        Stage crrStage = (Stage)bttnRegistrar.getScene().getWindow();
        crrStage.close();

        Stage newStage = new Stage();
        Scene newScene = MainController.CreateScene();
        newStage.setScene(newScene);
        newStage.show();
    }

    @FXML
    protected void verProdutos() throws Exception {

        Stage crrStage = (Stage)bttnRegistrar.getScene().getWindow();
        crrStage.close();

        Stage newStage = new Stage();
        Scene newScene = ProductsController.CreateScene();
        newStage.setScene(newScene);
        newStage.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }
}
