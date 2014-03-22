package app;

public class Rover {
  int x, y;
  char orientation;

  public Rover(int x, int y, char orientation) {
    if (x < 0 || y < 0) {
      System.err.printf("ERROR: invalid rover start coordinates.\n");
      System.exit(1);
    }

    if (orientation != 'N' && orientation != 'S' && orientation != 'E' && orientation != 'W') {
      System.err.printf("ERROR: invalid rover start orientation.\n");
      System.exit(1);
    }

    this.x = x;
    this.y = y;
    this.orientation = orientation;

  }

}
