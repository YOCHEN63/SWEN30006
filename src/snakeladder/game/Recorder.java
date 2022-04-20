package snakeladder.game;

import java.util.ArrayList;
import java.util.HashMap;

public class Recorder {
    private int playerIndex;
    private HashMap<Integer, Integer> playerData = new HashMap<>();
    private int isUp = 0;
    private int isDown = 0;

    public Recorder(int playerIndex){
        this.playerIndex = playerIndex;
    }
    public void count(Integer value){
        if(playerData.containsKey(value)){
            Integer oldValue = playerData.get(value);
            playerData.replace(value, oldValue + 1);
        } else {
            playerData.put(value, 1);
        }
    }

    public void isUp(){
        isUp += 1;
    }

    public void isDown(){
        isDown += 1;
    }

    public void printToString(){
        System.out.print("Player"+playerIndex+" rolled: ");
        for(Integer key : playerData.keySet()){
            System.out.print(key+"-"+playerData.get(key));
        }
        System.out.print("\n");
        System.out.println("Player "+playerIndex+" traversed: up-"+isUp+" down-"+isDown);
    }
}
