package com.tracking.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tracking.model.Emp;

public class AdminEmpDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/employee";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Harshith@_12";
    
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employees (emp_name, emp_email, emp_password, emp_role, emp_join_date, emp_phone, emp_address, emp_department) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM employees WHERE emp_id = ?";
    
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public boolean registerEmployee(Emp employee) {
        boolean rowInserted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getPassword());
            preparedStatement.setString(4, employee.getRole());
            preparedStatement.setString(5, employee.getJoinDate());
            preparedStatement.setString(6, employee.getPhone());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setString(8, employee.getDepartment());
            
            rowInserted = preparedStatement.executeUpdate() > 0;
            if (rowInserted) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        employee.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }
    
    public void deleteEmployee(int empId) {
    	
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            preparedStatement.setInt(1, empId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
}
