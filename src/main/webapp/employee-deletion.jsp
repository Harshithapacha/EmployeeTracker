<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Deletion</title>
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
        .deletion-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
        }
        .deletion-container h1 {
            margin-bottom: 20px;
        }
        .deletion-container label, .deletion-container input {
            width: 95%;
            display: block;
            margin-bottom: 10px;
        }
        .deletion-container input[type="text"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .deletion-container button {
            width: 100%;
            padding: 10px;
            background-color: #191970;
            font-family: "Times New Roman", Times, serif;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        .deletion-container button:hover {
            background-color: #B0C4DE;
        }
    </style>
</head>
<body>
    <div class="deletion-container">
        <h1>Employee Deletion</h1>
        <form action="AdminEmpServlet" method="post">
            <label for="employeeId">Employee ID:</label>
            <input type="text" id="employeeId" name="employeeId" required>
            <input type="hidden" name="action" value="delete">
            <button type="submit">Delete Employee</button>
        </form>
        <form action="adminemp-management.jsp" method="get">
            <button type="submit">Back to Employee Management</button>
        </form>
    </div>
</body>
</html>
