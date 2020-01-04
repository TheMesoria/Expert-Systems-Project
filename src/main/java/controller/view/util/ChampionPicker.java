package controller.view.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import models.Champion;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ChampionPicker
        implements Initializable
{
    @FXML private BorderPane m_ChooseChampionBox;
    @FXML private TextField m_ChampionSearchBox;
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

        onSearchEntry(null);
    }

    @FXML private void onSearchEntry(KeyEvent keyEvent)
    {
        m_ChampionPool.getChildren().clear();

        for (var champ : m_Champions)
        {
            if (m_ChampionSearchBox.getText().equals(""))
            {
                m_ChampionPool.getChildren().add(champ.jfxButton);
                continue;
            }

            var out = FuzzySearch.partialRatio(m_ChampionSearchBox.getText(), (String) champ.data.get("name"));

            System.out.println("For \"" + champ.data.get("name") + "\" we got: " + out + ".");

            if (out >= 50)
            {
                System.out.println("For \"" + champ.data.get("name") + "\" we got: " + out + ".");

                m_ChampionPool.getChildren().add(champ.jfxButton);
            }

        }
    }
}
