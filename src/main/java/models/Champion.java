package models;

import javafx.scene.image.Image;

import java.util.LinkedHashMap;

public class Champion
{
    LinkedHashMap<String, Object> data;
    LinkedHashMap<String, String> stats;

    Image avatar;

    public Champion(LinkedHashMap<String, Object> data)
    {
        this.data = data;

        this.stats = (LinkedHashMap<String, String>) data.get("stats");
        System.out.println(data.get("id"));
        avatar = new Image(getClass().getResource("/images/champions/" + data.get("id") + ".png").toString());
    }
}
