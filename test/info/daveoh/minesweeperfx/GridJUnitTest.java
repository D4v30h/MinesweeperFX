/*
 * Copyright (C) 2014 David
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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David Hodgson <daveoh@daveoh.info>
 */
public class GridJUnitTest {
    
    private Grid grid;
    private static final Difficulty difficulty = Difficulty.EASY;
    
    public GridJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Running Grid test using difficulty: "+difficulty);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        grid = new Grid(difficulty);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Ensures that a Grid starts full of Squares and that they aren't flagged.
     */
    @Test
    public void initialGridEmpty()
    {
        for (int x = 0; x < difficulty.getGridSize(); x++) {
            for (int y = 0; y < difficulty.getGridSize(); y++) {
                assertTrue(grid.getSquare(x, y).isFlagged() == false);
            }
        }
    }
    
    /**
     * Ensures that a grid has the appropriate number of mines in the field.
     */
    @Test
    public void testMinesPlacedCount()
    {
        int mines = 0;
        // Count all mines.
        for (int x = 0; x < difficulty.getGridSize(); x++) {
            for (int y = 0; y < difficulty.getGridSize(); y++) {
                if (grid.getSquare(x, y).isMine())
                    mines++;
            }
        }
        
        // Check against specified amount.
        assertTrue(mines == difficulty.getMineCount());
    }
}
