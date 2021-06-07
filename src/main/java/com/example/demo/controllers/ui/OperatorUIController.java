package com.example.demo.controllers.ui;

import com.example.demo.model.NewTaxi.TaxiOperator;
import com.example.demo.model.NewTaxiForms.TaxiOperatorForm;
import com.example.demo.service.ModelService;
import com.example.demo.service.operator.impls.OperatorServicesImpl;
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
@Tag(name = "OperationController", description = "UI table controller")
@RestController
@Controller
@RequestMapping("/ui/OperatorsList")
public class OperatorUIController {
    private final ModelService<TaxiOperator> oper_base = new OperatorServicesImpl();

    @RequestMapping("/list")
    public String showAll(Model model) {
        List<TaxiOperator> operators = oper_base.getList();
        model.addAttribute("operators", operators);
        return "Tables/OperatorPage";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        TaxiOperator edited = oper_base.getByIDOrNull(id);
        if(edited!=null)
        {
            TaxiOperatorForm former = new TaxiOperatorForm(edited);
            model.addAttribute("OperatorForm", former);
        }
        return "Tables/OperatorEditPage";
    }

    @PostMapping("/edit/{id}")
    public String update(TaxiOperatorForm former, @PathVariable("id") int id) {
        former.operator_id = String.valueOf(id);
        TaxiOperator updated = new TaxiOperator(former);
        oper_base.update(updated);
        return "redirect:/ui/OperatorsList/list";
    }

    @RequestMapping("/insertNew")
    public String insertNew() {
        List<TaxiOperator> list = oper_base.getList();
        int max = 1;
        if (list.size() > 0)
            max = list.stream().max(TaxiOperator::compareTo).get().operator_id + 1;
        TaxiOperator inserted = new TaxiOperator("",max);
        oper_base.insert(inserted);
        return "redirect:/ui/OperatorsList/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        TaxiOperator deleted = oper_base.getByIDOrNull(id);
        if (deleted != null)
            oper_base.delete(deleted);
        return "redirect:/ui/OperatorsList/list";
    }
}
