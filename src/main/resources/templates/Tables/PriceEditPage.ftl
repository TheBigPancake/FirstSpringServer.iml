<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Price</title>
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
    <form name="PriceForm" action="" method="POST">
        <fieldset>
            <legend><h2>Edit Trip Price</h2></legend>
        <table>
            <tr>
                <th>PriceDate:</th>
                <td>${PriceForm.date}</td>
            </tr>
            <tr>
                <th>CarType:</th>
                <td><@spring.formSingleSelect "PriceForm.car_type" car_type_options "${PriceForm.car_type}"/></td>
            </tr>
            <tr>
                <th>Min price:</th>
                <td><@spring.formInput "PriceForm.min_price" "${PriceForm.min_price}" "text"/></td>
            </tr>
            <tr>
                <th>Waiting time:</th>
                <td><@spring.formInput "PriceForm.waiting_time" "${PriceForm.waiting_time}" "text"/></td>
            </tr>
            <tr>
                <th>Price by city:</th>
                <td><@spring.formInput "PriceForm.price_by_city" "${PriceForm.price_by_city}" "text"/></td>
            </tr>
            <tr>
                <th>Price outside the city:</th>
                <td><@spring.formInput "PriceForm.price_outside_the_city" "${PriceForm.price_outside_the_city}" "text"/></td>
            </tr>
        </table>
        <button><a href="/ui/PricesList/list">Cancel</a></button>
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