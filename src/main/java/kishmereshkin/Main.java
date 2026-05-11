package kishmereshkin;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        Keys.getInstance().addKey(2);
        Keys.getInstance().addKey(3);
        String src = "C:\\Users\\Andrey\\Desktop\\Тест программы2.txt";
        SaveToFile saveToFile = new SaveToFile();
        ReadingFromFile readingFromFile = new ReadingFromFile();
        List<String> str1 = new ArrayList<>(List.of("Всем привет ","Всем пока \n"));
        BruteForce bruteForce = new BruteForce();
        //saveToFile.saveToFile(str1,src);

        List<String> str = readingFromFile.readingFromFile(src);
        if(str.isEmpty()){
            System.out.println("Ничего нет");
        }
        Encoder encoder = new Encoder();
        List<String> str2 = encoder.encoder(str,0);
        saveToFile.saveToFile(encoder.encoder(str1,0),src);
        System.out.println("Тест кодировщика");
        str2.forEach(s -> System.out.println(s));
        //saveToFile.saveToFile(str2,src);
        Decoder decoder = new Decoder();
        decoder.decod(str,0);

        str.forEach(s -> System.out.println(s));
        System.out.println(bruteForce.bruteForce(src));
        System.out.println("Статический декодер. Тест...");
        StaticDecoder staticDecoder = new StaticDecoder();
        System.out.println(staticDecoder.decoder(encoder.encoder(str1,1)));
    }
}
