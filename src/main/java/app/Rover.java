package app;

public class Rover {
  int x, y;
  char orientation;
  Planet planet;

  public Rover(int x, int y, char orientation, Planet planet) {
    if (x < 0 || y < 0 || x > planet.getWidth() || y > planet.getHeight()) {
      System.err.printf("ERROR: invalid starting location.\n");
      System.err.printf("x = %d, y = %d, width = %d, height = %d\n", x, y, planet.getWidth(), planet.getHeight());
      System.exit(1);
    }

    if (orientation != 'N' && orientation != 'S' && orientation != 'E' && orientation != 'W') {
      System.err.printf("ERROR: invalid starting orientation.\n");
      System.exit(1);
    }

    this.x = x;
    this.y = y;
    this.orientation = orientation;
    this.planet = planet;

  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public char getOrientation() {
    return orientation;
  }

  public void rove(String commands) {
    for (int i = 0; i < commands.length(); i++) {
      char command = commands.charAt(i);
      if (command == 'r' || command == 'l') {
        rotate(command);
      }

      if (command == 'f' || command == 'b') {
        if (!move(command)) break;
      }
    }

  }

  private void rotate(char command) {
    switch (orientation) {
      case 'N': orientation = (command == 'r') ? 'E' : 'W';
                break;
      case 'E': orientation = (command == 'r') ? 'S' : 'N';
                break;
      case 'S': orientation = (command == 'r') ? 'W' : 'E';
                break;
      case 'W': orientation = (command == 'r') ? 'N' : 'S';
                break;
    
    }

  }

  private boolean move(char command) {
    int prevx = x;
    int prevy = y;

    int movement = (command == 'f') ? 1 : -1;
    switch (orientation) {
      case 'N': y += movement;
                break;
      case 'E': x += movement;
                break;
      case 'S': y -= movement;
                break;
      case 'W': x -= movement;
                break;

    }

    // Wrap around the planet's boundaries
    y = y % planet.getHeight();
    x = x % planet.getWidth();

    if (planet.hasObstacleAt(x, y)) {
      System.out.printf("\nOBSTACLE DETECTED AT (%d, %d).\n", x, y);
      System.out.printf("ROVER IS AT (%d, %d) FACING %c.\n\n", prevx, prevy, orientation);
      x = prevx;
      y = prevy;
      return false;
    
    }

    return true;

  }


}
