/*
 * TCSS 305 - Easy Street
 */
package model;



/**
 * This is a superclass, which will be extended by the vehicles.
 * 
 * @author Arjun Prajapati
 * @version October 24, 2017
 */
public abstract class AbstractVehicle implements Vehicle {
    /**
     * variable for the X coordinate. 
     */
    private int myX;
    
    /**
     * variable for y coordinate.
     */
    private int myY;
    
    /**
     * variable for direction.
     */
    private Direction myDirection;
    
    /**
     * variable to store default X.
     */
    private int myDefaultX;
    
    /**
     * variable to store default Y.
     */
    private int myDefaultY;
    
    /**
     * variable to store default direction.
     */
    private Direction myDefaultDirection;
    
    /**
     * variable to store death time.
     */
    private int myDeathTime;
    
    /**
     * variable to store if vehicle is Alive.
     */
    private boolean myIsAlive;
    
    /**
     * variable to count the number of poke.
     */
    private int myPokeTime;
    
    
    /**
     * This is a constructor to initialize the fields.
     * @param theX X co-ordinate of a vehicle.
     * @param theY Y co-ordinate of a vehicle.
     * @param theDir direction of a vehicle.
     * @param theDeathMoves the death time of a vehicle.
     */
    protected AbstractVehicle(final int theX, final int theY, 
                              final Direction theDir, final int theDeathMoves) {
        myX = theX;
        myY = theY;
        myDirection = theDir;
        myDefaultX = theX;
        myDefaultY = theY;
        myDefaultDirection = theDir;
        myDeathTime = theDeathMoves;
        myIsAlive = true;
        
    }


    /**
     * Called when this Vehicle collides with the specified other Vehicle.
     * 
     * @param theOther The other object.
     */
    public void collide(final Vehicle theOther) {
        
//        if ((isAlive() && theOther.isAlive()) && (myDeathTime > theOther.getDeathTime())) {
//            myIsAlive = false;
//        
//        } else if ((isAlive() && theOther.isAlive()) 
//                        && (myDeathTime < theOther.getDeathTime())) {
//            myIsAlive = true;
//        
//        } else if ((isAlive() && theOther.isAlive()) 
//                        && (myDeathTime == theOther.getDeathTime())) {
//            myIsAlive = true;
//        }
        if ((isAlive() && theOther.isAlive()) 
                        && (myDeathTime > theOther.getDeathTime())) {
            myIsAlive = false;
        } else if (((isAlive() && theOther.isAlive()) 
                        && (myDeathTime == theOther.getDeathTime())) 
                        && (myDeathTime > theOther.getDeathTime())) {
            myIsAlive = true;
        }
        
    }

    /**
     * Returns the number of updates between this vehicle's death and when it
     * should be revived.
     * 
     * @return the number of updates.
     */
    public int getDeathTime() {
        return myDeathTime;
        
    }

    /**
     * Returns the file name of the image for this Vehicle object, such as
     * "car.gif".
     * 
     * @return the file name.
     */
    public String getImageFileName() {
        
        final StringBuilder fileName = new StringBuilder();
        fileName.append(getClass().getSimpleName().toLowerCase());
        if (myIsAlive) {
            return (fileName.append(".gif")).toString();
        }
        return (fileName.append("_dead.gif")).toString();
        
    }

    /**
     * Returns this Vehicle object's direction.
     * 
     * @return the direction.
     */
    public Direction getDirection() {
        return myDirection;
    }

    /**
     * Returns this Vehicle object's x-coordinate.
     * 
     * @return the x-coordinate.
     */
    public int getX() {
        return myX;
        
    }

    /**
     * Returns this Vehicle object's y-coordinate.
     * 
     * @return the y-coordinate.
     */
    public int getY() {
        return myY;
        
    }

    /**
     * Returns whether this Vehicle object is alive and should move on the map.
     * 
     * @return true if the object is alive, false otherwise.
     */
    public boolean isAlive() {
        return myIsAlive;
    }

    /**
     * Called by the UI to notify a dead vehicle that 1 movement round has
     * passed, so that it will become 1 move closer to revival.
     */
    public void poke() {
        
        
//        if (isAlive()) {
//            myIsAlive = true;
//        
//        } else if (myPokeTime == myDeathTime) {
//            myIsAlive = true;
//            setDirection(Direction.random());
//            myPokeTime = 0;
//        
//        } else if (myPokeTime < myDeathTime) {
//            myPokeTime++;
//        }
        
        if (myPokeTime == myDeathTime && !isAlive()) {
            myIsAlive = true;
            setDirection(Direction.random());
            myPokeTime = 0;
        } else {
            myPokeTime++;
        }
    }

    /**
     * Moves this vehicle back to its original position.
     */
    public void reset() {
        myX = myDefaultX;
        myY = myDefaultY;
        myDirection = myDefaultDirection;
        myIsAlive = true;
        myPokeTime = 0;
    }

    
    /**
     * Sets this object's facing direction to the given value.
     * 
     * @param theDir The new direction.
     */
    public void setDirection(final Direction theDir) {
        myDirection = theDir;
    }

    /**
     * Sets this object's x-coordinate to the given value.
     * 
     * @param theX The new x-coordinate.
     */
    public void setX(final int theX) {
        myX = theX;
    }

    /**
     * Sets this object's y-coordinate to the given value.
     * 
     * @param theY The new y-coordinate.
     */
    public void setY(final int theY) {
        myY = theY;
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(128); 
        builder.append(getClass().getSimpleName());
        builder.append(" (");
        builder.append(myX);
        builder.append(", ");
        builder.append(myY);
        builder.append(")");
        return builder.toString();
    }

}
