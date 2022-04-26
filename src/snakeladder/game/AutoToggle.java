package snakeladder.game;

import ch.aplu.jgamegrid.GGCheckButton;

public class AutoToggle implements ToggleMode{
    // put
    @Override
    public void autoToggle(int numOfDice, GamePane gp, boolean isToggle, GGCheckButton toggleCheck) {
        int nextPuppetCellIndex = gp.getNextPuppet().getCellIndex();
        int upCount = 0;
        int downCount = 0;
        // loop the future cell of next puppet and count the number of up and down connection.
        for (int i = nextPuppetCellIndex; i <= numOfDice * 6 + nextPuppetCellIndex; i++) {

            for (Connection connection : gp.getConnections()) {
                if (i == connection.cellStart &&
                        ((connection instanceof Snake && !gp.isReversed()) ||
                                (connection instanceof Ladder && gp.isReversed()))) {
                    downCount += 1;
                } else if (i == connection.cellStart &&
                        ((connection instanceof Snake && gp.isReversed()) ||
                                (connection instanceof Ladder && !gp.isReversed()))) {
                    upCount += 1;
                }
            }
        }
        // compare up and down connection to decide reverse or not.
        if (downCount < upCount) {
            gp.reverseAllConnections();
            isToggle = !isToggle;
            toggleCheck.setChecked(isToggle);
        }
    }
}
