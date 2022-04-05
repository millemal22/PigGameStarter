package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method

        if (!(info instanceof PigGameState)){
            return;
        }
        PigGameState state = new PigGameState();
        state = (PigGameState)info;

        //if(not player's turn){
        //return;
        //}
        /*else
            float rand = Math.random()*2;
            if(rand >= 1){
                PigRollAction roll = new PigRollAction();
                sendUpdatedInfo(player);
            }
            else{
                PigHoldAction = new PigHoldAction();
                sendUpdatedInfo(player);
            }

            //Updates the TextViews to display the scores

            //Updates the dieImageButton to show the right number
            //dieImage.setImageResource

            //calls the onClick method whenever the user taps
            //hold or taps the die button to roll the dice
         */

    }//receiveInfo

}
