package app;

import java.util.ArrayList;

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

  public boolean move(char command, int width, int height, ArrayList<int[]> obstacles) {
    int oldX = x;
    int oldY = y;

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

    if (obstructedCoordinate(obstacles)) {
      System.out.printf("OBSTACLE DETECTED AT (%d, %d).\n", x, y);
      x = oldX;
      y = oldY;
      System.out.printf("ROVER IS AT (%d, %d).\n", x, y);
      return false;

    }

    return true;

  }

  private boolean obstructedCoordinate(ArrayList<int[]> obstacles) {
    for (int i = 0; i < obstacles.size(); i++) {
      if (obstacles.get(i)[0] == x && obstacles.get(i)[1] == y) return true;
    
    }

    return false;

  }

}
