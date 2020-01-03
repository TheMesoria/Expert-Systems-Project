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

        avatar.setScaleX(0.2);
        avatar.setScaleY(0.2);

        jfxButton = new JFXButton("", avatar);
        jfxButton.setPrefSize(25, 25);
        jfxButton.setMinSize(25,25);
        jfxButton.setMaxSize(25,25);

        jfxButton.setOnMouseClicked(e ->
                System.out.println(data.get("description")));
    }
}
