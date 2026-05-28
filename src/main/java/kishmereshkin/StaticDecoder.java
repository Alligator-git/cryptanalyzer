package kishmereshkin;

import java.util.*;

public class StaticDecoder {
    //Подсчет наиболее частых букв. Будет взят целый алфавит, а далее будет идти сравнение
    HashMap<Character,Integer> hashMap = new HashMap<>();
    public int decoder(String src){
        System.out.println("Начинается подборка ключа методом частотного анализа...");
        ReadingFromFile readingFromFile = new ReadingFromFile();
        List<String> lines = readingFromFile.readingFromFile(src, 2);


        automaticHashMap();

        Dictionary dictionary = new Dictionary();
        dictionary.loadDictionary();
        Decoder decoder = new Decoder();

        int letterO = Alphabet.getIndexLettres('о');
        int letterE = Alphabet.getIndexLettres('е');
        int letterA = Alphabet.getIndexLettres('а');

        int[] targetLetters = {letterO, letterE, letterA};
        int alphabetSize = 32;


        for (String s : lines) {
            char[] letters = s.toLowerCase().toCharArray();
            for (char c : letters) {

                if (hashMap.containsKey(c)) {
                    hashMap.put(c, hashMap.get(c) + 1);
                }
            }
        }

        // 2. Поиск символов с максимальной частотой
        List<Character> mostLetters = new ArrayList<>();
        if (!hashMap.isEmpty()) {
            int max = Collections.max(hashMap.values());
            hashMap.forEach((key, value) -> {
                if (value == max) {
                    mostLetters.add(key);
                }
            });
        }


        for (char mostChar : mostLetters) {
            int index = Alphabet.getIndexLettres(mostChar);
            if (index == -1) continue; // Пропускаем, если символ не найден в алфавите

            for (int targetLetter : targetLetters) {
                // Вычисляем потенциальный шаг (сдвиг)
                int finalyIndex = (index - targetLetter) % alphabetSize;
                if (finalyIndex < 0) {
                    finalyIndex += alphabetSize;
                }

                // ПРОВЕРКА: Дешифровка всей первой строчки
                String testLine = decoder.decoderWithStep(lines.getFirst(), finalyIndex);
                String[] words = testLine.split("\\s+");

                int matches = 0;
                for (String word : words) {
                    String cleanWord = word.toLowerCase().replaceAll("[^а-яё]", "");
                    if (!cleanWord.isEmpty() && dictionary.russianDictionary(cleanWord)) {
                        matches++;
                    }
                }


                if (matches >= 2 || (words.length == 1 && matches == 1)) {
                    System.out.println("Ключ успешно найден: " + finalyIndex);
                    return finalyIndex;
                }
            }
        }

        System.out.println("Частотный анализ не дал точного результата, возвращаем 0.");
        return 0;
    }
    public void automaticHashMap(){
        List<Character> smallLitters = Alphabet.russianSmallLitters;
        smallLitters.forEach(character -> hashMap.put(character,0));
    }
    public String decoderStr(String str){
        int finalyIndex = 0;
        System.out.println("Начинается подборка ключа методом частотного анализа...");

        automaticHashMap();

        Dictionary dictionary = new Dictionary();
        dictionary.loadDictionary();
        Decoder decoder = new Decoder();

        int letterO = Alphabet.getIndexLettres('о');
        int letterE = Alphabet.getIndexLettres('е');
        int letterA = Alphabet.getIndexLettres('а');

        int[] targetLetters = {letterO, letterE, letterA};
        int alphabetSize = 32;


        char[] letters = str.toLowerCase().toCharArray();
        for (char c : letters) {

            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            }
        }


        // 2. Поиск символов с максимальной частотой
        List<Character> mostLetters = new ArrayList<>();
        if (!hashMap.isEmpty()) {
            int max = Collections.max(hashMap.values());
            hashMap.forEach((key, value) -> {
                if (value == max) {
                    mostLetters.add(key);
                }
            });
        }


        for (char mostChar : mostLetters) {
            int index = Alphabet.getIndexLettres(mostChar);
            if (index == -1) continue; // Пропускаем, если символ не найден в алфавите

            for (int targetLetter : targetLetters) {
                // Вычисляем потенциальный шаг (сдвиг)
                finalyIndex = (index - targetLetter) % alphabetSize;
                if (finalyIndex < 0) {
                    finalyIndex += alphabetSize;
                }

                // ПРОВЕРКА: Дешифровка всей первой строчки
                String testLine = decoder.decoderWithStep(str, finalyIndex);
                String[] words = testLine.split("\\s+");

                int matches = 0;
                for (String word : words) {
                    String cleanWord = word.toLowerCase().replaceAll("[^а-яё]", "");
                    if (!cleanWord.isEmpty() && dictionary.russianDictionary(cleanWord)) {
                        matches++;
                    }
                }


                if (matches >= 2 || (words.length == 1 && matches == 1)) {
                    System.out.println("Ключ успешно найден: " + finalyIndex);
                    return decoder.decoderWithStep(str,finalyIndex);
                }
            }
        }

        System.out.println("Частотный анализ не дал точного результата, возвращаем 0.");
        return null;
    }
}
