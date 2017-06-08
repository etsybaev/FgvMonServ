package com.fgvmonserv.controller;

import com.fgvmonserv.BaseTableNamesEnum;
import com.fgvmonserv.enums.SearchByRangeTypeEnum;
import com.fgvmonserv.model.BaseTableDateFilter;
import com.fgvmonserv.model.userauth.User;
import com.fgvmonserv.service.BaseTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class RootDomainController {

    private BaseTableService baseTableService;


    @Autowired
    @Qualifier("baseTableService")
    public RootDomainController setBaseTableService(BaseTableService baseTableService) {
        this.baseTableService = baseTableService;
        return this;
    }


    @PreAuthorize("isFullyAuthenticated()")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(Model model, @ModelAttribute("baseTableDateFilter") BaseTableDateFilter dateFilter){
        model.addAttribute("user", new User());
        model.addAttribute("byAuctionDate",  Arrays.asList(BaseTableNamesEnum.AUCTION_DATE, BaseTableNamesEnum.NEW_AUCTION_DATE));
        model.addAttribute("searchByRangeType",  Arrays.asList(SearchByRangeTypeEnum.values()));

        if(dateFilter.getStartDate() == null){
            dateFilter.setStartDate(LocalDate.now().minusMonths(1));
        }
        if(dateFilter.getBaseTableNamesEnum() == null){
            dateFilter.setBaseTableNamesEnum(BaseTableNamesEnum.AUCTION_DATE);
        }
        if(dateFilter.getSearchByRangeTypeEnum() == null){
            dateFilter.setSearchByRangeTypeEnum(SearchByRangeTypeEnum.START_FROM);
        }

        model.addAttribute("allRecordsList", this.baseTableService.getAllRecordsList(dateFilter));
        model.addAttribute("baseTableDateFilter", dateFilter);
        return "index";
    }
}