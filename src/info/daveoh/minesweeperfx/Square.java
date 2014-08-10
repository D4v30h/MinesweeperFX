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
    private ImageView imageView = new ImageView(Images.square);
    public ImageView getImageView() { return imageView; }
    
    public Square () {
        //imageView.setOnMouseClicked(new MouseEventImpl());
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if (isMine())
                    System.err.println("I'm a mine!");
                else
                    System.out.println("I'm not a mine.");
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
    
    
}
