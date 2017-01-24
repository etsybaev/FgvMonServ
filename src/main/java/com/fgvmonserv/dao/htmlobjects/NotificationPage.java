package com.fgvmonserv.dao.htmlobjects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class NotificationPage {
    private Passport passport;
    private List<LotForSale> lotForSaleList;

    public NotificationPage(String url) {
        System.out.println("Started data collection for url " + url);
        try {
            Document doc = Jsoup.connect(url).get();
            Elements tbodyLots = doc.body().getElementsByTag("tbody").get(0).children();
            //remove row with table titles
            lotForSaleList = new ArrayList();
            tbodyLots.remove(0);
            //parse all lots and add it to list
            tbodyLots.forEach((element)->{
                lotForSaleList.add(new LotForSale(element));
            });
            //get passport for current page
            Elements tbodyPassport = doc.body().getElementsByTag("tbody").get(1).children();
            passport = new Passport(tbodyPassport);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<LotForSale> getLotForSaleList() {
        return lotForSaleList;
    }

    public void setLotForSaleList(List<LotForSale> lotForSaleList) {
        this.lotForSaleList = lotForSaleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotificationPage)) return false;

        NotificationPage that = (NotificationPage) o;

        if (lotForSaleList != null ? !lotForSaleList.equals(that.lotForSaleList) : that.lotForSaleList != null)
            return false;
        if (passport != null ? !passport.equals(that.passport) : that.passport != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = passport != null ? passport.hashCode() : 0;
        result = 31 * result + (lotForSaleList != null ? lotForSaleList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NotificationPage{" +
                "passport=" + passport +
                ", lotForSaleList=" + lotForSaleList +
                '}';
    }
}
