module com.example.nimgameai {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires AnimateFX;

    opens com.example.nimgameai to javafx.fxml;
    exports com.example.nimgameai;
}