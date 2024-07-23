package com.tracking.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tracker1DAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Harshith@_12";

    // Method to get a database connection
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // Utility method to close resources
    private static void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve total number of employees
    public static int getTotalEmployeesCount() throws SQLException {
        int count = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT COUNT(*) AS total FROM employees");
            rs = stmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt("total");
            }
        } finally {
            closeResources(conn, stmt, rs);
        }

        return count;
    }

    // Retrieve number of completed projects
    public static int getCompletedProjectsCount() throws SQLException {
        int count = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT COUNT(*) AS completed FROM projects WHERE status = 'completed'");
            rs = stmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt("completed");
            }
        } finally {
            closeResources(conn, stmt, rs);
        }

        return count;
    }

    // Retrieve number of ongoing projects
    public static int getOngoingProjectsCount() throws SQLException {
        int count = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT COUNT(*) AS ongoing FROM projects WHERE status = 'ongoing'");
            rs = stmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt("ongoing");
            }
        } finally {
            closeResources(conn, stmt, rs);
        }

        return count;
    }

    // Retrieve task completion status for a user
    public static ResultSet getTaskCompletionStatus(int userId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT task_status, COUNT(*) AS count FROM tasks where task_assigned_to = ? ");
            stmt.setInt(1, 101);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
}
