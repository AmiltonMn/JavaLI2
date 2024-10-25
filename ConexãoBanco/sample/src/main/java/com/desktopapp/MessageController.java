package com.desktopapp;

import java.net.URL;

import com.desktopapp.model.Produto;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class MessageController {

    public static Scene CreateScene(String message) throws Exception
    {
        URL sceneUrl = MessageController.class
            .getResource("MessageScene.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        MessageController controller = loader.getController();

        controller.messageLabel.setText(message);

        return scene;
    }

    @FXML
    private Text messageLabel;
}
