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

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * MinesweeperFX
 * @author David Hodgson <daveoh@daveoh.info>
 */
public class MinesweeperFX extends Application {
    
    private static MinesweeperFX instance = null;
    public static MinesweeperFX getInstance() { return instance; }
    
    // Game
    private Game game = null;
    private Difficulty difficulty = Difficulty.EASY;
    
    // UI
        private VBox vbox;
        private GridPane grid;
        private Scene scene;
        private Stage stage;
    // MenuBar
        final private MenuBar menuBar = new MenuBar();
    // Main menus
        final private Menu menuGame = new Menu("Game");
        final private Menu menuHelp = new Menu("Help");
    // Menu Game items
        final private Menu menuGameNew = new Menu("New Game");
        final private MenuItem menuGameNew1 = new MenuItem("One player");
        final private MenuItem menuGameNew2 = new MenuItem("Two players");
        final private Menu menuGameDiff = new Menu("Difficulty");
        final private CheckMenuItem menuGameDiffEasy = new CheckMenuItem("Easy");
        final private CheckMenuItem menuGameDiffMedium = new CheckMenuItem("Medium");
        final private CheckMenuItem menuGameDiffHard = new CheckMenuItem("Hard");
        final private MenuItem menuGameEnd = new MenuItem("End Game");
        final private MenuItem menuGameExit = new MenuItem("Exit");
    
    @Override
    public void start(Stage stage) {
        instance = this;
        this.stage = stage;
        Images.InitialiseImages();
        vbox = new VBox();
        grid = new GridPane();
        
        setupMenuBar();
        vbox.getChildren().addAll(menuBar, grid);
        
        scene = new Scene(vbox, 16*Difficulty.EASY.getGridSize(), 16*Difficulty.EASY.getGridSize() + 51);
        
        stage.setTitle("MinesweeperFX");
        stage.setScene(scene);
        stage.show();
        stage.sizeToScene();
    }
    
    public MenuBar setupMenuBar() {
        
        // Setup
        menuBar.getMenus().addAll(menuGame, menuHelp);
        menuGameEnd.setDisable(true);
        menuGameDiffEasy.setSelected(true);
        
        // Menu Game > New Game
        menuGameNew1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game = new Game(1, difficulty);
                menuGameEnd.setDisable(false);
            }
        });
        menuGameNew2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                game = new Game(2, difficulty);
                menuGameEnd.setDisable(false);
            }
        });
        menuGameNew.getItems().addAll(menuGameNew1, menuGameNew2);
        
        // Menu Game > Difficulty
        menuGameDiffEasy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                setDifficulty(Difficulty.EASY);
            }
        });
        menuGameDiffMedium.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                setDifficulty(Difficulty.MEDIUM);
            }
        });
        menuGameDiffHard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                setDifficulty(Difficulty.HARD);
            }
        });
        menuGameDiff.getItems().addAll(menuGameDiffEasy, menuGameDiffMedium, menuGameDiffHard);
        
        menuGameEnd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                // TODO
                menuGameEnd.setDisable(true);
            }
        });
        menuGameExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                // Exit the application.
                Platform.exit();
            }
        });
        menuGame.getItems().addAll(menuGameNew, menuGameDiff, menuGameEnd, menuGameExit);
        return menuBar;
    }
    
    /**
     * Sets the difficulty of any newly created games.
     * @param diff The difficulty to set.
     */
    public void setDifficulty(Difficulty diff) {
        difficulty = diff;
        // Remove check from all menu items.
        menuGameDiffEasy.setSelected(false);
        menuGameDiffMedium.setSelected(false);
        menuGameDiffHard.setSelected(false);
        // Check appropriate menu item.
        switch (diff) {
            case EASY: menuGameDiffEasy.setSelected(true); break;
            case MEDIUM: menuGameDiffMedium.setSelected(true); break;
            case HARD: menuGameDiffHard.setSelected(true); break;
        }
    }
    
    public void initialiseGrid(Grid gameGrid) {
        grid.getChildren().clear();
        int size = gameGrid.getGridSize();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                ImageView iv = gameGrid.getSquare(x, y).getImageView();
                grid.getChildren().add(iv);
                GridPane.setRowIndex(iv, x);
                GridPane.setColumnIndex(iv, y);
            }
        }
        
        scene.getWindow().setWidth(16*size);
        scene.getWindow().setHeight(16*size + 51);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}