<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Orders</title>
    <style>
        tr td {
            align-content: center;
            padding: 8px;
        }
    </style>
</head>
<body>
    <header>
        <h2>LOGO</h2>
        <div class="btn-group">
            <button>Кнопка</button>
            <button>Кнопка</button>
            <button>Кнопка</button>
        </div>
    </header>
    <div class="body">
<div>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>Id</th>
        <th>CustID</th>
        <th>RideID</th>
        <th>Phone</th>
        <th>StartAddr</th>
        <th>FinishAdde</th>
        <th>OrderDate</th>
        <th>CarType</th>
        <th>Status</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    </thead>
    <tbody>
    <#list orders as order>
        <tr>
            <td>${order.order_id}</td>
            <td>${order.customer_id}</td>
            <td>${order.ride_id}</td>
            <td>${order.phone}</td>
            <td>${order.start_address}</td>
            <td>${order.finish_address}</td>
            <td>${order.date_of_ordering}</td>
            <td>${order.car_type}</td>
            <td>${order.status}</td>
            <td><a href="/ui/OrdersList/delete/${order.order_id}">Удалить</a></td>
            <td><a href="/ui/OrdersList/edit/${order.order_id}">Редактировать</a></td>
        </tr>
    </#list>
    </tbody>
</table>
    <button><a href="/ui/OrdersList/insertNew">Добавить</a></button>
    <button><a href="/HomePage">На главную</a></button>
</div>
    </div>
    <footer>
        <h4>sdasdasdsad</h4>
        <h2>LOGO</h2>
        <div class="btn-group">
           <h4>qqqqqqqqqqqqqqqqqqqqqqqqq</h4>
        </div>
    </footer>
</body>
</html>