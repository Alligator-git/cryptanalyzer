package kishmereshkin;

import java.util.*;

public class StaticDecoder {
    //Подсчет наиболее частых букв. Будет взят целый алфавит, а далее будет идти сравнение
    HashMap<Character,Integer> hashMap = new HashMap<>();
    public int decoder(List<String> str){
        automaticHashMap();

        Dictionary dictionary = new Dictionary();
        dictionary.loadDictionary();
        Decoder decoder = new Decoder();
        int letterO = Alphabet.getIndexLettres('о');
        int letter1 = Alphabet.getIndexLettres('е');
        int letter2 = Alphabet.getIndexLettres('а');
        int result = 0;

        for(String s:str){
            String[] line = s.split(" ");
            for(int i = 0;i!=line.length;i++){
                char[] letter = line[i].toCharArray();
                for(int x = 0;x!=letter.length;x++){
                    if(hashMap.containsValue(letter[i])){
                        int value = hashMap.get(letter[i]);
                        hashMap.put(letter[i],value+1);
                    }
                }

            }
        }
        List<Character> mostLetter = new ArrayList<>();
        Set<Map.Entry<Character, Integer>> set = hashMap.entrySet();
        int max = Collections.max(hashMap.values());
        set.forEach(entry -> {
            if(entry.getValue() == max)
                mostLetter.add(entry.getKey());
        });
        for(int i = 0;i!=mostLetter.size();i++){
            int index = Alphabet.getIndexLettres(mostLetter.get(i));
            if(index-letterO<=0){
                int finalyIndex = index-letterO+32;
                String[] strings = str.get(0).split(" ");
                if(dictionary.russianDictionary(decoder.decoderWithStep(strings[0],finalyIndex)))
                    return finalyIndex;
            }
            else {
                int finalyIndex = index-letterO;
                String[] strings = str.get(0).split(" ");
                if(dictionary.russianDictionary(decoder.decoderWithStep(strings[0],finalyIndex)))
                    return finalyIndex;
            }

        }
        for(int i = 0;i!=mostLetter.size();i++){
            int index = Alphabet.getIndexLettres(mostLetter.get(i));
            if(index-letterO<=0){
                int finalyIndex = index-letter1+32;
                String[] strings = str.get(0).split(" ");
                if(dictionary.russianDictionary(decoder.decoderWithStep(strings[0],finalyIndex)))
                    return finalyIndex;
            }
            else {
                int finalyIndex = index-letter1;
                String[] strings = str.get(0).split(" ");
                if(dictionary.russianDictionary(decoder.decoderWithStep(strings[0],finalyIndex)))
                    return finalyIndex;
            }

        }
        for(int i = 0;i!=mostLetter.size();i++){
            int index = Alphabet.getIndexLettres(mostLetter.get(i));
            if(index-letterO<=0){
                int finalyIndex = index-letter2+32;
                String[] strings = str.get(0).split(" ");
                if(dictionary.russianDictionary(decoder.decoderWithStep(strings[0],finalyIndex)))
                    return finalyIndex;
            }
            else {
                int finalyIndex = index-letter2;
                String[] strings = str.get(0).split(" ");
                if(dictionary.russianDictionary(decoder.decoderWithStep(strings[0],finalyIndex)))
                    return finalyIndex;
            }

        }
        return result;
    }
    public void automaticHashMap(){
        List<Character> smallLitters = Alphabet.russianSmallLitters;
        smallLitters.forEach(character -> {
            hashMap.put(character,0);
        });
    }
}
