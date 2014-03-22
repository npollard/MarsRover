package app;

public class MissionControl {
  private Rover rover;
  private Planet planet;

  public MissionControl(Planet planet, Rover rover) {
    if (rover.getX() > planet.getWidth() || rover.getY() > planet.getHeight()) {
      System.err.printf("ERROR: rover coordinates not within planet bounds.\n");
      System.exit(1);
    }

    this.planet = planet;
    this.rover = rover;
  
  }


}
