package controller.manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewStorage
{
    static private ViewStorage m_Instance;

    private HashMap<FXMLLoader, Parent> m_ObjectMapping = new HashMap<>();

    private Stage m_ActiveStage;

    private Locale activeLocale_ = Locale.ENGLISH;
    private String activeStyle_ = "styles/Dark.css";
    // private Locale locale_ = new Locale("en", "EN");

    private FXMLLoader m_MainView;
    private FXMLLoader m_ChampionPickerView;

    public static void changeLanguage(Locale locale)
    {
        getInstance().activeLocale_ = locale;
        getInstance().m_ActiveStage.close();
        getInstance().initialise();
    }

    public static ViewStorage getInstance()
    {
        if (m_Instance == null)
        {
            m_Instance = new ViewStorage();
        }

        return m_Instance;
    }

    public void initialise(Stage stage)
    {
        m_ActiveStage = stage;
        initialise();
    }

    private void initialise()
    {
        try
        {
            var bundle = ResourceBundle.getBundle("languages.LanguageBundle", activeLocale_);

            var kek = bundle.getKeys();

            while (kek.hasMoreElements())
            {
                String param = kek.nextElement();
                System.out.println(param);
            }

            m_ChampionPickerView = new FXMLLoader(this.getClass().getClassLoader().getResource(
                    "view/util/ChampionPicker.fxml"), bundle);
            m_ObjectMapping.putIfAbsent(m_ChampionPickerView, m_ChampionPickerView.load());
            m_MainView = new FXMLLoader(this.getClass().getClassLoader().getResource("view/MainView.fxml"), bundle);
            m_ObjectMapping.putIfAbsent(m_MainView, m_MainView.load());

            m_ActiveStage.setScene(new Scene(m_MainView.getRoot()));
            m_ActiveStage.sizeToScene();
            m_ActiveStage.show();
            m_ActiveStage.setMinWidth(m_ActiveStage.getWidth());
            m_ActiveStage.setMinHeight(m_ActiveStage.getHeight());


            m_ObjectMapping.get(m_MainView).requestFocus();
        }
        catch (IOException e)
        {
            System.err.println("Loading FXML's failed.");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e)
        {
            System.err.println("Unhandled error:");
            e.printStackTrace();
        }

        changeTheme(activeStyle_);
    }

    public static void changeTheme(String theme)
    {
        for (var fxmlLoaderParentEntry : getInstance().m_ObjectMapping.entrySet())
        {
            fxmlLoaderParentEntry.getValue().getStylesheets().add(theme);
        }
    }

    private ViewStorage() {}

    public Scene getMainView() { return new Scene(m_ObjectMapping.get(m_MainView)); }
    public Parent getChampionPickerView() { return m_ObjectMapping.get(m_ChampionPickerView); }

    public FXMLLoader getMainViewFxmlLoader() {return m_MainView;}
    public FXMLLoader getChampionPickerFxmlLoader() { return m_ChampionPickerView;}
}
