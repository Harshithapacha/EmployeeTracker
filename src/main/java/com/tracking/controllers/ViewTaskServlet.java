package com.tracking.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracking.DAO.ViewTaskDAO;
import com.tracking.model.Task;

/**
 * Servlet implementation class ViewTaskServlet
 */
@WebServlet("/ViewTaskServlet")
public class ViewTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String employeeId = request.getParameter("employeeId");

	        try {
	            int empId = Integer.parseInt(employeeId);
	            ViewTaskDAO taskDao = new ViewTaskDAO();
	            List<Task> tasks = taskDao.getTasksByEmployeeId(empId);

	            request.setAttribute("tasks", tasks);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("ViewTask.jsp");
	            dispatcher.forward(request, response);
	        } catch (NumberFormatException e) {
	            // Handle invalid employee ID
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid employee ID");
	        } catch (Exception e) {
	            // Handle any other exceptions
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving tasks");
	        }
	    }
	}
