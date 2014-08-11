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

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * A representation of a field/tile on the minefield.
 * @author David Hodgson <daveoh@daveoh.info>
 */
public class Square {
    
    private boolean isMine = false;
    public boolean isMine() { return isMine; }
    private boolean isFlagged = false;
    public boolean isFlagged() { return isFlagged; }
    private ImageView imageView = new ImageView(Images.Type.SQUARE.getImage());
    public ImageView getImageView() { return imageView; }
    private Grid grid;
    private int x, y;
    
    public Square (final Grid grid, final int x, final int y) {
        this.grid = grid;
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (isMine())
                    System.err.println("I'm a mine!");
                else
                    System.out.println("I'm not a mine.");
                grid.mineClicked(x, y);
            }
        });
    }
    
    /**
     * Toggles the flagged status of the square.
     * @return The new flagged status of the square.
     */
    public boolean ToggleFlag()
    {
        isFlagged = !isFlagged;
        return isFlagged;
    }
    
    /**
     * Sets the square to be a mine or not.
     * @param isMine true or false
     */
    public void setMine(boolean isMine)
    {
        this.isMine = isMine;
    }
    
    /**
     * Updates the Square's image to that of its clicked counterpart.
     */
    public void click() {
        if (isMine()) {
            imageView.setImage(Images.Type.SQUARE_MINE_RED.getImage());
        }
        else {
            switch (grid.getNumMinesAroundSquare(x, y)) {
                case 0: imageView.setImage(Images.Type.SQUARE_EMPTY.getImage()); break;
                case 1: imageView.setImage(Images.Type.SQUARE_1.getImage()); break;
                case 2: imageView.setImage(Images.Type.SQUARE_2.getImage()); break;
                case 3: imageView.setImage(Images.Type.SQUARE_3.getImage()); break;
                case 4: imageView.setImage(Images.Type.SQUARE_4.getImage()); break;
                case 5: imageView.setImage(Images.Type.SQUARE_5.getImage()); break;
                case 6: imageView.setImage(Images.Type.SQUARE_6.getImage()); break;
                case 7: imageView.setImage(Images.Type.SQUARE_7.getImage()); break;
                case 8: imageView.setImage(Images.Type.SQUARE_8.getImage()); break;
            }
        }
    }
    
    /**
     * Used at the end of the game to reveal any unclicked mines as mines.
     */
    public void revealIfMine() {
        if (isMine()) {
            imageView.setImage(Images.Type.SQUARE_MINE.getImage());
        }
    }
    
}
