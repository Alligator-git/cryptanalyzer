package kishmereshkin;

import java.util.ArrayList;

public class Keys {
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
        keyArrayList.add(value);
    }
}
