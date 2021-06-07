<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/MP.css">
    <style>
        .first-conteiner {
            position: relative;
            width: 1140px;
            height: 392px;
            left: calc(50% - 1140px/2);
        }

        .second-conteiner {
            position: relative;
            align-items: center;
            display: flex;
            width: 1140px;
            height: 220px;
            left: calc(50% - 1140px/2);
            top: 10px;
        }

        .bg-image {
            width: 1140px;
            height: 392px;
        }

        .bg-black {
            width: 1140px;
            height: 392px;
            margin-top: -34%;
            background: rgba(73, 73, 73, 0.54);
            border: 1px solid #E3FFDE;
            box-sizing: border-box;
            filter: blur(4px);
        }

        .first-text-block {
            position: relative;
            width: 568px;
            height: 188px;
            left: 64px;
            margin-top: -30%;
            padding: 15px;
            background: rgba(0, 0, 0, 0.3);
        }

        .first-text-block h1 {
            width: 407px;
            height: 50px;
            font-family: Ruda;
            font-style: normal;
            font-weight: normal;
            font-size: 28px;
            line-height: 34px;
            color: #FFFFFF;
        }

        .first-text-block hr {
            margin: auto 10px;
            border: 1px solid #FFFFFF;
        }

        .first-text-block p {
            font-family: Ribeye Marrow;
            font-style: normal;
            font-weight: normal;
            font-size: 22px;
            line-height: 30px;
            color: #FFFFFF;
        }

        .second-text-block {
            position: relative;
            width: 458px;
            height: 200px;
            left: -153px;
            background: #DFD9D9;
            padding: 20px;
            margin-left: 500px;
        }

        .second-text-block h2 {
            width: 458px;
            height: 39px;
            margin-left: -15px;
            text-align: center;
            font-size: 28px;
        }

        .second-text-block .bloc {
            width: 417px;
            height: 134px;
            margin-top: 10px;
        }

        .second-text-block .bloc p {
            font-family: Ribeye Marrow;
            font-style: normal;
            font-weight: normal;
            font-size: 18px;
            line-height: 25px;
        }

        .taxi-form {
            align-content: center;
            width: 355px;
            height: 320px;
            left: 185px;
            top: 0px;
            background: #b1aaaa;
            padding: 20px;
        }

        input[type=submit] {
            transition-duration: 0.3s;
            position: relative;
            width: 230px;
            height: 50px;
            background: #FDAB30;
            margin-top: 10px;
            left: calc(50% - 325px/2 + 0.5px);
            font-family: Ribeye Marrow;
            font-style: normal;
            font-weight: normal;
            font-size: 25px;
            line-height: 34px;
            text-align: center;
            color: #FFFFFF;
        }

        input[type=submit]:hover {
            background: #fcba57;
            color: #e7e7e7;
        }

        input[type=submit]:active {
            background: #c98725;
            color: #b3b3b3;
        }

        input[type=text] {
            width: 315px;
            height: 40px;
            margin-top: 10px;
            border: 2px solid #757171;
            box-sizing: border-box;
        }
        .footer-conteiner {
            height: 167px;
            background: #CDCDCD;
            padding: 20px;
            margin-top: 280px;
            clear: both;
        }
    </style>
    <title>Головна</title>
</head>

<body>
    <div class="conteiner">
        <div class="header-conteiner">
            <div class="wrapper">
                <nav>
                    <img class="header-logo" src="images/header-logo.png" alt="">
                    <ul class="nav-items">
                        <li>
                            <a href="TaxiPage.html">Замовити таксі</a>
                        </li>
                        <li>
                            <a href="ParcingPage.html">Запити</a>
                        </li>
                        <li>
                            <a href="#">Таблиці</a>
                            <ul>
                                <li><a href="/ui/CarsList/list">Автомобілі</a></li>
                                <li><a href="/ui/CustomersList/list">Клієнти</a></li>
                                <li><a href="/ui/DriversList/list">Водії</a></li>
                                <li><a href="/ui/OperatorsList/list">Оператори</a></li>
                                <li><a href="/ui/OrdersList/list">Замовлення</a></li>
                                <li><a href="/ui/PricesList/list">Цени</a></li>
                                <li><a href="/ui/RidesList/list">Поїздки</a></li>
                            </ul>                            
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="body-conteiner">
            <div class="first-conteiner">
                <div class="wrapper">
                    <div class="bg-image">
                        <img src="images/infoblock-bg.png" alt="">
                    </div>
                    <div class="bg-black"></div>
                    <div class="first-text-block">
                        <h1>Ми найкраще таксі в країні!</h1>
                        <hr>
                        <p>
                            Наш за допомогою нашого сайту, ви зможете максимально швидко замовити таксі!
                            <br>
                            Лише 5-10 хвилин та таксі вже буде біля вас.
                        </p>
                    </div>
                </div>
            </div>

            <div class="second-conteiner">
                <div class="second-text-block">
                    <h2>Замовте таксі зі знижкою!</h2>
                    <div class="bloc">
                        <p>
                            Заповніть форму та за 10 хвилин до вас приїде наше таксі.
                        </p>
                        <hr>
                        <p>
                            *Якщо ми вас обслуговуємо вперше, тоді ви отримаєте снижку 20% на першу поїздку.
                        </p>
                        <center>
                            <div class="taxi-form">
                                <form name="order-form" action="" method="POST">
                                    Введіть номер телефону<br>
                                    <input type="text" name="start-point" id="1" placeholder="Введіть початкову точку маршруту" required>
                                    Введіть початкову точку маршруту<br>
                                    <input type="text" name="finish-point" id="2" placeholder="Введіть кінцеву точку маршруту" required>
                                    Введіть кінцеву точку маршруту<br>
                                    <input type="text" name="finish-point" id="2" placeholder="Введіть кінцеву точку маршруту" required>
                                    Выберіть тип авто<br>
                                    <input type="text"><br>
                                    <#--Введіть номер телефону<br>
                                    <@spring.formInput "form.phone" "" "text"/><br>
                                    Введіть початкову точку маршруту<br>
                                    <@spring.formInput "form.start_address" "" "text"/><br>
                                    Введіть кінцеву точку маршруту<br>
                                    <@spring.formInput "form.finish_address" "" "text"/><br>
                                    Выберіть тип авто<br>
                                    <@spring.formSingleSelect "form.car_type" type_options ""/><br>-->
                                    <input type="submit" value="Замовити таксі">
                                </form>
                            </div>
                        </center>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-conteiner">
            <div class="wrapper">
                <h2>Контактна інформація:</h2>
                <img class="footer-logo" src="images/header-logo.png" alt="">
                <p>Вул.Гагаріна 25 м.Чернівці тел:380 000 00000</p>
            </div>
        </div>
    </div>
</body>

</html>