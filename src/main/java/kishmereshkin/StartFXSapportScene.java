package kishmereshkin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StartFXSapportScene {
    Stage stage;
    FXMLLoader fxmlLoader;
    public void start(Stage stageMain) throws IOException {
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/kishmereshkin/SapportScene.fxml"));

        ControllerSapportScene controllerSapportScene = fxmlLoader.getController();

        Parent root =  fxmlLoader.load();

        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.initOwner(stageMain);
        stage.initModality(Modality.WINDOW_MODAL);

        stage.show();
    }
    public void stop(){
        stage.close();
    }
    public ControllerSapportScene getController(){
        return fxmlLoader.getController();
    }
}
