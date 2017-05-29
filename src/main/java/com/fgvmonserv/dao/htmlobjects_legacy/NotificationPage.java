package com.fgvmonserv.dao.htmlobjects_legacy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;


public class NotificationPage {
    private Passport passport;
    private List<LotForSale> lotForSaleList;

    public NotificationPage(String url) {
        System.out.println("Started data collection for url " + url);
        try {
            Document doc = Jsoup.connect(url).get();
            Elements tbodyLots = doc.body().getElementsByTag("tbody").get(0).children();
            //This is the final matrix with parsed values from table
            String[][] matrix = parseTableWithLots(tbodyLots);

            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String[][] parseTableWithLots(Elements tbodyLots){
        int tbodyLotsSize = tbodyLots.size();
        int columnSize = tbodyLots.get(0).children().size();
        //This is the final matrix with parsed values from table
        String[][] matrix = new String[tbodyLotsSize][columnSize];
        //iterate by each row in table
        for(int i=0; i< tbodyLotsSize; i++) {
            //iterate by each column in table
            Element row = tbodyLots.get(i);
            for(int j=0; j< row.children().size(); j++){
                Element td = row.getElementsByTag("td").get(j);
                //find first free cell to put data (some of fields may be already busy by values that were out by "rowspan")
                for (int k=0; k<columnSize;k++){
                    if (matrix[i][k] == null || matrix[i][k].isEmpty()){
                        matrix[i][k] = td.text();
                        System.out.println("breaking search");
                        break;
                    }
                }
                //if has rowspan - then add the value to next fields as well
                if(td.hasAttr("rowspan")) {
                    int rowspan = Integer.parseInt(td.attr("rowspan"));
                    for (int k=1; k<rowspan; k++){
                        matrix[i+k][j] = td.text();
                    }
                }

                System.out.println(td.text());
            }
            System.out.println();
        }
        return matrix;
    }
}




//
//import org.dom4j.util.IndexedElement;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class NotificationPage {
//    private Passport passport;
//    private List<LotForSale> lotForSaleList;
//
//    public NotificationPage(String url) {
//        System.out.println("Started data collection for url " + url);
//        try {
//            Document doc = Jsoup.connect(url).get();
//            Elements tbodyLots = doc.body().getElementsByTag("tbody").get(0).children();
//            int tbodyLotsColumnsNumber = tbodyLots.get(0).children().size();
//            //remove row with table titles
////            lotForSaleList = new ArrayList();
////            tbodyLots.remove(0);
//
//
////            Document document = Jsoup.connect(url).get(); //get the HTML page
////            Elements rows = doc.select("tbody > tr"); //select all rows
//            Elements rows = tbodyLots.select("tr"); //select all rows
//            int[] offsets = new int[rows.size()];
//
//            for (int i = 0; i < rows.get(0).children().size(); i++) {//unless colspans are used, this should return the number of columns
//                for (int j = 0; j < rows.size();j++){ // loops through the rows of each column
//                    Element cell = rows.get(j).child(i + offsets[j]); //get an individual cell
//                    System.out.println("a");
//                    if (cell.hasAttr("rowspan")){ //if that cell has a rowspan
//                        System.out.println("b");
//                        int rowspan = Integer.parseInt(cell.attr("rowspan"));
//
//                        for (int k = 1; k < rowspan; k++){
//                            System.out.println("c");
//                            offsets[j + k]--; //add offsets to rows that now have a cell "missing"
//                        }
//
//                        j += rowspan - 1; //add rowspan to index, to skip the "missing" cells
//                        System.out.println("d");
//                    }
//                    System.out.println(cell.text());
//                }
//                System.out.println("");
//            }
//
//
//////            Getting list of all rows with rowspan attribute
////            Elements rows = tbodyLots.select("tr > td[rowspan=2]");
////            for (Element row : rows) {
////                row.parent().nextElementSibling().append("<td>$50</td>");
////            }
//
//            System.out.println("aaa");
//            //parse all lots and add it to list
////            tbodyLots.forEach((element)->{
////                lotForSaleList.add(new LotForSale(element));
////            });
////            //get passport for current page
////            Elements tbodyPassport = doc.body().getElementsByTag("tbody").get(1).children();
////            passport = new Passport(tbodyPassport);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Passport getPassport() {
//        return passport;
//    }
//
//    public void setPassport(Passport passport) {
//        this.passport = passport;
//    }
//
//    public List<LotForSale> getLotForSaleList() {
//        return lotForSaleList;
//    }
//
//    public void setLotForSaleList(List<LotForSale> lotForSaleList) {
//        this.lotForSaleList = lotForSaleList;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof NotificationPage)) return false;
//
//        NotificationPage that = (NotificationPage) o;
//
//        if (lotForSaleList != null ? !lotForSaleList.equals(that.lotForSaleList) : that.lotForSaleList != null)
//            return false;
//        if (passport != null ? !passport.equals(that.passport) : that.passport != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = passport != null ? passport.hashCode() : 0;
//        result = 31 * result + (lotForSaleList != null ? lotForSaleList.hashCode() : 0);
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "NotificationPage{" +  "\n" +
//                "   passport=" + passport + ",\n" +
//                "   lotForSaleList=" + lotForSaleList + "\n" +
//                '}' + "\n";
//    }
//}
