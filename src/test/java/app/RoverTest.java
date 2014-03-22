package app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class RoverTest {
  Planet mars;
  Rover marsRover;

  @Before
  public void setup() {
    mars = new Planet(100, 100);
    marsRover = new Rover(0, 0, 'W', mars);
  }

 
	@Test
	public void testSetup() {
    assertEquals("Rover start x", 0, marsRover.getX());
    assertEquals("Rover start y", 0, marsRover.getY());
    assertEquals("Rover start orientation", 'W', marsRover.getOrientation());
  
  }
  
  @Test
  public void testRotation() {
    marsRover.move("r");
    assertEquals("Rover rotation", 'N', marsRover.getOrientation());
    marsRover.move("r");
    assertEquals("Rover rotation", 'E', marsRover.getOrientation());
    marsRover.move("r");
    assertEquals("Rover rotation", 'S', marsRover.getOrientation());
    marsRover.move("r");
    assertEquals("Rover rotation", 'W', marsRover.getOrientation());
    marsRover.move("l");
    assertEquals("Rover rotation", 'S', marsRover.getOrientation());
    marsRover.move("l");
    assertEquals("Rover rotation", 'E', marsRover.getOrientation());
    marsRover.move("l");
    assertEquals("Rover rotation", 'N', marsRover.getOrientation());
    marsRover.move("l");
    assertEquals("Rover rotation", 'W', marsRover.getOrientation());

  }
 

}
