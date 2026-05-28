package kishmereshkin;

import java.util.ArrayList;
import java.util.List;

public class Encoder {
    //Алфавит и знаки для кодировки
    ArrayList<Character> russianSmallLitters = new ArrayList<>(List.of('а','б','в','г','д','е',
            'ё','ж','з','и','Й','к','л'
            ,'м','н','о','п','р','с','т'
            ,'у','ф','х','ц','ч','ш','щ'
            ,'ъ','ь','э','ю','я'));
    ArrayList<Character> russianBigLitters = new ArrayList<>(List.of('А','Б','В','Г','Д','Е'
            ,'Ё','Ж','З','И','Й','К','Л'
            ,'М','Н','О','П','Р','С','Т'
            ,'У','Ф','Х','Ц','Ч','Ш','Щ'
            ,'Ъ','Ь','Э','Ю','Я'));
    ArrayList<Character> znak = new ArrayList<>(List.of('.','!','?',',','\\','|','/',';',':'));
    public String encoder(String src, int indexKey){
        ReadingFromFile readingFromFile = new ReadingFromFile();
        List<String> str = readingFromFile.readingFromFile(src);
        List<String> newStr = new ArrayList<>();
        String resultTotal = "";
        if(!str.isEmpty()){
            str.forEach(s -> {

                int index1 = str.indexOf(s);
                int keyInt = Keys.getInstance().getKey(indexKey);//Значение ключа
                String[] arrayString = s.split(" ");//Разрезаю строку на подстроки
                String result = "";//Переменная для вывода результата


                for(int count = 0;count!=arrayString.length;count++){

                    char[] strToChar = arrayString[count].toCharArray();//Разрезаю слово на массив char
                    char[] chars = new char[strToChar.length];
                    for(int i = 0;i!=strToChar.length;i++){

                        if (strToChar[i] == ' ' || znak.contains(strToChar[i]) || strToChar[i] == '\n'){
                            chars[i] = strToChar[i];
                            continue;
                        }

                        if (russianSmallLitters.contains(strToChar[i])) {


                            int index = russianSmallLitters.indexOf(strToChar[i]);

                            if (index + keyInt >= 32) {
                                int indexChar = index + keyInt - 32;
                                chars[i] = russianSmallLitters.get(indexChar);
                            } else {
                                int indexChar = index + keyInt;
                                chars[i] = russianSmallLitters.get(indexChar);
                            }
                            continue;
                        }

                        if (russianBigLitters.contains(strToChar[i])) {

                            int index = russianBigLitters.indexOf(strToChar[i]);

                            if (index + keyInt >= 32) {
                                int indexChar = index + keyInt - 32;
                                chars[i] = russianBigLitters.get(indexChar);
                            } else {
                                int indexChar = index + keyInt;
                                chars[i] = russianBigLitters.get(indexChar);
                            }

                        }

                    }
                    String s2 = String.valueOf(chars);//Формирую результат
                    result = result + " " +s2;
                }
                newStr.add(index1, result.trim());
            });
        }
        for (String s : newStr) {
            resultTotal += s + "\n";
        }
        return resultTotal;
    }
    public String encoderWithStep(String str, int step){//Этот метод используется для метода BruteForce
        List<String> newStr = new ArrayList<>();
        String result = "";//Переменная для вывода результата
        if(!str.isEmpty()){
                int keyInt = step;//Значение ключа
                    char[] strToChar = str.toCharArray();//Разрезаю слово на массив char
                    int lenght = strToChar.length;
                    char[] chars = new char[lenght];
                    for(int i = 0;i!=strToChar.length;i++){

                        if (strToChar[i] == ' ' || znak.contains(strToChar[i]) || strToChar[i] == '\n'){
                            chars[i] = strToChar[i];
                        }


                        if (russianSmallLitters.contains(strToChar[i])) {


                            int index = russianSmallLitters.indexOf(strToChar[i]);

                            if (index + keyInt >= 32) {
                                int indexChar = index + keyInt - 32;
                                chars[i] = russianSmallLitters.get(indexChar);
                            } else {
                                int indexChar = index + keyInt;
                                chars[i] = russianSmallLitters.get(indexChar);
                            }
                        }

                        if (russianBigLitters.contains(strToChar[i])) {

                            int index = russianBigLitters.indexOf(strToChar[i]);

                            if (index + keyInt >= 32) {
                                int indexChar = index + keyInt - 32;
                                chars[i] = russianBigLitters.get(indexChar);
                            } else {
                                int indexChar = index + keyInt;
                                chars[i] = russianBigLitters.get(indexChar);
                            }
                        }

                    String s2 = String.valueOf(chars);//Формирую результат
                    result = s2 + " ";
                }
        }
        return result;
    }
    public List<String> encoderWithCollectionInput(List<String> str, int indexKey){
            List<String> newStr = new ArrayList<>();

            if (str == null || str.isEmpty()) {
                return newStr;
            }

            int keyInt = Keys.getInstance().getKey(indexKey); // Получаем ключ один раз, а не в цикле

            for (String s : str) {
                String[] arrayString = s.split(" "); // Режем строку на слова
                StringBuilder lineBuilder = new StringBuilder(); // Создаем builder для КАЖДОЙ строки отдельно

                for (int count = 0; count < arrayString.length; count++) {
                    char[] strToChar = arrayString[count].toCharArray();
                    StringBuilder wordBuilder = new StringBuilder(); // Builder для конкретного слова

                    for (int i = 0; i < strToChar.length; i++) {
                        char ch = strToChar[i];

                        // Проверка знаков (пробелов тут быть не может, так как мы резали по split(" "))
                        if (znak.contains(ch) || ch == '\n') {
                            wordBuilder.append(ch);
                            continue;
                        }

                        // Маленькие русские буквы
                        if (russianSmallLitters.contains(ch)) {
                            int index = russianSmallLitters.indexOf(ch);
                            int indexChar = (index + keyInt) % 32; // Быстрый сдвиг по кругу без if-else
                            wordBuilder.append(russianSmallLitters.get(indexChar));
                            continue; // Переходим к следующему символу
                        }

                        // Большие русские буквы
                        if (russianBigLitters.contains(ch)) {
                            int index = russianBigLitters.indexOf(ch);
                            int indexChar = (index + keyInt) % 32;
                            wordBuilder.append(russianBigLitters.get(indexChar));
                            continue;
                        }

                        // Если символ не подошел ни под одно условие (например, английский или цифра)
                        wordBuilder.append(ch);
                    }

                    // Склеиваем слова через пробел
                    if (count > 0) {
                        lineBuilder.append(" ");
                    }
                    lineBuilder.append(wordBuilder.toString());
                }

                // Просто добавляем строку в конец списка (сохраняет правильный порядок)
                newStr.add(lineBuilder.toString());
            }

            return newStr;

    }
    public String encoderWithStep(List<String> strList, int step){//Этот метод используется для метода BruteForce
        StringBuilder builder = new StringBuilder();//Вывод результата
        for(String str:strList){
            if(!str.isEmpty()){
                int keyInt = step;//Значение ключа
                char[] strToChar = str.toCharArray();//Разрезаю слово на массив char
                int lenght = strToChar.length;
                char[] chars = new char[lenght];
                for(int i = 0;i!=strToChar.length;i++){

                    if (strToChar[i] == ' ' || znak.contains(strToChar[i]) || strToChar[i] == '\n'){
                        builder.append(strToChar[i]);
                        continue;
                    }


                    if (russianSmallLitters.contains(strToChar[i])) {


                        int index = russianSmallLitters.indexOf(strToChar[i]);

                        if (index + keyInt >= 32) {
                            int indexChar = index + keyInt - 32;
                            builder.append(russianSmallLitters.get(indexChar));
                        } else {
                            int indexChar = index + keyInt;
                            builder.append(russianSmallLitters.get(indexChar));
                        }
                    }

                    if (russianBigLitters.contains(strToChar[i])) {

                        int index = russianBigLitters.indexOf(strToChar[i]);

                        if (index + keyInt >= 32) {
                            int indexChar = index + keyInt - 32;
                            builder.append(russianBigLitters.get(indexChar));
                        } else {
                            int indexChar = index + keyInt;
                            builder.append(russianBigLitters.get(indexChar));
                        }
                    }
                }
            }
        }

        return String.valueOf(builder);
    }
    public String encoderRandom(String str){
        int randomStep = (int) (Math.random()*10);
        return encoderWithStep(str,randomStep);
    }

}
