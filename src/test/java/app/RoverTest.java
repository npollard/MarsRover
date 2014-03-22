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
    mars = new Planet(10, 10);
    marsRover = new Rover(0, 0, 'N', mars);
  }

 
	@Test
	public void testSetup() {
    assertEquals("Rover start x", 0, marsRover.getX());
    assertEquals("Rover start y", 0, marsRover.getY());
    assertEquals("Rover start orientation", 'N', marsRover.getOrientation());
  
  }
  
  @Test
  public void testRotation() {
    assertEquals("Rover rotation", 'N', marsRover.getOrientation());
    marsRover.rove("r");
    assertEquals("Rover rotation", 'E', marsRover.getOrientation());
    marsRover.rove("r");
    assertEquals("Rover rotation", 'S', marsRover.getOrientation());
    marsRover.rove("r");
    assertEquals("Rover rotation", 'W', marsRover.getOrientation());
    marsRover.rove("r");
    assertEquals("Rover rotation", 'N', marsRover.getOrientation());
    marsRover.rove("l");
    assertEquals("Rover rotation", 'W', marsRover.getOrientation());
    marsRover.rove("l");
    assertEquals("Rover rotation", 'S', marsRover.getOrientation());
    marsRover.rove("l");
    assertEquals("Rover rotation", 'E', marsRover.getOrientation());
    marsRover.rove("l");
    assertEquals("Rover rotation", 'N', marsRover.getOrientation());

  }

  @Test
  public void testBasicMovement() {
    marsRover.rove("f");
    assertEquals("Rover basic movement", 0, marsRover.getX());
    assertEquals("Rover basic movement", 1, marsRover.getY());
    marsRover.rove("b");
    assertEquals("Rover basic movement", 0, marsRover.getX());
    assertEquals("Rover basic movement", 0, marsRover.getY());
    marsRover.rove("r");
    marsRover.rove("f");
    assertEquals("Rover basic movement", 1, marsRover.getX());
    assertEquals("Rover basic movement", 0, marsRover.getY());
    marsRover.rove("b");
    assertEquals("Rover basic movement", 0, marsRover.getX());
    assertEquals("Rover basic movement", 0, marsRover.getY());

  }

  @Test
  public void testRoving() {
    marsRover.rove("ffrff");
    assertEquals("Rover rove", 2, marsRover.getX());
    assertEquals("Rover rove", 2, marsRover.getY());
  
  }

  @Test
  public void testWrapping() {
    marsRover.rove("fffffffff");
    assertEquals("Rover y wrap", 9, marsRover.getY());
    marsRover.rove("f");
    assertEquals("Rover y wrap", 0, marsRover.getY());  
    marsRover.rove("rfffffffff");
    assertEquals("Rover x wrap", 9, marsRover.getX());
    marsRover.rove("f");
    assertEquals("Rover x wrap", 0, marsRover.getX());
  
  }

  @Test
  public void testObstacles() {
    mars.addObstacle(2, 2);
    marsRover.rove("ffrffff");
    assertEquals("Rover obstacle", 1, marsRover.getX());
    assertEquals("Rover obstacle", 2, marsRover.getY());
  }
 

}
