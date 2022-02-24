package edu.up.cs301.pig;

import edu.up.cs301.game.GameHumanPlayer;
import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
    int playerID; //0 or 1 --- keeps track of whose turn it is
    int player0Score;
    int player1Score;
    int runningTotal; //added to the current player's turn if Hold is used
    int currDieVal; //1-6

    /**
     * initializes the state
     */
    public PigGameState(){
        this.playerID = -1;
        this.player0Score = 0;
        this.player1Score = 0;
        this.runningTotal = 0;
        this.currDieVal = -1;
    }

    /**
     * copy constructor
     * creates a new instance of  that has the same values
     * for its variables as a given instance
     */
    public PigGameState(PigGameState state){

        this.playerID = getPlayerID();
        this.player0Score = getPlayer0Score();
        this.player1Score = getPlayer1Score();
        this.runningTotal = getRunningTotal();
        this.currDieVal = getCurrDieVal();
    }

    public void setPlayerID(int id){ this.playerID = id; }
    public int getPlayerID(){return this.playerID;}

    public void setPlayer0Score(int score0){ this.player0Score = score0; }
    public int getPlayer0Score(){ return this.player0Score; }

    public void setPlayer1Score(int score1){ this.player1Score = score1; }
    public int getPlayer1Score(){ return this.player1Score;}

    public void setRunningTotal(int total){ this.runningTotal = total; }
    public int getRunningTotal(){ return this.runningTotal; }

    public void setCurrDieVal(int val){ this.currDieVal = val; }
    public int getCurrDieVal(){ return this.currDieVal; }
}

