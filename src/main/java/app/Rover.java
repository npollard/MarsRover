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

  public int getX() {
    return x;

  }

  public int getY() {
    return y;
  
  }

  public char getOrientation() {
    return orientation;
 
  }

  public void rotate(char command) {
    switch (orientation) {
      case 'N': orientation = (command == 'l') ? 'W' : 'E';
                break;
      case 'S': orientation = (command == 'l') ? 'E' : 'W';
                break;
      case 'E': orientation = (command == 'l') ? 'N' : 'S';
                break;
      case 'W': orientation = (command == 'l') ? 'S' : 'N';
                break;
    }

  }

  public void move(char command, int width, int height) {
    int movement = (command == 'f') ? 1 : -1;

    switch (orientation) {
      case 'N': y += movement;
                break;
      case 'S': y -= movement;
                break;
      case 'E': x += movement;
                break;
      case 'W': x -= movement;
                break;
    }

    x = x % width;
    y = y % height;

  }

}
