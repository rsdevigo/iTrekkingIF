package io.github.rsdevigo;

class PlayerControlPoint {
  public int id;
  public int x;
  public int y;
  public int z;
  public String player_name;
  public String player_uuid;
  public String point_name;
  public int point_id;

  public int getX() {
    return x;
  }

  public int getPointId() {
    return point_id;
  }

  public void setPointId(int point_id) {
    this.point_id = point_id;
  }

  public String getPointName() {
    return point_name;
  }

  public void setPointName(String point_name) {
    this.point_name = point_name;
  }

  public String getPlayerName() {
    return player_name;
  }

  public void setPlayerName(String player_name) {
    this.player_name = player_name;
  }

  public String getPlayerUUID() {
    return player_uuid;
  }

  public void setPlayerUUID(String player_uuid) {
    this.player_uuid = player_uuid;
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


}