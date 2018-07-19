package com.fgvmonserv.controller;

import com.fgvmonserv.BaseTableNamesEnum;
import com.fgvmonserv.enums.SearchByRangeTypeEnum;
import com.fgvmonserv.model.BaseTableDateFilter;
import com.fgvmonserv.model.StatusOfCall;
import com.fgvmonserv.model.StatusOfDeal;
import com.fgvmonserv.model.userauth.User;
import com.fgvmonserv.service.BaseTableService;
import com.fgvmonserv.service.StatusOfCallService;
import com.fgvmonserv.service.StatusOfDealService;
import com.fgvmonserv.service.userauth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */

@Controller
@Scope("session")
public class RootDomainController {

    private BaseTableService baseTableService;
    private UserService userService;
    private StatusOfDealService statusOfDealService;
    private StatusOfCallService statusOfCallService;
    private BaseTableDateFilter dateFilter = new BaseTableDateFilter();

    @Autowired
    @Qualifier("baseTableService")
    public RootDomainController setBaseTableService(BaseTableService baseTableService) {
        this.baseTableService = baseTableService;
        return this;
    }

    @Autowired
    @Qualifier("userService")
    public RootDomainController setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }

    @Autowired
    @Qualifier("statusOfDealService")
    public RootDomainController setStatusOfDealService(StatusOfDealService statusOfDealService) {
        this.statusOfDealService = statusOfDealService;
        return this;
    }

    @Autowired
    @Qualifier("statusOfCallService")
    public RootDomainController setStatusOfCallService(StatusOfCallService statusOfCallService) {
        this.statusOfCallService = statusOfCallService;
        return this;
    }

    @PreAuthorize("isFullyAuthenticated()")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(Model model, @ModelAttribute("baseTableDateFilter") BaseTableDateFilter dateFilter,
                            @ModelAttribute("searchForText") String searchForText){

        //for the first run when both dateFilters are empty
        if(this.dateFilter.getStartDate() == null && this.dateFilter.getStartDate() == null){
            this.dateFilter.setStartDate(LocalDate.now().minusMonths(1));
            this.dateFilter.setEndDate(LocalDate.now());
            this.dateFilter.setBaseTableNamesEnum(BaseTableNamesEnum.AUCTION_DATE);
            this.dateFilter.setSearchByRangeTypeEnum(SearchByRangeTypeEnum.START_FROM);
            this.dateFilter.setManager(new User().setId(0));
            this.dateFilter.setStatusOfDeal(new StatusOfDeal().setId(0));
            this.dateFilter.setStatusOfCall(new StatusOfCall().setId(0));
        }else if(dateFilter.getStartDate() != null) {
            this.dateFilter.setStartDate(dateFilter.getStartDate());
            this.dateFilter.setEndDate(dateFilter.getEndDate());
            this.dateFilter.setBaseTableNamesEnum(dateFilter.getBaseTableNamesEnum());
            this.dateFilter.setSearchByRangeTypeEnum(dateFilter.getSearchByRangeTypeEnum());
            this.dateFilter.setManager(dateFilter.getManager());
            this.dateFilter.setStatusOfDeal(dateFilter.getStatusOfDeal());
            this.dateFilter.setIsUnderControl(dateFilter.getIsUnderControl());
            this.dateFilter.setBank(dateFilter.getBank());
            this.dateFilter.setStatusOfCall(dateFilter.getStatusOfCall());
        }

        //if searchForText is not empty - then we are looking for all records through whole DB ignoring other filters
        if(searchForText.isEmpty()){
            model.addAttribute("allRecordsList", this.baseTableService.getAllRecordsList(this.dateFilter));
        }else {
            model.addAttribute("allRecordsList", this.baseTableService.getAllRecordsList(searchForText));
        }

        model.addAttribute("searchKey", searchForText);
        model.addAttribute("baseTableDateFilter", this.dateFilter);
        model.addAttribute("user", new User());
        model.addAttribute("byAuctionDate",  Arrays.asList(BaseTableNamesEnum.AUCTION_DATE,
                BaseTableNamesEnum.NEW_AUCTION_DATE, BaseTableNamesEnum.CREATED_TIME,
                BaseTableNamesEnum.DATE_OF_CALL, BaseTableNamesEnum.REMINDER_DATE));
        model.addAttribute("searchByRangeType",  Arrays.asList(SearchByRangeTypeEnum.values()));
        model.addAttribute("allUsersList", this.userService.listUsers());
        model.addAttribute("statusOfDealList", this.statusOfDealService.getAllStatusList());
        model.addAttribute("allBanksList", this.baseTableService.getAllBanksList());
        model.addAttribute("allCallStatusesList", this.statusOfCallService.getAllStatusesList());

        int currentUserId = userService.getUserByContactPhoneNumber(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        model.addAttribute("remindersList", this.baseTableService.getAllRecordsListByReminderDate(
                LocalDate.now(), true, currentUserId));

        model.addAttribute("missedRemindersList", this.baseTableService.getAllRecordsListWithMissedReminders(
                LocalDate.now(), true));
        return "index";
    }

    @PreAuthorize("isFullyAuthenticated()")
    @RequestMapping(value = "resetFilerToDefault", method = RequestMethod.GET)
    public String resetFilterToDefault(){
        this.dateFilter = new BaseTableDateFilter();
        return "redirect:/";
    }
}