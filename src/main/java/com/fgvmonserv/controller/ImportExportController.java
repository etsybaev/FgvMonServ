package com.fgvmonserv.controller;

import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.userauth.User;
import com.fgvmonserv.service.BaseTableService;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */

@Controller
public class ImportExportController {


    private BaseTableService baseTableService;

    @Autowired(required = true)
    @Qualifier(value = "baseTableService")
    public ImportExportController setBaseTableService(BaseTableService baseTableService) {
        this.baseTableService = baseTableService;
        return this;
    }

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/home/ievgeniit/tempTomcatUpload/";

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/importexport", method = RequestMethod.GET)
    public String indexPage(Model model){
        model.addAttribute("user", new User());
        return "importexport/files";
    }



    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/importexport/fileupload", method=RequestMethod.POST)
    public String processUpload(@RequestParam CommonsMultipartFile file, RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/importexport/uploadStatus";
        }

        List<BaseTable> shortBaseTableInfoFromCsvFile = this.baseTableService.getShortBaseTableInfoFromCsvFile(file);

        redirectAttributes.addFlashAttribute("message", "Please check the records to be uploaded." +
                " \n If ot looks good please press on Confirm button below. Otherwise fix your CSV file and try again. ");
        redirectAttributes.addFlashAttribute("parsedData", shortBaseTableInfoFromCsvFile);
        return "redirect:/importexport/uploadStatus";
    }

    @GetMapping("/importexport/uploadStatus")
    public String uploadStatus() {
        return "/importexport/uploadStatus";
    }



    @RequestMapping("/importexport/download")
    public void downloadPDFResource( HttpServletRequest request,
                                     HttpServletResponse response){


        //For filter param some oject may be used, ex:
        //   @PreAuthorize("hasRole('ROLE_ADMIN')")
        //   public String addUser(@ModelAttribute("exportParams") ExportParams exportParams){
        // Then we may assemble request using params ex "exportParams.getPeriodRange()" etc.

        //Here should be some logic of fetching data from DB and file creation.


        //Authorized user will download the file
        String fileName = "1pr.csv";

        Path file = Paths.get(UPLOADED_FOLDER, fileName);
        if (Files.exists(file)){
            response.setContentType("text/csv");
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }









//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @RequestMapping(value="/importexport/fileupload", method=RequestMethod.POST)
//    public String processUpload(@RequestParam CommonsMultipartFile file, RedirectAttributes redirectAttributes) {
//
//        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:/importexport/uploadStatus";
//        }
//        try {
//            // Get the file and save it somewhere
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.write(path, bytes);
//
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
//
//            //http://opencsv.sourceforge.net/
//            CSVReader reader = new CSVReader(new FileReader(UPLOADED_FOLDER + file.getOriginalFilename()), ';');
//            String [] line;
//            while ((line = reader.readNext()) != null) {
//                System.out.println("AAAA " + line[0] + "   " + line[1] + "    etc...");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/importexport/uploadStatus";
//    }

}
