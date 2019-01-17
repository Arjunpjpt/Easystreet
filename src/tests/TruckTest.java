/*
 * TCSS 305 - Easy Street
 */
package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import model.Direction;
import model.Light;
import model.Terrain;
import model.Truck;
import org.junit.Before;
import org.junit.Test;


/**
 * This is a test class for the truck.
 * @author Arjun Prajapati
 * @version October 24, 2017
 *
 */
public class TruckTest {
    /**
     * The number of times to repeat a test to have a high probability that all
     * random possibilities have been explored.
     */
    private static final int TRIES_FOR_RANDOMNESS = 50;
    /**
     * Truck object.
     */
    private Truck myTruck;
    
    
    
//    /**
//     * The number of times to repeat a test to have a high probability that all
//     * random possibilities have been explored.
//     */
//    private static final int DEATH_MOVES = 0;
    
    /**
     * A Map collection with Direction and Terrain as Key and value.
     */
    
   

    /**
     * Test method for initializing the Truck with some given default value.
     */
    @Before
    public void setUp() {
        myTruck = new Truck(10, 11, Direction.EAST);
//        myMap = new HashMap<Direction, Terrain>();
    }


    
    
    
    /** Test method for Human constructor. */
    @Test
    public void testTruckConstructor() {
        myTruck = new Truck(10, 11, Direction.EAST);
        
        assertEquals("Truck x coordinate not initialized correctly!", 10, myTruck.getX());
        assertEquals("Truck y coordinate not initialized correctly!", 11, myTruck.getY());
        assertEquals("Truck direction not initialized correctly!",
                     Direction.EAST, myTruck.getDirection());
        assertEquals("Human death time not initialized correctly!", 0, myTruck.getDeathTime());
        assertTrue("Human isAlive() fails initially!", myTruck.isAlive());
    }
    
//    /** Test method for Human setters. */
//    @Test
//    public void testTruckSetters() {
       // final Truck h = new Truck(10, 11, Direction.NORTH);
//        
//        h.setX(12);
//        assertEquals("Truck setX failed!", 10, h.getX());
//        h.setY(13);
//        assertEquals("Truck setY failed!", 11, h.getY());
//        h.setDirection(Direction.EAST);
//        assertEquals("Truck setDirection failed!", Direction.SOUTH, h.getDirection());
//    }
    /**
     * Test method for truck in STREET.
     */
    @Test
    public void testCanPassStreet() {

        assertEquals(true, myTruck.canPass(Terrain.STREET, Light.RED));
        assertEquals(true, myTruck.canPass(Terrain.STREET, Light.GREEN));
        assertEquals(true, myTruck.canPass(Terrain.STREET, Light.YELLOW));

//        assertNotEquals(false, myTruck.canPass(Terrain.S, Light.RED));
    }
    
    /**
     * Test method for truck in Light.
     */
    @Test
    public void testCanPassLight() {

        assertEquals(true, myTruck.canPass(Terrain.LIGHT, Light.RED));
        assertEquals(true, myTruck.canPass(Terrain.LIGHT, Light.GREEN));
        assertEquals(true, myTruck.canPass(Terrain.LIGHT, Light.YELLOW));

    }
    
    /**
     * Test method for truck in Light.
     */
    @Test
    public void testCanPassCrossWalk() {
        assertEquals(false, myTruck.canPass(Terrain.CROSSWALK, Light.RED));
        assertEquals(true, myTruck.canPass(Terrain.CROSSWALK, Light.GREEN));
        assertEquals(true, myTruck.canPass(Terrain.CROSSWALK, Light.YELLOW));

    }
    /**
     * Test method for truck in other Terrain.
     */
    @Test
    public void testCanPassFail() {

        assertEquals(false, myTruck.canPass(Terrain.GRASS, Light.RED));
        assertEquals(false, myTruck.canPass(Terrain.TRAIL, Light.GREEN));

    }
    
//    /**
//     * Test method for truck in other Terrain.
//     */
//    @Test
//    public void testCollide() {
//
//
//    }
    
