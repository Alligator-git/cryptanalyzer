package kishmereshkin;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class SaveToFile {
    public void saveToFile(List<String> str, String src){
            str.forEach(s -> {
                try {
                    Path path = Path.of(src);
                    if(Files.exists(path)){
                        Files.writeString(path,s, StandardOpenOption.APPEND);
                    }
                } catch (IOException e) {
                    System.out.println("Данного файла не существует");
                }
            });
            System.out.println("Файл успешно сохранен в файл " + src);
    }
}
