package com.example.nimgameai;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import animatefx.animation.FadeIn;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class WelcomeInterfaceController {
    SelectVersionController obj = new SelectVersionController();
    private Scene scene;
    private Stage stage;
    Alert alert = new Alert(AlertType.ERROR);
    public void openSelectVersion(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("selectVersion.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            new FadeIn(root).play();
        }
    public void errorMessage(String message)
    {
        alert.setTitle("Error");
        alert.setHeaderText("Something went wrong");
        alert.setContentText(message);
        alert.showAndWait();
    }
}