/*
Questo fantasmino seglie la direzione in modo casuale. Se la direzione scelta in modo
casuale Ã¨ bloccata se ne sceglie un'altra fino a quando non ha via libera.
 */
package model.Fantasmi;

import altro.Tile;
import java.util.Random;
import model.PacMan;

public class Clyde extends Fantasma {

    private int counter;
    private int currentDirection;
    int randNumber = 3;
    private int X_MAIN_POS = 288;
    private int Y_MAIN_POS = 256;
    Random rand = new Random();
 
       
    /** 
     * @param tile_width identifies the width of a single tile
     * @param tile_heigth identifies the height of a single tile
     * @param mapWidth identifies the width of the map
     * @param tiles informations about the tiles of the map
     */
    public Clyde(int tile_width, int tile_heigth, int mapWidth, Tile[][] tiles) {
        super(tile_width, tile_heigth, mapWidth, tiles);
        //currentDirection = choose_direction(null);
        x = X_MAIN_POS;
        y = Y_MAIN_POS;
    }
    
    public int choose_direction(PacMan pacman) {
        setCorners();                
        direction(pacman);
        return randNumber;
    }
    
    /**
     * 
     * @param x x position of pacman
     * @param y y position of pacman
     * @return the distance between the ghost and pacman.
     */
    private double radar(int x, int y){

	return Math.sqrt(
            Math.pow(this.x - x, 2) +
            Math.pow(this.y - y, 2)
        );
	
    }
    

    private void direction(PacMan pacman) {
    
        if(radar(pacman.getxPos(),pacman.getyPos())<100){
            switch(pacman.getDirection()){
                case UP:
                    randNumber = 0;
                    break;
                case DOWN:
                    randNumber = 1;
                    break;
                case LEFT:
                    randNumber = 2;
                    break;
                case RIGHT:
                    randNumber = 3;
            }
        }
        
        else{
            switch(randNumber){
                case 0:
                    if((controlloBlockedSu()) == false)
                        randNumber = rand.nextInt(2)+2;
                    break;
                case 1:
                    if((controlloBlockedGiu()) == false)
                        randNumber = rand.nextInt(2)+2;
                    break;
                case 2:
                    if((controlloBlockedSx()) == false){
                        randNumber = rand.nextInt(2);
                    }
                    break;
                case 3:
                    if((controlloBlockedDx()) == false){
                        randNumber = rand.nextInt(2);
                    }
                    break;
            }
        }
    }   
}


