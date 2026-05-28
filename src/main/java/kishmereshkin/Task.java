package kishmereshkin;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Task implements Runnable{
    @Override
    public void run() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/kishmereshkin/Settings.fxml"));

        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root,400,400);
        Stage primaryStage = new Stage();

        primaryStage.initModality(Modality.APPLICATION_MODAL);//Разрешение на изменение размера окна

        primaryStage.setTitle("Настройки приложения");
        primaryStage.setMaxWidth(300.0);
        primaryStage.setMaxHeight(300.0);
        primaryStage.setMinHeight(100.0);
        primaryStage.setMinWidth(100.0);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);// true - блокировка других окон, пока не закрыто это

        primaryStage.setOnCloseRequest(event -> Platform.exit());//Закрывает задачу для OS чтобы можно было повторно вызвать

    }
}
