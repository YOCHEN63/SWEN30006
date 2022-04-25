package snakeladder.game;

import ch.aplu.jgamegrid.Actor;

public class Die extends Actor
{
  private NavigationPane np;
  private int nb;


  private Pool pool;
  private int index;


  Die(int nb, Pool pool,int index)
  {
    super("sprites/pips" + nb + ".gif", 7);
    this.nb = nb;
    this.index = index;
    this.pool = pool;
  }

  public void act()
  {
    showNextSprite();
    if (getIdVisible() == 6)
    {

      setActEnabled(false);
      //when rolled dice reach the max of allowed dice
      //stop rolling and start to move
      if(index == pool.np.getNumOfDice()){
        pool.stopRolling();
      }


    }
  }

}

