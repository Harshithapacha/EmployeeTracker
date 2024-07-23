<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tracking.model.Task" %>
<%@ page import="com.tracking.DAO.TaskDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task Management</title>
    <style>
        body {
            font-family: "Times New Roman", Times, serif;
            background: url('Ep.jpg') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .task-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 80%;
            text-align: center;
        }
        .task-container h1 {
            margin-bottom: 20px;
        }
        .task-container table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        .task-container table, .task-container th, .task-container td {
            border: 1px solid #ccc;
        }
        .task-container th, .task-container td {
            padding: 10px;
            text-align: center;
        }
        .task-container .add-button, .task-container .back-button {
            background-color: #191970;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-bottom: 10px;
            cursor: pointer;
            border-radius: 4px;
        }
        .task-container .add-button:hover, .task-container .back-button:hover {
            background-color: #B0C4DE;
        }
        .task-container .edit-button, .task-container .delete-button {
            background-color: #DC143C;
            border: none;
            color: white;
            padding: 8px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 2px;
            cursor: pointer;
            border-radius: 4px;
        }
        .task-container .edit-button:hover, .task-container .delete-button:hover {
            background-color: #FF6347;
        }
        .add-task-form, .edit-task-form {
            display: none;
        }
    </style>
    <script>
        function showAddTaskForm() {
            var addTaskForm = document.getElementById("addTaskForm");
            addTaskForm.style.display = "block";
        }

        function showEditTaskForm() {
            var editTaskForm = document.getElementById("editTaskForm");
            editTaskForm.style.display = "block";
        }
    </script>
</head>
<body>
    <div class="task-container">
        <h1>Task Management</h1>
        
        <!-- Display tasks in a table -->
        <table>
            <thead>
                <tr>
                    <th>Task ID</th>
                    <th>Task Name</th>
                    <th>Task Description</th>
                    <th>Assigned To</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
                    if (tasks != null) {
                        for (Task task : tasks) {
                %>
                <tr>
                    <td><%= task.getTaskId() %></td>
                    <td><%= task.getTaskName() %></td>
                    <td><%= task.getTaskDescription() %></td>
                    <td><%= task.getTaskAssignedTo() %></td>
                    <td><%= task.getTaskStartDate() %></td>
                    <td><%= task.getTaskEndDate() %></td>
                    <td><%= task.getTaskStatus() %></td>
                    <td>
                        <form action="TaskManagementServlet" method="post" style="display:inline;">
                            <input type="hidden" name="taskId" value="<%= task.getTaskId() %>">
                            <input type="hidden" name="action" value="edit">
                            <button type="submit" class="edit-button">Edit</button>
                        </form>
                        <form action="TaskManagementServlet" method="post" style="display:inline;">
                            <input type="hidden" name="taskId" value="<%= task.getTaskId() %>">
                            <input type="hidden" name="action" value="delete">
                            <button type="submit" class="delete-button">Delete</button>
                        </form>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>

        <!-- Button to show Add Task form -->
        <button class="add-button" onclick="showAddTaskForm()">Add Task</button>

        <!-- Add Task Form -->
        <div id="addTaskForm" class="add-task-form">
            <form action="TaskManagementServlet" method="post">
                <input type="hidden" name="action" value="add">
                <label for="taskName">Task Name:</label>
                <input type="text" id="taskName" name="taskName" required><br><br>
                <label for="taskDescription">Task Description:</label>
                <input type="text" id="taskDescription" name="taskDescription" required><br><br>
                <label for="assignedTo">Assigned To (Employee ID):</label>
                <input type="number" id="assignedTo" name="assignedTo" required><br><br>
                <label for="startDate">Start Date:</label>
                <input type="date" id="startDate" name="startDate" required><br><br>
                <label for="endDate">End Date:</label>
                <input type="date" id="endDate" name="endDate" required><br><br>
                <label for="status">Status:</label>
                <input type="text" id="status" name="status" required><br><br>
                <button type="submit" class="add-button">Add Task</button>
            </form>
        </div>

        <!-- Edit Task Form -->
        <div id="editTaskForm" class="edit-task-form">
            <form action="TaskManagementServlet" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="taskId" value="<%= request.getAttribute("task") != null ? ((Task) request.getAttribute("task")).getTaskId() : "" %>">
                <label for="taskName">Task Name:</label>
                <input type="text" id="taskName" name="taskName" value="<%= request.getAttribute("task") != null ? ((Task) request.getAttribute("task")).getTaskName() : "" %>" required><br><br>
                <label for="taskDescription">Task Description:</label>
                <input type="text" id="taskDescription" name="taskDescription" value="<%= request.getAttribute("task") != null ? ((Task) request.getAttribute("task")).getTaskDescription() : "" %>" required><br><br>
                <label for="assignedTo">Assigned To (Employee ID):</label>
                <input type="number" id="assignedTo" name="assignedTo" value="<%= request.getAttribute("task") != null ? ((Task) request.getAttribute("task")).getTaskAssignedTo() : "" %>" required><br><br>
                <label for="startDate">Start Date:</label>
                <input type="date" id="startDate" name="startDate" value="<%= request.getAttribute("task") != null ? ((Task) request.getAttribute("task")).getTaskStartDate() : "" %>" required><br><br>
                <label for="endDate">End Date:</label>
                <input type="date" id="endDate" name="endDate" value="<%= request.getAttribute("task") != null ? ((Task) request.getAttribute("task")).getTaskEndDate() : "" %>" required><br><br>
                <label for="status">Status:</label>
                <input type="text" id="status" name="status" value="<%= request.getAttribute("task") != null ? ((Task) request.getAttribute("task")).getTaskStatus() : "" %>" required><br><br>
                <button type="submit" class="add-button">Update Task</button>
            </form>
        </div>

        <!-- Button to go back -->
        <button class="back-button" onclick="window.location.href='adminDash.jsp'">Back to Dashboard</button>
    </div>
</body>
</html>
