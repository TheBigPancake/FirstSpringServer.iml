<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Customer</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        tr{
            text-align:;
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
<fieldset>
    <legend><h2>Edit Customer</h2></legend>
    <form name="CustomerForm" action="" method="POST">
        <table>
            <tr>
                <th>ID:</th>
                <td>${CustomerForm.customer_id}</td>
            </tr>
            <tr>
            <th>Full Name:</th>
            <td><@spring.formInput "CustomerForm.full_name" "${CustomerForm.full_name}" "text"/></td>
            </tr>
            <tr>
            <th>Phone:</th>
            <td><@spring.formInput "CustomerForm.phone" "${CustomerForm.phone}" "text"/></td>
            </tr>
            <tr>
            <th>VIP:</th>
            <td><@spring.formCheckbox "CustomerForm.vip" "${CustomerForm.vip}"/></td>
            </tr>
        </table>
        <button><a href="/ui/CustomersList/list">Cancel</a></button>
        <input type="submit" value="Update"/>
    </form>
</fieldset>
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