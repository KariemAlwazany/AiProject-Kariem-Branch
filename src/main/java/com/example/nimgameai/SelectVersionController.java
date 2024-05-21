package com.example.nimgameai;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import animatefx.animation.FadeIn;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class SelectVersionController implements Initializable{
    @FXML
    private Label welcomeMessage;
    private Scene scene;
    private Stage stage;
    @FXML
    private JFXButton rules;
    @FXML
    private StackPane stackpane;
    public void openVersion1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("version1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new FadeIn(root).play();
    }
    public void openVersion2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("version2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new FadeIn(root).play();
    }
    public void home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("welcomeInterface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new FadeIn(root).play();
    }
    public void close(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("selectVersion.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.close();
    }
    public void rules(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new FadeIn(root).play();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeMessage.setText("         Welcome  \n     please choose \n   a version to play");
    }
}
