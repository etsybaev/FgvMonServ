package com.fgvmonserv.converter;

import com.fgvmonserv.BaseTableNamesEnum;
import com.fgvmonserv.model.BaseTable;
import com.opencsv.CSVReader;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ievgeniit on 02.06.17.
 */
public class CsvConverter {


    public List<BaseTable> getShortBaseTableInfoFromCsvFile(CommonsMultipartFile file) {
        List<BaseTable> resultList = new ArrayList<>();
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            //http://opencsv.sourceforge.net/
            CSVReader reader = new CSVReader(new InputStreamReader(new ByteArrayInputStream(bytes)), ';');
            List<String[]> csvLines = reader.readAll();
            //As the first line of CSV document is column titles - need to start from second line, i.e. not from 0, but from 1
            for(int i = 1; i < csvLines.size(); i++){
                String[] csvLine = csvLines.get(i);
                BaseTable shortBaseTableFromCsvLine = BaseTable.getShortBaseTableFromCsvLine(csvLine);
                resultList.add(shortBaseTableFromCsvLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }


    public List<String[]> getPreparedListOfStringArrayToWriteToCsvFile(List<BaseTable> allRecordsList) {
        List<String[]> listOfStringArrayToWriteToCsvFile = new ArrayList<>();
        //Adding columns header names
        listOfStringArrayToWriteToCsvFile.add(getColumnNamesThatWillBeShownInexportedCsvFile());
        //Now need to prepare and add values
        allRecordsList.forEach(baseTable -> {
            listOfStringArrayToWriteToCsvFile.add(baseTable.getValuesAsStringArray());
        });

        return listOfStringArrayToWriteToCsvFile;
    }

    public void writeBaseTableToCSVFileAndSendToClientInResponse(HttpServletResponse response, List<BaseTable> allRecordsList,
                                            String[] columnNamesThatWillBeShownInExportedCsvFile, String[] baseTableVariablesNameToBeExported){
        String csvFileName = "DataBase.csv";
        response.setContentType("text/csv");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
        response.setHeader(headerKey, headerValue);

        ICsvBeanWriter csvWriter = null;
        try {
            csvWriter = new CsvBeanWriter(response.getWriter(),
                    (new CsvPreference.Builder('\"', ';', "\n")).build());
            //Write header - i.e. column names that will be shown in exported csv file
            csvWriter.writeHeader(columnNamesThatWillBeShownInExportedCsvFile);
            //get records from DB to export to CSV file
            for (BaseTable baseTable : allRecordsList) {
                //This column names of variables is used to map values from base table to column. At least it seems so ;)
                csvWriter.write(baseTable, baseTableVariablesNameToBeExported);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (csvWriter != null){
                try {
                    csvWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public String[] getColumnNamesThatWillBeShownInexportedCsvFile(){
        Field[] declaredFields = BaseTable.class.getDeclaredFields();
        String[] declaredFieldsAsString =  new String[declaredFields.length];
        //Get all declared variables in BaseTable class and find appropriate values in Enum.
        for(int i = 0; i < declaredFields.length; i++){
            declaredFieldsAsString[i] = BaseTableNamesEnum.getViewNameFromDbName(declaredFields[i].getName());
        }
        return declaredFieldsAsString;
    }


    public String[] getBaseTableVariablesNameToBeExported(){
        Field[] declaredFields = BaseTable.class.getDeclaredFields();
        String[] declaredFieldsAsString =  new String[declaredFields.length];
        //Get all declared variables in BaseTable class and find appropriate values in Enum.
        for(int i = 0; i < declaredFields.length; i++){
            declaredFieldsAsString[i] = declaredFields[i].getName();
//            declaredFieldsAsString[i] = BaseTableNamesEnum.getViewNameFromDbName(declaredFields[i].getName());
        }
        return declaredFieldsAsString;
    }
}
