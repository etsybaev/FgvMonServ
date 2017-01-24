package com.fgvmonserv.dao.htmlobjects;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HTMLParser {
    private static Pattern pagesPattern = Pattern.compile("([0-9]+(?!.*[0-9]))");
    private static final String BASE_URI = "http://www.fg.gov.ua";
    private static final String ASSETS_SELLING_URI = "/assets-selling";

    public static void main(String args[]) {
        int totalPagesNumber = getTotalPagesNumber();
        List<String> fullPagesList = getFullPagesList(totalPagesNumber);

        //Get list of all the URLs from all the pages
        List<String> allLinksFromAllPagesList = new CopyOnWriteArrayList();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        fullPagesList.forEach((pageUrl) -> {
            System.out.println(pageUrl);
            executorService.submit(() -> {
                List<String> linksForPage = getLinksForPage(pageUrl);
                allLinksFromAllPagesList.addAll(linksForPage);
//                linksForPage.forEach((url)->{
//                    System.out.println("!!! " + new NotificationPage(url).toString());
//                });

            });
        });
        //Wait for all threads
        try {
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished. Collected Links numbers:" + allLinksFromAllPagesList.size());

        allLinksFromAllPagesList.forEach((url)->{
            System.out.println(new NotificationPage(url).toString());
        });
    }

    private static List<String> getFullPagesList(int totalPagesNumber){
        List<String> fullPagesList = new ArrayList();
        for(int i=1; i <= totalPagesNumber; i++){
            fullPagesList.add(BASE_URI + ASSETS_SELLING_URI + getPageUrlRequestParam(i));
        }
        return fullPagesList;
    }

    private static String getPageUrlRequestParam(int pageNumber){
        int param = pageNumber*20-20;
        return "?start=" + param;
    }

    private static int getTotalPagesNumber(){
        try {
            Document doc = Jsoup.connect(BASE_URI + ASSETS_SELLING_URI).get();
            String totalPagesData = doc.body().getElementsByClass("counter pull-right").text().trim();
            Matcher m = pagesPattern.matcher(totalPagesData);
            if(m.find()) {
                return Integer.parseInt(m.group(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static List<String> getLinksForPage(String url){
        List<String> urlList = new ArrayList();
        try {
            Document doc = Jsoup.connect(url).get();
            Element tbody = doc.getElementsByTag("tbody").get(0);
            Elements tbodyElements = tbody.children();
            for (Element element : tbodyElements) {
                Element urlElem = element.children().get(2).children().get(0);
//                urlList.add(urlElem.baseUri() + urlElem.attributes().get("href"));
                urlList.add(BASE_URI + urlElem.attributes().get("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        urlList.forEach(System.out::println);
        return urlList;
    }

}

