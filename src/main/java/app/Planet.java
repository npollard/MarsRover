package app;

import java.util.ArrayList;

public class Planet {
  int width, height;
  ArrayList<int[]> obstacles;

  public Planet(int width, int height) {
    if (width < 1 || height < 1) {
      System.err.printf("ERROR: invalid planet dimensions.\n");
      System.exit(1);
    }

    this.width = width;
    this.height = height;
    obstacles = new ArrayList<int[]>();

  }

  public int getWidth() {
    return width;
  
  }

  public int getHeight() {
    return height;
  
  }

  public void addObstacle(int x, int y) {
    int[] obstacle = {x, y};
    obstacles.add(obstacle);

  }

  public boolean hasObstacleAt(int x, int y) {
    for (int i = 0; i < obstacles.size(); i++) {
      if (obstacles.get(i)[0] == x && obstacles.get(i)[1] == y) return true;

    }
    return false;

  }



}
