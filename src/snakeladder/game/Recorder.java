package snakeladder.game;

import java.util.ArrayList;
import java.util.HashMap;

public class Recorder {
    private int diceCount;
    private HashMap<Integer, Integer> rollData;
    private int up = 0;
    private int down = 0;

    // generate all possible value when Recorder is constructed in the puppet class
    public Recorder(int diceCount){
        this.diceCount = diceCount;
        // give rollData a size that is because that possible value of the roll maybe larger than the default size.
        rollData = new HashMap<>(diceCount*6);
        for(int i = diceCount; i <= diceCount * 6; i++){
            rollData.put(i, 0);
        }

    }

    // give a value and save in the Data map
    public void count(Integer value){
        if(value == -1){
            return;
        }
        Integer oldValue = rollData.get(value);
        rollData.replace(value, oldValue + 1);

    }

    public void isUp(){
        up += 1;
    }

    public void isDown(){
        down += 1;
    }

    // convert rollData from hashmap to String
    public String rollData(){
        String result = "";
        result = result + diceCount + "-" + rollData.get(diceCount);
        for(int i = diceCount + 1; i <= diceCount * 6; i++){
            result = result + ", " + i + "-" + rollData.get(i);
        }
        return result;
    }

    // convert traversalData to String
    public String traversalData(){
        return "up-" + up + ", down-" + down;
    }
}
