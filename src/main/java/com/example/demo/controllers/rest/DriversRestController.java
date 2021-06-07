package com.example.demo.controllers.rest;

import com.example.demo.model.NewTaxi.TaxiDriver;
import com.example.demo.service.ModelService;
import com.example.demo.service.driver.impls.DriverServicesImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * FirstSpringServer.iml.StudentRestController
 *
 * @Autor: golde
 * @DateTime: 18.02.2021|10:24
 * @Version StudentRestController: 1.0
 */
@RestController
public class DriversRestController {
    private ModelService<TaxiDriver> driv_base = new DriverServicesImpl();
    @RequestMapping("/ListDrivers")
    public String PrintDrivers() {
        String str = "";
        for (var item: driv_base.getList())
            str += item.toHTML() + "<br>";
        return str;
    }
    @RequestMapping("/ListDrivers/{ID}")
    public String PrintDriver(@PathVariable("ID") int id) {
        var item = driv_base.getByIDOrNull(id);
        if (item != null)
            return item.toHTML();
        return "Driver not found";
    }
    @RequestMapping("/TableDrivers")
    public String PrintTableDrivers() {
        return HTMLTable.createTable_DRIV(driv_base.getList());
    }
}
