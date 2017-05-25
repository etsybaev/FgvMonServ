package com.fgvmonserv.controller;

import com.fgvmonserv.model.userauth.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */

@Controller
public class ImportExportController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/importexport", method = RequestMethod.GET)
    public String indexPage(Model model){
        model.addAttribute("user", new User());
        return "importexport/files";
    }



    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/importexport/fileupload", method=RequestMethod.POST)
    public String processUpload(@RequestParam MultipartFile file) throws IOException {

        System.out.println("Uploaded file!! " + file.toString());

        return "redirect:/importexport";
    }
}
