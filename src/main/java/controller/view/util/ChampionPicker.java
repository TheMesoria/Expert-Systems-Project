package controller.view.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfoenix.controls.JFXMasonryPane;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChampionPicker
        implements Initializable
{
    @FXML private BorderPane m_ChooseChampionBox;
    @FXML private JFXTextField m_ChampionNameTextBox;
    @FXML private JFXMasonryPane m_ChampionPool;

    private ArrayList<Object> m_Champions;

    @Override public void initialize(URL url,
                                     ResourceBundle resourceBundle)
    {
        try
        {
            m_Champions =
                    new ObjectMapper().readValue(getClass().getResource("/data/list.json"), new TypeReference<>() {});

            System.out.println(m_Champions.get(0).getClass().getSimpleName());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        m_ChampionNameTextBox.focusedProperty().addListener(
                (observableValue, oldValue, newValue) ->
                {
                    if (newValue) { m_ChampionNameTextBox.clear(); }
                }
                                                           );
    }

    public void clearChampionNameTextBox()
    {
        // m_ChampionNameTextBox.clear();
    }
}
