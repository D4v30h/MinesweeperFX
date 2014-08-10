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

import java.util.Random;

/**
 * A representation of an NxN grid composed of Squares.
 * @author David Hodgson <daveoh@daveoh.info>
 */
public class Grid {
   
    private int gridSize = 0;
    private int mineCount = 0;
    public int getGridSize() { return gridSize; }
    private Square[][] squares = null;
    private boolean isPopulated = false;
    private boolean hasPlacedMines = false;
    
    public Grid(Difficulty difficulty) {
        gridSize = difficulty.getGridSize();
        mineCount = difficulty.getMineCount();
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
            Random random = new Random();
            int minesPlaced = 0;
            while (minesPlaced < mineCount) {
                // Get two random coordinates and set the square as a mine, unless it is a mine already.
                int randX = Integer.remainderUnsigned(random.nextInt(), gridSize), randY = Integer.remainderUnsigned(random.nextInt(), gridSize);
                Square square = getSquare(randX, randY);
                if (square.isMine() == false) {
                    square.setMine(true);
                    minesPlaced++;
                }
                // Else if the square is already a mine, continue looping without adding one to the count.
            }
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
            throw new IndexOutOfBoundsException("Square coordinates must be inside grid. X: "+x+", Y: "+y);
        return squares[x][y];
    }
    
    /**
     * @return The number of mines around a square.
     */
    public int getNumMinesAroundSquare(int x, int y) throws IndexOutOfBoundsException
    {
        if ( (x < 0) || (y < 0) || (x >= gridSize) || (y >= gridSize))
            throw new IndexOutOfBoundsException("Square coordinates must be inside grid.");
        // TODO: Implement getNumMinesAroundSquare()
        return 0;
    }
}