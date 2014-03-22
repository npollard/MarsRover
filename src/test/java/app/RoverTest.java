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
    marsRover = new Rover();
    planet = new Planet();
    marsMission = new MissionControl(planet, marsRover);
  }

 
	@Test
	public void testBasic() {
    assertTrue(true);
  }   
 

}
