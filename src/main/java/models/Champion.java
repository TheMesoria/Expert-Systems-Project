package models;

import com.jfoenix.controls.JFXButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URI;
import java.net.URL;
import java.util.LinkedHashMap;

public class Champion
{
    public LinkedHashMap<String, Object> data;
    public LinkedHashMap<String, String> stats;

    public JFXButton jfxButton;
    public URL avatarPath;
    public Image avatar;
    public ImageView avatarView;

    public Champion(LinkedHashMap<String, Object> data)
    {
        this.data = data;

        this.stats = (LinkedHashMap<String, String>) data.get("stats");

        avatarPath = getClass().getResource("/images/champions/" + data.get("id") + ".png");
        avatar = new Image(avatarPath.toString());
        avatarView = new ImageView(avatar);

        avatarView.setFitHeight(50);
        avatarView.setFitWidth(50);

        jfxButton = new JFXButton("", avatarView);

        jfxButton.setOnMouseClicked(e ->
                System.out.println(data.get("description")));
    }
}
