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

  public char getRoverOrientation() {
    return rover.getOrientation();
  
  }

  public int getRoverX() {
    return rover.getX();

  }

  public int getRoverY() {
    return rover.getY();
  
  }


  public void rove(String commands) {
    char command;
    
    for (int i = 0; i < commands.length(); i++) {
      command = commands.charAt(i);
      
      if (command != 'l' && command != 'r' && command != 'f' && command != 'b') {
        System.err.printf("ERROR: invalid roving command.\n");
        System.exit(1);
      }

      if (command == 'l' || command == 'r') rover.rotate(command);
      if (command == 'f' || command == 'b') {
        if (!rover.move(command, planet.getWidth(), planet.getHeight(), planet.getObstacles())) {
          break;
        }
      }

    }

  }


}
