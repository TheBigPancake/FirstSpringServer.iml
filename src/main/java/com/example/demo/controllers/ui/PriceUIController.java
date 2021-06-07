package com.example.demo.controllers.ui;

import com.example.demo.model.NewTaxi.CarType;
import com.example.demo.model.NewTaxi.TripPrices;
import com.example.demo.model.NewTaxiForms.TripPricesForm;
import com.example.demo.service.ModelService;
import com.example.demo.service.prices.impls.PricesServicesImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
@Tag(name = "PriceController", description = "UI table controller")
@RestController
@Controller
@RequestMapping("/ui/PricesList")
public class PriceUIController {
    private final PricesServicesImpl pric_base = new PricesServicesImpl();

    @RequestMapping("/list")
    public String showAll(Model model) {
        List<TripPrices> orders = pric_base.getList();
        model.addAttribute("prices", orders);
        return "Tables/PricePage";
    }

    @GetMapping("/edit/{date}/{car_type}")
    public String edit(Model model, @PathVariable("car_type") CarType car_type, @PathVariable("date") String date) {
        TripPrices edited = pric_base.getPriceOrNull(LocalDateTime.parse(date),car_type);
        if(edited!=null)
        {
            TripPricesForm former = new TripPricesForm(edited);
            model.addAttribute("PriceForm", former);
            model.addAttribute("car_type_options", CarTypeList());
        }
        return "Tables/PriceEditPage";
    }
    private List<String> CarTypeList(){
        var list = new ArrayList<String>();
        for (var item:CarType.values())
            list.add(item.toString());
        return list;
    }

    @Operation(summary = "update problem", description = "due to problems with getting date from MongoDB, the update operation does not work correctly")
    @PostMapping("/edit/{date}/{car_type}")
    public String update(TripPricesForm former, @PathVariable("car_type") CarType car_type, @PathVariable("date") String date) {
        former.car_type = String.valueOf(car_type);
        former.date = String.valueOf(date);
        TripPrices updated = new TripPrices(former);
        pric_base.update(updated);
        return "redirect:/ui/PricesList/list";
    }

    @RequestMapping("/insertNew")
    public String insertNew() {
        TripPrices inserted = new TripPrices(CarType.standart,100,10,20,30);
        pric_base.insert(inserted);
        return "redirect:/ui/PricesList/list";
    }

    @Operation(summary = "delete problem", description = "due to problems with getting date from MongoDB, delete operation does not work")
    @RequestMapping("/delete/{date}/{car_type}")
    public String delete(@PathVariable("car_type") CarType car_type, @PathVariable("date") String date) {
        TripPrices deleted = pric_base.getPriceOrNull(LocalDateTime.parse(date),car_type);
        if (deleted != null)
            pric_base.delete(deleted);
        return "redirect:/ui/PricesList/list";
    }
}
