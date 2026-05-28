package kishmereshkin;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Controller {
    ControllerSetting controllerSetting;
    @FXML
    private Button settings;
    @FXML
    private Button chooseFile;
    @FXML
    private Button okButton;
    @FXML
    private TextArea outputArea;
    @FXML
    private TextField inputField;
    @FXML
    private AnchorPane AnchorPaneMain;
    @FXML
    private AnchorPane AnchorPaneSettings;
    @FXML
    private Button encodThisText;

    int selectionMethod;//Переменная для контроля выбора метода

    File file;
    private Stage mainStage;
    Color colorButton;
    Color colorPane;

    StartFXSettings startFXSettings = new StartFXSettings();
    BruteForce bruteForce = new BruteForce();
    StaticDecoder staticDecoder = new StaticDecoder();
    Encoder encoder = new Encoder();
    SaveToFile saveToFile = new SaveToFile();
    ReadingFromFile readingFromFile = new ReadingFromFile();
    FileChooser fileChooser = new FileChooser();
    Keys keys = Keys.getInstance();
    StartFXSapportScene startFXSapportScene = new StartFXSapportScene();
    ControllerSapportScene controllerSapportScene;


    @FXML
    private void settingOpenWindow() throws Exception {
        settings.arm();
        startFXSettings.setMainController(this);
        startFXSettings.start(mainStage);

        controllerSetting = startFXSettings.getController();

        controllerSetting.setColorButton(colorButton);//Установка цвета
        controllerSetting.setColorPane(colorPane);
    }





    @FXML
    private void chooseFileClick(ActionEvent event){
        chooseFile.arm();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().
                add(new FileChooser.ExtensionFilter("Text files" , "*.txt"));
        file = fileChooser.showOpenDialog(Window.getWindows().getFirst());
    }
    @FXML
    private void okButtonClick() throws IOException {
        okButton.arm();
        switch (selectionMethod){

            case 1 -> {
                int i = bruteForce.bruteForce(file.getPath());
                File file1 = fileChooser.showSaveDialog(Window.getWindows().getFirst());
                if(file1 != null || file != null){
                    List<String> str = Files.readAllLines(file.toPath());
                    Files.writeString(file1.toPath(),"");
                    saveToFile.saveToFile(encoder.encoderWithStep(str,i),file1.getPath());
                    outputArea.appendText("По методу Brute Force такой результат \n" + i);
                }
            }

            case 2 -> {
                int i = staticDecoder.decoder(file.getPath());
                File file1 = fileChooser.showSaveDialog(Window.getWindows().getFirst());
                if(file1 != null || file != null){
                    List<String> str = Files.readAllLines(file.toPath());
                    Files.writeString(file1.toPath(),"");
                    saveToFile.saveToFile(encoder.encoderWithStep(str,i),file1.getPath());
                    outputArea.appendText("По статическому методу такой результат \n" + i);

                }

            }

            case 3 -> {
                int i = (int) (Math.random()*10);
                File file1 = fileChooser.showSaveDialog(Window.getWindows().getFirst());
                if(file1 != null || file != null){
                    List<String> str = Files.readAllLines(file.toPath());
                    Files.writeString(file1.toPath(),"");
                    saveToFile.saveToFile(encoder.encoderWithCollectionInput(str,keys.addKey(i)),file1.getPath());
                    outputArea.appendText("Шифровка началась рандомный ключом\n");
                    outputArea.appendText("Шифровка закончилась");
                }
            }

            case 4 ->{
                if(inputField.getText().isEmpty()){
                    outputArea.appendText("Введите ключ!!!!!\n");
                }
                else{
                    try{
                        Keys keys = Keys.getInstance();
                        int index = keys.addKey(Integer.parseInt(inputField.getText()));
                        File file2 = fileChooser.showSaveDialog(Window.getWindows().getFirst());
                        if(file2 != null || file != null){
                            Files.writeString(file2.toPath(),"");
                            saveToFile.saveToFile(encoder.encoder(file.getPath(),index),file2.getPath());
                            outputArea.appendText("Ваш файл сохранён в файл " + file2.getPath());
                        }
                    } catch (Exception e) {
                        outputArea.appendText("Введите число от 0 и до 32");
                    }
                }
            }
            case 5->{
                    startFXSapportScene.start(mainStage);
                    controllerSapportScene = startFXSapportScene.getController();
                    controllerSapportScene.castomColor(colorButton,colorPane);

            }
        }
    }
    @FXML
    public void initialize(){
        System.out.println("Загрузка контроллера");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files" , "*.txt"));
        outputArea.setEditable(false);
        settings.applyCss();
        okButton.applyCss();
        AnchorPaneMain.applyCss();
        System.out.println("Загрузка завершена успешно");

    }

    @FXML
    public void setSelectionMethod(int selectionMethod) {
        this.selectionMethod = selectionMethod;
    }
    @FXML
    public TextArea getOutputArea() {
        return outputArea;
    }
    @FXML
    public TextField getInputField() {
        return inputField;
    }
    @FXML
    public Button getSettings() {
        return settings;
    }
    @FXML
    public Button getChooseFile() {
        return chooseFile;
    }
    @FXML
    public Button getOkButton() {
        return okButton;
    }
    @FXML
    public AnchorPane getAnchorPaneMain() {
        return AnchorPaneMain;
    }
    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
    public void print(String s){
        outputArea.appendText(s);
    }
    public void lockInput(boolean b){
        inputField.setEditable(b);
    }
    @FXML
    private String getText(){
        return inputField.getText();
    }

    public void setColorButton(Color colorButton) {
        this.colorButton = colorButton;
    }

    public void setColorPane(Color colorPane) {
        this.colorPane = colorPane;
    }
}
