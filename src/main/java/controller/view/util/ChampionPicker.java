package controller.view.util;

import com.jfoenix.controls.JFXMasonryPane;
import com.jfoenix.controls.JFXTextField;
import controller.manager.ViewStorage;
import controller.view.MainViewController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    }
}
