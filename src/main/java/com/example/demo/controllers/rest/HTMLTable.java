package com.example.demo.controllers.rest;

import com.example.demo.model.NewTaxi.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * FirstSpringServer.iml.HTMLTeble
 *
 * @Autor: golde
 * @DateTime: 26.04.2021|17:59
 * @Version HTMLTeble: 1.0
 */
public class HTMLTable {
    private static final String START_HTML =
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <style>\n" +
            /*"        tr td{\n" +
            "            padding: 5px;\n" +
            "        }\n" +*/
            "        tr.table2 {\n" +
            "            background-color: yellow;\n" +
            "            font-weight: bold;\n" +
            "        }\n" +
            "        tr.bbc {\n" +
            "            background-color: gainsboro;\n" +
            "        }\n" +
            "        td.aquaunit {\n" +
            "            background-color: aqua;\n" +
            "        }\n" +
            "        tr.table4 {\n" +
            "            background-color: darkgreen;\n" +
            "            font-weight: bold;\n" +
            "        }\n" +
            "    </style>\n" +
            "    <title>Tables</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <div>\n" +
            "        <table cellspacing=\"0\" border=\"2\">";
    private static final String END_HTML =
            "</table>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>";
    public static String createTable_CUST(List<Customer> list)
    {
        String table_str = START_HTML;
        table_str += getTable_CUST(list);
        return table_str;
    }
    private static String getTable_CUST(List<Customer> list) {
        String table_str =
                "<tr class=\"table2\">\n" +
                "   <th>id</th>\n" +
                "   <th>full_name</th>\n" +
                "   <th>phone</th>\n" +
                "   <th>vip</th>\n" +
                "</tr>";
        for (var item: list)
            table_str +=
                    "<tr class=\"bbc\">\n" +
                    "   <td class=\"aquaunit\">"+item.customer_id+"</td>\n" +
                    "   <td>"+item.full_name+"</td>\n" +
                    "   <td>"+item.phone+"</td>\n" +
                    "   <td>"+item.vip+"</td>\n" +
                    "</tr>";
        table_str += END_HTML;
        return table_str;
    }

    public static String createTable_CAR(List<TaxiCar> list)
    {
        String table_str = START_HTML;
        table_str += getTable_CAR(list);
        table_str += END_HTML;
        return table_str;
    }
    private static String getTable_CAR(List<TaxiCar> list) {
        String table_str =
                "<tr class=\"table2\">\n" +
                        "   <th>id</th>\n" +
                        "   <th>description</th>\n" +
                        "   <th>type</th>\n" +
                        "</tr>";
        for (var item: list)
            table_str +=
                    "<tr class=\"bbc\">\n" +
                            "   <td class=\"aquaunit\">"+item.car_id+"</td>\n" +
                            "   <td>"+item.description+"</td>\n" +
                            "   <td>"+item.type+"</td>\n" +
                            "</tr>";
        return table_str;
    }

    public static String createTable_OPER(List<TaxiOperator> list)
    {
        String table_str = START_HTML;
        table_str += getTable_OPER(list);
        table_str += END_HTML;
        return table_str;
    }
    private static String getTable_OPER(List<TaxiOperator> list) {
        String table_str =
                "<tr class=\"table2\">\n" +
                        "   <th>id</th>\n" +
                        "   <th>full_name</th>\n" +
                        "   <th>rating</th>\n" +
                        "   <th>work_hours_day</th>\n" +
                        "   <th>work_hours_night</th>\n" +
                        "   <th>premium</th>\n" +
                        "</tr>";
        for (var item: list)
            table_str +=
                    "<tr class=\"bbc\">\n" +
                            "   <td class=\"aquaunit\">"+item.operator_id+"</td>\n" +
                            "   <td>"+item.full_name+"</td>\n" +
                            "   <td>"+item.rating+"</td>\n" +
                            "   <td>"+item.work_hours_day+"</td>\n" +
                            "   <td>"+item.work_hours_night+"</td>\n" +
                            "   <td>"+item.premium+"</td>\n" +
                            "</tr>";
        return table_str;
    }

    public static String createTable_ORDE(List<TaxiOrder> list)
    {
        String table_str = START_HTML;
        table_str += getTable_ORDE(list);
        table_str += END_HTML;
        return table_str;
    }
    private static String getTable_ORDE(List<TaxiOrder> list) {
        String table_str =
                "<tr class=\"table2\">\n" +
                        "   <th>id</th>\n" +
                        "   <th>ride_id</th>\n" +
                        "   <th>customer_id</th>\n" +
                        "   <th>phone</th>\n" +
                        "   <th>start_address</th>\n" +
                        "   <th>finish_address</th>\n" +
                        "   <th>status</th>\n" +
                        "   <th>car_type</th>\n" +
                        "   <th>date_of_ordering</th>\n" +
                        "</tr>";
        for (var item: list)
            table_str +=
                    "<tr class=\"bbc\">\n" +
                            "   <td class=\"aquaunit\">"+item.order_id+"</td>\n" +
                            "   <td>"+item.ride_id+"</td>\n" +
                            "   <td>"+item.customer_id+"</td>\n" +
                            "   <td>"+item.phone+"</td>\n" +
                            "   <td>"+item.start_address+"</td>\n" +
                            "   <td>"+item.finish_address+"</td>\n" +
                            "   <td>"+item.status+"</td>\n" +
                            "   <td>"+item.car_type+"</td>\n" +
                            "   <td>"+item.date_of_ordering+"</td>\n" +
                            "</tr>";
        return table_str;
    }

