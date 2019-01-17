/*
 * TCSS 305 - Easy Street
 */
package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * This is a class for Human, which extends AbstractVehicle.
 * 
 * @author Arjun Prajapati
 * @version October 24, 2017
 */
public class Human extends AbstractVehicle {
    /**
     * Death move time of a vehicle.
     */
    private static final int DEATH_MOVES = 50;
    /**
     * variable to store direction.
     */
    private Direction myDirection; 
    
//    private Direction myTempDirection;

    /**
     * This is a constructor to call super class passing some parameters.
     * @param theX X coordinate direction of Human.
     * @param theY Y coordinate direction of Human.
     * @param theDir Direction of Human.
     */
    public Human(final int theX, final int theY, final Direction theDir) {
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
        boolean isAllowed = false;
        
        if (theTerrain == Terrain.GRASS || theTerrain == Terrain.CROSSWALK) {
            isAllowed = true;
        }
        
        if ((theTerrain == Terrain.CROSSWALK || theTerrain == Terrain.LIGHT) 
                        && (theLight == Light.GREEN)) {
            isAllowed = false;
        }
        return isAllowed; 
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
            if (theNeighbors.get(direction) == Terrain.CROSSWALK 
                && direction != getDirection().reverse()) {
                myDirection = direction;
                return myDirection;
            } else if (theNeighbors.get(direction) == Terrain.GRASS
                            && direction != getDirection().reverse()) {
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
    
        
        
//        myDirection = Direction.random();
//        
//        
//        if (theNeighbors.get(myDirection) == Terrain.CROSSWALK) {
//            return myDirection;
//        } else if (theNeighbors.get(myDirection.left()) == Terrain.CROSSWALK) {
//            myDirection = myDirection.left();
//        } else if (theNeighbors.get(myDirection.right()) == Terrain.CROSSWALK) {
//            myDirection = myDirection.right();
//        } else if (theNeighbors.get(myDirection) == Terrain.GRASS) {
//            return myDirection;
//            
//        } else if (theNeighbors.get(myDirection.left()) == Terrain.GRASS) {
//            myDirection = myDirection.left();
//        } else if (theNeighbors.get(myDirection.right()) == Terrain.GRASS) {
//            myDirection = myDirection.right();
//        } else if ((theNeighbors.get(myDirection) != Terrain.GRASS) 
//                        || (theNeighbors.get(myDirection) != Terrain.CROSSWALK)) {
//            myDirection = getDirection().reverse();
//        }
//      
//        return myDirection;
//        
        
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
           
   
