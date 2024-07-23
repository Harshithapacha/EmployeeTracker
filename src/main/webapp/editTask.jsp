<%@ page import="com.tracking.model.Task" %>
<%@ page import="java.sql.Date" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Task</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 100%;
            max-width: 600px;
        }
        h2 {
            margin-top: 0;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"],
        input[type="date"],
        textarea,
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 15px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Edit Task</h2>
        <form action="EditTaskServlet" method="post">
            <input type="hidden" name="taskId" value="${task.taskId}" />
            
            <label for="taskName">Task Name:</label>
            <input type="text" id="taskName" name="taskName" value="${task.taskName}" required />

            <label for="taskDescription">Task Description:</label>
            <textarea id="taskDescription" name="taskDescription" required>${task.taskDescription}</textarea>

            <label for="assignedTo">Assigned To:</label>
            <input type="number" id="assignedTo" name="assignedTo" value="${task.taskAssignedTo}" required />

            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" value="${task.taskStartDate}" required />

            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" value="${task.taskEndDate}" required />

            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="Pending" ${task.taskStatus == 'Pending' ? 'selected' : ''}>Pending</option>
                <option value="In Progress" ${task.taskStatus == 'In Progress' ? 'selected' : ''}>In Progress</option>
                <option value="Completed" ${task.taskStatus == 'Completed' ? 'selected' : ''}>Completed</option>
            </select>

            <input type="submit" value="Update Task" />
        </form>
    </div>
</body>
</html>
