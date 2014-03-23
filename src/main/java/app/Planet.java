package app;

import java.util.ArrayList;

public class Planet {
  int width;
  int height;
  ArrayList<int[]> obstacles;

  public Planet(int width, int height, ArrayList<int[]> obstacles) {
    if (width < 1 || height < 1) {
      System.err.printf("ERROR: invalid planet size.\n");
      System.exit(1);
    }

    this.width = width;
    this.height = height;
    this.obstacles = obstacles;

  }

  public int getWidth() {
    return width;

  }

  public int getHeight() {
    return height;

  }

  public ArrayList<int[]> getObstacles() {
    return obstacles;

  }

}

