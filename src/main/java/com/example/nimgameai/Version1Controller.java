package com.example.nimgameai;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import animatefx.animation.FadeIn;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import static com.example.nimgameai.NODE.alphabeta;

public class Version1Controller implements Initializable {
    @FXML
    private JFXRadioButton version1Easy;
    @FXML
    private JFXRadioButton version1Medium;
    @FXML
    private JFXRadioButton version1Hard;
    @FXML
    private JFXComboBox<String> version1ComboBox1;
    @FXML
    private JFXButton playButton;
    @FXML
    private StackPane StackPane;
    private Scene scene;
    private Stage stage;
    @FXML
    private JFXRadioButton version1Ai;
    @FXML
    private JFXRadioButton version1Me;
    @FXML
    private ImageView stick_1;

    @FXML
    private ImageView stick_10;

    @FXML
    private ImageView stick_11;

    @FXML
    private ImageView stick_12;

    @FXML
    private ImageView stick_13;

    @FXML
    private ImageView stick_14;

    @FXML
    private ImageView stick_15;

    @FXML
    private ImageView stick_16;

    @FXML
    private ImageView stick_2;

    @FXML
    private ImageView stick_3;

    @FXML
    private ImageView stick_4;

    @FXML
    private ImageView stick_5;

    @FXML
    private ImageView stick_6;

    @FXML
    private ImageView stick_7;

    @FXML
    private ImageView stick_8;

    @FXML
    private ImageView stick_9;

    Alert alert = new Alert(AlertType.ERROR);
    private ImageView[] sticks;
    private Random random = new Random();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ArrayList<String> values = new ArrayList<>();
        Collections.addAll(values, "1, 3, 5, 7", "6, 3, 2, 5", "5, 4, 2, 5");
        version1ComboBox1.getItems().addAll(values);
    }
    public void home(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("welcomeInterface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new FadeIn(root).play();
    }
    public void close(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("selectVersion.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.close();
    }
    public void openSelectVersion(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("selectVersion.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new FadeIn(root).play();
    }
    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Version1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new FadeIn(root).play();
    }
    public void Choice() throws IOException
    {
        if(version1ComboBox1.getValue().equalsIgnoreCase("5, 4, 2, 5"))
         {
             Parent root = FXMLLoader.load(getClass().getResource("version1_5_4_2_5.fxml"));
             StackPane.getChildren().removeAll();
             StackPane.getChildren().setAll(root);
             new FadeIn(root).play();
         }
        if(version1ComboBox1.getValue().equalsIgnoreCase("6, 3, 2, 5"))
        {
            Parent root = FXMLLoader.load(getClass().getResource("version1_6_3_2_5.fxml"));
            StackPane.getChildren().removeAll();
            StackPane.getChildren().setAll(root);
            new FadeIn(root).play();
        }
        if(version1ComboBox1.getValue().equalsIgnoreCase("1, 3, 5, 7"))
        {
            Parent root = FXMLLoader.load(getClass().getResource("version1_1_3_5_7.fxml"));
            StackPane.getChildren().removeAll();
            StackPane.getChildren().setAll(root);
            new FadeIn(root).play();
        }
    }
    private void removeSticks ( double result, NODE root, ImageView[]sticks){
        List<ImageView> remainingSticks = getRemainingSticks();
        int moveIndex = -1;
        double bestValue = (root.children.get(0)).value;
        for (int i = 1; i < root.children.size(); i++) {
            double childValue = (root.children.get(i)).value;
            if (result == childValue) {
                moveIndex = i - 1;
                break;
            }
        }
        if (moveIndex >= 0 && moveIndex < remainingSticks.size()) {
            ImageView selectedStick = remainingSticks.get(moveIndex);
            removeStick(selectedStick);
        }
    }
    public void errorMessage(String message)
    {
        alert.setTitle("Error");
        alert.setHeaderText("Something went wrong");
        alert.setContentText(message);
        alert.showAndWait();
    }
    private List<ImageView> getRemainingSticks() {
        List<ImageView> remaining = new ArrayList<>();
        for (ImageView stick : sticks) {
            if (stick.isVisible()) {
                remaining.add(stick);
            }
        }
        return remaining;
    }
    public void rules(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Rules.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new FadeIn(root).play();
    }




    private void removeStick(ImageView stick)
    {
        stick.setVisible(false);
    }

}