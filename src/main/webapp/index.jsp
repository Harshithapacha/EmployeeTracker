<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
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
        .login-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            font-family: "Times New Roman", Times, serif;
        }
        .login-container h1 {
            margin-bottom: 20px;
            text-align: center;
        }
        .login-container label {
            display: block;
            margin-bottom: 5px;
        }
        .login-container input[type="text"], .login-container input[type="password"] {
            width: 90%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .login-container select {
            width: 95%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .login-container button {
            width: 95%;
            padding: 10px;
            background-color: #191970;
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }
        .login-container button:hover {
            background-color: #B0C4DE;
        }
        .forget-password {
            text-align: center;
            margin-top: 10px;
        }
        .forget-password a {
            color: #191970;
            text-decoration: none;
        }
        .forget-password a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="login-container">
        <h1>Login</h1>
        <form action="Login" method="post">
            <label for="username"><h2>Username:</h2></label>
            <input type="text" id="username" name="username" required>

            <label for="password"><h2>Password:</h2></label>
            <input type="password" id="password" name="password" required>

            <label for="role"><h2>Login as:</h2></label>
            <select id="role" name="role" required>
                <option value="admin">Admin</option>
                <option value="customer">Employee</option>
            </select>

            <button type="submit"><h2>Login</h2></button>
        </form>

        
    </div>

</body>
</html>
    