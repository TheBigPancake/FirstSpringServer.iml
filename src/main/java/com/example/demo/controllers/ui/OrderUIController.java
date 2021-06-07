package com.example.demo.controllers.ui;

import com.example.demo.model.NewTaxi.CarType;
import com.example.demo.model.NewTaxi.OrderStatus;
import com.example.demo.model.NewTaxi.TaxiOrder;
import com.example.demo.model.NewTaxiForms.TaxiOrderForm;
import com.example.demo.service.ModelService;
import com.example.demo.service.orders.impls.OrdersServicesImpl;
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
@Tag(name = "OrderController", description = "UI table controller")
@RestController
@Controller
@RequestMapping("/ui/OrdersList")
public class OrderUIController {
    private final ModelService<TaxiOrder> orde_base = new OrdersServicesImpl();

    @RequestMapping("/list")
    public String showAll(Model model) {
        List<TaxiOrder> orders = orde_base.getList();
        model.addAttribute("orders", orders);
        return "Tables/OrderPage";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        TaxiOrder edited = orde_base.getByIDOrNull(id);
        if(edited!=null)
        {
            TaxiOrderForm former = new TaxiOrderForm(edited);
            model.addAttribute("OrderForm", former);
            model.addAttribute("status_options", StatusList());
            model.addAttribute("car_type_options", CarTypeList());
        }
        return "Tables/OrderEditPage";
    }
    private List<String> CarTypeList(){
        var list = new ArrayList<String>();
        for (var item:CarType.values())
            list.add(item.toString());
        return list;
    }
    private List<String> StatusList(){
        var list = new ArrayList<String>();
        for (var item: OrderStatus.values())
            list.add(item.toString());
        return list;
    }

    @Operation(summary = "update problem", description = "due to problems with getting date from MongoDB, the update operation does not work correctly")
    @PostMapping("/edit/{id}")
    public String update(TaxiOrderForm former, @PathVariable("id") int id) {
        former.order_id = String.valueOf(id);
        TaxiOrder updated = new TaxiOrder(former);
        orde_base.update(updated);
        return "redirect:/ui/OrdersList/list";
    }

    @RequestMapping("/insertNew")
    public String insertNew() {
        List<TaxiOrder> list = orde_base.getList();
        int max = 1;
        if (list.size() > 0)
            max = list.stream().max(TaxiOrder::compareTo).get().order_id + 1;
        TaxiOrder inserted = TaxiOrder.CreateOrder(max,0,"","","", CarType.standart);
        inserted.ride_id = 0;
        orde_base.insert(inserted);
        return "redirect:/ui/OrdersList/list";
    }

    @Operation(summary = "delete problem", description = "due to problems with getting date from MongoDB, delete operation does not work")
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        TaxiOrder deleted = orde_base.getByIDOrNull(id);
        if (deleted != null)
            orde_base.delete(deleted);
        return "redirect:/ui/OrdersList/list";
    }
}
