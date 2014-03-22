package app;

public class Planet {
  int width, height;

  public Planet(int width, int height) {
    if (width < 1 || height < 1) {
      System.err.printf("ERROR: invalid planet dimensions\n");
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
