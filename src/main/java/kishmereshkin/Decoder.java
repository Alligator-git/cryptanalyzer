package kishmereshkin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Decoder {
    ArrayList<Character> russianSmallLitters = new ArrayList<>(List.of('а','б','в','г','д','е',
            'ё','ж','з','и','Й','к','л'
            ,'м','н','о','п','р','с','т'
            ,'у','ф','х','ц','ч','ш','щ'
            ,'ъ','ь','э','ю','я'));
    ArrayList<Character> russianBigLitters = new ArrayList<>(List.of('А','Б','В','Г','Д','Е',
            'Ё','Ж','З','И','Й','К','Л'
            ,'М','Н','О','П','Р','С','Т'
            ,'У','Ф','Х','Ц', 'Ч','Ш','Щ'
            ,'Ъ','Ь','Э','Ю','Я'));

    ArrayList<Character> znak = new ArrayList<>(List.of('.','!','?',',','\\','|','/',';',':'));
    public List<String> decod(List<String> str,int indexKey){

        //int strLength = str.stream().mapToInt(String::length).sum();
        List<String> newStr = new ArrayList<>();
        if(str.isEmpty()){
            str.forEach(s -> {
                int index1 = str.indexOf(s);
                int keyInt = Keys.getInstance().getKey(indexKey);
                String[] arrayString = s.split(" ");//Разрезаю строку на подстроки
                String result = "";//Переменная для вывода результата
                String s1 = "";//Переменная для вывода результата
                for(int count = 0;count!=arrayString.length;count++){

                    char[] strToChar = arrayString[count].toCharArray();
                    int lenght = strToChar.length;
                    char[] chars = new char[lenght];
                    for(int i = 0;i!=strToChar.length;i++){

                        if (strToChar[i] == ' ' || znak.contains(strToChar[i]) || strToChar[i] == '\n')
                            continue;

                        if (russianSmallLitters.contains(strToChar[i])) {


                            int index = russianSmallLitters.indexOf(strToChar[i]);

                            if (index - keyInt <=0) {
                                int indexChar = index + keyInt + 32;
                                chars[i] = russianSmallLitters.get(indexChar);
                            } else {
                                int indexChar = index - keyInt;
                                chars[i] = russianSmallLitters.get(indexChar);
                            }
                        }

                        if (russianBigLitters.contains(strToChar[i])) {

                            int index = russianBigLitters.indexOf(strToChar[i]);

                            if (index - keyInt <= 0) {
                                int indexChar = index + keyInt + 32;
                                chars[i] = russianBigLitters.get(indexChar);
                            } else {
                                int indexChar = index - keyInt;
                                chars[i] = russianBigLitters.get(indexChar);
                            }
                        }

                    }
                    String s2 = String.valueOf(chars);
                    result = result + " " +s2;
                }
                newStr.add(index1, result.trim());
            });
        }
        return str;
    }
}
