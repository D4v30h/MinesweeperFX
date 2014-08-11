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
    
    public enum Type {
        SQUARE { public Image getImage() { return Images.square; } },
        SQUARE_FLAGGED { public Image getImage() { return Images.squareFlagged; } },
        SQUARE_EMPTY { public Image getImage() { return Images.squareEmpty; } },
        SQUARE_MINE { public Image getImage() { return Images.squareMine; } },
        SQUARE_MINE_RED { public Image getImage() { return Images.squareMineRed; } },
        SQUARE_MINE_FLAGGED { public Image getImage() { return Images.squareMineFlagged; } },
        SQUARE_1 { public Image getImage() { return Images.square1; } },
        SQUARE_2 { public Image getImage() { return Images.square2; } },
        SQUARE_3 { public Image getImage() { return Images.square3; } },
        SQUARE_4 { public Image getImage() { return Images.square4; } },
        SQUARE_5 { public Image getImage() { return Images.square5; } },
        SQUARE_6 { public Image getImage() { return Images.square6; } },
        SQUARE_7 { public Image getImage() { return Images.square7; } },
        SQUARE_8 { public Image getImage() { return Images.square8; } };
        public abstract Image getImage();
    }
    
    public static void InitialiseImages() {
        try {
            square = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/square.png").toURI().toURL().toString());
            squareFlagged = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/squareFlagged.png").toURI().toURL().toString());
            squareEmpty = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/squareEmpty.png").toURI().toURL().toString());
            squareMine = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/squareMine.png").toURI().toURL().toString());
            squareMineRed = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/squareMineRed.png").toURI().toURL().toString());
            squareMineFlagged = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/squareMineFlagged.png").toURI().toURL().toString());
            square1 = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/square1.png").toURI().toURL().toString());
            square2 = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/square2.png").toURI().toURL().toString());
            square3 = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/square3.png").toURI().toURL().toString());
            square4 = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/square4.png").toURI().toURL().toString());
            square5 = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/square5.png").toURI().toURL().toString());
            square6 = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/square6.png").toURI().toURL().toString());
            square7 = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/square7.png").toURI().toURL().toString());
            square8 = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/square8.png").toURI().toURL().toString());
        }
        catch (Exception e) {
            System.err.println("Images.InitialiseImages() exception: "+e);
        }
    }
    
    private static Image square;
    private static Image squareFlagged;
    private static Image squareEmpty;
    private static Image squareMine;
    private static Image squareMineRed;
    private static Image squareMineFlagged;
    private static Image square1;
    private static Image square2;
    private static Image square3;
    private static Image square4;
    private static Image square5;
    private static Image square6;
    private static Image square7;
    private static Image square8;
    
}
