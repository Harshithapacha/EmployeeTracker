<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tracking.model.Task" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reports & Charts</title>
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
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 600px;
            height: auto;
            text-align: center;
        }
        header {
            background: #333;
            color: #fff;
            padding: 20px;
            border-bottom: #77aaff 3px solid;
            margin-bottom: 20px;
        }
        header h1 {
            margin: 0;
            font-size: 24px;
        }
        .total-tasks {
            background: #333;
            color: #fff;
            text-align: center;
            padding: 15px;
            font-size: 20px;
            margin: 10px 0;
            border-radius: 5px;
        }
        #chart_div {
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 20px 0;
            height: 500px;
        }
    </style>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', { packages: ['corechart'] });
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Task Status', 'Count'],
                ['Completed', <%= request.getAttribute("completedCount") %>],
                ['Ongoing', <%= request.getAttribute("ongoingCount") %>]
            ]);

            var options = {
                title: 'Tasks Status',
                is3D: true,
                pieSliceText: 'label',
                slices: {
                    0: { color: '#0000CD' },
                    1: { color: '#FF00FF' }
                },
                chartArea: { width: '150%', height: '80%' }
            };

            var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }
    </script>
</head>
<body>
    
    <div class="container">
        <div class="total-tasks">
            Total Number of Tasks: <%= ((List<Task>) request.getAttribute("tasks")).size() %>
        </div>
        <div class="total-tasks">
            Completed Tasks: <%= request.getAttribute("completedCount") %>
        </div>
        <div class="total-tasks">
            Ongoing Tasks: <%= request.getAttribute("ongoingCount") %>
        </div>
        <div id="chart_div"></div>
        <div class="dashboard-link">
            <a href="adminDash.jsp">Back to Dashboard</a>
        </div>
    </div>
    
</body>
</html>
