<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Rides</title>
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
        <th>Car ID</th>
        <th>Dri ID</th>
        <th>SDate</th>
        <th>FDate</th>
        <th>Wait Time</th>
        <th>Km</th>
        <th>Km Out</th>
        <th>Donation</th>
        <th>Payment</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    </thead>
    <tbody>
    <#list rides as ride>
        <tr>
            <td>${ride.ride_id}</td>
            <td>${ride.car_id}</td>
            <td>${ride.driver_id}</td>
            <td>${ride.start_date}</td>
            <td>${ride.finish_date}</td>
            <td>${ride.waiting_time}</td>
            <td>${ride.km_by_city}</td>
            <td>${ride.km_outside_the_city}</td>
            <td>${ride.donation}</td>
            <td>${ride.payment_type}</td>
            <td><a href="/ui/RidesList/delete/${ride.ride_id}">Удалить</a></td>
            <td><a href="/ui/RidesList/edit/${ride.ride_id}">Изменить</a></td>
        </tr>
    </#list>
    </tbody>
</table>
    <button><a href="/ui/RidesList/insertNew">Добавить</a></button>
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