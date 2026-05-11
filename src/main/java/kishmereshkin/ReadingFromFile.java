package kishmereshkin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadingFromFile {
    public List<String> readingFromFile(String src){
        List<String> str = new ArrayList<>();
        try {
            Path path = Path.of(src);
            if(Files.exists(path)){
                str =Files.readAllLines(path);
                System.out.println("Прочитано строк" + str.size());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }
    public List<String> readingFromFile(String src,int valueLines){
        List<String> str = new ArrayList<>();
        try {
            Path path = Path.of(src);
            if(Files.exists(path)){
                for(int i = 0;i!=valueLines;i++){
                    str.add(Files.readString(path));

                }
                System.out.println("Прочитано строк" + str.size() + " строки:");
                str.forEach(s -> System.out.println(s));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }
}
