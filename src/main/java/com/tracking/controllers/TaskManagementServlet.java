package com.tracking.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracking.DAO.TaskDAO;
import com.tracking.model.Task;

@WebServlet("/TaskManagementServlet")
public class TaskManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display tasks
        List<Task> tasks = TaskDAO.getAllTasks();
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("TaskManagement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    addTask(request, response);
                    break;
                case "edit":
                    // Forward to the same JSP page with task details
                	int taskId = Integer.parseInt(request.getParameter("taskId"));
                    response.sendRedirect(request.getContextPath() + "/EditTaskServlet?taskId=" + taskId);
                    break;
                case "update":
                    updateTask(request, response);
                    break;
                case "delete":
                    deleteTask(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/TaskManagementServlet");
                    break;
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/TaskManagementServlet");
        }
    }

    private void addTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String taskName = request.getParameter("taskName");
            String taskDescription = request.getParameter("taskDescription");
            int assignedTo = Integer.parseInt(request.getParameter("assignedTo"));
            Date startDate = Date.valueOf(request.getParameter("startDate"));
            Date endDate = Date.valueOf(request.getParameter("endDate"));
            String status = request.getParameter("status");

            Task newTask = new Task(taskName, taskDescription, assignedTo, startDate, endDate, status);

            TaskDAO.addTask(newTask);

            response.sendRedirect(request.getContextPath() + "/TaskManagementServlet");
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/TaskManagementServlet");
        }
    }

    private void updateTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int taskId = Integer.parseInt(request.getParameter("taskId"));
            String taskName = request.getParameter("taskName");
            String taskDescription = request.getParameter("taskDescription");
            int assignedTo = Integer.parseInt(request.getParameter("assignedTo"));
            Date startDate = Date.valueOf(request.getParameter("startDate"));
            Date endDate = Date.valueOf(request.getParameter("endDate"));
            String status = request.getParameter("status");

            Task updatedTask = new Task(taskId, taskName, taskDescription, assignedTo, startDate, endDate, status);

            TaskDAO.updateTask(updatedTask);

            response.sendRedirect(request.getContextPath() + "/TaskManagementServlet");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Invalid number format for assignedTo or taskId.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Invalid parameter value detected.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void deleteTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int taskId = Integer.parseInt(request.getParameter("taskId"));
            TaskDAO.deleteTask(taskId);
            response.sendRedirect(request.getContextPath() + "/TaskManagementServlet");
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/TaskManagementServlet");
        }
    }
}