     /**
     * Test method for truck for death time.
     */
    @Test
    public void testGetDeathTime() {
        assertEquals(0, myTruck.getDeathTime());
        assertNotEquals(1, myTruck.getDeathTime());
    }
    
//    /**
//     * Test method for truck for get image file name.
//     */
//    @Test
//    public void testGetImageFileNameAlive() {
//        if (myTruck.isAlive()) {
//            assertEquals("truck.gif", myTruck.getImageFileName());
//        } else {
//        
//            assertEquals("truck_dead.gif", myTruck.getImageFileName());
//        }
//       
//    }
    
    /**
     * Test method for truck to get Direction.
     */
    @Test
    public void testGetDirection() {
        assertEquals(Direction.EAST, myTruck.getDirection());
        
    }
    
    /**
    * Test method for truck to get X cordinate.
    */
    @Test
    public void testGetX() {
        assertEquals(10, myTruck.getX());
       
    }
    
    /**
     * Test method for truck to get Y cordinate.
     */
    @Test
    public void testGetY() {
        assertEquals(11, myTruck.getY());
        
    }
    
    /**
     * Test method for truck to check if the vehicle is alive..
     */
    @Test
    public void testIsAlive() {
        assertEquals(true, myTruck.isAlive());
        assertNotEquals(false, myTruck.isAlive());
        
    }
    
    /**
     * Test method for truck to set direction of truck.
     */
    @Test
    public void testSetDirection() {
        myTruck.setDirection(Direction.NORTH);
        assertEquals(Direction.NORTH, myTruck.getDirection());
        assertNotEquals(Direction.EAST, myTruck.getDirection());
    }
    
    /**
     * Test method for truck to set X coordinate of truck.
     */
    @Test
    public void testSetX() {
        
        myTruck.setX(6);
        assertEquals(6, myTruck.getX());
        assertNotEquals(7, myTruck.getX());
    }
    
    /**
    * Test method for truck to set Y coordinate of truck.
    */
    @Test
    public void testSetY() {
        myTruck.setY(6);
        assertEquals(6, myTruck.getY());
        assertNotEquals(7, myTruck.getY());
    }
    
//    /**
//     * Test method for truck to check toString method.
//     */
//    @Test
//    public void testToString() {
//        assertEquals("Truck (Direction: EAST, Death Moves: 0)", myTruck.toString());
//         
//    }
    
    /**
     * Test method for the choose direction of Street.
     */
    @Test
    public void testChooseDirection() {

        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.SOUTH, Terrain.CROSSWALK);
        neighbors.put(Direction.NORTH, Terrain.STREET);
        neighbors.put(Direction.EAST, Terrain.LIGHT);
        neighbors.put(Direction.WEST, Terrain.GRASS);
        
       
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
//        final Truck truck = new Truck(0, 0, Direction.NORTH);
        
        for (int count = 0; count < TRIES_FOR_RANDOMNESS; count++) {
            final Direction d = myTruck.chooseDirection(neighbors);
                            //truck.chooseDirection(neighbors);
            
            if (d == Direction.WEST) {
                seenWest = true;
            } else if (d == Direction.EAST) {
                seenNorth = true;
            } else if (d == Direction.NORTH) {
                seenEast = true;
            } else if (d == Direction.SOUTH) { // this should NOT be chosen
                seenSouth = true;
            }
        }
 
        assertTrue("Human chooseDirection() fails to select randomly "
                   + "among all possible valid choices!",
                   seenSouth && seenNorth && seenEast);
            
        assertFalse("Human chooseDirection() reversed direction when not necessary!",
                    seenWest);
        
        //to test for reverse, pass empty neighbor(map);
        neighbors.clear();
        assertEquals(Direction.WEST, myTruck.chooseDirection(neighbors)); 
        
    }
    
     
    
    
//
//    /**
//     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
//     */
//    @Test
//    public void testChooseDirection() {
//        fail("Not yet implemented");
//    }

}
