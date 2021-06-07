package com.example.demo.controllers.ui;

import com.example.demo.model.NewTaxi.Customer;
import com.example.demo.model.NewTaxiForms.CustomerForm;
import com.example.demo.service.ModelService;
import com.example.demo.service.customer.impls.CustomerServicesImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * FirstSpringServer.iml.CustomerUIController
 *
 * @Autor: golde
 * @DateTime: 18.05.2021|12:12
 * @Version CustomerUIController: 1.0
 */
@Tag(name = "CustomerController", description = "UI table controller")
@RestController
@Controller
@RequestMapping("/ui/CustomersList")
public class CustomerUIController {
    private final ModelService<Customer> cust_base = new CustomerServicesImpl();

    @RequestMapping("/list")
    public String showAll(Model model) {
        List<Customer> customers = cust_base.getList();
        model.addAttribute("customers", customers);
        return "Tables/CustomerPage";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        Customer edited = cust_base.getByIDOrNull(id);
        if(edited!=null)
        {
            CustomerForm former = new CustomerForm(edited);
            model.addAttribute("CustomerForm", former);
        }
        return "Tables/CustomerEditPage";
    }

    @PostMapping("/edit/{id}")
    public String update(CustomerForm former, @PathVariable("id") int id) {
        former.customer_id = String.valueOf(id);
        Customer updated = new Customer(former);
        cust_base.update(updated);
        return "redirect:/ui/CustomersList/list";
    }

    @RequestMapping("/insertNew")
    public String insertNew() {
        List<Customer> list = cust_base.getList();
        int max = 1;
        if (list.size() > 0)
            max = list.stream().max(Customer::compareTo).get().customer_id + 1;
        Customer inserted = new Customer(max, "", "", false);
        cust_base.insert(inserted);
        return "redirect:/ui/CustomersList/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        Customer deleted = cust_base.getByIDOrNull(id);
        if (deleted != null)
            cust_base.delete(deleted);
        return "redirect:/ui/CustomersList/list";
    }
}
