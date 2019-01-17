/*
 * TCSS 305 - Easy Street
 */
package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * This is a class for Bicycle, which extends AbstractVehicle.
 * 
 * @author Arjun Prajapati
 * @version October 24, 2017
 */
public class Bicycle extends AbstractVehicle {
    /**
     * Death move time of a vehicle.
     */
    public static final int DEATH_MOVES = 30;
    
    /**
     * to store direction.
     */
    private Direction myDirection; 
    
    /**
     * boolean for passing true if allowed to pass.
     */
    private boolean myIsAllowed;
    
    /**
     * This is a constructor to initialize the value of car.
     * 
     * @param theX X co-ordinate of a car.
     * @param theY Y co-ordinate of a car.
     * @param theDir direction of a car.
     */
    public Bicycle(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_MOVES);
        myDirection = theDir;
        
    }
    
    /**
     * Returns whether or not Atv may move onto the given type of
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
        
        if (theTerrain == Terrain.TRAIL || theTerrain == Terrain.STREET) {
            myIsAllowed = true;
        }
        
        if ((theTerrain == Terrain.CROSSWALK || theTerrain == Terrain.LIGHT) 
                        && (theLight == Light.GREEN)) {
            myIsAllowed = true;
        }
        return myIsAllowed;
           
    }
    
    /**
     * Returns the direction Atv would like to move, based on the given
     * map of the neighboring terrain.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this object would like to move.
     */
    
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        if (theNeighbors.get(getDirection()) == Terrain.TRAIL) {
            return getDirection();  
        } else if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
            return getDirection().left();  
        } else if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
            return getDirection().right();
        }
      
        myDirection = getDirection().right();
        // list to store the direction of vehicle
        final ArrayList<Direction> list = new ArrayList<Direction>();
        // loop to add the direction in list using keySet to get direction from map.

        for (final Direction direction : theNeighbors.keySet()) {
            if ((theNeighbors.get(direction) == Terrain.STREET
                            || theNeighbors.get(direction) == Terrain.CROSSWALK
                            || theNeighbors.get(direction) == Terrain.LIGHT)
                            && (direction != getDirection().reverse())) {
                list.add(direction);
                    
            }
            
        }
        
        
        // statement to return chose random direction from list.
        // if empty list return reverse direction.
        if (!list.isEmpty()) {
            //get the first value which will be Trail mostly if the trail is near.
//            myDirection = list.get(0);
            final Random random = new Random();
            final int num = random.nextInt(list.size());
            myDirection = list.get(num);
        } else {
            myDirection = getDirection().reverse();
            
        }
        return myDirection;
        
        
        
//        if (theNeighbors.get(getDirection()) == Terrain.TRAIL) {
//            myDirection = getDirection();  
//        } else if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
//            myDirection = getDirection().left();  
//        } else if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
//            myDirection = getDirection().right();
//        } else if ((theNeighbors.get(getDirection()) == Terrain.STREET) 
//                        || (theNeighbors.get(getDirection()) == Terrain.LIGHT)) {
//            myDirection = getDirection();
//        } else if ((theNeighbors.get(getDirection().left()) == Terrain.STREET) 
//                        || (theNeighbors.get(getDirection().left()) == Terrain.LIGHT)) {
//            myDirection = getDirection().left();
//        } else if ((theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK)
//                        || (theNeighbors.get(getDirection().left()) == Terrain.LIGHT)) {
//            myDirection = getDirection().left();
//            
//        } else if ((theNeighbors.get(getDirection().right()) == Terrain.STREET) 
//                        || (theNeighbors.get(getDirection().right()) == Terrain.LIGHT)) {
//            myDirection = getDirection().right();
//        } else if ((theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK)
//                        || (theNeighbors.get(getDirection().left()) == Terrain.LIGHT)) {
//            myDirection = getDirection().left();
//        } else {
//            myDirection = getDirection().reverse();
//        }
//        return myDirection;
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(128); 
        builder.append(getClass().getSimpleName());
        builder.append(" (Direction: ");
        builder.append(getDirection() + ",");
        builder.append(" Death Moves: ");
        builder.append(DEATH_MOVES + ")");
        return builder.toString();
        
        
    }
}
