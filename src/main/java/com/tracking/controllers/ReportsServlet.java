package com.tracking.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracking.DAO.ReportsDAO;
import com.tracking.model.Task;

@WebServlet("/ReportsServlet")
public class ReportsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ReportsDAO reportsDAO;

    public void init() {
        reportsDAO = new ReportsDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch all tasks
        List<Task> tasks = reportsDAO.selectAllTasks();
        
        // Fetch counts for completed and ongoing tasks
        int completedCount = reportsDAO.countCompletedTasks();
        int ongoingCount = reportsDAO.countOngoingTasks();
        
        // Debugging lines
        for (Task task : tasks) {
            System.out.println(task.getTaskName() + " - " + task.getTaskStatus());
        }
        
        // Set attributes for JSP
        request.setAttribute("tasks", tasks);
        request.setAttribute("completedCount", completedCount);
        request.setAttribute("ongoingCount", ongoingCount);
        
        // Forward to JSP page
        request.getRequestDispatcher("Reprots.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests similarly if needed
        doPost(request, response);
    }
}
