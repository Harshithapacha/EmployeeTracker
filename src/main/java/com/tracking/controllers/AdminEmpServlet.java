package com.tracking.controllers;

import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracking.DAO.AdminEmpDAO;
import com.tracking.model.Emp;

@WebServlet("/AdminEmpServlet")
public class AdminEmpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        AdminEmpDAO employeeDAO = new AdminEmpDAO();

        switch (action) {
            case "register":
                // Handle employee registration
                String name = request.getParameter("employeeName");
                String email = request.getParameter("employeeEmail");
                String role = request.getParameter("employeeRole");
                String joinDate = request.getParameter("employeeJoinDate");
                String phone = request.getParameter("employeePhone");
                String address = request.getParameter("employeeAddress");
                String department = request.getParameter("employeeDepartment");

                // Generate random password
                String password = generateRandomPassword();

                Emp newEmployee = new Emp(name, email, password, role, joinDate, phone, address, department);
                boolean isRegistered = employeeDAO.registerEmployee(newEmployee);

                if (isRegistered) {
                    // Set attributes to display on success page
                    request.setAttribute("message", "Your Registration is Successful!!");
                    request.setAttribute("employeeId", newEmployee.getId());
                    request.setAttribute("employeePassword", password);
                    request.getRequestDispatcher("success.jsp").forward(request, response);
                } else {
                    response.sendRedirect("error.jsp");
                }
                break;
            case "delete":
                // Handle employee deletion
                int empIdToDelete = Integer.parseInt(request.getParameter("employeeId"));
                employeeDAO.deleteEmployee(empIdToDelete);
                response.sendRedirect("employee-deletion.jsp");
                break;
            
            default:
                // Handle invalid action
                response.sendRedirect("error.jsp");
                return;
        }
    }

    private String generateRandomPassword() {
        SecureRandom random = new SecureRandom();
        int tempPassword = 100000 + random.nextInt(900000);
        return String.valueOf(tempPassword);
    }
}
