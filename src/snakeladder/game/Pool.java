package snakeladder.game;
import java.util.ArrayList;
import java.util.List;


public class Pool {
    private List<Die> listOfDie;

    private int totalRolled = 0;
    private NavigationPane np;

    public Pool(NavigationPane np){
        this.np = np;
        this.listOfDie = new ArrayList<>();

    }

    public NavigationPane getNp(){
        return this.np;
    }


    public int getDiceSize(){
        //get the size of Die list
        return listOfDie.size();
    }

    public void roll(int nb, int sizeOfDices){
        //adding each roll into the die list
        //and count the total rolled point
        int index = sizeOfDices+1;
        Die die = new Die(nb,this,index);
        listOfDie.add(die);
        totalRolled+=nb;
    }


    public void stopRolling(){
        //when rolled dice reach the max of allowed dice
        //stop rolling and start to move
        np.startMoving(totalRolled);
        this.totalRolled = 0;
        this.listOfDie.clear();


    }

    public ch.aplu.jgamegrid.Actor DieActor(){
        return this.listOfDie.get(this.listOfDie.size()-1);
    }

}

