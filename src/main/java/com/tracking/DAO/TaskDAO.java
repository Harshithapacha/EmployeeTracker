package com.tracking.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tracking.model.Task;

public class TaskDAO {
	
	

    // Method to get a task by ID
    public static Task getTaskById(int taskId) {
        Task task = null;
        String sql = "SELECT * FROM tasks WHERE task_id = ?";
        
        try (Connection conn = TrackerDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, taskId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String taskName = rs.getString("task_name");
                    String taskDescription = rs.getString("task_description");
                    int assignedTo = rs.getInt("task_assigned_to");
                    Date startDate = rs.getDate("task_start_date");
                    Date endDate = rs.getDate("task_end_date");
                    String status = rs.getString("task_status");

                    task = new Task(taskId, taskName, taskDescription, assignedTo, startDate, endDate, status);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return task;
    }

    // Method to get all tasks
    public static List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        
        try (Connection conn = TrackerDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                int taskId = rs.getInt("task_id");
                String taskName = rs.getString("task_name");
                String taskDescription = rs.getString("task_description");
                int assignedTo = rs.getInt("task_assigned_to");
                Date startDate = rs.getDate("task_start_date");
                Date endDate = rs.getDate("task_end_date");
                String status = rs.getString("task_status");

                Task task = new Task(taskId, taskName, taskDescription, assignedTo, startDate, endDate, status);
                tasks.add(task);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return tasks;
    }

    // Method to add a new task
    public static boolean addTask(Task task) {
        String sql = "INSERT INTO tasks (task_name, task_description, task_assigned_to, task_start_date, task_end_date, task_status) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = TrackerDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, task.getTaskName());
            stmt.setString(2, task.getTaskDescription());
            stmt.setInt(3, task.getTaskAssignedTo());
            stmt.setDate(4, task.getTaskStartDate());
            stmt.setDate(5, task.getTaskEndDate());
            stmt.setString(6, task.getTaskStatus());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    // Method to update an existing task
    public static boolean updateTask(Task task) {
        String sql = "UPDATE tasks SET task_name = ?, task_description = ?, task_assigned_to = ?, task_start_date = ?, task_end_date = ?, task_status = ? WHERE task_id = ?";
        
        try (Connection conn = TrackerDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, task.getTaskName());
            stmt.setString(2, task.getTaskDescription());
            stmt.setInt(3, task.getTaskAssignedTo());
            stmt.setDate(4, task.getTaskStartDate());
            stmt.setDate(5, task.getTaskEndDate());
            stmt.setString(6, task.getTaskStatus());
            stmt.setInt(7, task.getTaskId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    // Method to delete a task
    public static boolean deleteTask(int taskId) {
        String sql = "DELETE FROM tasks WHERE task_id = ?";
        
        try (Connection conn = TrackerDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, taskId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
}
