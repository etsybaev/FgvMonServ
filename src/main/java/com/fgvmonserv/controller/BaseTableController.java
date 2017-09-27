package com.fgvmonserv.controller;

import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.BaseTableHistory;
import com.fgvmonserv.service.BaseTableHistoryService;
import com.fgvmonserv.service.BaseTableService;
import com.fgvmonserv.service.StatusOfCallService;
import com.fgvmonserv.service.StatusOfDealService;
import com.fgvmonserv.service.userauth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private BaseTableHistoryService baseTableHistoryService;
    private UserService userService;
    private StatusOfDealService statusOfDealService;
    private StatusOfCallService statusOfCallService;

    @Autowired(required = true)
    @Qualifier(value = "baseTableService")
    public void setBaseTableService(BaseTableService baseTableService) {
        this.baseTableService = baseTableService;
    }


    @Autowired(required = true)
    @Qualifier(value = "baseTableHistoryService")
    public BaseTableController setBaseTableHistoryService(BaseTableHistoryService baseTableHistoryService) {
        this.baseTableHistoryService = baseTableHistoryService;
        return this;
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
        model.addAttribute("recordId", id);
        model.addAttribute("baseTableRecord", this.baseTableService.getRecordById(id));
        model.addAttribute("allUsersList", this.userService.listUsers());
        model.addAttribute("statusOfDealList", this.statusOfDealService.getAllStatusList());
        model.addAttribute("allCallStatusesList", this.statusOfCallService.getAllStatusesList());
        return "basetable/basetablerecorddetails";
    }

    @RequestMapping("/basetablerecorddetails/history/{id}")
    @PreAuthorize("isFullyAuthenticated()")
    public String baseTableHistory(@PathVariable("id") int id, Model model){
        model.addAttribute("recordId", id);
        model.addAttribute("baseTableRecordHistory", this.baseTableHistoryService.getBaseTableHistoryListByBaseTableId(id));
        return "basetable/history";
    }

    @RequestMapping("/removebasetablerecord/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String removeBaseTableRecord(@PathVariable("id") int id){
        this.baseTableService.removeBaseTableRecord(id);
        //Now need to remove a history of editing for this record
        this.baseTableHistoryService.deleteAllHistoryRecordsForBaseTableId(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/addeditbasetablerecord", method = RequestMethod.POST)
    @PreAuthorize("isFullyAuthenticated()")
    public String addOrEditBaseTableRecord(@ModelAttribute("baseTableRecord") BaseTable baseTable, RedirectAttributes redirectAttributes){

        //This is hot fix for set null instead of null to db, when no value assigned
        if(baseTable.getStatusOfCall() != null && baseTable.getStatusOfCall().getId()==0){
            baseTable.setStatusOfCall(null);
        }
        if(baseTable.getManager() != null && baseTable.getManager().getId()==0){
            baseTable.setManager(null);
        }
        if(baseTable.getStatusOfDeal() != null && baseTable.getStatusOfDeal().getId()==0){
            baseTable.setStatusOfDeal(null);
        }

//        if(baseTable.getId() == null){
//            //After adding to DB we get updated record that contains auto-generated id
//            baseTable = this.baseTableService.addBaseTableRecord(baseTable);
//            //Now need to add initial record to BaseTable history
//            addRecordToBaseTableHistoryTable(baseTable, SecurityContextHolder.getContext().getAuthentication());
//            redirectAttributes.addFlashAttribute("message", "Record has been successfully created!");
//            return "redirect:/";
//        }else {
//            this.baseTableService.updateBaseTableRecord(baseTable);
//            //Prepare and add record to history table
//            addRecordToBaseTableHistoryTable(baseTable, SecurityContextHolder.getContext().getAuthentication());
//            redirectAttributes.addFlashAttribute("message", "Record has been successfully updated!");
//            return "redirect:/basetableconroller/basetablerecorddetails/" + baseTable.getId();
//        }

        if(baseTable.getId() == null){
            //After adding to DB we get updated record that contains auto-generated id
            baseTable = this.baseTableService.addBaseTableRecord(baseTable);
            redirectAttributes.addFlashAttribute("message", "Record has been successfully created!");
        }else {
            this.baseTableService.updateBaseTableRecord(baseTable);
            redirectAttributes.addFlashAttribute("message", "Record has been successfully updated!");
        }
        addRecordToBaseTableHistoryTable(baseTable, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/basetableconroller/basetablerecorddetails/" + baseTable.getId();

    }

    private void addRecordToBaseTableHistoryTable(BaseTable baseTableRecordToAddToHistory, Authentication auth){
        BaseTableHistory baseTableHistory = new BaseTableHistory(baseTableRecordToAddToHistory);
        baseTableHistory.setManagerUpdatedBy(userService.getUserByContactPhoneNumber(auth.getName()));
        baseTableHistoryService.addBaseTableHistoryRecord(baseTableHistory);
    }
}
