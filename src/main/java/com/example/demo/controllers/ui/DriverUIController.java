package com.example.demo.controllers.ui;

import com.example.demo.model.NewTaxi.TaxiDriver;
import com.example.demo.model.NewTaxiForms.TaxiDriverForm;
import com.example.demo.service.ModelService;
import com.example.demo.service.driver.impls.DriverServicesImpl;
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
@Tag(name = "DriverController", description = "UI table controller")
@RestController
@Controller
@RequestMapping("/ui/DriversList")
public class DriverUIController {
    private final ModelService<TaxiDriver> cust_base = new DriverServicesImpl();

    @RequestMapping("/list")
    public String showAll(Model model) {
        List<TaxiDriver> drivers = cust_base.getList();
        model.addAttribute("drivers", drivers);
        return "Tables/DriverPage";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        TaxiDriver edited = cust_base.getByIDOrNull(id);
        if(edited!=null)
        {
            TaxiDriverForm former = new TaxiDriverForm(edited);
            model.addAttribute("DriverForm", former);
        }
        return "Tables/DriverEditPage";
    }

    @PostMapping("/edit/{id}")
    public String update(TaxiDriverForm former, @PathVariable("id") int id) {
        former.driver_id = String.valueOf(id);
        TaxiDriver updated = new TaxiDriver(former);
        cust_base.update(updated);
        return "redirect:/ui/DriversList/list";
    }

    @RequestMapping("/insertNew")
    public String insertNew() {
        List<TaxiDriver> list = cust_base.getList();
        int max = 1;
        if (list.size() > 0)
            max = list.stream().max(TaxiDriver::compareTo).get().driver_id + 1;
        TaxiDriver inserted = new TaxiDriver("",max,0);
        cust_base.insert(inserted);
        return "redirect:/ui/DriversList/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        TaxiDriver deleted = cust_base.getByIDOrNull(id);
        if (deleted != null)
            cust_base.delete(deleted);
        return "redirect:/ui/DriversList/list";
    }
}
