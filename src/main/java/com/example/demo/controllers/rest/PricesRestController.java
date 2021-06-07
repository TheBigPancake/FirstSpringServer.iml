package com.example.demo.controllers.rest;

import com.example.demo.service.prices.impls.PricesServicesImpl;
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
public class PricesRestController {
    private PricesServicesImpl price_base = new PricesServicesImpl();
    @RequestMapping("/ListPrices")
    public String PrintPrices() {
        String str = "";
        for (var item: price_base.getList())
            str += item.toHTML() + "<br>";
        return str;
    }
    @RequestMapping("/TablePrices")
    public String PrintTablePrices() {
        return HTMLTable.createTable_PRIC(price_base.getList());
    }
}
