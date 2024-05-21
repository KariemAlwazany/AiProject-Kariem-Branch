package com.example.nimgameai;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import animatefx.animation.FadeIn;
import java.io.IOException;
import java.net.URL;
import java.util.*;
public class Version2Controller implements Initializable {
    @FXML
    private StackPane StackPane;
    @FXML
    private JFXComboBox<String> version2ComboBox;
    private Scene scene;
    private Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> values = new ArrayList<>();
        Collections.addAll(values, "8", "10", "12");
        version2ComboBox.getItems().addAll(values);
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
    public void openSelectVersion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("selectVersion.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new FadeIn(root).play();
    }
    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Version2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new FadeIn(root).play();
    }
    public void rules(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new FadeIn(root).play();
    }
    public void sticks() throws IOException
    {
        if (version2ComboBox.getValue().equalsIgnoreCase("8"))
        {
            Parent root = FXMLLoader.load(getClass().getResource("Version2-8.fxml"));
            StackPane.getChildren().removeAll();
            StackPane.getChildren().setAll(root);
            new FadeIn(root).play();
        }
        if (version2ComboBox.getValue().equalsIgnoreCase("10"))
        {
            Parent root = FXMLLoader.load(getClass().getResource("Version2-10.fxml"));
            StackPane.getChildren().removeAll();
            StackPane.getChildren().setAll(root);
            new FadeIn(root).play();
        }
        if (version2ComboBox.getValue().equalsIgnoreCase("12"))
        {
            Parent root = FXMLLoader.load(getClass().getResource("Version2-12.fxml"));
            StackPane.getChildren().removeAll();
            StackPane.getChildren().setAll(root);
            new FadeIn(root).play();
        }
    }
}
