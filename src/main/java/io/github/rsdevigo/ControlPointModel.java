package io.github.rsdevigo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


class ControlPointModel {

  public static ControlPoint getControlPoint(int x, int y, int z) {
    Statement stmt = null;
    ResultSet rs = null;

    try {
        stmt = iTrekkingIF.connection.createStatement();
        rs = stmt.executeQuery("SELECT * FROM control_point WHERE x = "+String.valueOf(x)+" AND y = "+String.valueOf(y)+" AND z = "+String.valueOf(z)+" LIMIT 1");

        while(rs.next()){
          ControlPoint cp = new ControlPoint();
          cp.setId(rs.getInt("id"));
          cp.setX(rs.getInt("x"));
          cp.setY(rs.getInt("y"));
          cp.setZ(rs.getInt("z"));
          cp.setName(rs.getString("name"));
          return cp;
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