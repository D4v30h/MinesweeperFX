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
 * A representation of a player.
 * @author David Hodgson <daveoh@daveoh.info>
 */
public class Player {
    private String name = null;
    private boolean isPlaying = false;
    private Grid grid = null;
    private int wins = 0;
    private int losses = 0;
    private static int id = 0;
    
    /**
     * Generates a Player with the name "Unnamed_" followed by a unique ID.
     */
    public Player() {
        this.name = "Unnamed_"+id++;
    }
    /**
     * Generates a Player with the specified name.
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
    }
    
    /**
     * Starts a new game for the player with the specified difficulty.
     * @param difficulty Desired difficulty level.
     */
    public void NewGame(Difficulty difficulty) {
        grid = new Grid(this, difficulty);
    }
    
    /**
     * Called when the player loses the game by clicking on a mine.
     */
    public void gameOver() {
        // TODO: Player.gameOver()
    }
    
    /**
     * @return The grid of the game associated by the player.
     */
    public Grid getGrid() { return grid; }
}