package snakeladder.game;

import java.util.ArrayList;
import java.util.HashMap;

public class Recorder {
    private int diceCount;
    private HashMap<Integer, Integer> rollData;
    private int up = 0;
    private int down = 0;

    public Recorder(int diceCount){
        this.diceCount = diceCount;
        rollData = new HashMap<>(diceCount*6);
        for(int i = diceCount; i <= diceCount * 6; i++){
            rollData.put(i, 0);
        }

    }

    public void count(Integer value){
        Integer oldValue = rollData.get(value);
        rollData.replace(value, oldValue + 1);

    }

    public void isUp(){
        up += 1;
    }

    public void isDown(){
        down += 1;
    }

    public String rollData(){
        String result = "";
        result = result + diceCount + "-" + rollData.get(diceCount);
        for(int i = diceCount + 1; i <= diceCount * 6; i++){
            result = result + ", " + i + "-" + rollData.get(i);
        }
        return result;
    }

    public String traversalData(){
        return "up-" + up + ", down-" + down;
    }
}
