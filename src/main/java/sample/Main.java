package sample;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import view.AppForm;

public class Main extends Application {
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AppForm appForm = new AppForm();
        stage.setTitle("Spy-game");
        stage.getIcons().add(new Image("spy_icon.png"));
        stage.setScene(appForm.getMainScene(this));
        stage.setResizable(false);
        stage.show();
    }
}
