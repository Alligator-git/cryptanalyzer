package kishmereshkin;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {
    static ArrayList<Character> russianSmallLitters = new ArrayList<>(List.of('а','б','в','г','д','е',
            'ё','ж','з','и','Й','к','л'
            ,'м','н','о','п','р','с','т'
            ,'у','ф','х','ц','ч','ш','щ'
            ,'ъ','ь','э','ю','я'));
    static ArrayList<Character> russianBigLitters = new ArrayList<>(List.of('А','Б','В','Г','Д','Е'
            ,'Ё','Ж','З','И','Й','К','Л'
            ,'М','Н','О','П','Р','С','Т'
            ,'У','Ф','Х','Ц','Ч','Ш','Щ'
            ,'Ъ','Ь','Э','Ю','Я'));
    public static int getIndexLettres(Character letter){
        if(russianSmallLitters.contains(letter))
            return russianSmallLitters.indexOf(letter);
        else if (russianBigLitters.contains(letter)) {
            return russianBigLitters.indexOf(letter);
        }
        return 0;
    }
    public static List<Character> getAlphabetSmallLetters(){
        return russianSmallLitters;
    }
}
