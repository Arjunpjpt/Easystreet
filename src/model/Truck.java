/* 
 * TCSS 305 - Easy Street
 */
 
package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * This is the child class Truck which inherits the AbstractVehicle class.
 * @author Arjun Prajapati
 * @version October 24, 2017
 */
public class Truck extends AbstractVehicle {
    /**
     * Death move time of a vehicle.
     */
    private static final int DEATH_MOVES = 0;

    /**
     * gives a direction for a truck.
     */
    private Direction myDirection;
    
    /**
     * This is a constructor to call super class passing some parameters.
     * @param theX X coordinate direction of Truck
     * @param theY Y coordinate direction of Truck
     * @param theDir Direction of truck
     */
    public Truck(final int theX, final int theY, final Direction theDir) {
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
        if (theTerrain == Terrain.LIGHT || theTerrain == Terrain.STREET) {
            return true;
        }
        if (theTerrain == Terrain.CROSSWALK) {
            if (theLight != Light.RED) {
                return true;
            }
        }
        return false;
        
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
        // list to store the direction of vehicle
        final ArrayList<Direction> list = new ArrayList<Direction>();
        // loop to add the direction in list using keySet to get direction from map.

        for (final Direction direction : theNeighbors.keySet()) {
            if ((theNeighbors.get(direction) == Terrain.CROSSWALK 
                            || theNeighbors.get(direction) == Terrain.STREET
                            || theNeighbors.get(direction) == Terrain.LIGHT)
                            && (direction != getDirection().reverse())) {
                list.add(direction);
                    
            }
            
        }
        
        
        // statement to return chose random direction from list.
        // if empty list return reverse direction.
        if (!list.isEmpty()) {
            final Random random = new Random();
            final int num = random.nextInt(list.size());
            myDirection = list.get(num);
        } else {
            myDirection = getDirection().reverse();
            
        }
        return myDirection;
        
        
        
//        truck randomly select
//        myDirection = Direction.random();
//        if ((theNeighbors.get(getDirection()) == Terrain.STREET) 
//                        || (theNeighbors.get(getDirection()) == Terrain.LIGHT)
//                        || (theNeighbors.get(getDirection()) == Terrain.CROSSWALK)) {
//            myDirection = getDirection();
//        } else if ((theNeighbors.get(getDirection().left()) == Terrain.STREET) 
//                        || (theNeighbors.get(getDirection().left()) == Terrain.LIGHT)
//                        || (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK)) {
//            myDirection = getDirection().left();
//      
//            
//        } else if ((theNeighbors.get(getDirection().right()) == Terrain.STREET) 
//                        || (theNeighbors.get(getDirection().right()) == Terrain.LIGHT)
//                        || (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK)) {
//            myDirection = getDirection().right();
//        } else {
//            myDirection = getDirection().reverse();
//        }
//        return myDirection;
    
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
