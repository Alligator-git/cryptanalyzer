package kishmereshkin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;

public class BruteForce {
    public int bruteForce(String src) {
        System.out.println("Начинается подборка ключа...");
        ReadingFromFile readingFromFile = new ReadingFromFile();
        Decoder decoder = new Decoder();
        Dictionary dictionary = new Dictionary();
        dictionary.loadDictionary();

        // Читаем строки из файла
        List<String> lines = readingFromFile.readingFromFile(src, 4);

        int bestStep = 0;
        int maxMatches = -1; //Максимальное количество совпавших слов

        // Перебираем все возможные шаги (от 0 до 31)
        for (int step = 0; step < 32; step++) {
            int currentStepMatches = 0;

            for (String line : lines) {

                String decryptedLine = decoder.decoderWithStep(line, step);


                String[] words = decryptedLine.split("\\s+");

                for (String word : words) {

                    String cleanWord = word.toLowerCase().replaceAll("[^а-яё]", "");

                    if (!cleanWord.isEmpty() && dictionary.russianDictionary(cleanWord)) {
                        currentStepMatches++;
                    }
                }
            }

            // Если этот шаг даёт больше осмысленных слов, чем предыдущие, запоминаем его
            if (currentStepMatches > maxMatches) {
                maxMatches = currentStepMatches;
                bestStep = step;
            }


            if (currentStepMatches > 15) {
                System.out.println("Ключ успешно подобран методом BruteForce!");
                return step;
            }
        }

        System.out.println("Подбор окончен. Лучший результат с шагом: " + bestStep + " (Совпало слов: " + maxMatches + ")");
        return bestStep;
    }
    public int bruteForceStr(String str) {
        System.out.println("Начинается подборка ключа...");
        ReadingFromFile readingFromFile = new ReadingFromFile();
        Decoder decoder = new Decoder();
        Dictionary dictionary = new Dictionary();
        dictionary.loadDictionary();


        int bestStep = 0;
        int maxMatches = -1; //Максимальное количество совпавших слов

        // Перебираем все возможные шаги (от 0 до 31)
        for (int step = 0; step < 32; step++) {
            int currentStepMatches = 0;

                String decryptedLine = decoder.decoderWithStep(str, step);


                String[] words = decryptedLine.split("\\s+");

                for (String word : words) {

                    String cleanWord = word.toLowerCase().replaceAll("[^а-яё]", "");

                    if (!cleanWord.isEmpty() && dictionary.russianDictionary(cleanWord)) {
                        currentStepMatches++;
                    }
                }


            // Если этот шаг даёт больше осмысленных слов, чем предыдущие, запоминаем его
            if (currentStepMatches > maxMatches) {
                maxMatches = currentStepMatches;
                bestStep = step;
            }


            if (currentStepMatches > 15) {
                System.out.println("Ключ успешно подобран методом BruteForce!");
                return step;
            }
        }

        System.out.println("Подбор окончен. Лучший результат с шагом: " + bestStep + " (Совпало слов: " + maxMatches + ")");
        return bestStep;
    }
}
