package com.example.demo.controllers.ui;

import com.example.demo.model.NewTaxi.CarType;
import com.example.demo.model.NewTaxi.TaxiCar;
import com.example.demo.model.NewTaxiForms.TaxiCarForm;
import com.example.demo.service.ModelService;
import com.example.demo.service.car.impls.CarsServicesImpl;
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
@Tag(name = "CarController", description = "UI table controller")
@RestController
@Controller
@RequestMapping("/ui/CarsList")
public class CarUIController {
    private final ModelService<TaxiCar> cars_base = new CarsServicesImpl();

    @RequestMapping("/list")
    public String showAll(Model model) {
        List<TaxiCar> cars = cars_base.getList();
        model.addAttribute("cars", cars);
        return "Tables/CarPage";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        TaxiCar edited = cars_base.getByIDOrNull(id);
        if(edited!=null) {
            TaxiCarForm former = new TaxiCarForm(edited);
            model.addAttribute("CarForm", former);
            model.addAttribute("type_options", CarTypeList());
        }
        return "Tables/CarEditPage";
    }
    private List<String> CarTypeList(){
        var list = new ArrayList<String>();
        for (var item:CarType.values())
            list.add(item.toString());
        return list;
    }

    @PostMapping("/edit/{id}")
    public String update(TaxiCarForm former, @PathVariable("id") int id) {
        former.car_id = String.valueOf(id);
        TaxiCar updated = new TaxiCar(former);
        cars_base.update(updated);
        return "redirect:/ui/CarsList/list";
    }

    @RequestMapping("/insertNew")
    public String insertNew() {
        List<TaxiCar> list = cars_base.getList();
        int max = 1;
        if (list.size() > 0)
            max = list.stream().max(TaxiCar::compareTo).get().car_id + 1;
        TaxiCar inserted = new TaxiCar(max,"", CarType.standart);
        cars_base.insert(inserted);
        return "redirect:/ui/CarsList/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        TaxiCar deleted = cars_base.getByIDOrNull(id);
        if (deleted != null)
            cars_base.delete(deleted);
        return "redirect:/ui/CarsList/list";
    }
}
