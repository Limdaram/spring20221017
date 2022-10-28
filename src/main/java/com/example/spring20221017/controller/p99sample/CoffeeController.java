package com.example.spring20221017.controller.p99sample;

import com.example.spring20221017.domain.sample.CoffeeDto;
import com.example.spring20221017.mapper.CoffeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sample")
public class CoffeeController {
    @Autowired
    private CoffeeMapper mapper;

    @GetMapping("coffee")
    public void form(Model model) {
        List<CoffeeDto> list = mapper.getCoffeeList();
        model.addAttribute("coffeeList", list);
    }

    @PostMapping("coffee")
    public String updateCoffee(CoffeeDto coffee) {
        mapper.update(coffee);
        return "redirect:coffee";
    }
}
