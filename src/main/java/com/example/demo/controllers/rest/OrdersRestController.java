package com.example.demo.controllers.rest;

import com.example.demo.model.NewTaxi.TaxiOrder;
import com.example.demo.service.ModelService;
import com.example.demo.service.orders.impls.OrdersServicesImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * FirstSpringServer.iml.CustomerRestController
 *
 * @Autor: golde
 * @DateTime: 25.03.2021|10:09
 * @Version CustomerRestController: 1.0
 */
@RestController
public class OrdersRestController {
    private ModelService<TaxiOrder> orde_base = new OrdersServicesImpl();
    @RequestMapping("/ListOrders")
    public String PrintOrders() {
        String str = "";
        for (var item: orde_base.getList())
            str += item.toHTML() + "<br>";
        return str;
    }
    @RequestMapping("/ListOrders/{ID}")
    public String PrintOrder(@PathVariable("ID") int id) {
        var item = orde_base.getByIDOrNull(id);
        if (item != null)
            return item.toHTML();
        return "Order not found";
    }
    @RequestMapping("/TableOrders")
    public String PrintTableOrders() {
        return HTMLTable.createTable_ORDE(orde_base.getList());
    }
}
