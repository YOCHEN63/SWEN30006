package snakeladder.game;

import ch.aplu.jgamegrid.GGCheckButton;

public interface ToggleMode {
    // make autoToggle as an interface to let the role is easy to change
    void autoToggle(int numOfDice, GamePane gp, boolean isToggle, GGCheckButton toggleCheck);
}
