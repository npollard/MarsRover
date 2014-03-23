package app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class RoverTest {
  Rover marsRover;
  Planet planet;
  MissionControl marsMission;

  @Before
  public void setup() {
    marsRover = new Rover(0, 0, 'N');
    planet = new Planet(10, 10);
    marsMission = new MissionControl(planet, marsRover);
  }

 
	@Test
	public void testRotation() {
    assertEquals("Rover rotation", 'N', marsMission.getRoverOrientation());
    marsMission.rove("l");
    assertEquals("Rover rotation", 'W', marsMission.getRoverOrientation());
    marsMission.rove("l");
    assertEquals("Rover rotation", 'S', marsMission.getRoverOrientation());
    marsMission.rove("l");
    assertEquals("Rover rotation", 'E', marsMission.getRoverOrientation());
    marsMission.rove("l");
    assertEquals("Rover rotation", 'N', marsMission.getRoverOrientation());
    marsMission.rove("r");
    assertEquals("Rover rotation", 'E', marsMission.getRoverOrientation());
    marsMission.rove("r");
    assertEquals("Rover rotation", 'S', marsMission.getRoverOrientation());
    marsMission.rove("r");
    assertEquals("Rover rotation", 'W', marsMission.getRoverOrientation());
    marsMission.rove("r");
    assertEquals("Rover rotation", 'N', marsMission.getRoverOrientation());

  }

  @Test
  public void testMovement() {
    assertEquals("Rover movement", 0, marsMission.getRoverX());
    assertEquals("Rover movement", 0, marsMission.getRoverY());
    marsMission.rove("f");
    assertEquals("Rover movement", 0, marsMission.getRoverX());
    assertEquals("Rover movement", 1, marsMission.getRoverY());
    marsMission.rove("b");
    assertEquals("Rover movement", 0, marsMission.getRoverX());
    assertEquals("Rover movement", 0, marsMission.getRoverY());
  
  }

  @Test
  public void testRoving() {
    marsMission.rove("ffrff");
    assertEquals("Rover roving", 2, marsMission.getRoverX());
    assertEquals("Rover roving", 2, marsMission.getRoverY());

  }

  @Test
  public void testWrapping() {
    marsMission.rove("fffffffff");
    assertEquals("Rover wrapping", 9, marsMission.getRoverY());
    marsMission.rove("f");
    assertEquals("Rover wrapping", 0, marsMission.getRoverY());
    marsMission.rove("rfffffffff");
    assertEquals("Rover wrapping", 9, marsMission.getRoverX());
    marsMission.rove("f");
    assertEquals("Rover wrapping", 0, marsMission.getRoverX());

  }
 

}
