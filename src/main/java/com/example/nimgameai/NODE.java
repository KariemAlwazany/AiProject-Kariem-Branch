package com.example.nimgameai;
import animatefx.animation.FadeInLeft;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
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
public class NODE
{
            int value;
            List<NODE> children;
            boolean leaf;
            public NODE(int value, List<NODE> children) {
                this.value = value;
                this.children = children;
                this.leaf = false;
            }
    public NODE() {

    }
    static version1_6_3_2_5 obj = new version1_6_3_2_5();

    public NODE(int nimSum, List<Integer> tempList, boolean isLeaf) {
    }

    static double alphabeta(NODE node, int depth, double a, double B, boolean maximizingPlayer) {
                if (depth == 0 || isTerminal(node)) {
                    return evaluate(node);
                }

                if (maximizingPlayer) {
                    double v = Double.NEGATIVE_INFINITY;

                    for (NODE child : node.children) {
                        v = Math.max(v, alphabeta(child, depth - 1, a, B, false));
                        a = Math.max(a, v);
                        if (B <= a) {
                            break; // B cut-off
                        }
                    }

                    return v;
                } else {
                    double v = Double.POSITIVE_INFINITY;

                    for (NODE child : node.children) {
                        v = Math.min(v, alphabeta(child, depth - 1, a, B, true));
                        B = Math.min(B, v);

                        if (B <= a) {
                            break; // a cut-off
                        }
                    }

                    return v;
                }
            }

            static boolean isTerminal(NODE node) {
                return node.children.isEmpty() || node.value == 1;
            }
            static double evaluate(NODE node) {
                double value = 0;

                if (node.value == 1) {
                    value += 100;
                } else {

                    value -= 0;
                }
                return value;
            }
            static int sticksNumber(int index) {
                int sum = 0;
                for (int i = 0; i < obj.rows.size(); i++) {
                    for (int j = 0; j < obj.rows.get(index).size(); j++) {
                        sum++;
                    }
                    return sum;
                }
                return 0;
            }

}


