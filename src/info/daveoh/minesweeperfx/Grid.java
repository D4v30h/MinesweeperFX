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

import java.util.ArrayList;
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
    private Player player;
    public Player getPlayer() { return player; }
    
    public Grid(Player player, Difficulty difficulty) {
        this.player = player;
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
            for (int y = 0; y < gridSize; y++) {
                for (int x = 0; x < gridSize; x++) {
                    squares[x][y] = new Square(this, x, y);
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
     * @param x The X coordinate.
     * @param y The Y coordinate.
     * @return The number of mines around a square.
     */
    public int getNumMinesAroundSquare(int x, int y) throws IndexOutOfBoundsException, IllegalStateException
    {
        if ( (x < 0) || (y < 0) || (x >= gridSize) || (y >= gridSize))
            throw new IndexOutOfBoundsException("Square coordinates must be inside grid. X: "+x+", Y: "+y);
        int fromX = Math.max(x-1, 0), toX = Math.min(x+1, gridSize-1),
            fromY = Math.max(y-1, 0), toY = Math.min(y+1, gridSize-1),
            count = 0;
        //System.out.println("getNumMinesAroundSquare fromX: "+fromX+", toX: "+toX+", fromY: "+fromY+", toY: "+toY);
        for (int i = fromX; i <= toX; i++) {
            for (int j = fromY; j <= toY; j++) {
                if ( (i == x) && (j == y) ) { continue; }
                if (squares[i][j].isMine()) { count++; }
            }
        }
        //System.out.println("Count: "+count);
        if ( (count < 0) || (count > 8) )
            throw new IllegalStateException("Grid.getNumMinesAroundSquare found an invalid number of mines around a square: "+count);
        return count;
    }
    
    /**
     * Called when the user clicks on a mine and loses the game.
     * @param x The X coordinate.
     * @param y The Y coordinate.
     */
    public void mineClicked(int x, int y) {
        // TODO: Implement mineClicked()
        // Reveal any mines.
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                squares[i][j].revealIfMine();
            }
        }
    }

    /**
     * When the player clicks on a square with no adjacent mines, reveal squares around it until it finds a mine.
     * @param x The X coordinate.
     * @param y The Y coordinate.
     */
    public void revealAroundSquare(int x, int y) {
        ArrayList<Square> squaresToReveal = new ArrayList<Square>();
        {
            int fromX = Math.max(x-1, 0), toX = Math.min(x+1, gridSize-1),
                fromY = Math.max(y-1, 0), toY = Math.min(y+1, gridSize-1);
            for (int i = fromX; i <= toX; i++) {
                for (int j = fromY; j <= toY; j++) {
                    if ( (i == x) && (j == y) ) { continue; }
                    squaresToReveal.add(squares[i][j]);
                }
            }
        }
        while (squaresToReveal.isEmpty() == false) {
            Square checkSquare = squaresToReveal.get(0);
            
            boolean addToList = checkSquare.revealNotMine();
            squaresToReveal.remove(0);
            if (addToList) {
                int newX = checkSquare.getX(), newY = checkSquare.getY(),
                    fromX = Math.max(newX-1, 0), toX = Math.min(newX+1, gridSize-1),
                    fromY = Math.max(newY-1, 0), toY = Math.min(newY+1, gridSize-1);
                for (int i = fromX; i <= toX; i++) {
                    for (int j = fromY; j <= toY; j++) {
                        if ( (i == newX) && (j == newY) ) { continue; }
                        if (squares[i][j].isRevealed()) { continue; }
                        squaresToReveal.add(squares[i][j]);
                    }
                }
            }
            
        }
    }
}