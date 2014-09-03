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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
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
    private boolean isRevealed = false;
    public boolean isRevealed() { return isRevealed; }
    private final ImageView imageView = new ImageView(Images.Type.SQUARE.getImage());
    public ImageView getImageView() { return imageView; }
    private final Grid grid;
    private final int x, y;
    public int getX() { return x; }
    public int getY() { return y; }
    
    public Square (final Grid grid, final int x, final int y) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                if (me.getButton() == MouseButton.PRIMARY) { clickLeft(); }
                else if (me.getButton() == MouseButton.SECONDARY) { clickRight(); }
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
     * Registers a click (LMB) on the Square. This presses the square and updates its image to that of its clicked counterpart.
     */
    public void clickLeft() {
        if ( (grid.hasFailed() == false) && (isFlagged() == false) ) {
            isRevealed = true;
            if (isMine()) {
                grid.mineClicked(x, y);
                imageView.setImage(Images.Type.SQUARE_MINE_RED.getImage());
            }
            else {
                switch (grid.getNumMinesAroundSquare(x, y)) {
                    case 0:
                        imageView.setImage(Images.Type.SQUARE_EMPTY.getImage());
                        grid.revealAroundSquare(x, y);
                        break;
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
    }
    
    /**
     * Registers a click (RMB) on the Square. This toggles the flagged state of the square updates its image appropriately.
     */
    public void clickRight() {
        if ( (grid.hasFailed() == false) && (isRevealed() == false) ) {
            if (isFlagged()) {
                imageView.setImage(Images.Type.SQUARE.getImage());
                if (isMine()) { grid.mineUnflagged(); }
            }
            else {
                imageView.setImage(Images.Type.SQUARE_FLAGGED.getImage());
                if (isMine()) { grid.mineFlagged(); }
            }
            ToggleFlag();
        }
    }
    
    /**
     * Called when clearing an area which isn't mines.
     * @return true if no mines adjacent, false otherwise, and false if the square has already been revealed.
     */
    public boolean revealNotMine() {
        if ( (isRevealed() == false) && (isMine() == false) ) {
            isRevealed = true;
            int minesAroundSquare = grid.getNumMinesAroundSquare(x, y);
            switch (minesAroundSquare) {
                case 0:
                    imageView.setImage(Images.Type.SQUARE_EMPTY.getImage());
                    return true;
                case 1: imageView.setImage(Images.Type.SQUARE_1.getImage()); return false;
                case 2: imageView.setImage(Images.Type.SQUARE_2.getImage()); return false;
                case 3: imageView.setImage(Images.Type.SQUARE_3.getImage()); return false;
                case 4: imageView.setImage(Images.Type.SQUARE_4.getImage()); return false;
                case 5: imageView.setImage(Images.Type.SQUARE_5.getImage()); return false;
                case 6: imageView.setImage(Images.Type.SQUARE_6.getImage()); return false;
                case 7: imageView.setImage(Images.Type.SQUARE_7.getImage()); return false;
                case 8: imageView.setImage(Images.Type.SQUARE_8.getImage()); return false;
            }
            return false; // We don't reach this line.
        }
        return false;
    }
    
    /**
     * Used at the end of the game to reveal any unclicked mines as mines.
     */
    public void revealIfMine() {
        if ( (isRevealed() == false) && (isMine()) ) {
            imageView.setImage(Images.Type.SQUARE_MINE.getImage());
            isRevealed = true;
        }
    }
    
}
