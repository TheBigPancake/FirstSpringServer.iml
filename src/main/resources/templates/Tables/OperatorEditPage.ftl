<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Operator</title>
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
<fieldset>
    <legend><h2>Edit Operator</h2></legend>
    <form name="OperatorForm" action="" method="POST">
        <table>
            <tr>
                <th>ID:</th>
                <td>${OperatorForm.operator_id}</td>
            </tr>
            <th>FName:</th>
            <td><@spring.formInput "OperatorForm.full_name" "${OperatorForm.full_name}" "text"/></td>
            </tr>
            <th>Rating:</th>
            <td><@spring.formInput "OperatorForm.rating" "${OperatorForm.rating}" "text"/></td>
            </tr>
            <th>WHD:</th>
            <td><@spring.formInput "OperatorForm.work_hours_day" "${OperatorForm.work_hours_day}" "text"/></td>
            </tr>
            <th>WHN:</th>
            <td><@spring.formInput "OperatorForm.work_hours_night" "${OperatorForm.work_hours_night}" "text"/></td>
            </tr>
            <th>Premium:</th>
            <td><@spring.formInput "OperatorForm.premium" "${OperatorForm.premium}" "text"/></td>
            </tr>
        </table>
        <button><a href="/ui/OperatorsList/list">Cancel</a></button>
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