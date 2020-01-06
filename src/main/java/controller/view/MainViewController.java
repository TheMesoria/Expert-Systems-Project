package controller.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import controller.manager.ViewStorage;
import controller.view.util.ChampionPicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import models.Champion;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MainViewController
        implements Initializable
{

    @FXML private StackPane m_LayoutStackPane;
    @FXML private JFXDialog m_ChampionPickDialog;

    @FXML private HBox m_RedTeamHBox;
    @FXML private VBox m_RedTeamBanVBox;
    @FXML private JFXButton m_RedBanButton_1;
    @FXML private JFXButton m_RedBanButton_2;
    @FXML private JFXButton m_RedBanButton_3;
    @FXML private JFXButton m_RedBanButton_4;
    @FXML private JFXButton m_RedBanButton_5;
    @FXML private JFXButton m_RedTeamPickButton_1;
    @FXML private JFXButton m_RedTeamPickButton_2;
    @FXML private JFXButton m_RedTeamPickButton_3;
    @FXML private JFXButton m_RedTeamPickButton_4;
    @FXML private JFXButton m_RedTeamPickButton_5;

    @FXML private HBox m_BlueTeamHBox;
    @FXML private VBox m_BlueTeamBanVBox;
    @FXML private JFXButton m_BlueBanButton_1;
    @FXML private JFXButton m_BlueBanButton_2;
    @FXML private JFXButton m_BlueBanButton_3;
    @FXML private JFXButton m_BlueBanButton_4;
    @FXML private JFXButton m_BlueBanButton_5;
    @FXML private JFXButton m_BlueTeamPickButton_1;
    @FXML private JFXButton m_BlueTeamPickButton_2;
    @FXML private JFXButton m_BlueTeamPickButton_3;
    @FXML private JFXButton m_BlueTeamPickButton_4;
    @FXML private JFXButton m_BlueTeamPickButton_5;

    public HashMap<JFXButton, Champion> m_ChampionMap = new HashMap<>();
    public JFXButton m_LastRequestedButton;

    @Override public void initialize(URL url,
                                     ResourceBundle resourceBundle)
    {
        m_LayoutStackPane.getChildren().remove(m_ChampionPickDialog);

        var content = new JFXDialogLayout();
        content.setHeading(new Text("Choose champion"));
        content.setBody(ViewStorage.getInstance().getChampionPickerView());

        m_ChampionMap.putIfAbsent(m_RedBanButton_1, null);
        m_ChampionMap.putIfAbsent(m_RedBanButton_2, null);
        m_ChampionMap.putIfAbsent(m_RedBanButton_3, null);
        m_ChampionMap.putIfAbsent(m_RedBanButton_4, null);
        m_ChampionMap.putIfAbsent(m_RedBanButton_5, null);

        m_ChampionMap.putIfAbsent(m_RedTeamPickButton_1, null);
        m_ChampionMap.putIfAbsent(m_RedTeamPickButton_2, null);
        m_ChampionMap.putIfAbsent(m_RedTeamPickButton_3, null);
        m_ChampionMap.putIfAbsent(m_RedTeamPickButton_4, null);
        m_ChampionMap.putIfAbsent(m_RedTeamPickButton_5, null);

        m_ChampionMap.putIfAbsent(m_BlueBanButton_1, null);
        m_ChampionMap.putIfAbsent(m_BlueBanButton_2, null);
        m_ChampionMap.putIfAbsent(m_BlueBanButton_3, null);
        m_ChampionMap.putIfAbsent(m_BlueBanButton_4, null);
        m_ChampionMap.putIfAbsent(m_BlueBanButton_5, null);

        m_ChampionMap.putIfAbsent(m_BlueTeamPickButton_1, null);
        m_ChampionMap.putIfAbsent(m_BlueTeamPickButton_2, null);
        m_ChampionMap.putIfAbsent(m_BlueTeamPickButton_3, null);
        m_ChampionMap.putIfAbsent(m_BlueTeamPickButton_4, null);
        m_ChampionMap.putIfAbsent(m_BlueTeamPickButton_5, null);

        m_ChampionPickDialog.setTransitionType(JFXDialog.DialogTransition.BOTTOM);
        m_ChampionPickDialog.setContent(content);
        m_ChampionPickDialog.setDialogContainer(m_LayoutStackPane);
    }


    @FXML
    private void onMouseClicked(MouseEvent mouseEvent)
    {
        ChampionPicker cpController = ViewStorage.getInstance().getChampionPickerFxmlLoader().getController();

        m_LastRequestedButton = (JFXButton) mouseEvent.getSource();
        m_ChampionPickDialog.show();

        // ((JFXButton)mouseEvent.getSource()).setBackground(
        //         new Background(new BackgroundImage(
        //                 cpController.m_Champions.getFirst().avatar
        //                 , BackgroundRepeat.NO_REPEAT
        //                 , BackgroundRepeat.NO_REPEAT
        //                 , BackgroundPosition.CENTER
        //                 , BackgroundSize.DEFAULT
        //         )));
    }
}
