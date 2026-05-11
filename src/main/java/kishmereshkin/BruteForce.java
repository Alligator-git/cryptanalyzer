package kishmereshkin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;

public class BruteForce {
    public int bruteForce(String src) {
        System.out.println("Начинается подборка ключа...");
        Path path = Path.of(src);
        ReadingFromFile readingFromFile = new ReadingFromFile();
        Decoder decoder = new Decoder();
        Dictionary dictionary = new Dictionary();
        dictionary.loadDictionary();
        List<String> lines = readingFromFile.readingFromFile(src,2);
        int result = 0;
        for (String s:lines){
            String[] str = s.split(" ");
            for(int step = 0;step!=32;step++){
                for (int i =0;i!=str.length;i++){
                    String s1 = decoder.decoderWithStep(str[i],step);
                    if(dictionary.russianDictionary(s1)){
                        return step;
                    }
                }

            }
        }
        return result;
    }
}
