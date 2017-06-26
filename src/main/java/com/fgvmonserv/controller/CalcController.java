package com.fgvmonserv.controller;

import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.CalculatorPageTable;
import com.fgvmonserv.service.BaseTableService;
import com.fgvmonserv.service.CalculatorPageTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(value = "/editcalcrecord", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addUser(@ModelAttribute("calcRecord") CalculatorPageTable calculatorPageTable, RedirectAttributes redirectAttributes){
        System.out.println("Updating CalculatorPageTable record with id " + calculatorPageTable.getId());

        //If at least one of field is not defined - browser cant calculate result and send it as "Nan" which cann't be written to DB, so wll set it yo null
        if(calculatorPageTable.getFinalPrice() != null && calculatorPageTable.getFinalPrice().isNaN()){
            calculatorPageTable.setFinalPrice(null);
        }

        this.calculatorPageTableService.updateRecord(calculatorPageTable);

        //Updating info about record for Base Table record
        BaseTable baseTable = this.baseTableService.getRecordById(calculatorPageTable.getId()).setCalculatorPageTable(calculatorPageTable);
        this.baseTableService.updateBaseTableRecord(baseTable);

        redirectAttributes.addFlashAttribute("message", "Successfully updated");
        return "redirect:/calc/" + calculatorPageTable.getId();
    }

    @RequestMapping("/{id}")
    @PreAuthorize("isFullyAuthenticated()")
    public String calc(@PathVariable("id") int id, Model model){
        model.addAttribute("startPrice", this.baseTableService.getRecordById(id).getStartPrice());
        model.addAttribute("calcRecord", this.calculatorPageTableService.getCalculatorPageTableById(id));
        return "calc/calc";
    }
}
