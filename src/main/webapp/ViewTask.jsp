<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tracking.model.Task" %>
<%@ page import="com.tracking.DAO.ViewTaskDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Tasks</title>
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
        .tasks-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 600px;
            text-align: center;
        }
        .tasks-container table {
            width: 100%;
            border-collapse: collapse;
        }
        .tasks-container th, .tasks-container td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        .tasks-container th {
            background-color: #f2f2f2;
        }
        .tasks-container button {
            padding: 10px;
            background-color: #191970;
            font-family: "Times New Roman", Times, serif;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        .tasks-container button:hover {
            background-color: #B0C4DE;
        }
    </style>
</head>
<body>
    <div class="tasks-container">
        <h1>Tasks for Employee ID: ${param.employeeId}</h1>
        <table>
            <tr>
                <th>Task ID</th>
                <th>Task Name</th>
                <th>Description</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Status</th>
                <th>Update Status</th>
            </tr>
            <c:forEach var="task" items="${tasks}">
                <tr>
                    <td>${task.taskId}</td>
                    <td>${task.taskName}</td>
                    <td>${task.taskDescription}</td>
                    <td>${task.taskStartDate}</td>
                    <td>${task.taskEndDate}</td>
                    <td>${task.taskStatus}</td>
                    <td>
                        <form action="TaskManagementServlet" method="post">
                            <input type="hidden" name="taskId" value="${task.taskId}">
                            <select name="taskStatus">
                                <option value="Ongoing" ${task.taskStatus == 'Ongoing' ? 'selected' : ''}>Ongoing</option>
                                <option value="Completed" ${task.taskStatus == 'Completed' ? 'selected' : ''}>Completed</option>
                            </select>
                            <button type="submit">Update</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>