    public static String createTable_PRIC(List<TripPrices> list)
    {
        String table_str = START_HTML;
        table_str += getTable_PRIC(list);
        table_str += END_HTML;
        return table_str;
    }
    private static String getTable_PRIC(List<TripPrices> list) {
        String table_str =
                "<tr class=\"table2\">\n" +
                        "   <th>date</th>\n" +
                        "   <th>car_type</th>\n" +
                        "   <th>min_price</th>\n" +
                        "   <th>price_by_city</th>\n" +
                        "   <th>price_outside_the_city</th>\n" +
                        "   <th>waiting_time</th>\n" +
                        "</tr>";
        for (var item: list)
            table_str +=
                    "<tr class=\"bbc\">\n" +
                            "   <td class=\"aquaunit\">"+item.date+"</td>\n" +
                            "   <td>"+item.car_type+"</td>\n" +
                            "   <td>"+item.min_price+"</td>\n" +
                            "   <td>"+item.price_by_city+"</td>\n" +
                            "   <td>"+item.price_outside_the_city+"</td>\n" +
                            "   <td>"+item.waiting_time+"</td>\n" +
                            "</tr>";
        return table_str;
    }

    public static String createTable_RIDE(List<TaxiRide> list)
    {
        String table_str = START_HTML;
        table_str += getTable_RIDE(list);
        table_str += END_HTML;
        return table_str;
    }
    private static String getTable_RIDE(List<TaxiRide> list) {
        String table_str =
                "<tr class=\"table2\">\n" +
                        "   <th>ride_id</th>\n" +
                        "   <th>driver_id</th>\n" +
                        "   <th>car_id</th>\n" +
                        "   <th>waiting_time</th>\n" +
                        "   <th>km_by_city</th>\n" +
                        "   <th>km_outside_the_city</th>\n" +
                        "   <th>start_date</th>\n" +
                        "   <th>finish_date</th>\n" +
                        "   <th>payment_type</th>\n" +
                        "   <th>donation</th>\n" +
                        "</tr>";
        for (var item: list)
            table_str +=
                    "<tr class=\"bbc\">\n" +
                            "   <td class=\"aquaunit\">"+item.ride_id+"</td>\n" +
                            "   <td>"+item.driver_id+"</td>\n" +
                            "   <td>"+item.car_id+"</td>\n" +
                            "   <td>"+item.waiting_time+"</td>\n" +
                            "   <td>"+item.km_by_city+"</td>\n" +
                            "   <td>"+item.km_outside_the_city+"</td>\n" +
                            "   <td>"+item.start_date+"</td>\n" +
                            "   <td>"+item.finish_date+"</td>\n" +
                            "   <td>"+item.payment_type+"</td>\n" +
                            "   <td>"+item.donation+"</td>\n" +
                            "</tr>";
        return table_str;
    }

    public static String createTable_DRIV(List<TaxiDriver> list)
    {
        String table_str = START_HTML;
        table_str += getTable_DRIV(list);
        table_str += END_HTML;
        return table_str;
    }
    private static String getTable_DRIV(List<TaxiDriver> list) {
        String table_str =
                "<tr class=\"table2\">\n" +
                        "   <th>driver_id</th>\n" +
                        "   <th>car_id</th>\n" +
                        "   <th>full_name</th>\n" +
                        "   <th>rating</th>\n" +
                        "   <th>work_hours_day</th>\n" +
                        "   <th>work_hours_night</th>\n" +
                        "   <th>premium</th>\n" +
                        "</tr>";
        for (var item: list)
            table_str +=
                    "<tr class=\"bbc\">\n" +
                            "   <td class=\"aquaunit\">"+item.driver_id+"</td>\n" +
                            "   <td>"+item.full_name+"</td>\n" +
                            "   <td>"+item.car_id+"</td>\n" +
                            "   <td>"+item.rating+"</td>\n" +
                            "   <td>"+item.work_hours_day+"</td>\n" +
                            "   <td>"+item.work_hours_night+"</td>\n" +
                            "   <td>"+item.premium+"</td>\n" +
                            "</tr>";
        return table_str;
    }
}
