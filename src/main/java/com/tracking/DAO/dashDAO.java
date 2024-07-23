package com.tracking.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dashDAO {

    public int getTotalEmployees() {
        int totalEmployees = 0;
        String query = "SELECT COUNT(*) AS total FROM employees";
        
        try (Connection connection = TrackerDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                totalEmployees = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return totalEmployees;
    }
    
    public int getCompletedProjects() {
        int completedProjects = 0;
        String query = "SELECT COUNT(*) AS total FROM tasks WHERE status = 'Completed'";
        
        try (Connection connection = TrackerDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                completedProjects = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return completedProjects;
    }

    public int getOngoingProjects() {
        int ongoingProjects = 0;
        String query = "SELECT COUNT(*) AS total FROM tasks WHERE status = 'Ongoing'";
        
        try (Connection connection = TrackerDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ongoingProjects = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ongoingProjects;
    }
}
