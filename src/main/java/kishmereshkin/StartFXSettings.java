package kishmereshkin;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class StartFXSettings {

    private Stage primaryStage;
    private Controller controller;
    FXMLLoader fxmlLoader;

    public void start(Stage stageMain) {
        primaryStage = new Stage();

        try {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/kishmereshkin/Settings.fxml"));


            Parent root = fxmlLoader.load();
            ControllerSetting controllerSetting = fxmlLoader.getController();
            controllerSetting.setController(controller);
            Scene scene = new Scene(root, 400.0, 400.0);




            primaryStage.setTitle("Настройки приложения");
            primaryStage.setMaxWidth(300.0);
            primaryStage.setMaxHeight(300.0);
            primaryStage.setMinHeight(200.0);
            primaryStage.setMinWidth(150.0);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);//Разрешение на изменение размера окна
            primaryStage.initOwner(stageMain);

            primaryStage.initModality(Modality.WINDOW_MODAL);// Блокировка окна родителя

            //primaryStage.setAlwaysOnTop(true);

            primaryStage.show();

        } catch (Exception e) {
            System.out.println("Ошибка загрузки настроек");
            e.printStackTrace();
        }


    }

    public void setMainController(Controller controller){
        this.controller = controller;
    }
    public ControllerSetting getController(){
        return fxmlLoader.getController();
    }
}