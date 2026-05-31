package kishmereshkin;



public class Main {
    public static void main(String[] args) {

        StartFXMain startFXMain = new StartFXMain();

        startFXMain.fxStart();
        Controller controller = new Controller();

        controller.setMainStage(startFXMain.getStage());
    }
}
