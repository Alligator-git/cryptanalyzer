package kishmereshkin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadingFromFile {
    public List<String> readingFromFile(String src){
        List<String> str = new ArrayList<>();
        try {
            str =Files.readAllLines(Path.of(src));
            System.out.println("Прочитано строк" + str.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }
}
