package controller.handler;

import com.jfoenix.controls.JFXButton;
import controller.manager.ViewStorage;
import controller.view.MainViewController;
import models.Champion;

import java.util.*;

public class DecisionMaker
{
    LinkedList<JFXButton> m_ResultButtons;
    HashMap<JFXButton, Champion> m_ChampionMapping;
    LinkedHashMap<JFXButton, Champion> m_BannedChampions;
    LinkedList<Champion> m_ChampionList;

    public DecisionMaker(LinkedList<JFXButton> m_ResultButtons,
                         HashMap<JFXButton, Champion> m_ChampionMapping,
                         LinkedList<Champion> m_ChampionList,
                         LinkedHashMap<JFXButton, Champion> bans
                        )
    {
        this.m_ResultButtons = m_ResultButtons;
        this.m_ChampionMapping = m_ChampionMapping;
        this.m_ChampionList = m_ChampionList;
        this.m_BannedChampions = bans;
    }

    public void call()
    {
        var mc = (MainViewController) ViewStorage.getInstance().getMainViewFxmlLoader().getController();

        LinkedList<Champion> enemyChampions = new LinkedList<>();
        LinkedList<Champion> allyChampions = new LinkedList<>();

        LinkedList<Champion> bannedChampions = new LinkedList<>();

        for (Map.Entry<JFXButton, Champion> entry : m_BannedChampions.entrySet())
        {
            if (entry.getValue() != null)
            {
                bannedChampions.add(entry.getValue());
            }
        }

        allyChampions.add(m_ChampionMapping.get(mc.m_BlueTeamPickButton_1));
        allyChampions.add(m_ChampionMapping.get(mc.m_BlueTeamPickButton_2));
        allyChampions.add(m_ChampionMapping.get(mc.m_BlueTeamPickButton_3));
        allyChampions.add(m_ChampionMapping.get(mc.m_BlueTeamPickButton_4));
        allyChampions.add(m_ChampionMapping.get(mc.m_BlueTeamPickButton_5));

        enemyChampions.add(m_ChampionMapping.get(mc.m_RedTeamPickButton_1));
        enemyChampions.add(m_ChampionMapping.get(mc.m_RedTeamPickButton_2));
        enemyChampions.add(m_ChampionMapping.get(mc.m_RedTeamPickButton_3));
        enemyChampions.add(m_ChampionMapping.get(mc.m_RedTeamPickButton_4));
        enemyChampions.add(m_ChampionMapping.get(mc.m_RedTeamPickButton_5));

        HashMap<String, Integer> allyStyle = new HashMap<>();
        HashMap<String, Integer> enemyStyle = new HashMap<>();

        String targetAllyStyle = "teamfight";
        String targetEnemyStyle = "teamfight";

        for (var champ : allyChampions)
        {
            if (champ == null) continue;
            var x = (String) champ.data.get("type");
            allyStyle.putIfAbsent(x, 0);

            allyStyle.put(x, allyStyle.get(x) + 1);

        }
        for (var champ : enemyChampions)
        {
            if (champ == null) continue;
            var x = (String) champ.data.get("type");
            enemyStyle.putIfAbsent(x, 0);

            enemyStyle.put(x, enemyStyle.get(x) + 1);

        }

        // Buchal król!
        if (enemyStyle.getOrDefault("teamfight", 0) >= 2) { targetAllyStyle = "teamfight"; }
        else if (enemyStyle.getOrDefault("siege", 0) >= 2) {targetAllyStyle = "siege";}
        else if (enemyStyle.getOrDefault("pick", 0) >= 2) {targetAllyStyle = "pick";}
        else if (enemyStyle.getOrDefault("control", 0) >= 2) {targetAllyStyle = "control";}
        else if (enemyStyle.getOrDefault("splitpush", 0) >= 2) {targetAllyStyle = "splitpush";}

        if (enemyStyle.getOrDefault("teamfight", 0) >= 2) { targetEnemyStyle = "teamfight"; }
        else if (enemyStyle.getOrDefault("siege", 0) >= 2) {targetEnemyStyle = "siege";}
        else if (enemyStyle.getOrDefault("pick", 0) >= 2) {targetEnemyStyle = "pick";}
        else if (enemyStyle.getOrDefault("control", 0) >= 2) {targetEnemyStyle = "control";}
        else if (enemyStyle.getOrDefault("splitpush", 0) >= 2) {targetEnemyStyle = "splitpush";}

        var allyDesiredChampions = new LinkedList<Champion>();
        if (targetAllyStyle.compareTo("teamfight") == 0)
        {
            for (var champ : m_ChampionList)
            {
                if (((String) champ.data.get("type")).compareTo("teamfight") == 0)
                { allyDesiredChampions.add(champ); }
            }
        }
        if (targetAllyStyle.compareTo("siege") == 0)
        {
            for (var champ : m_ChampionList)
            {
                if (((String) champ.data.get("type")).compareTo("siege") == 0)
                { allyDesiredChampions.add(champ); }
            }
        }
        if (targetAllyStyle.compareTo("control") == 0)
        {
            for (var champ : m_ChampionList)
            {
                if (((String) champ.data.get("type")).compareTo("control") == 0)
                { allyDesiredChampions.add(champ); }
            }
        }
        if (targetAllyStyle.compareTo("splitpush") == 0)
        {
            for (var champ : m_ChampionList)
            {
                if (((String) champ.data.get("type")).compareTo("splitpush") == 0)
                { allyDesiredChampions.add(champ); }
            }
        }
        if (targetAllyStyle.compareTo("pick") == 0)
        {
            for (var champ : m_ChampionList)
            {
                if (((String) champ.data.get("type")).compareTo("pick") == 0)
                { allyDesiredChampions.add(champ); }
            }
        }

        var enemyDesiredChampions = new LinkedList<Champion>();
        if (targetEnemyStyle.compareTo("teamfight") == 0)
        {
            for (var champ : m_ChampionList)
            {
                if (((String) champ.data.get("type")).compareTo("pick") == 0 && ((String) champ.data.get("type"))
                        .compareTo("control") == 0)
                { enemyDesiredChampions.add(champ); }
            }
        }
        if (targetEnemyStyle.compareTo("siege") == 0)
        {
            for (var champ : m_ChampionList)
            {
                if (((String) champ.data.get("type")).compareTo("teamfight") == 0 && ((String) champ.data.get("type"))
                        .compareTo("pick") == 0)
                { enemyDesiredChampions.add(champ); }
            }
        }
        if (targetEnemyStyle.compareTo("control") == 0)
        {
            for (var champ : m_ChampionList)
            {
                if (((String) champ.data.get("type")).compareTo("splitpush") == 0 && ((String) champ.data.get("type"))
                        .compareTo("siege") == 0)
                { enemyDesiredChampions.add(champ); }
            }
        }
        if (targetEnemyStyle.compareTo("splitpush") == 0)
        {
            for (var champ : m_ChampionList)
            {
                if (((String) champ.data.get("type")).compareTo("siege") == 0 && ((String) champ.data.get("type"))
                        .compareTo("teamfight") == 0)
                { enemyDesiredChampions.add(champ); }
            }
        }
        if (targetEnemyStyle.compareTo("pick") == 0)
        {
            for (var champ : m_ChampionList)
            {
                if (((String) champ.data.get("type")).compareTo("splitpush") == 0 && ((String) champ.data.get("type"))
                        .compareTo("control") == 0)
                { enemyDesiredChampions.add(champ); }
            }
        }

        int i = 0;
        if (targetAllyStyle.compareTo(targetEnemyStyle) == 0)
        {
            for (var button : m_ResultButtons)
            {
                var size = button.getPrefWidth();
                var id = (String) allyDesiredChampions.get(i++).data.get("id");
                button.setStyle(
                        String.format(
                                "-fx-background-image: url(images/champions/%s.png);-fx-background-size: " + size +
                                        "px " + size + "px;"
                                , id)
                               );
            }
        }

        if (allyStyle.getOrDefault(targetAllyStyle, 0) >= enemyStyle.getOrDefault(targetEnemyStyle, 0))
        {
            for (var button : m_ResultButtons)
            {
                var size = button.getPrefWidth();
                var id = (String) allyDesiredChampions.get(i++).data.get("id");
                button.setStyle(
                        String.format(
                                "-fx-background-image: url(images/champions/%s.png);-fx-background-size: " + size +
                                        "px " + size + "px;"
                                , id)
                               );
            }
        }
        else
        {
            for (var button : m_ResultButtons)
            {
                var size = button.getPrefWidth();
                var id = (String) enemyDesiredChampions.get(i++).data.get("id");
                button.setStyle(
                        String.format(
                                "-fx-background-image: url(images/champions/%s.png);-fx-background-size: " + size +
                                        "px " + size + "px;"
                                , id)
                               ); ;
            }
        }
    }
}
