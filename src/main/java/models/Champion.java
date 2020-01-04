package models;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.LinkedHashMap;

public class Champion
{
    public LinkedHashMap<String, Object> data;
    public LinkedHashMap<String, String> stats;

    public JFXButton jfxButton;
    public ImageView avatar;

    public Champion(LinkedHashMap<String, Object> data)
    {
        this.data = data;

        this.stats = (LinkedHashMap<String, String>) data.get("stats");
        System.out.println(data.get("id"));
        avatar =
                new ImageView(new Image(getClass().getResource("/images/champions/" + data.get("id") + ".png")
                                                  .toString()));

        avatar.setFitHeight(50);
        avatar.setFitWidth(50);

        jfxButton = new JFXButton("", avatar);

        jfxButton.setOnMouseClicked(e ->
                System.out.println(data.get("description")));
    }
}
