package kishmereshkin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Collections;

public class ControllerSapportScene {
    @FXML
    private Spinner<Integer> spinner;
    @FXML
    private TextArea inputText;
    @FXML
    private TextArea outputText;
    @FXML
    private Button okButtonSapportScene;
    @FXML
    private MenuButton choseMethod;
    @FXML
    private Button close;
    @FXML
    private Pane paneSapport;

    int method = 0;

    Encoder encoder = new Encoder();
    Keys keys  = Keys.getInstance();
    Decoder decoder = new Decoder();
    BruteForce bruteForce = new BruteForce();
    StaticDecoder staticDecoder = new StaticDecoder();

    StartFXSapportScene scene = new StartFXSapportScene();

    @FXML
    private void initialize(){
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 32, 0, 1);
        valueFactory.setWrapAround(true);

        spinner.setValueFactory(valueFactory);

        outputText.setEditable(false);
        close.applyCss();
        spinner.applyCss();
        okButtonSapportScene.applyCss();
        choseMethod.applyCss();
        paneSapport.applyCss();
    }
    @FXML
    private void okButtonClick(){
        okButtonSapportScene.arm();
        switch (method){
            case 1-> outputText.setText(encoder.encoderWithStep(inputText.getText(),spinner.getValue()));

            case 2 ->outputText.setText(encoder.encoderRandom(inputText.getText()));

            case 3->outputText.setText(decoder.decoderWithStep(inputText.getText(),spinner.getValue()));

            case 4 ->{
                outputText.setText(decoder.decoderWithStep(outputText.getText(),
                    staticDecoder.decoder(inputText.getText())));
                System.out.println(decoder.decoderWithStep(outputText.getText(),
                        staticDecoder.decoder(inputText.getText())));
            }

            case 5->{
                outputText.setText(decoder.decoderWithStep(inputText.getText(),
                    bruteForce.bruteForceStr(inputText.getText())));

            }
        }

        //outputText.appendText(String.valueOf(encoder.encoderWithCollectionInput(Collections.singletonList(inputText.getText()), keys.addKey(spinner.getValue()))));
    }
    @FXML
    private void choseMethodSapport(ActionEvent event){
        choseMethod.arm();
        MenuItem menuItem = (MenuItem) event.getSource();
        String name = menuItem.getText();
        System.out.println(name);

        method = switch (name){
            case "Шифр. с ключом" -> {
                spinner.setVisible(true);
                spinner.setEditable(true);
                choseMethod.setText("Шифр. с ключом");
                yield 1;
            }
            case "Шифр. рандомно" -> {
                spinner.setVisible(false);
                spinner.setEditable(false);
                choseMethod.setText("Шифр. рандомно");
                yield 2;
            }
            case "Расшифр. с ключём" -> {
                spinner.setVisible(true);
                spinner.setEditable(true);
                choseMethod.setText("Расшифр. с ключём");
                yield 3;
            }
            case "Статистический метод" -> {
                spinner.setVisible(false);
                spinner.setEditable(false);
                choseMethod.setText("Статистический метод");
                yield 4;
            }
            case "BruteForce" -> {
                spinner.setVisible(false);
                spinner.setEditable(false);
                choseMethod.setText("BruteForce");
                yield 5;
            }
            default -> 0;
        };
    }
    @FXML
    public void closeScene(){
        scene.stop();
    }
    @FXML
    public void castomColor(Color colorButton,Color colorPane){
        if(colorButton !=null && colorPane!=null){
            String colorNew = colorButton.toString().replace("0x","#");
            close.setStyle("-fx-background-color: " + colorNew + ";");
            spinner.setStyle("-fx-background-color: " + colorNew + ";");
            okButtonSapportScene.setStyle("-fx-background-color: " + colorNew + ";");
            choseMethod.setStyle("-fx-background-color: " + colorNew + ";");
            String colorNew2 = colorPane.toString().replace("0x","#");
            paneSapport.setStyle("-fx-background-color: " + colorNew2 + ";");
        }
    }


}
