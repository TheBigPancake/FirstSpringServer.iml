package com.example.demo.controllers.rest;

import com.example.demo.model.NewTaxi.CarType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @GetMapping("/")
    public String home1(Model model) {
        model.addAttribute("Name", "Городенський Станіслав Дановичь");
        return "home_page";
    }

    @GetMapping("/HomePage")
    public String homepage() {
        return "HomePage";
    }

    @GetMapping("/MainPage")
    public String page(Model model) {
        model.addAttribute("type_options", CarTypeList());
        return "MainPage";
    }

    private List<String> CarTypeList(){
        var list = new ArrayList<String>();
        for (var item: CarType.values())
            list.add(item.toString());
        return list;
    }
    //<U th:text="${Name}"/>
    @GetMapping("/Named/{Name}")
    public String home2(@PathVariable("Name") String Name, Model model) {
        model.addAttribute("Name", Name);
        return "home_page";
    }
}
