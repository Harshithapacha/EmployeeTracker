package com.tracking.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogoutDAO {
    public void logLogoutEvent(String username) {
        String sql = "INSERT INTO logout_log (username, logout_time) VALUES (?, CURRENT_TIMESTAMP)";

        try (Connection conn = TrackerDAO.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
