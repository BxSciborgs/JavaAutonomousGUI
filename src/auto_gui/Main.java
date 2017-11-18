package auto_gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        stage.setTitle("SciBorgs Java Autonomous GUI - Version 0.2.0");
        stage.setScene(new Scene(controller));
        stage.setResizable(false);
        stage.getIcons().add(new Image("auto_gui/resources/SciBorgs.png"));
        stage.toFront();
        stage.show();
    }
}
