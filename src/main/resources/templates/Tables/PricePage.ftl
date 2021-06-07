<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Prices</title>
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
        <th>CarType</th>
        <th>Date</th>
        <th>Min_price</th>
        <th>Waiting Time</th>
        <th>Price by city</th>
        <th>Price outside the city</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    </thead>
    <tbody>
    <#list prices as price>
        <tr>
            <td>${price.car_type}</td>
            <td>${price.date}</td>
            <td>${price.min_price}</td>
            <td>${price.waiting_time}</td>
            <td>${price.price_by_city}</td>
            <td>${price.price_outside_the_city}</td>
            <td><a href="/ui/PricesList/delete/${price.date}/${price.car_type}">Удалить</a></td>
            <td><a href="/ui/PricesList/edit/${price.date}/${price.car_type}">Редактировать</a></td>
        </tr>
    </#list>
    </tbody>
</table>
    <button><a href="/ui/PricesList/insertNew">Добавить</a></button>
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