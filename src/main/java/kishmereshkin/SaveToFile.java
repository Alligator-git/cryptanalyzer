package kishmereshkin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class SaveToFile {
    public void saveToFile(List<String> str, String src){
            str.forEach(s -> {
                try {
                    Files.writeString(Path.of(src),s, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    System.out.println("Ошибка");
                }
            });
            System.out.println("Файл успешно сохранен в файл " + src);
    }
}
