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
    
//    static {
//        System.out.println("Images() static initialisation block");
//        try {
//        System.out.println("Working Directory = " +
//              System.getProperty("user.dir"));
//        String current = new java.io.File( "." ).getCanonicalPath();
//        System.out.println("Current dir:"+current);
//        String currentDir = System.getProperty("user.dir");
//        System.out.println("Current dir using System:" +currentDir);
//        } catch (Exception e) { System.err.println("Path exception: "+e); }
//        
//        File fileSquare = new File("square.png");
//        System.out.println("square.png exists? "+fileSquare.exists());
//        System.out.println("square.png isFile? "+fileSquare.isFile());
//        System.out.println("square.png canRead? "+fileSquare.canRead());
//        System.out.println("square.png to URI: " +fileSquare.toURI().toString());
//        System.out.println("square.png externalForm: "+Images.class.getResource("info/daveoh/minesweeperfx/square.png").toExternalForm());
//    }
    
//    static {
//        try {
//        square = new Image(new File("square.png").toURI().toURL().toExternalForm());
//        }
//        catch (Exception e) {
//            System.err.println("Images.static exception: "+e);
//        }
//    }
    
    public static void InitialiseImages() {
        try {
//            System.out.println("Working Directory = " +
//                System.getProperty("user.dir"));
//            String current = new java.io.File( "." ).getCanonicalPath();
//            System.out.println("Current dir:"+current);
//            String currentDir = System.getProperty("user.dir");
//            System.out.println("Current dir using System:" +currentDir);
//            
//            File fileSquare = new File("square.png");
//            System.out.println("File URI: "+fileSquare.toURI());
//            System.out.println("Resource URI: "+Object.class.getResource("/info/daveoh/minesweeperfx/square.png").toURI().toURL());
//            if (fileSquare.exists() == false) {
//                throw new RuntimeException("square.png could not be found");
//            }
            
        //square = new Image(new File("square.png").toURI().toURL().toExternalForm());
            square = new Image(Object.class.getResource("/info/daveoh/minesweeperfx/square.png").toURI().toURL().toString());
        
        }
        catch (Exception e) {
            System.err.println("Images.InitialiseImages() exception: "+e);
        }
    }
    
    //public static final Image square = new Image(Images.class.getResource("square.png").toString());
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
