<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Driver</title>
    <link rel="stylesheet" href="/static/css/style.css">
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
<fieldset>
    <legend><h2>Edit Driver</h2></legend>
    <form name="DriverForm" action="" method="POST">
        <table>
            <tr>
                <th>ID:</th>
                <td>${DriverForm.driver_id}</td>
            </tr>
            <tr>
            <th>CarID:</th>
            <td><@spring.formInput "DriverForm.car_id" "${DriverForm.car_id}" "text"/></td>
            </tr>
            <th>FName:</th>
            <td><@spring.formInput "DriverForm.full_name" "${DriverForm.full_name}" "text"/></td>
            </tr>
            <th>Rating:</th>
            <td><@spring.formInput "DriverForm.rating" "${DriverForm.rating}" "text"/></td>
            </tr>
            <th>WHD:</th>
            <td><@spring.formInput "DriverForm.work_hours_day" "${DriverForm.work_hours_day}" "text"/></td>
            </tr>
            <th>WHN:</th>
            <td><@spring.formInput "DriverForm.work_hours_night" "${DriverForm.work_hours_night}" "text"/></td>
            </tr>
            <th>Premium:</th>
            <td><@spring.formInput "DriverForm.premium" "${DriverForm.premium}" "text"/></td>
            </tr>
        </table>
        <button><a href="/ui/DriversList/list">Cancel</a></button>
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