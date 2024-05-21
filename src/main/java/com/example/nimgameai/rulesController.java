package com.example.nimgameai;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class rulesController implements Initializable {
    private Scene scene;
    private Stage stage;
    public void selectVerison(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("selectVersion.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new FadeIn(root).play();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void close(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("selectVersion.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.close();
    }
    public void home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("welcomeInterface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new FadeIn(root).play();
    }
}
