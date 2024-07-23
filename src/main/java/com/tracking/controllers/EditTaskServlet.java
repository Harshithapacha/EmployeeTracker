package com.tracking.controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracking.DAO.TaskDAO;
import com.tracking.model.Task;

/**
 * Servlet implementation class EditTaskServlet
 */
@WebServlet("/EditTaskServlet")
public class EditTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int taskId = Integer.parseInt(request.getParameter("taskId"));
	        Task task = TaskDAO.getTaskById(taskId);

	        if (task != null) {
	            request.setAttribute("task", task);
	            request.getRequestDispatcher("editTask.jsp").forward(request, response);
	        } else {
	            response.sendRedirect(request.getContextPath() + "/error.jsp");
	        }
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try {
	            int taskId = Integer.parseInt(request.getParameter("taskId"));
	            String taskName = request.getParameter("taskName");
	            String taskDescription = request.getParameter("taskDescription");
	            int assignedTo = Integer.parseInt(request.getParameter("assignedTo"));
	            Date startDate = Date.valueOf(request.getParameter("startDate"));
	            Date endDate = Date.valueOf(request.getParameter("endDate"));
	            String status = request.getParameter("status");

	            Task task = new Task(taskId, taskName, taskDescription, assignedTo, startDate, endDate, status);
	            boolean updated = TaskDAO.updateTask(task);

	            if (updated) {
	                response.sendRedirect(request.getContextPath() + "/TaskManagementServlet");
	            } else {
	                request.setAttribute("errorMessage", "Failed to update task.");
	                request.getRequestDispatcher("error.jsp").forward(request, response);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("errorMessage", "Error updating task.");
	            request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
	    }
	}