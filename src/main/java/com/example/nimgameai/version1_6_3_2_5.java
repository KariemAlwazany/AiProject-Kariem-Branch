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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import static com.example.nimgameai.NODE.alphabeta;
public class version1_6_3_2_5 implements Initializable {
    private ArrayList<ImageView> sticks = new ArrayList<>();
    @FXML
    private JFXRadioButton version1Easy1;
    @FXML
    private JFXRadioButton version1Medium1;
    @FXML
    private JFXRadioButton version1Hard1;
    @FXML
    private JFXComboBox<String> version1ComboBox1;
    @FXML
    private JFXButton playButton;
    @FXML
    private javafx.scene.layout.StackPane StackPane;
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
    @FXML
    private JFXButton playAgain;
    private Random random = new Random();
    Alert alert = new Alert(Alert.AlertType.ERROR);
    Alert info = new Alert(Alert.AlertType.INFORMATION);
    private ImageView[] stickss;
    List<ImageView> row;
    public List<List<ImageView>> rows;
    private int activeRowIndex = -1; // -1 indicates no row is currently active
     public NODE root;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        root =new NODE();
        for (ImageView stick : sticks) {
            root.children.add(new NODE(0, new ArrayList<>()));
        }
        ArrayList<String> values = new ArrayList<>();
        Collections.addAll(values, "6, 3, 2, 5");
        version1ComboBox1.getItems().addAll(values);
        sticks.add(stick_1);
        sticks.add(stick_2);
        sticks.add(stick_3);
        sticks.add(stick_4);
        sticks.add(stick_5);
        sticks.add(stick_6);
        sticks.add(stick_7);
        sticks.add(stick_8);
        sticks.add(stick_9);
        sticks.add(stick_10);
        sticks.add(stick_11);
        sticks.add(stick_12);
        sticks.add(stick_14);
        sticks.add(stick_15);
        sticks.add(stick_16);
        playAgain.setVisible(false);
        rows = new ArrayList<>();
        int[] sticksPerRow = {6, 3, 2, 5};
        for (int i = 0; i < sticksPerRow.length; i++)
        {
            row = new ArrayList<>();
        }
        row.add(stick_1);
        rows.add(row);              //first row
        row.add(stick_11);
        row.add(stick_10);
        row.add(stick_16);
        rows.add(row);              //second row
        row.add(stick_15);
        row.add(stick_9);
        row.add(stick_2);
        row.add(stick_4);
        row.add(stick_6);
        rows.add(row);              //third row
        row.add(stick_5);
        row.add(stick_3);
        row.add(stick_8);
        row.add(stick_7);
        row.add(stick_12);
        row.add(stick_14);
        row.add(stick_13);
        rows.add(row);
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
    private List<ImageView> getRemainingSticks() {
        List<ImageView> remaining = new ArrayList<>();
        for (ImageView stick : sticks) {
            if (stick.isVisible()) {
                remaining.add(stick);
            }
        }
        return remaining;
    }



    public void aiMoveEasy() {
        List<ImageView> selectedRow = selectRandomNonEmptyRow();
        if (selectedRow != null && !selectedRow.isEmpty()) {
            ImageView stick = selectedRow.get(selectedRow.size() - 1);
            removeStick(stick, rows.indexOf(selectedRow));
        }
    }
    private List<ImageView> selectRandomNonEmptyRow() {
        List<List<ImageView>> nonEmptyRows = new ArrayList<>();
        for (List<ImageView> row : rows) {
            if (!row.isEmpty()) {
                nonEmptyRows.add(row);
            }
        }
        return nonEmptyRows.isEmpty() ? null : nonEmptyRows.get(random.nextInt(nonEmptyRows.size()));
    }
    private void removeStick(ImageView stick, int rowIndex) {
        rows.get(rowIndex).remove(stick);
        stick.setVisible(false);
        if (rows.get(rowIndex).isEmpty()) {
            activeRowIndex = -1;
        }
    }
    private void delete(ImageView stick, int rowIndex) {
        if (activeRowIndex == -1 || activeRowIndex == rowIndex) {
            removeStick(stick, rowIndex);
            activeRowIndex = rowIndex; // Set or keep the row as active
        } else {
            errorMessage("You cant remove a stick from another row!");
        }
    }
    public boolean isGameOver() {
        return rows.stream().allMatch(List::isEmpty);
    }

