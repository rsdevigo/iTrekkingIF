package io.github.rsdevigo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


class PlayerControlPointModel {

  public static boolean create(String uuid, int point_id, String point_name, int x, int y, int z, String player_name) {
    Statement stmt = null;

    try {
        stmt = iTrekkingIF.connection.createStatement();
        String values = String.valueOf(x)+","+String.valueOf(y)+","+String.valueOf(z)+",\""+player_name+"\", \""+uuid+"\", \""+point_name+"\", "+point_id;
        int rows = stmt.executeUpdate("INSERT INTO player_control_point(x, y, z, player_name, player_uuid, point_name, point_id) VALUES("+values+")");

        if (rows > 0) {
          return true;
        }

        return false;
    }
    catch (SQLException ex){
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
    finally {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { } // ignore

            stmt = null;
        }
    }
    return false;
  }
  public static PlayerControlPoint findByPlayer(String uuid, int point_id) {
    Statement stmt = null;
    ResultSet rs = null;

    try {
        stmt = iTrekkingIF.connection.createStatement();
        rs = stmt.executeQuery("SELECT * FROM player_control_point WHERE player_uuid LIKE \""+uuid+"\" AND point_id = "+String.valueOf(point_id)+" LIMIT 1");

        while(rs.next()){
          PlayerControlPoint pcp = new PlayerControlPoint();
          pcp.setId(rs.getInt("id"));
          pcp.setX(rs.getInt("x"));
          pcp.setY(rs.getInt("y"));
          pcp.setZ(rs.getInt("z"));
          pcp.setPlayerName(rs.getString("player_name"));
          pcp.setPointName(rs.getString("point_name"));
          pcp.setPlayerUUID(rs.getString("player_uuid"));
          pcp.setPointId(rs.getInt("point_id"));
          return pcp;
        }

        return null;
    }
    catch (SQLException ex){
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
    finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) { } // ignore

            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { } // ignore

            stmt = null;
        }
    }
    return null;
  }
}