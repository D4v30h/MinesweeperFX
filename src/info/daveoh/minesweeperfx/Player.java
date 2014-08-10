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
    
    public Player() {
        this.name = "Unnamed_"+id++;
    }
    public Player(String name) {
        this.name = name;
    }
    
    public void NewGame(Difficulty difficulty) {
        grid = new Grid(difficulty);
    }
    
    public Grid getGrid() { return grid; }
}