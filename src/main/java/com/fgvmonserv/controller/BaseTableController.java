package com.fgvmonserv.controller;

import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.service.BaseTableService;
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

    @Autowired(required = true)
    @Qualifier(value = "baseTableService")
    public void setBaseTableService(BaseTableService baseTableService) {
        this.baseTableService = baseTableService;
    }

    @RequestMapping("/basetablerecorddetails/{id}")
    @PreAuthorize("isFullyAuthenticated()")
    public String baseTableRecordData(@PathVariable("id") int id, Model model){
        model.addAttribute("baseTableRecord", this.baseTableService.getRecordById(id));
        return "basetable/basetablerecorddetails";
    }

    @RequestMapping("/removebasetablerecord/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String removeBaseTableRecord(@PathVariable("id") int id){
        this.baseTableService.removeBaseTableRecord(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/editbasetablerecord", method = RequestMethod.POST)
    @PreAuthorize("isFullyAuthenticated()")
    public String addUser(@ModelAttribute("baseTableRecord") BaseTable baseTable, RedirectAttributes redirectAttributes){
        this.baseTableService.updateBaseTableRecord(baseTable);
        redirectAttributes.addFlashAttribute("message", "Record has been successfully updated!");
        return "redirect:/basetableconroller/basetablerecorddetails/" + baseTable.getId();
    }
}
