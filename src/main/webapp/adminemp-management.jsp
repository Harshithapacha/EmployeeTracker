<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
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
        .management-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 500px;
            text-align: center;
        }
        .management-container h1 {
            margin-bottom: 20px;
        }
        .management-container button {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #191970;
            font-family: "Times New Roman", Times, serif;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        .management-container button:hover {
            background-color: #B0C4DE;
        }
    </style>
</head>
<body>
    <div class="management-container">
        <h1>Employee Management</h1>
        <form action="employee-registration.jsp" method="post">
            <button type="submit"><h2>Employee Registration</h2></button>
        </form>
        <form action="employee-deletion.jsp" method="post">
            <button type="submit"><h2>Employee Deletion</h2></button>
        </form>
        
        <form action="adminDash.jsp" method="get">
            <button type="submit"><h2>Back to Dashboard</h2></button>
        </form>
    </div>
</body>
</html>
