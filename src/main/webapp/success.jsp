<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Success</title>
    <style>
        body {
        font-family: "Times New Roman", Times, serif;
            background: url('Ep.jpg') no-repeat center center fixed;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            color: #4CAF50;
        }
        p {
            font-size: 18px;
            color: #333;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            text-decoration: none;
            color: #fff;
            background-color: #4CAF50;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>${message}</h2>
        <p>Your Employee ID: ${employeeId}</p>
        <p>Your Password: ${employeePassword}</p>
        <a href="adminemp-management.jsp">Go back to Employee Management</a>
    </div>
</body>
</html>
