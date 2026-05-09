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
}
