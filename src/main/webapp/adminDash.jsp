<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
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
        .dashboard-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
        }
        .dashboard-container h1 {
            margin-bottom: 20px;
        }
        .dashboard-container label, .dashboard-container input {
            width: 95%;
            display: block;
            margin-bottom: 10px;
        }
        .dashboard-container input[type="text"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .dashboard-container button {
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
        .dashboard-container button:hover {
            background-color: #B0C4DE;
        }
    </style>
    
</head>
<body>
    <div class="dashboard-container">
        <h1>Welcome, Admin</h1>
        
        
        <form action="TaskManagementServlet" method="post">
            <button type="submit"><h2>Task Management</h2></button>
        </form>
        <form action="adminemp-management.jsp" method="post">
            <button type="submit"><h2>Employee Management</h2></button>
        </form>
        <form action="ReportsServlet" method="post">
    <button type="submit"><h2>Reports & Charts</h2></button>
</form>

        
        <form action="LogoutServlet" method="post">
            <button type="submit" class="logout-button"><h2>Logout</h2></button>
        </form>
    </div>
</body>
</html>
</html>