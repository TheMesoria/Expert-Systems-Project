package controller.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import controller.manager.ViewStorage;
import controller.view.util.ChampionPicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
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
    @FXML private JFXButton m_RedTeamPickButton_11;
    @FXML private JFXButton m_RedTeamPickButton_12;
    @FXML private JFXButton m_RedTeamPickButton_13;
    @FXML private JFXButton m_RedTeamPickButton_14;

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


    @Override public void initialize(URL url,
                                     ResourceBundle resourceBundle)
    {
        m_LayoutStackPane.getChildren().remove(m_ChampionPickDialog);

        var content = new JFXDialogLayout();
        content.setHeading(new Text("Choose champion"));
        content.setBody(ViewStorage.getInstance().getChampionPickerView());

        m_ChampionPickDialog.setTransitionType(JFXDialog.DialogTransition.BOTTOM);
        m_ChampionPickDialog.setContent(content);
        m_ChampionPickDialog.setDialogContainer(m_LayoutStackPane);
    }


    @FXML
    private void onMouseClicked(MouseEvent mouseEvent)
    {
        ChampionPicker cpController = ViewStorage.getInstance().getChampionPickerFxmlLoader().getController();
        cpController.clearChampionNameTextBox();
        m_ChampionPickDialog.show();
    }
}
