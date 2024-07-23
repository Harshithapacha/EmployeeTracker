<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Registration</title>
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
        .registration-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
        }
        .registration-container h1 {
            margin-bottom: 20px;
        }
        .registration-container label, .registration-container input {
            width: 95%;
            display: block;
            margin-bottom: 10px;
        }
        .registration-container input[type="text"], .registration-container input[type="email"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .registration-container button {
            width: 100%;
            padding: 10px;
            background-color: #191970;
            font-family: "Times New Roman", Times, serif;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        .registration-container button:hover {
            background-color: #B0C4DE;
        }
    </style>
</head>
<body>
    <div class="registration-container">
        <h1>Employee Registration</h1>
        <form action="AdminEmpServlet" method="post">
            <label for="employeeName">Employee Name:</label>
            <input type="text" id="employeeName" name="employeeName" required>
            <label for="employeeEmail">Employee Email:</label>
            <input type="email" id="employeeEmail" name="employeeEmail" required>
            <label for="employeeRole">Employee Role:</label>
            <input type="text" id="employeeRole" name="employeeRole" required>
            <label for="employeePhone">Employee Phone:</label>
            <input type="text" id="employeePhone" name="employeePhone">
            <label for="employeeAddress">Employee Address:</label>
            <input type="text" id="employeeAddress" name="employeeAddress">
            <label for="employeeDepartment">Employee Department:</label>
            <input type="text" id="employeeDepartment" name="employeeDepartment">
            <input type="hidden" name="action" value="register">
            <button type="submit">Register Employee</button>
        </form>
        <form action="adminemp-management.jsp" method="get">
            <button type="submit">Back to Employee Management</button>
        </form>
    </div>
</body>
</html>