    public void deleteStick1()
    {
        rows.get(0).remove(stick_1);
        stick_1.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick2()
    {
        rows.get(1).remove(stick_2);
        stick_2.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick3()
    {
        rows.get(3).remove(stick_3);
        stick_3.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick4()
    {
        rows.get(1).remove(stick_4);
        stick_4.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick5()
    {
        rows.get(3).remove(stick_5);
        stick_5.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick6()
    {
        rows.get(0).remove(stick_6);
        stick_6.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick7()
    {
        rows.get(3).remove(stick_7);
        stick_7.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick8()
    {
        rows.get(3).remove(stick_8);
        stick_8.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick9()
    {
        rows.get(1).remove(stick_9);
        stick_9.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick10()
    {
        rows.get(0).remove(stick_10);
        stick_10.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick11()
    {
        rows.get(0).remove(stick_11);
        stick_11.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick12()
    {
        rows.get(3).remove(stick_12);
        stick_12.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick13()
    {
        rows.get(2).remove(stick_13);
        stick_13.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick14()
    {
        rows.get(2).remove(stick_14);
        stick_14.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick15()
    {
        rows.get(0).remove(stick_15);
        stick_15.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }
    public void deleteStick16()
    {
        rows.get(0).remove(stick_16);
        stick_16.setVisible(false);
        if (isGameOver())
        {
            infoMessage("Ai Win!");
            playAgain.setVisible(true);
        }
    }



    public void aiMoveMedium() {
        List<ImageView> selectedRow = selectRowForMove();
        if (selectedRow != null && !selectedRow.isEmpty()) {
            int sticksToRemove = calculateSticksToRemove(selectedRow);
            for (int i = 0; i < sticksToRemove; i++) {
                ImageView stick = selectedRow.get(selectedRow.size() - 1);
                removeStick(stick, rows.indexOf(selectedRow));
            }
        }
    }

    private List<ImageView> selectRowForMove() {
        // Strategy to select a row for an intelligent move
        // For example, prioritizing rows with an odd number of sticks
        List<List<ImageView>> potentialRows = new ArrayList<>();
        for (List<ImageView> row : rows) {
            if (!row.isEmpty()) {
                potentialRows.add(row);
            }
        }

        if (!potentialRows.isEmpty()) {
            return potentialRows.get(random.nextInt(potentialRows.size()));
        }
        return null;
    }

    private int calculateSticksToRemove(List<ImageView> row) {
        // Intelligent calculation of sticks to remove
        // For example, if the row has an odd number of sticks, remove one to make it even
        return row.size() % 2 != 0 ? 1 : random.nextInt(row.size() / 2) + 1;
    }

    public void removeStick(ImageView stick)
    {
        stick.setVisible(false);
    }
    private void removeSticks(double result, NODE root, ArrayList<ImageView> sticks) {
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
    public void play() {
        if (version1Easy1.isSelected()) {
            if (version1ComboBox1.getValue().equalsIgnoreCase("6, 3, 2, 5")) {
                playButton.setText("Let Ai play");
                if (version1Ai.isSelected())
                {
                    aiMoveEasy();
                    if(isGameOver()) {
                        infoMessage("You Win");
                        playAgain.setVisible(true);
                    }
                }
                else if(version1Me.isSelected())
                {

                }
            }
        }
        if (version1Medium1.isSelected()) {
            if (version1ComboBox1.getValue().equalsIgnoreCase("6, 3, 2, 5")) {
                playButton.setText("Let Ai play");
                if (version1Ai.isSelected())
                {
                    aiMoveMedium();
                    if(isGameOver()) {
                        infoMessage("You Win");
                        playAgain.setVisible(true);
                    }
                }
                else if(version1Me.isSelected())
                {

                }
            }
        }

        if (version1Hard1.isSelected()) {
            if (sticks != null && sticks.size() > 0) {
                if (version1Ai.isSelected())
                {
                    NODE root = new NODE(0, new ArrayList<>());
                    for (ImageView stick : sticks) {
                        root.children.add(new NODE(0, new ArrayList<>()));
                    }
                    int depth = 4;
                    double result = alphabeta(root, depth, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, true);
                    removeSticks(result, root, sticks);
                }
                else if(version1Me.isSelected()){}
            }
            else if(sticks.size() ==0)
                infoMessage("Ai Win");
        }
    }
    public void playAgain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Version1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        new FadeIn(root).play();
    }
}
