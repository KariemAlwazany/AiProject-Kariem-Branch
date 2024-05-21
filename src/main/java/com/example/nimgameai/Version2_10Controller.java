package com.example.nimgameai;
import animatefx.animation.FadeIn;
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
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.*;
public class Version2_10Controller implements Initializable {
    @FXML
    private JFXButton playButton;
    @FXML
    private ImageView stick10_10;
    @FXML
    private ImageView stick1_10;
    @FXML
    private ImageView stick2_10;
    @FXML
    private ImageView stick3_10;
    @FXML
    private ImageView stick4_10;
    @FXML
    private ImageView stick5_10;
    @FXML
    private ImageView stick6_10;
    @FXML
    private ImageView stick7_10;
    @FXML
    private ImageView stick8_10;
    @FXML
    private ImageView stick9_10;
    @FXML
    private JFXRadioButton version2Ai1;
    @FXML
    private JFXComboBox<String> version2ComboBox;
    @FXML
    private JFXRadioButton version2Easy1;
    @FXML
    private JFXRadioButton version2Hard1;
    @FXML
    private JFXRadioButton version2Me1;
    @FXML
    private JFXRadioButton version2Medium1;
    private ArrayList<ImageView> sticks = new ArrayList<>();
    List<ImageView> remainingSticks;
    @FXML
    private JFXButton playAgain;
    private Random random = new Random();
    Alert alert = new Alert(Alert.AlertType.ERROR);
    Alert info = new Alert(Alert.AlertType.INFORMATION);
    private Scene scene;
    private Stage stage;
    int maxRemove = 5;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> values = new ArrayList<>();
        Collections.addAll(values, "10");
        version2ComboBox.getItems().addAll(values);
        sticks.add(stick1_10);
        sticks.add(stick2_10);
        sticks.add(stick3_10);
        sticks.add(stick4_10);
        sticks.add(stick5_10);
        sticks.add(stick6_10);
        sticks.add(stick7_10);
        sticks.add(stick8_10);
        sticks.add(stick9_10);
        sticks.add(stick10_10);
        playAgain.setVisible(false);
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
    private void removeStick(ImageView stick) {
        stick.setVisible(false);
    }
    public void errorMessage(String message)
    {
        alert.setTitle("Error");
        alert.setHeaderText("Something went wrong");
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void infoMessage(String message)
    {
        info.setHeaderText(message);
        info.showAndWait();
    }
    public void deleteStick1()
    {
        sticks.remove(stick1_10);
        stick1_10.setVisible(false);
        if (sticks.isEmpty())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick2()
    {
        sticks.remove(stick2_10);
        stick2_10.setVisible(false);
        if (sticks.isEmpty())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick3()
    {
        sticks.remove(stick3_10);
        stick3_10.setVisible(false);
        if (sticks.isEmpty())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick4()
    {
        sticks.remove(stick4_10);
        stick4_10.setVisible(false);
        if (sticks.isEmpty())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick5()
    {
        sticks.remove(stick5_10);
        stick5_10.setVisible(false);
        if (sticks.isEmpty())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick6()
    {
        sticks.remove(stick6_10);
        stick6_10.setVisible(false);
        if (sticks.isEmpty())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick7()
    {
        sticks.remove(stick7_10);
        stick7_10.setVisible(false);
        if (sticks.isEmpty())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick8()
    {
        sticks.remove(stick8_10);
        stick8_10.setVisible(false);
        if (sticks.isEmpty())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick9()
    {
        sticks.remove(stick9_10);
        stick9_10.setVisible(false);
        if (sticks.isEmpty())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick10()
    {
        sticks.remove(stick10_10);
        stick8_10.setVisible(false);
        if (sticks.isEmpty())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void playAgain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Version2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        new FadeIn(root).play();
    }
    public int calculateSticksToRemove(int totalSticks, int maxRemove) {
        if (totalSticks % 2 == 0) {
            if(sticks.size() == 8)
                return 3;
            if(sticks.size() == 6)
                return 2;
            if(sticks.size()==3)
                return 3;
            if(sticks.size()==1)
                return 1;
            return 1;
        } else {
            return random.nextInt(maxRemove);
        }
    }
    public void botTurn() {
        int sticksToRemove = calculateSticksToRemove(sticks.size(), maxRemove);
        removeSticksMedium(sticksToRemove);
    }
    private void removeSticksMedium(int numberOfSticks) {
        for (int i = 0; i < numberOfSticks; i++) {
            if (!sticks.isEmpty()) {
                ImageView stick = sticks.remove(sticks.size() - 1);
                stick.setVisible(false);
            }
        }
    }
    public void play() throws IOException {
        if (version2Easy1.isSelected()) {
            if (version2ComboBox.getValue().equalsIgnoreCase("10"))
            {
                playButton.setText("Let Ai play");
                remainingSticks = getRemainingSticks();
                if (version2Ai1.isSelected())
                {
                    if (!sticks.isEmpty())
                    {
                        int index = random.nextInt(remainingSticks.size());
                        ImageView selectedStick = remainingSticks.get(index);
                        removeStick(selectedStick);
                        sticks.remove(selectedStick);
                        if(sticks.isEmpty()) {
                            infoMessage("You win!");
                            playAgain.setVisible(true);
                        }
                    }
                }
                else if(version2Me1.isSelected())
                {
                    if(sticks.size() == 9)
                        errorMessage("its your turn!");
                    if(sticks.size()<9)
                    {
                        playButton.setText("Let Ai play");
                        remainingSticks = getRemainingSticks();
                        if (!sticks.isEmpty())
                        {
                            int index = random.nextInt(remainingSticks.size());
                            ImageView selectedStick = remainingSticks.get(index);
                            removeStick(selectedStick);
                            remainingSticks.remove(selectedStick);
                            if(sticks.isEmpty())
                            {
                                infoMessage("Ai win!");
                                playAgain.setVisible(true);
                            }
                        }
                    }
                }
            }
        }
        if (version2Medium1.isSelected())
        {
            if (version2ComboBox.getValue().equalsIgnoreCase("10"))
            {
                playButton.setText("Let Ai play");
                if (version2Ai1.isSelected())
                {
                    if (!sticks.isEmpty())
                    {
                        botTurn();
                        if(sticks.isEmpty())
                        {
                            infoMessage("You win!");
                            playAgain.setVisible(true);
                        }
                    }
                }
                else if(version2Me1.isSelected())
                {
                    if(sticks.size() == 9)
                        errorMessage("its your turn!");
                    if(sticks.size()<9)
                    {
                        playButton.setText("Let Ai play");
                        if (!sticks.isEmpty())
                        {
                            botTurn();
                            if(sticks.isEmpty())
                            {
                                infoMessage("You win!");
                                playAgain.setVisible(true);
                            }
                        }
                    }
                }
            }
        }
        if (version2Hard1.isSelected())
        {
        }
    }
}
