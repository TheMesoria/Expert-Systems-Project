package controller.view.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfoenix.controls.JFXMasonryPane;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import models.Champion;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ChampionPicker
        implements Initializable
{
    @FXML private BorderPane m_ChooseChampionBox;
    // @FXML private JFXTextField m_ChampionNameTextBox;
    @FXML private FlowPane m_ChampionPool;

    private LinkedList<Champion> m_Champions = new LinkedList<>();

    @Override public void initialize(URL url,
                                     ResourceBundle resourceBundle)
    {
        try
        {
            ArrayList<LinkedHashMap<String, Object>> input =
                    new ObjectMapper().readValue(getClass().getResource("/data/list.json"),
                            new TypeReference<ArrayList<LinkedHashMap<String, Object>>>() {});

            // m_ChampionPool.s

            System.out.println(input.getClass().getSimpleName());
            for (var champion : input)
            {
                m_Champions.add(new Champion(champion));
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // m_ChampionNameTextBox.focusedProperty().addListener(
        //         (observableValue, oldValue, newValue) ->
        //         {
        //             if (newValue) { m_ChampionNameTextBox.clear(); }
        //         }
        //                                                    );
    }

    public void addAll()
    {
        for(var champ : m_Champions)
        {
            m_ChampionPool.getChildren().add(champ.jfxButton);

        }

        // m_ChampionPool.setStyle("-fx-background-color: gray");
        // for (int i = 0; i < 10; i++)
        // {
        //     m_ChampionPool.getChildren().add(new Button(String.valueOf(i)));
        // }
        // System.out.println(m_ChampionPool.getAlignment());
    }
}
