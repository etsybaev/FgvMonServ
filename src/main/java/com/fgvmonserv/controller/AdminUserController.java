package com.fgvmonserv.controller;

import com.fgvmonserv.model.StatusOfCall;
import com.fgvmonserv.model.StatusOfDeal;
import com.fgvmonserv.model.userauth.User;
import com.fgvmonserv.service.StatusOfCallService;
import com.fgvmonserv.service.StatusOfDealService;
import com.fgvmonserv.service.userauth.UserRolesService;
import com.fgvmonserv.service.userauth.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */

@Controller
@RequestMapping("/admin")
public class AdminUserController {

    private final Logger LOGGER = LogManager.getLogger(this);
    private UserService userService;
    private UserRolesService userRolesService;
    private BCryptPasswordEncoder passwordEncoder;
    private StatusOfDealService statusOfDealService;
    private StatusOfCallService statusOfCallService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Autowired(required = true)
    @Qualifier(value = "userRolesService")
    public void setUserRolesService(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
    }

    @Autowired(required = true)
    @Qualifier(value = "passwordEncoder")
    public AdminUserController setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        return this;
    }

    @Autowired(required = true)
    @Qualifier(value = "statusOfDealService")
    public AdminUserController setStatusOfDealService(StatusOfDealService statusOfDealService) {
        this.statusOfDealService = statusOfDealService;
        return this;
    }

    @Autowired(required = true)
    @Qualifier(value = "statusOfCallService")
    public AdminUserController setStatusOfCallService(StatusOfCallService statusOfCallService) {
        this.statusOfCallService = statusOfCallService;
        return this;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String listUsers(Model model){
        return "adminpages/admin";
    }


    @RequestMapping(value = "usermanagement", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String userManagement(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());
        model.addAttribute("userRolesList", this.userRolesService.getAllUserRoles());
        return "adminpages/usermanagement";
    }

    @RequestMapping(value = "usermanagement/adduser", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addUser(@ModelAttribute("user") User user){
        if(user.getId() == null){
            LOGGER.debug("Adding new user with params " + user.toString());
            //add pass encryption
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            this.userService.addUser(user);
        }else {
            LOGGER.debug("Updating user with params " + user.toString());
            //add pass encryption
            //Check if pass it the same as in BD - i.e. already encrypted
            if(!userService.getUserById(user.getId()).getPassword().equals(user.getPassword())){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            this.userService.updateUser(user);
        }
        return "redirect:/admin/usermanagement";
    }

    @RequestMapping("usermanagement/removeuser/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);
        return "redirect:/admin/usermanagement";
    }

    @RequestMapping("usermanagement/edituser/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        model.addAttribute("userRolesList", this.userRolesService.getAllUserRoles());
        return "adminpages/usermanagement";
    }

    @RequestMapping("usermanagement/userdata/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        return "adminpages/userdata";
    }




    @RequestMapping(value = "statusofdealmanagement", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String statusOfDealManagement(Model model){
        model.addAttribute("statusOfDeal", new StatusOfDeal());
        model.addAttribute("statusOfDealList", this.statusOfDealService.getAllStatusList());
        return "adminpages/statusofdealmanagement";
    }

    @RequestMapping("statusofdealmanagement/editstatusofdeal/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editStatusOfDeal(@PathVariable("id") int id, Model model){
        model.addAttribute("statusOfDeal", this.statusOfDealService.getStatusById(id));
        model.addAttribute("statusOfDealList", this.statusOfDealService.getAllStatusList());
        return "adminpages/statusofdealmanagement";
    }

    @RequestMapping(value = "statusofdealmanagement/addstatusofdeal", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addStatusOfDeal(@ModelAttribute("statusOfDeal") StatusOfDeal statusOfDeal){
        if(statusOfDeal.getId() == null){
            LOGGER.debug("Adding new Status Of Deal with params " + statusOfDeal.toString());
            this.statusOfDealService.addStatusOfDeal(statusOfDeal);
        }else {
            LOGGER.debug("Updating Status Of Deal with params " + statusOfDeal.toString());
            this.statusOfDealService.updateStatusOfDeal(statusOfDeal);
        }
        return "redirect:/admin/statusofdealmanagement";
    }

    @RequestMapping("statusofdealmanagement/removestatusofdeal/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String removeStatusOfDeal(@PathVariable("id") int id){
        this.statusOfDealService.deleteStatusOfDeal(id);
        return "redirect:/admin/statusofdealmanagement";
    }




    @RequestMapping(value = "statusofcallmanagement", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String statusOfCallManagement(Model model){
        model.addAttribute("statusOfCall", new StatusOfCall());
        model.addAttribute("statusOfCallList", this.statusOfCallService.getAllStatusesList());
        return "adminpages/statusofcallmanagement";
    }

    @RequestMapping("statusofcallmanagement/editstatusofcall/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editStatusOfCall(@PathVariable("id") int id, Model model){
        model.addAttribute("statusOfCall", this.statusOfCallService.getCallStatusById(id));
        model.addAttribute("statusOfCallList", this.statusOfCallService.getAllStatusesList());
        return "adminpages/statusofcallmanagement";
    }

    @RequestMapping(value = "statusofcallmanagement/addstatusofcall", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addStatusOfCall(@ModelAttribute("statusOfCall") StatusOfCall statusOfCall){
        if(statusOfCall.getId() == null){
            LOGGER.debug("Adding new Status Of Call with params " + statusOfCall.toString());
            this.statusOfCallService.addStatusOfCall(statusOfCall);
        }else {
            LOGGER.debug("Updating Status Of Call with params " + statusOfCall.toString());
            this.statusOfCallService.updateStatusOfCall(statusOfCall);
        }
        return "redirect:/admin/statusofcallmanagement";
    }

    @RequestMapping("statusofcallmanagement/removestatusofcall/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String removeStatusOfCall(@PathVariable("id") int id){
        this.statusOfCallService.deleteStatusOfCall(id);
        return "redirect:/admin/statusofcallmanagement";
    }
}
