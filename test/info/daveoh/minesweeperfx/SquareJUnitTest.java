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
public class SquareJUnitTest {
    
    private Square square;
    
    public SquareJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        square = new Square();
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Tests the default state of a new Square object.
     */
    @Test
    public void testDefaultState()
    {
        assertTrue(square.isMine() == false);
        assertTrue(square.isFlagged() == false);
    }
    
    /**
     * Tests the ToggleFlag() method.
     */
    @Test
    public void testToggleFlag()
    {
        assertTrue(square.isFlagged() == false);
        square.ToggleFlag();
        assertTrue(square.isFlagged() == true);
        square.ToggleFlag();
        assertTrue(square.isFlagged() == false);
    }
    
    /**
     * Tests the setMine() method.
     */
    @Test
    public void testSetMine()
    {
        assertTrue(square.isMine() == false);
        square.setMine(true);
        assertTrue(square.isMine());
    }
}
