<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Order</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        tr{
            text-align:right;
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
    <form name="OrderForm" action="" method="POST">
        <fieldset>
            <legend><h2>Edit Order</h2></legend>
        <table>
            <tr>
                <th>ID:</th>
                <td>${OrderForm.order_id}</td>
            </tr>
            <tr>
                <th>CusID:</th>
                <td><@spring.formInput "OrderForm.customer_id" "${OrderForm.customer_id}" "text"/></td>
            </tr>
            <tr>
                <th>RideID:</th>
                <td><@spring.formInput "OrderForm.ride_id" "${OrderForm.ride_id}" "text"/></td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td><@spring.formInput "OrderForm.phone" "${OrderForm.phone}" "text"/></td>
            </tr>
            <tr>
                <th>StartAddr:</th>
                <td><@spring.formInput "OrderForm.start_address" "${OrderForm.start_address}" "text"/></td>
            </tr>
            <tr>
                <th>FinishAddr:</th>
                <td><@spring.formInput "OrderForm.finish_address" "${OrderForm.finish_address}" "text"/></td>
            </tr>
            <tr>
                <th>OrderDate:</th>
                <td><@spring.formInput "OrderForm.date_of_ordering" "${OrderForm.date_of_ordering}" "datetime-local"/></td>
            </tr>
            <tr>
                <th>CarType:</th>
                <td><@spring.formSingleSelect "OrderForm.car_type" car_type_options "${OrderForm.car_type}"/></td>
            </tr>
            <tr>
                <th>Status:</th>
                <td><@spring.formSingleSelect "OrderForm.status" status_options "${OrderForm.status}"/></td>
            </tr>
        </table>
        <button><a href="/ui/OrdersList/list">Cancel</a></button>
        <input type="submit" value="Update"/>
</fieldset>
    </form>
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