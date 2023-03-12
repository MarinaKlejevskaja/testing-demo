package org.example.hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Hotel {

    public List<String> fetchAvailableRooms() {
        List<String> availableRooms = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection("DATABASE_URL");
            Statement statement = conn.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("SELECT * FROM ROOMS WHERE AVAILABLE like '1'");
            while (rs.next()) {
                availableRooms.add(rs.getString("Room name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return availableRooms;
    }
}
