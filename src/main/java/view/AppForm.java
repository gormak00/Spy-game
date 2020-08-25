package view;

import controller.GameController;
import javafx.application.HostServices;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import sample.Main;
import view.alert.AlertGameCreated;
import view.alert.AlertIncorrectValue;

import java.io.File;

public class AppForm {
    private Label numberOfPlayersLabel, pathLabel, projectPathLable, pathExampleLable;
    private Button startGameButton, rulesButton;
    private TextField numberOfPlayersField, pathField;
    private CheckBox projectPathCheckBox;

    private GameController gameController;

    public Scene getMainScene(Main main){
        BorderPane pane = new BorderPane();

        pane.setTop(getTitlePane());
        pane.setCenter(getMainPane());
        pane.setBottom(getBottomPane());
        Scene scene = new Scene(pane, 800, 450);
        action(main);
        return scene;
    }

    private Pane getTitlePane(){
        Pane pane = new Pane();
        Text titleText = new Text("Добро пожаловать в игру, где необходимо найти шпиона!");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titleText.setLayoutX(50.0);
        titleText.setLayoutY(50.0);
        pane.getChildren().add(titleText);
        return pane;
    }

    private Pane getMainPane(){
        Pane mainPane = new Pane();
        numberOfPlayersLabel = new Label("Введите колличество игроков");
        setLayoutLabel( 50.0, 100.0,150.0, numberOfPlayersLabel, mainPane);
        numberOfPlayersField = new TextField();
        setLayoutTextField(300.0, 100.0, 50.0, numberOfPlayersField, mainPane);
        pathLabel = new Label("Введите место, где сохранить");
        setLayoutLabel( 50.0, 150.0,150.0, pathLabel, mainPane);
        pathField = new TextField();
        setLayoutTextField(300.0, 150.0, 50.0, pathField, mainPane);
        pathExampleLable = new Label("Пример: /home/asus/Downloads/");
        pathExampleLable.setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, 10));
        setLayoutLabel( 50.0, 180.0,150.0, pathExampleLable, mainPane);
        projectPathCheckBox = new CheckBox();
        setLayoutCheckBox(300.0, 180.0, 20.0, projectPathCheckBox, mainPane);
        projectPathLable = new Label("Сохранить в папке проекта");
        setLayoutLabel( 330.0, 180.0,100.0, projectPathLable, mainPane);
        startGameButton = new Button("Создать игру");
        setLayoutButton(300.0, 230.0,100.0, startGameButton, mainPane);
        return mainPane;
    }

    private Pane getBottomPane(){
        Pane pane = new Pane();
        rulesButton = new Button("Правила игры");
        setLayoutButton(50.0, 100.0,100.0, rulesButton, pane);
        return pane;
    }

    private void setLayoutLabel(Double layoutX, Double layoutY, Double maxWidth, Label label, Pane pane){
        label.setLayoutX(layoutX);
        label.setLayoutY(layoutY);
        label.maxWidth(maxWidth);
        pane.getChildren().add(label);
    }

    private void setLayoutButton(Double layoutX, Double layoutY, Double maxWidth, Button button, Pane pane){
        button.setLayoutX(layoutX);
        button.setLayoutY(layoutY);
        button.maxWidth(maxWidth);
        pane.getChildren().add(button);
    }

    private void setLayoutTextField(Double layoutX, Double layoutY, Double maxWidth, TextField textField, Pane pane){
        textField.setLayoutX(layoutX);
        textField.setLayoutY(layoutY);
        textField.maxWidth(maxWidth);
        pane.getChildren().add(textField);
    }

    private void setLayoutCheckBox(Double layoutX, Double layoutY, Double maxWidth, CheckBox checkBox, Pane pane){
        checkBox.setLayoutX(layoutX);
        checkBox.setLayoutY(layoutY);
        checkBox.maxWidth(maxWidth);
        pane.getChildren().add(checkBox);
    }

    private void action(Main main){
        startGameButton.setOnAction(t -> {
            if (numberOfPlayersField.getText().isEmpty() || (!pathField.getText().isEmpty() && !projectPathCheckBox.isSelected())){
                new AlertIncorrectValue();
            } else {
                String path;
                gameController = new GameController();
                if (projectPathCheckBox.isSelected()) {
                    path = "./Files/";
                } else path = pathField.getText();
                gameController.createGame(Integer.parseInt(numberOfPlayersField.getText()), path);
                new AlertGameCreated();
            }
        });

        rulesButton.setOnAction(t -> {
            File file = new File("./src/main/resources/rules_spy_game.pdf");
            HostServices hostServices = main.getHostServices();
            hostServices.showDocument(file.getAbsolutePath());
        });
    }
}
