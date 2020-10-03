package io.github.rsdevigo;

class ControlPoint {
  public String nome;
  public int id;
  public int x;
  public int y;
  public int z;
  public String tempo_ideal;

  public String getNome() {
    return nome;
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

  public void setNome(String name) {
    this.nome = name;
  }

  public void setTempo_ideal(String tempo_ideal) {
    this.tempo_ideal = tempo_ideal;
  }

  public String getTempo_ideal() {
    return this.tempo_ideal;
  }

  public String toString() {
    return this.tempo_ideal;
  }
}