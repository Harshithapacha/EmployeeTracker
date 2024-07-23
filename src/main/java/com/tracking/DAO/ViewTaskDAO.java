package com.tracking.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tracking.model.Task;

public class ViewTaskDAO {
    // Method to get tasks by employee ID
	public List<Task> getTasksByEmployeeId(int employeeId) {
        List<Task> tasks = new ArrayList<>();

        try (Connection connection = TrackerDAO.getConnection()) {
            String sql = "SELECT * FROM tasks WHERE task_assigned_to = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, employeeId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Task task = new Task(connection);
                        task.setTaskId(resultSet.getInt("task_id"));
                        task.setTaskName(resultSet.getString("task_name"));
                        task.setTaskDescription(resultSet.getString("task_description"));
                        task.setTaskStartDate(resultSet.getDate("task_start_date"));
                        task.setTaskEndDate(resultSet.getDate("task_end_date"));
                        task.setTaskStatus(resultSet.getString("task_status"));
                        tasks.add(task);
                    }
                }
            }
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }

        return tasks;
    }

    public void updateTaskStatus(int taskId, String taskStatus) {
        try (Connection connection = TrackerDAO.getConnection()) {
            String sql = "UPDATE tasks SET task_status = ? WHERE task_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, taskStatus);
                statement.setInt(2, taskId);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
        }
    }
}

