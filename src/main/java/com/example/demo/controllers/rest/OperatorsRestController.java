package com.example.demo.controllers.rest;

import com.example.demo.model.NewTaxi.TaxiOperator;
import com.example.demo.service.ModelService;
import com.example.demo.service.operator.impls.OperatorServicesImpl;
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
public class OperatorsRestController {
    private ModelService<TaxiOperator> oper_base = new OperatorServicesImpl();
    @RequestMapping("/ListOperators")
    public String PrintOperators() {
        String str = "";
        for (var item: oper_base.getList())
            str += item.toHTML() + "<br>";
        return str;
    }
    @RequestMapping("/ListOperators/{ID}")
    public String PrintOperator(@PathVariable("ID") int id) {
        var item = oper_base.getByIDOrNull(id);
        if (item != null)
            return item.toHTML();
        return "Operator not found";
    }
    @RequestMapping("/TableOperators")
    public String PrintTableOperators() {
        return HTMLTable.createTable_OPER(oper_base.getList());
    }
}
