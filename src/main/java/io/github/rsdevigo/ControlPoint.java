package io.github.rsdevigo;

class ControlPoint {
  public String name;
  public int id;
  public int x;
  public int y;
  public int z;

  public String getName() {
    return name;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getZ() {
    return z;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setZ(int z) {
    this.z = z;
  }
  
  public void setY(int y) {
    this.y = y;
  }
  
  public void setName(String name) {
    this.name = name;
  }
}