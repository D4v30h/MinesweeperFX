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
 * A representation of an NxN grid composed of Squares.
 * @author David Hodgson <daveoh@daveoh.info>
 */
public class Grid {
   
    private int gridSize = 0;
    private Square[][] squares = null;
    private boolean isPopulated = false;
    private boolean hasPlacedMines = false;
    
    public Grid(Difficulty difficulty) {
//        switch (difficulty) {
//      	case EASY:  gridSize = 5; break;
//      	case MEDIUM:gridSize = 7; break;
//      	case HARD:  gridSize = 9; break;
//        }
        gridSize = difficulty.getGridSize();
        squares = new Square[gridSize][gridSize];
        populate();
        placeMines();
    }
    
    /**
     * Populates the grid with squares, if not already so.
     */
    private void populate()
    {
        if (isPopulated == false) {
            for (int x = 0; x < gridSize; x++) {
                for (int y = 0; y < gridSize; y++) {
                    squares[x][y] = new Square();
                }
            }
            isPopulated = true;
        }
    }
    
    /**
     * Sets some of the Squares of the grid as mines.
     */
    private void placeMines()
    {
        if (hasPlacedMines == false)
        {
            // TODO
            hasPlacedMines = true;
        }
    }
    
    /**
     * @param x The X coordinate.
     * @param y The Y coordinate.
     * @return The square at the specified coordinates.
     */
    public Square getSquare(int x, int y) throws IndexOutOfBoundsException
    {
        if ( (x < 0) || (y < 0) || (x >= gridSize) || (y >= gridSize))
            throw new IndexOutOfBoundsException("Square coordinates must be inside grid.");
        return squares[x][y];
    }
    
    /**
     * TODO
     * @return The number of mines around a square.
     */
    public int getNumMinesAroundSquare(int x, int y) throws IndexOutOfBoundsException
    {
        if ( (x < 0) || (y < 0) || (x >= gridSize) || (y >= gridSize))
            throw new IndexOutOfBoundsException("Square coordinates must be inside grid.");
        return 0;
    }
}