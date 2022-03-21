package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState state;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        this.state = new PigGameState();
        //int numPlayers = playerNames.length;
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if (state.playerID == playerIdx){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if (action instanceof PigHoldAction){
            if (state.playerID == 0) {
                state.player0Score += state.runningTotal;
                state.setRunningTotal(0);

                //change player 0 to player 1
                state.setPlayerID(1);
            }
            else if (state.playerID == 1){
                state.player1Score += state.runningTotal;
                state.setRunningTotal(0);

                //change player 1 to player 0
                state.setPlayerID(0);
            }
            return true;
        }
        else if (action instanceof PigRollAction){
            state.setCurrDieVal((int)Math.random()*7);

            //there's a 1% chance that it'll be seven
            if (state.currDieVal == 7) {
                state.runningTotal += 6;
            }
            else if (state.currDieVal == 1){
                state.setCurrDieVal(0);

            }
            else{
                state.runningTotal += state.currDieVal;
            }
            return true;
        }
        else {
            return false;
        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState copy = new GameState(this.state);
        p.sendInfo(copy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method

        String win = "";

        if (state.player0Score >= 50 || state.player1Score >= 50) {
            if (state.player0Score > state.player1Score) {
                win = playerNames[0] + " has won! Score: " + state.player0Score;
            } else if (state.player1Score > state.player0Score) {
                win = playerNames[1] + " has won! Score: " + state.player1Score;
            }
            return win;
        }
        return null;
    }

}// class PigLocalGame
