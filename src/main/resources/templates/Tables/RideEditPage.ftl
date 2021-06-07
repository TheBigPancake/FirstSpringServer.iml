<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Ride</title>
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
    <form name="RideForm" action="" method="POST">
        <fieldset>
            <legend><h2>Edit Ride</h2></legend>
        <table>
            <tr>
                <th>ID:</th>
                <td>${RideForm.ride_id}</td>
            </tr>
            <tr>
                <th>CarID:</th>
                <td><@spring.formInput "RideForm.car_id" "${RideForm.car_id}" "text"/></td>
            </tr>
            <tr>
                <th>DriID:</th>
                <td><@spring.formInput "RideForm.driver_id" "${RideForm.driver_id}" "text"/></td>
            </tr>
            <tr>
                <th>StartDate:</th>
                <td><@spring.formInput "RideForm.start_date" "${RideForm.start_date}" "datetime-local"/></td>
            </tr>
            <tr>
                <th>FinishDate:</th>
                <td><@spring.formInput "RideForm.finish_date" "${RideForm.finish_date}" "datetime-local"/></td>
            </tr>
            <tr>
                <th>WaitingTime:</th>
                <td><@spring.formInput "RideForm.waiting_time" "${RideForm.waiting_time}" "text"/></td>
            </tr>
            <tr>
                <th>KmByCity:</th>
                <td><@spring.formInput "RideForm.km_by_city" "${RideForm.km_by_city}" "text"/></td>
            </tr>
            <tr>
                <th>KmOutsideTheCity:</th>
                <td><@spring.formInput "RideForm.km_outside_the_city" "${RideForm.km_outside_the_city}" "text"/></td>
            </tr>
            <tr>
                <th>Donation:</th>
                <td><@spring.formInput "RideForm.donation" "${RideForm.donation}" "text"/></td>
            </tr>
            <tr>
                <th>PaymentType:</th>
                <td><@spring.formSingleSelect "RideForm.payment_type" Payment_options "${RideForm.payment_type}"/></td>
            </tr>
        </table>
        <button><a href="/ui/RidesList/list">Cancel</a></button>
        <input type="submit" value="Update"/>
</fieldset>
    </form>
    </div>
</body>
</html>