/*
 * TCSS 305 - Easy Street
 */
package model;

import java.util.Map;

/**
 * This is a class for Taxi, which extends AbstractVehicle.
 * 
 * @author Arjun Prajapati
 * @version October 24, 2017
 */
public class Taxi extends AbstractVehicle {

    /**
     * Death move time of a vehicle.
     */
    public static final int DEATH_MOVES = 10;
    
    /**
     * variable for counting 3 clock cycle.
     */
    private int myClockCycle = -1;
    /**
     * boolean for passing true if allowed to pass.
     */
    private boolean myIsAllowed;
    
    
    /**
     * gives a direction for a Taxi.
     */
    private Direction myDirection;
    /**
     * This is a constructor to call super class passing some parameters.
     * @param theX X coordinate direction of Taxi.
     * @param theY Y coordinate direction of Taxi.
     * @param theDir Direction of taxi.
     */
    public Taxi(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_MOVES);
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
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        myIsAllowed = false;
        if (theTerrain == Terrain.STREET) {
            myIsAllowed = true;
        }
        
        if ((theLight != Light.RED) && theTerrain == Terrain.LIGHT) {
            myIsAllowed = true;
        }
        if ((theLight != Light.RED) && theTerrain == Terrain.CROSSWALK) {
            myClockCycle = -1;
            myIsAllowed = true;
        }
        
        if (theLight == Light.RED  && theTerrain == Terrain.CROSSWALK) {
            myClockCycle++;
        }
        if (myClockCycle == 2) {
            myClockCycle = -1;
            myIsAllowed = true;
        }
        
        return myIsAllowed;
    } 
    
    
    /**
     * Returns the direction this object would like to move, based on the given
     * map of the neighboring terrain.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this object would like to move.
     */   
    @Override
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
//    }
              
}
