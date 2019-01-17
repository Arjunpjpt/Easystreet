/*
 * TCSS 305 - Easy Street
 */
package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * This is a class for Atv, which extends AbstractVehicle.
 * 
 * @author Arjun Prajapati
 * @version October 24, 2017
 */
public class Atv extends AbstractVehicle {

    /**
     * Death move time of a vehicle.
     */
    public static final int DEATH_MOVES = 20;
    
    /**
     * variable to store direction.
     */
    private Direction myDirection;
    
    /**
     * This is a constructor to initialize the value of car.
     * 
     * @param theX X co-ordinate of a car.
     * @param theY Y co-ordinate of a car.
     * @param theDir direction of a car.
     */
    public Atv(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_MOVES);
        myDirection = theDir;
        
    }
    
//    /**
//     * Returns whether or not Atv may move onto the given type of
//     * terrain, when the street lights are the given color.
//     * 
//     * @param theTerrain The terrain.
//     * @param theLight The light color.
//     * @return whether or not this object may move onto the given type of
//     *         terrain when the street lights are the given color.
//     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        if (theTerrain == Terrain.WALL) {
            return false;
        }
        return true;
        
    }
//    /**
//     * This is a helper method to choose the random direction of vehicle.
//     * If this returns the reverse direction, it will be called again.
//     * @return Direction 
//     */
//    public Direction randomDirection() {
//        myDirection = Direction.random();
//        
//        if (myDirection == getDirection().reverse()) {
//            randomDirection();
//        }
//        return myDirection;
//        
//    }
    /**
     * Returns the direction Atv would like to move, based on the given
     * map of the neighboring terrain.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this object would like to move.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
//        return randomDirection();
        // list to store the direction of vehicle
        final ArrayList<Direction> list = new ArrayList<Direction>();
        // loop to add the direction in list using keySet to get direction from map.
        for (final Direction direction : theNeighbors.keySet()) {
            if ((theNeighbors.get(direction) != Terrain.WALL) 
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
