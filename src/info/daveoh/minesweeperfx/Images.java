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

import java.io.File;
import javafx.scene.image.Image;

/**
 *
 * @author David Hodgson <daveoh@daveoh.info>
 */
public class Images {
    
    public static void InitialiseImages() {
        try {
            square = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/square.png").toURI().toURL().toString());
        }
        catch (Exception e) {
            System.err.println("Images.InitialiseImages() exception: "+e);
        }
    }
    
    public static Image square;
//    public static final Image squareFlagged = new Image("squareFlagged.png");
//    public static final Image squareEmpty = new Image("squareEmpty.png");
//    public static final Image squareMine = new Image("squareMine.png");
//    public static final Image square1 = new Image("square1.png");
//    public static final Image square2 = new Image("square2.png");
//    public static final Image square3 = new Image("square3.png");
//    public static final Image square4 = new Image("square4.png");
//    public static final Image square5 = new Image("square5.png");
//    public static final Image square6 = new Image("square6.png");
//    public static final Image square7 = new Image("square7.png");
//    public static final Image square8 = new Image("square8.png");
    
}
