package com.example.demo.controllers.rest;

import com.example.demo.model.NewTaxi.Customer;
import com.example.demo.service.ModelService;
import com.example.demo.service.customer.impls.CustomerServicesImpl;
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
public class CustomerRestController {
    private ModelService<Customer> cust_base = new CustomerServicesImpl();
    @RequestMapping("/ListCustomers")
    public String PrintCustomers() {
        String str = "";
        for (var item: cust_base.getList())
            str += item.toHTML() + "<br>";
        return str;
    }
    @RequestMapping("/ListCustomers/{ID}")
    public String PrintCustomer(@PathVariable("ID") int id) {
        var item = cust_base.getByIDOrNull(id);
        if (item != null)
            return item.toHTML();
        return "Customer not found";
    }
    @RequestMapping("/TableCustomers")
    public String PrintTableCustomers() {
        return HTMLTable.createTable_CUST(cust_base.getList());
    }
}
