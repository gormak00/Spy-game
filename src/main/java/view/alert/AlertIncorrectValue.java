package view.alert;

import javafx.scene.control.Alert;

public class AlertIncorrectValue {
    public AlertIncorrectValue(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Alert!");
        alert.setHeaderText("Ошибка:");
        alert.setContentText("Не указано количество играющих или \nне указан путь, где сохранить файлы");

        alert.showAndWait();
    }
}
