<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>Customers</title>
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
        <th>FName</th>
        <th>Phone</th>
        <th>VIP</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    </thead>
    <tbody>
    <#list customers as customer>
        <tr>
            <td>${customer.customer_id}</td>
            <td>${customer.full_name}</td>
            <td>${customer.phone}</td>
            <td>${customer.vip? then ('Yes', 'No')}</td>
            <td><a href="/ui/CustomersList/delete/${customer.customer_id}">Удалить</a></td>
            <td><a href="/ui/CustomersList/edit/${customer.customer_id}">Редактировать</a></td>
        </tr>
    </#list>
    </tbody>
</table>
    <button><a href="/ui/CustomersList/insertNew">Добавить</a></button>
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