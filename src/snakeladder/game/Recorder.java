package snakeladder.game;

import java.util.ArrayList;
import java.util.HashMap;

public class Recorder {
    private HashMap<Integer, Integer> rollData = new HashMap<>();
    private int isUp = 0;
    private int isDown = 0;

    public void count(Integer value){
        if(rollData.containsKey(value)){
            Integer oldValue = rollData.get(value);
            rollData.replace(value, oldValue + 1);
        } else {
            rollData.put(value, 1);
        }
    }

    public void isUp(){
        isUp += 1;
    }

    public void isDown(){
        isDown += 1;
    }

//    public void printToString(){
//        System.out.print("Player"+playerIndex+" rolled: ");
//        for(Integer key : rollData.keySet()){
//            System.out.print(key+"-"+rollData.get(key));
//        }
//        System.out.print("\n");
//        System.out.println("Player "+playerIndex+" traversed: up-"+isUp+" down-"+isDown);
//    }
}
