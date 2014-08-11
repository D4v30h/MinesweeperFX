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
 * How difficult the game should be.
 * @author David Hodgson <daveoh@daveoh.info>
 */
public enum Difficulty {
    // Difficulty( gridSize, mineCount )
    EASY(9, 10),
    MEDIUM(12, 25),
    HARD(15, 60);
    
    private final int gridSize;
    public int getGridSize() { return gridSize; }
    private final int mineCount;
    public int getMineCount() { return mineCount; }
    
    Difficulty(int gridSize, int mineCount)
    {
        this.gridSize = gridSize;
        this.mineCount = mineCount;
    }
}
