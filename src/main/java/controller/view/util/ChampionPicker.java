package controller.view.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfoenix.controls.JFXButton;
import controller.manager.ViewStorage;
import controller.view.MainViewController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
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

    public JFXButton m_ActiveButton;

    private LinkedList<Champion> m_Champions = new LinkedList<>();
    private LinkedList<Champion> m_ChampionsCache;

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
                m_ChampionPool.getChildren().add(m_Champions.getLast().jfxButton);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML private void onSearchEntry(KeyEvent keyEvent)
    {
        if (keyEvent.getCode() == KeyCode.ENTER)
        {
            if (m_ChampionsCache.size() != 0)
            {
                var cm = (MainViewController) ViewStorage.getInstance().getMainViewFxmlLoader().getController();

                cm.m_ChampionMap.put(cm.m_LastRequestedButton, m_ChampionsCache.getFirst());
                cm.m_LastRequestedButton.setBackground(
                        new Background(new BackgroundImage(
                                m_ChampionsCache.getFirst().avatar
                                , BackgroundRepeat.NO_REPEAT
                                , BackgroundRepeat.NO_REPEAT
                                , BackgroundPosition.DEFAULT
                                , BackgroundSize.DEFAULT
                        )));
            }
        }
        else
        {
            m_ChampionPool.getChildren().clear();

            m_ChampionsCache = getChampions();
        }
    }

    private LinkedList<Champion> getChampions()
    {
        var returnList = new LinkedList<Champion>();

        for (var champ : m_Champions)
        {
            if (m_ChampionSearchBox.getText().equals(""))
            {
                m_ChampionPool.getChildren().add(champ.jfxButton);
                continue;
            }

            var currentString = m_ChampionSearchBox.getText().toLowerCase();
            var champName = ((String) champ.data.get("name")).toLowerCase();

            if (currentString.length() > champName.length())
            {
                continue;
            }

            var match = true;
            for (var i = 0; i < currentString.length(); i++)
            {
                if (currentString.charAt(i) != champName.charAt(i))
                {
                    match = false;
                    break;
                }
            }

            if (!match)
            {
                continue;
            }

            m_ChampionPool.getChildren().add(champ.jfxButton);
            returnList.add(champ);
        }
        return returnList;
    }
}
