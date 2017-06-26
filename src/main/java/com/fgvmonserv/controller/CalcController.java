package com.fgvmonserv.controller;

import com.fgvmonserv.model.CalculatorPageTable;
import com.fgvmonserv.service.BaseTableService;
import com.fgvmonserv.service.CalculatorPageTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */

@Controller
@RequestMapping("/calc")
public class CalcController {

    private CalculatorPageTableService calculatorPageTableService;
    private BaseTableService baseTableService;

    @Autowired(required = true)
    @Qualifier(value = "calculatorPageTableService")
    public CalcController setCalculatorPageTableService(CalculatorPageTableService calculatorPageTableService) {
        this.calculatorPageTableService = calculatorPageTableService;
        return this;
    }

    @Autowired
    @Qualifier("baseTableService")
    public CalcController setBaseTableService(BaseTableService baseTableService) {
        this.baseTableService = baseTableService;
        return this;
    }


    @RequestMapping("/{id}")
    @PreAuthorize("isFullyAuthenticated()")
    public String calc(@PathVariable("id") int id, Model model){
        model.addAttribute("startPrice", this.baseTableService.getRecordById(id).getStartPrice());
        model.addAttribute("calcRecord", this.calculatorPageTableService.getCalculatorPageTableById(id));
        return "calc/calc";
    }
}
