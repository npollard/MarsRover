package app;

public class Planet {
  int width;
  int height;

  public Planet(int width, int height) {
    if (width < 1 || height < 1) {
      System.err.printf("ERROR: invalid planet size.\n");
      System.exit(1);
    }

    this.width = width;
    this.height = height;

  }

  public int getWidth() {
    return width;

  }

  public int getHeight() {
    return height;

  }

}

