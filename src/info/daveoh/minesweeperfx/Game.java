/*
 * Copyright (C) 2014 David Hodgson <daveoh@daveoh.info>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package info.daveoh.minesweeperfx;

/**
 * Manages the game.
 * @author David Hodgson <daveoh@daveoh.info>
 */
public class Game {
    private static final int MAX_PLAYERS = 1; // TODO: Support two players.
    private final Difficulty difficulty;
    
    private Player[] players = new Player[MAX_PLAYERS];
    public Player getPlayer(int index) throws IndexOutOfBoundsException {
        if ( (index < 0) || (index > MAX_PLAYERS-1) )
                throw new IndexOutOfBoundsException("Player index "+index+" is invalid. Max players: "+MAX_PLAYERS);
        return players[index];
    }
    
    private int playerCount = 0;
    public int getPlayerCount() { return playerCount; }

    public Game(int numPlayers, Difficulty difficulty) throws IllegalArgumentException {
        if ( (numPlayers <= 0) || (numPlayers > MAX_PLAYERS) )
                throw new IndexOutOfBoundsException("Number of players "+numPlayers+" is invalid. Max players: "+MAX_PLAYERS);
        
        this.difficulty = difficulty;
        
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player();
            players[i].NewGame(difficulty);
            Grid grid = players[i].getGrid();
            MinesweeperFX.getInstance().initialiseGrid(grid);
        }
    }
}