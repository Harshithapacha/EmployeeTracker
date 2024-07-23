package com.tracking.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracking.DAO.LoginDAO;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Role: " + role);

        LoginDAO loginDao = new LoginDAO();

        // Validate user credentials
        boolean isValidUser = false;
        if ("admin".equals(role)) {
            isValidUser = loginDao.validateAdmin(username, password);
        } else if ("customer".equals(role)) {
            isValidUser =  loginDao.validateCustomer(username, password);
        }

        if (isValidUser) {
        	 
            if ("admin".equals(role)) {
                // Redirect to the admin dashboard
                request.getSession().setAttribute("username", username);
                response.sendRedirect("adminDash.jsp");
            } else if ("customer".equals(role)) {
                // Redirect to the customer dashboard
                request.getSession().setAttribute("username", username);
                response.sendRedirect("EmployeeDash.jsp");
            }
        } else {
            // If credentials are not valid, redirect to the login page with an error message
            response.sendRedirect("index.jsp?error=Invalid%20username%20or%20password");
        }
    }
}
