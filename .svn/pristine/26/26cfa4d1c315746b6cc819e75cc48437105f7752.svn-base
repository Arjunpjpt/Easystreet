/*
 * TCSS 305 - Easy Street
 */
package model;

import java.util.Map;

/**
 * This is a class for Car, which extends AbstractVehicle.
 * 
 * @author Arjun Prajapati
 * @version October 24, 2017
 */
public class Car extends AbstractVehicle {
    /**
     * Death move time of a vehicle.
     */
    private static final int DEATH_MOVES = 10;
    /**
     * gives a direction for a car.
     */
    private Direction myDirection; 
     
    
    /**
     * This is a constructor to initialize the value of car.
     * 
     * @param theX X co-ordinate of a car.
     * @param theY Y co-ordinate of a car.
     * @param theDir direction of a car.
     */
    public Car(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_MOVES);
        
//        myDefaultX = theX;
//        myDefaultY = theY;
        myDirection = theDir;
        
    }
    
    /**
     * Returns whether or not Car may move onto the given type of
     * terrain, when the street lights are the given color.
     * 
     * @param theTerrain The terrain.
     * @param theLight The light color.
     * @return whether or not this object may move onto the given type of
     *         terrain when the street lights are the given color.
     */
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        if (theLight == Light.RED && theTerrain == Terrain.LIGHT) {
            return false;
        }
        if (((theLight == Light.RED) || (theLight == Light.YELLOW)) 
                        && theTerrain == Terrain.CROSSWALK) {
            return false;
        }
        return true;
        
    }
    
    /**
     * Returns the direction this object would like to move, based on the given
     * map of the neighboring terrain.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this object would like to move.
     */
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        if ((theNeighbors.get(getDirection()) == Terrain.STREET) 
                        || (theNeighbors.get(getDirection()) == Terrain.LIGHT)
                        || (theNeighbors.get(getDirection()) == Terrain.CROSSWALK)) {
            myDirection = getDirection();
        } else if ((theNeighbors.get(getDirection().left()) == Terrain.STREET) 
                        || (theNeighbors.get(getDirection().left()) == Terrain.LIGHT)
                        || (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK)) {
            myDirection = getDirection().left();
      
            
        } else if ((theNeighbors.get(getDirection().right()) == Terrain.STREET) 
                        || (theNeighbors.get(getDirection().right()) == Terrain.LIGHT)
                        || (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK)) {
            myDirection = getDirection().right();
        } else {
            myDirection = getDirection().reverse();
        }
        return myDirection;
    }
    
//    @Override
//    public String toString() {
//        final StringBuilder builder = new StringBuilder(128); 
//        builder.append(getClass().getSimpleName());
//        builder.append(" (Direction: ");
//        builder.append(getDirection() + ",");
//        builder.append(" Death Moves: ");
//        builder.append(DEATH_MOVES + ")");
//        return builder.toString();
//        
//        
//    }
}
