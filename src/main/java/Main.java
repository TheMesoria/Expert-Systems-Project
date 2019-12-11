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
        try
        {
            var root = (Parent) FXMLLoader.load(getClass().getResource("view/MainView.fxml"));

            var scene = new Scene(root, 1000, 800);
            scene.getStylesheets().add(getClass().getResource("styles/Dark.css").toExternalForm());

            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e)
        {
            System.out.println("Exception happened: " + e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}