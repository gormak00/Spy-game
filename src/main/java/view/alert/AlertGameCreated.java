package view.alert;

import javafx.scene.control.Alert;

public class AlertGameCreated {
    public AlertGameCreated(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");
        alert.setHeaderText("Поздравляю:");
        alert.setContentText("Ваша игра создана!");

        alert.showAndWait();
    }
}
