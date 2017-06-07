package com.fgvmonserv.controller;

import com.fgvmonserv.converter.CsvConverter;
import com.fgvmonserv.converter.JsonConverter;
import com.fgvmonserv.converter.UrlEncoderDecoder;
import com.fgvmonserv.model.BaseTable;
import com.fgvmonserv.model.BaseTableListHolder;
import com.fgvmonserv.model.userauth.User;
import com.fgvmonserv.service.BaseTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ImportExportController {

    private BaseTableService baseTableService;
    private JsonConverter jsonConverter ;
    private UrlEncoderDecoder urlEncoderDecoder;
    private CsvConverter csvConverter;

    @Autowired(required = true)
    @Qualifier(value = "baseTableService")
    public ImportExportController setBaseTableService(BaseTableService baseTableService) {
        this.baseTableService = baseTableService;
        return this;
    }

    @Autowired(required = true)
    @Qualifier(value = "jsonConverter")
    public ImportExportController setJsonConverter(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
        return this;
    }

    @Autowired(required = true)
    @Qualifier(value = "urlEncoderDecoder")
    private ImportExportController setUrlEncoderDecoder(UrlEncoderDecoder urlEncoderDecoder){
        this.urlEncoderDecoder = urlEncoderDecoder;
        return this;
    }

    @Autowired(required = true)
    @Qualifier(value = "csvConverter")
    public ImportExportController setCsvConverter(CsvConverter csvConverter) {
        this.csvConverter = csvConverter;
        return this;
    }

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
            return "redirect:/importexport/fileupload";
        }

        List<BaseTable> shortBaseTableInfoFromCsvFile = csvConverter.getShortBaseTableInfoFromCsvFile(file);
        BaseTableListHolder baseTableListHolder = new BaseTableListHolder();
        baseTableListHolder.getBaseTableList().addAll(shortBaseTableInfoFromCsvFile);

        redirectAttributes.addFlashAttribute("message", "Please check the records to be uploaded." +
                " \n If it looks good please press on Confirm button below. Otherwise fix your CSV file and try again. ");

        redirectAttributes.addFlashAttribute("parsedData", baseTableListHolder);
        redirectAttributes.addFlashAttribute("jsonData",
                urlEncoderDecoder.encodeToUrlUtf8((jsonConverter.convertToJson(baseTableListHolder))));
        return "redirect:/importexport/fileupload";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/importexport/fileupload", method=RequestMethod.GET)
    public String processUploadGet(@ModelAttribute("parsedData") BaseTableListHolder baseTableHolder) {
        return "/importexport/files";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/importexport/doAddRecords", method=RequestMethod.POST)
    public String addUser(@ModelAttribute("data") String baseTableHolder, RedirectAttributes redirectAttributes){
        String s = urlEncoderDecoder.decodeFromUrlUtf8(baseTableHolder);
        BaseTableListHolder baseTableListHolder = jsonConverter.convertJsonToObject(s,
                BaseTableListHolder.class, false);

        baseTableListHolder.getBaseTableList().forEach(record -> this.baseTableService.addBaseTableRecord(record));
        redirectAttributes.addFlashAttribute("message", "All records have been added to database");
        return "redirect:/importexport/fileupload";
    }

    @PreAuthorize("isFullyAuthenticated()")
    @RequestMapping("/importexport/download")
    public void downloadPDFResource(HttpServletResponse response){
        //For filter param some oject may be used, ex:
        //   @PreAuthorize("hasRole('ROLE_ADMIN')")
        //   public String addUser(@ModelAttribute("exportParams") ExportParams exportParams){
        // Then we may assemble request using params ex "exportParams.getPeriodRange()" etc.

        //Here should be some logic of fetching data from DB and file creation.
        csvConverter.writeBaseTableToCSVFileAndSendToClientInResponse(response, baseTableService.getAllRecordsList(),
                csvConverter.getColumnNamesThatWillBeShownInexportedCsvFile(), csvConverter.getBaseTableVariablesNameToBeExported());
    }



//    @PreAuthorize("isFullyAuthenticated()")
//    @RequestMapping("/importexport/download")
//    public void downloadPDFResource(HttpServletResponse response){
//        //For filter param some oject may be used, ex:
//        //   @PreAuthorize("hasRole('ROLE_ADMIN')")
//        //   public String addUser(@ModelAttribute("exportParams") ExportParams exportParams){
//        // Then we may assemble request using params ex "exportParams.getPeriodRange()" etc.
//
//        //Here should be some logic of fetching data from DB and file creation.
//
//
//        String csvFileName = "DataBase.csv";
//        response.setContentType("text/csv");
//        String headerKey = "Content-Disposition";
//        String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
//        response.setHeader(headerKey, headerValue);
//
//        ICsvBeanWriter csvWriter = null;
//        try {
//            csvWriter = new CsvBeanWriter(response.getWriter(),
//                    (new CsvPreference.Builder('\"', ';', "\n")).build());
//            //Write header - i.e. column names that will be shown in exported csv file
//            csvWriter.writeHeader(csvConverter.getColumnNamesThatWillBeShownInexportedCsvFile());
//            //get records from DB to export to CSV file
//            List<BaseTable> allRecordsList = this.baseTableService.getAllRecordsList();
//            for (BaseTable baseTable : allRecordsList) {
//                //This column names of variables is used to map values from base table to column. At least it seems so ;)
//                String[] valueNamesThatWillBeExportedToCsvFile = csvConverter.getColumnNamesOfVariables();
//                csvWriter.write(baseTable, valueNamesThatWillBeExportedToCsvFile);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (csvWriter != null){
//                try {
//                    csvWriter.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }



//    @PreAuthorize("isFullyAuthenticated()")
//    @RequestMapping("/importexport/download")
//    public void downloadPDFResource( HttpServletRequest request, HttpServletResponse response){
//
//
//        //For filter param some oject may be used, ex:
//        //   @PreAuthorize("hasRole('ROLE_ADMIN')")
//        //   public String addUser(@ModelAttribute("exportParams") ExportParams exportParams){
//        // Then we may assemble request using params ex "exportParams.getPeriodRange()" etc.
//
//        //Here should be some logic of fetching data from DB and file creation.
//
//
//        List<BaseTable> allRecordsList = this.baseTableService.getAllRecordsList();
//
//        List<String[]> preparedListOfStringArrayToWriteToCsvFile = csvConverter
//                .getPreparedListOfStringArrayToWriteToCsvFile(allRecordsList);
//
//        CSVWriter writer = null;
//        String tmpFilePath = UPLOADED_FOLDER + fileName + System.currentTimeMillis();
//        File tmpFile = new File(tmpFilePath);
//        try {
//            writer = new CSVWriter(new FileWriter(tmpFile), ';');
//            writer.writeAll(preparedListOfStringArrayToWriteToCsvFile);
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Path file = Paths.get(tmpFilePath);
//        if (Files.exists(file)){
//            response.setContentType("text/csv");
//            response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
//            try{
//                Files.copy(file, response.getOutputStream());
//                response.getOutputStream().flush();
//            }
//            catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//        tmpFile.delete();
//    }
}
