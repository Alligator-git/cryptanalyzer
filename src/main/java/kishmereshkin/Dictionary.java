package kishmereshkin;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Dictionary {
    private HashSet<String> dictionary;
    public boolean russianDictionary(String str){
        if(!dictionary.contains(str))
            return false;
        return true;
    }
    public void loadDictionary(){
       Path path = getPath();
        if(Files.exists(path)){
            try {
                System.out.println("Загрузка словаря начинается...");
                 dictionary = new HashSet<>(Files.readAllLines(path));
                 if(dictionary == null)
                    System.out.println("Словарь пуст!!");
                System.out.println("Словарь загружен");
            } catch (IOException e) {
                System.out.println("Ошибка!" + e.getMessage());
            }
        }
    }
    private Path getPath(){
        Path path;
        try {
            URL strURL = getClass().getResource("/kishmereshkin/russian_surnames.txt");
            URI strPath = strURL.toURI();
            path = Path.of(strPath);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return path;
    }
}
