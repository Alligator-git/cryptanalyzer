package kishmereshkin;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class SaveToFile {
    public void saveToFile(String doc, String src){
                try {
                    System.out.println(doc);
                    Path path = Path.of(src);
                    if(Files.exists(path)){
                        Files.writeString(path, "");
                        Files.writeString(path,doc, StandardOpenOption.APPEND);
                    }
                    else{
                        Files.createFile(path);
                        Files.writeString(path,doc, StandardOpenOption.APPEND);
                    }


                } catch (IOException e) {
                    System.out.println("Данного файла не существует " +e.getMessage() );

                }
            System.out.println("Файл успешно сохранен в файл " + src);
    }
    public void saveToFile(List<String> str, String src){
        for(String doc:str){
            try {
                System.out.println(doc);
                Path path = Path.of(src);
                if(Files.exists(path)){
                    Files.writeString(path, "");
                    Files.writeString(path,doc, StandardOpenOption.APPEND);
                }
                else{
                    Files.createFile(path);
                    Files.writeString(path,doc, StandardOpenOption.APPEND);
                }


            } catch (IOException e) {
                System.out.println("Данного файла не существует " +e.getMessage() );

            }
            System.out.println("Файл успешно сохранен в файл " + src);
        }
        }

}
