package com.example.demo.controllers.rest;

import com.example.demo.model.NewTaxi.TaxiRide;
import com.example.demo.service.ModelService;
import com.example.demo.service.rides.impls.RidesServicesImpl;
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
public class RidesRestController {
    private ModelService<TaxiRide> ride_base = new RidesServicesImpl();
    @RequestMapping("/ListRides")
    public String PrintRides() {
        String str = "";
        for (var item: ride_base.getList())
            str += item.toHTML() + "<br>";
        return str;
    }
    @RequestMapping("/ListRides/{ID}")
    public String PrintRide(@PathVariable("ID") int id) {
        var item = ride_base.getByIDOrNull(id);
        if (item != null)
            return item.toHTML();
        return "Ride not found";
    }
    @RequestMapping("/TableRides")
    public String PrintTableRides() {
        return HTMLTable.createTable_RIDE(ride_base.getList());
    }
}
