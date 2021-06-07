<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Car</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
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
    <fieldset>
        <legend><h2>Edit Car</h2></legend>
            <form name="CarForm" action="" method="POST">
                <table>
                    <tr>
                        <th>ID:</th>
                        <td>${CarForm.car_id}</td>
                    </tr>
                    <tr>
                        <th>Description:</th>
                        <td><@spring.formTextarea "CarForm.description" "${CarForm.description}"/></td>
                    </tr>
                    <tr>
                        <th>CarType:</th>
                        <td><@spring.formSingleSelect "CarForm.type" type_options "${CarForm.type}"/></td>
                    </tr>
                </table>
                    <button><a href="/ui/CarsList/list">Cancel</a></button>
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