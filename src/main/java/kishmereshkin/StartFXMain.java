package kishmereshkin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StartFXMain extends Application {
    Stage stageMain;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stageMain = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/kishmereshkin/Interface.fxml"));


        Parent root = fxmlLoader.load();


        Scene scene = new Scene(root,690,430);

        stageMain.setResizable(false);
        stageMain.setTitle("Криптоанализатор");
        stageMain.setMaxWidth(700.0);
        stageMain.setMaxHeight(700.0);

        stageMain.setScene(scene);
        stageMain.isFullScreen();
        stageMain.show();

    }
    public void fxStart(){
        StartFXMain.launch();
    }
    public Stage getStage(){
        return stageMain;
    }

}
