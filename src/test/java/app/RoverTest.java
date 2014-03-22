package app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class RoverTest {

  @Before
  public void setUp() {
    Planet mars = new Planet(100, 100);
    Rover marsRover = new Rover(0, 0, 'W', mars);
  }

 
	@Test
	public void testBasic() {
    assertTrue(true);
  }   
 

}
