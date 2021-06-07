package com.example.demo.controllers.rest;

import com.example.demo.model.NewTaxi.TaxiCar;
import com.example.demo.service.ModelService;
import com.example.demo.service.car.impls.CarsServicesImpl;
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
public class CarsRestController {
    private ModelService<TaxiCar> cars_base = new CarsServicesImpl();
    @RequestMapping("/ListCars")
    public String PrintCars() {
        String str = "";
        for (var item: cars_base.getList())
            str += item.toHTML() + "<br>";
        return str;
    }
    @RequestMapping("/ListCars/{ID}")
    public String PrintCar(@PathVariable("ID") int id) {
        var item = cars_base.getByIDOrNull(id);
        if (item != null)
            return item.toHTML();
        return "Car not found";
    }
    @RequestMapping("/TableCars")
    public String PrintTableCars() {
        return HTMLTable.createTable_CAR(cars_base.getList());
    }
}
