package com.desktopapp;
import java.net.URL;

import com.desktopapp.model.User;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController {

    public static Scene CreateScene() throws Exception
    {
        User usuario =  new User();
        Context ctx = new Context();

        ctx.begin();

        usuario.setName("adm");
        usuario.setPassword("123");

        ctx.save(usuario);
        ctx.commit();

        URL sceneUrl = MainController.class
            .getResource("MainScreen.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);        

        return scene;
    }

    @FXML
    protected TextField inputLogin;

    @FXML
    protected TextField inputSenha;

    @FXML
    protected Button bttnLogin;

    @FXML
    protected Button bttnRegistrar;

    @FXML
    protected Pane loginBlock;

    @FXML
    protected void logar(MouseEvent e) throws Exception {

        Context ctx =  new Context();

        ctx.begin();

        var query =  ctx.createQuery(User.class, "from User where name = :name");
        query.setParameter("name", this.inputLogin.getText());
        var users = query.getResultList();

        if (users.size() > 0) {
            
            if (users.get(0).getPassword().equals(this.inputSenha.getText())) {
                System.out.println("Ta logado irmao!");
                Stage crrStage = (Stage)bttnLogin.getScene().getWindow();
                crrStage.close();

                Stage newStage = new Stage();
                Scene newScene = RegisterController.CreateScene();
                newStage.setScene(newScene);
                newStage.show();

            } else {
                System.out.println("Senha incorreta!");
            }
        } else {
            System.out.println("O usuario " + this.inputLogin.getText() + " nao foi encontrado!");
        }
    }
}
