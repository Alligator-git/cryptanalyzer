package kishmereshkin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class ControllerSetting implements InterfaceSettingController {
    @FXML
    private Button settings;
    @FXML
    private Button chooseFile;
    @FXML
    private Button okButton;
    @FXML
    private TextArea outputArea;
    @FXML
    private Button settingsEncoder;
    @FXML
    private Button settingsRandomEncoder;
    @FXML
    private Button settingsStaticMethod;
    @FXML
    private Button settingsBruteForce;
    @FXML
    private ColorPicker settingsColorButtons;
    @FXML
    private ColorPicker settingsColorBackground;
    @FXML
    private Button settingClose;
    @FXML
    private AnchorPane AnchorPaneSettings;
    @FXML
    private AnchorPane AnchorPaneMain;
    @FXML
    TextField inputField;
    @FXML
    private Button settingEncodThisText;


    Controller controller;
    StartFXSettings startFXSettings = new StartFXSettings();
    Color colorButton;
    Color colorPane;

    int selectionMethod;//Переменная для контроля выбора метода


    @FXML
    private void settingsBruteForceClick(ActionEvent event){
        settingsBruteForce.arm();
        selectionMethod = 1;
        controller.setSelectionMethod(selectionMethod);
        controller.getInputField().setPromptText("Вы выбрали метод BruteForce поле для ввода недоступно \n");
        controller.lockInput(false);

    }

    @FXML
    private void settingsStaticMethodClick(ActionEvent event){
        settingsStaticMethod.arm();
        selectionMethod = 2;
        controller.setSelectionMethod(selectionMethod);
        controller.lockInput(false);
        controller.getInputField().setPromptText("Вы выбрали статический метод расшифровки поле недоступно\n");
    }
    @FXML
    private void settingEncodThisText(){
        settingEncodThisText.arm();
        selectionMethod = 5;
        controller.setSelectionMethod(selectionMethod);
    }

    @FXML
    private void settingsRandomEncoderClick(ActionEvent event){
        settingsRandomEncoder.arm();
        selectionMethod = 3;
        controller.getInputField().setPromptText("Вы выбрали случайную шифровку документа это поле недоступно\n");
        controller.lockInput(false);
        controller.setSelectionMethod(selectionMethod);
    }

    @FXML
    private void settingsChooseKeyEncoderClick(ActionEvent event){
        settingsEncoder.arm();
        selectionMethod = 4;
        controller.lockInput(true);
        controller.getInputField().setPromptText("Вы выбрали шифрование по определенному ключу\n");
        controller.setSelectionMethod(selectionMethod);
    }

    @FXML
    private void  settingCloseClick(ActionEvent event){
        settingClose.arm();
        Stage stage = (Stage) settingClose.getScene().getWindow();
        stage.close();
    }




    @Override
    public void updateFromMain(String data) {
        outputArea.appendText("Сообщение от контроллера 1" + data);
    }

    @FXML
    private void settingsColorBackgroundChoose(ActionEvent event){//Устанавливает цвет фона приложения
        Color color = settingsColorBackground.getValue();
        String colorNew = color.toString().replace("0x","#");
        controller.setColorPane(color);
        AnchorPaneSettings.applyCss();
        AnchorPaneSettings.setStyle("-fx-background-color: " + colorNew + ";");
        controller.getAnchorPaneMain().setStyle("-fx-background-color: " + colorNew + ";");
    }

    @FXML
    private void settingsColorButtonsChoose(ActionEvent event){//Устанавливает цвет фона кнопок
        Color color = settingsColorButtons.getValue();

        BackgroundFill backgroundFill = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        String colorNew = color.toString().replace("0x","#");
        controller.setColorButton(color);

        //controller.setColorBackground(color);
        settingsEncoder.setStyle("-fx-background-color: " + colorNew + ";");
        settingsRandomEncoder.setStyle("-fx-background-color: " + colorNew + ";");
        settingsStaticMethod.setStyle("-fx-background-color: " + colorNew + ";");
        settingsBruteForce.setStyle("-fx-background-color: " + colorNew + ";");
        settingClose.setStyle("-fx-background-color: " + colorNew + ";");
        controller.getOkButton().setStyle("-fx-background-color: " + colorNew + ";");
        controller.getChooseFile().setStyle("-fx-background-color: " + colorNew + ";");
        controller.getSettings().setStyle("-fx-background-color: " + colorNew + ";");
        settingEncodThisText.setStyle("-fx-background-color: " + colorNew + ";");

    }
    public void setController(Controller controller){
        this.controller = controller;
    }
    @FXML
    public void initialize(){

        settingClose.applyCss();
        settingsBruteForce.applyCss();
        settingsColorBackground.applyCss();
        settingsEncoder.applyCss();
        settingsColorButtons.applyCss();
        settingsStaticMethod.applyCss();
        settingsRandomEncoder.applyCss();
        AnchorPaneSettings.applyCss();
        settingEncodThisText.applyCss();
        controller = new Controller();


    }

   public void setColorButton(Color colorButton){
        if(colorButton!=null){
            String colorNew = colorButton.toString().replace("0x","#");

            settingsEncoder.setStyle("-fx-background-color: " + colorNew + ";");
            settingsRandomEncoder.setStyle("-fx-background-color: " + colorNew + ";");
            settingsStaticMethod.setStyle("-fx-background-color: " + colorNew + ";");
            settingsBruteForce.setStyle("-fx-background-color: " + colorNew + ";");
            settingClose.setStyle("-fx-background-color: " + colorNew + ";");
            controller.getOkButton().setStyle("-fx-background-color: " + colorNew + ";");
            controller.getChooseFile().setStyle("-fx-background-color: " + colorNew + ";");
            controller.getSettings().setStyle("-fx-background-color: " + colorNew + ";");
            settingEncodThisText.setStyle("-fx-background-color: " + colorNew + ";");
        }

   }
   public void setColorPane(Color colorPane){
        if(colorPane!= null){
            Color color = settingsColorBackground.getValue();
            String colorNew = color.toString().replace("0x","#");
            AnchorPaneSettings.setStyle("-fx-background-color: " + colorNew + ";");
            controller.getAnchorPaneMain().setStyle("-fx-background-color: " + colorNew + ";");
        }
   }
}
