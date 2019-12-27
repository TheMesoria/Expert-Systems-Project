package controller.view.util;

import com.jfoenix.controls.JFXMasonryPane;
import com.jfoenix.controls.JFXTextField;
import controller.manager.ViewStorage;
import controller.view.MainViewController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ChampionPicker
        implements Initializable
{
    @FXML private BorderPane m_ChooseChampionBox;
    @FXML private JFXTextField m_ChampionNameTextBox;
    @FXML private JFXMasonryPane m_ChampionPool;

    @Override public void initialize(URL url,
                                     ResourceBundle resourceBundle)
    {
        var image = new Image("file:/home/black/Work/code/college/Expert-Systems-Project/src/main/resources/images" +
                "/champions/Aatrox.png");

        var imageView = new ImageView(
                image
        );

        imageView.setScaleX(0.5);
        imageView.setScaleY(0.5);

        m_ChampionPool.getChildren().add(
                imageView
                );

        m_ChampionNameTextBox.focusedProperty().addListener(
                new ChangeListener<Boolean>() {
                    @Override public void changed(ObservableValue<? extends Boolean> observableValue,
                                                  Boolean oldValue,
                                                  Boolean newValue)
                    {
                        if(newValue)
                        {
                            m_ChampionNameTextBox.clear();
                        }
                    }
                }
                                                           );
    }

    public void clearChampionNameTextBox()
    {
        // m_ChampionNameTextBox.clear();
    }
}
