import controller.manager.ViewStorage;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Main
        extends Application
{
    // static FXMLLoader MainFXMLLoader = new FXMLLoader();

    @Override
    public void start(Stage primaryStage)
    {
        ViewStorage.getInstance().initialise(primaryStage);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}