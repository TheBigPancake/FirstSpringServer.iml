package com.example.demo.controllers.ui;

import com.example.demo.model.NewTaxi.CarType;
import com.example.demo.model.NewTaxi.PaymentType;
import com.example.demo.model.NewTaxi.TaxiRide;
import com.example.demo.model.NewTaxiForms.TaxiRideForm;
import com.example.demo.service.ModelService;
import com.example.demo.service.rides.impls.RidesServicesImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * FirstSpringServer.iml.CustomerUIController
 *
 * @Autor: golde
 * @DateTime: 18.05.2021|12:12
 * @Version CustomerUIController: 1.0
 */
@Tag(name = "RideController", description = "UI table controller")
@RestController
@Controller
@RequestMapping("/ui/RidesList")
public class RideUIController {
    private final ModelService<TaxiRide> ride_base = new RidesServicesImpl();

    @RequestMapping("/list")
    public String showAll(Model model) {
        List<TaxiRide> rides = ride_base.getList();
        model.addAttribute("rides", rides);
        return "Tables/RidePage";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        TaxiRide edited = ride_base.getByIDOrNull(id);
        if(edited!=null)
        {
            TaxiRideForm former = new TaxiRideForm(edited);
            model.addAttribute("RideForm", former);
            model.addAttribute("Payment_options", PaymentTypeList());
        }
        return "Tables/RideEditPage";
    }
    
    private List<String> PaymentTypeList(){
        var list = new ArrayList<String>();
        for (var item: PaymentType.values())
            list.add(item.toString());
        return list;
    }

    @Operation(summary = "update problem", description = "due to problems with getting date from MongoDB, the update operation does not work correctly")
    @PostMapping("/edit/{id}")
    public String update(TaxiRideForm former, @PathVariable("id") int id) {
        former.ride_id = String.valueOf(id);
        TaxiRide updated = new TaxiRide(former);
        ride_base.update(updated);
        return "redirect:/ui/RidesList/list";
    }

    @RequestMapping("/insertNew")
    public String insertNew() {
        List<TaxiRide> list = ride_base.getList();
        int max = 1;
        if (list.size() > 0)
            max = list.stream().max(TaxiRide::compareTo).get().ride_id + 1;
        TaxiRide inserted = TaxiRide.startRide(max,0,0);
        inserted.endRide(PaymentType.cash,0);
        ride_base.insert(inserted);
        return "redirect:/ui/RidesList/list";
    }
@Operation(summary = "delete problem", description = "due to problems with getting date from MongoDB, delete operation does not work")
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        TaxiRide deleted = ride_base.getByIDOrNull(id);
        if (deleted != null)
            ride_base.delete(deleted);
        return "redirect:/ui/RidesList/list";
    }
}
