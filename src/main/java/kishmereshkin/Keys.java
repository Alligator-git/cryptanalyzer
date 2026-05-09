package kishmereshkin;

import java.util.ArrayList;

public class Keys {//Используются для создания и хранения ключей
    private Keys(){
    }
    private static Keys keys = new Keys();

    private ArrayList<Integer> keyArrayList = new ArrayList<>();

    public static Keys getInstance(){
        return keys;
    }
    public int getKey(int index) {
        return keyArrayList.get(index);
    }
    public void addKey(int value){
        if(value>=1 && value<=32){
            keyArrayList.add(value);
        }
    }
}
