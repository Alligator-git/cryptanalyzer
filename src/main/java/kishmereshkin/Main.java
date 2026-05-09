package kishmereshkin;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        Keys.getInstance().addKey(2);

        String src = "C:\\Users\\Andrey\\Desktop\\Тест программы2.txt";
        SaveToFile saveToFile = new SaveToFile();

        List<String> str1 = new ArrayList<>(List.of("Всем привет ","Всем пока \n"));

        saveToFile.saveToFile(str1,src);
        ReadingFromFile readingFromFile = new ReadingFromFile();
        List<String> str = readingFromFile.readingFromFile(src);
        if(str.isEmpty()){
            System.out.println("Ничего нет");
        }
        Encoder encoder = new Encoder();
        List<String> str2 = encoder.encod(str,0);
        System.out.println("Тест кодировщика");
        str2.forEach(s -> System.out.println(s));
        //saveToFile.saveToFile(str2,src);
        Decoder decoder = new Decoder();
        decoder.decod(str,0);

        str.forEach(s -> System.out.println(s));
    }
}
