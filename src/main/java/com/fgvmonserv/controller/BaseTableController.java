package com.fgvmonserv.controller;

import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.CalculatorPageTable;
import com.fgvmonserv.service.BaseTableService;
import com.fgvmonserv.service.CalculatorPageTableService;
import com.fgvmonserv.service.StatusOfCallService;
import com.fgvmonserv.service.StatusOfDealService;
import com.fgvmonserv.service.userauth.UserService;
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
@RequestMapping("/basetableconroller")
public class BaseTableController {

    private BaseTableService baseTableService;
    private UserService userService;
    private StatusOfDealService statusOfDealService;
    private StatusOfCallService statusOfCallService;
    private CalculatorPageTableService calculatorPageTableService;

    @Autowired(required = true)
    @Qualifier(value = "baseTableService")
    public void setBaseTableService(BaseTableService baseTableService) {
        this.baseTableService = baseTableService;
    }

    @Autowired
    @Qualifier("userService")
    public BaseTableController setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }

    @Autowired
    @Qualifier("statusOfDealService")
    public BaseTableController setStatusOfDealService(StatusOfDealService statusOfDealService) {
        this.statusOfDealService = statusOfDealService;
        return this;
    }

    @Autowired
    @Qualifier("statusOfCallService")
    public BaseTableController setStatusOfCallService(StatusOfCallService statusOfCallService) {
        this.statusOfCallService = statusOfCallService;
        return this;
    }

    @Autowired
    @Qualifier("calculatorPageTableService")
    public BaseTableController setCalculatorPageTableService(CalculatorPageTableService calculatorPageTableService) {
        this.calculatorPageTableService = calculatorPageTableService;
        return this;
    }


    @RequestMapping(value = "/addnewbasetablerecordform")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addBaseTableRecord(@ModelAttribute("baseTableRecord") BaseTable baseTable, Model model){
        model.addAttribute("action", "ADD_USER");
        model.addAttribute("allUsersList", this.userService.listUsers());
        model.addAttribute("statusOfDealList", this.statusOfDealService.getAllStatusList());
        model.addAttribute("allCallStatusesList", this.statusOfCallService.getAllStatusesList());
        return "basetable/basetablerecorddetails";
    }

    @RequestMapping("/basetablerecorddetails/{id}")
    @PreAuthorize("isFullyAuthenticated()")
    public String baseTableRecordData(@PathVariable("id") int id, Model model){
        model.addAttribute("baseTableRecord", this.baseTableService.getRecordById(id));
        model.addAttribute("allUsersList", this.userService.listUsers());
        model.addAttribute("statusOfDealList", this.statusOfDealService.getAllStatusList());
        model.addAttribute("allCallStatusesList", this.statusOfCallService.getAllStatusesList());
        return "basetable/basetablerecorddetails";
    }

    @RequestMapping("/removebasetablerecord/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String removeBaseTableRecord(@PathVariable("id") int id){
        this.baseTableService.removeBaseTableRecord(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/addeditbasetablerecord", method = RequestMethod.POST)
    @PreAuthorize("isFullyAuthenticated()")
    public String addOrEditBaseTableRecord(@ModelAttribute("baseTableRecord") BaseTable baseTable, RedirectAttributes redirectAttributes){
        if(baseTable.getId() == null){
            this.baseTableService.addBaseTableRecord(baseTable);
            redirectAttributes.addFlashAttribute("message", "Record has been successfully created!");
            return "redirect:/";
        }else {
            //check if Start price was changed. If yes - then will remove total price as obsolete value.
            BaseTable baseTableFromDBBeforeUpdate = this.baseTableService.getRecordById(baseTable.getId());
            CalculatorPageTable calc = this.calculatorPageTableService.getCalculatorPageTableById(baseTable.getId());
            if (!baseTableFromDBBeforeUpdate.getStartPrice().equals(baseTable.getStartPrice())){
                this.calculatorPageTableService.updateRecord(calc.setFinalPrice(null));
            }else {
                //If prise is the same that means that some other fields were updated. But final price is not sent from browser
                //So we need to set it here to keep the same as before update other fields. Not good way, need to get back later and re-write
                baseTable.setCalculatorPageTable(calc);
            }
            this.baseTableService.updateBaseTableRecord(baseTable);
            redirectAttributes.addFlashAttribute("message", "Record has been successfully updated!");
            return "redirect:/basetableconroller/basetablerecorddetails/" + baseTable.getId();
        }
    }
}
