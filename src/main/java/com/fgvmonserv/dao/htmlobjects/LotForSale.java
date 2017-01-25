package com.fgvmonserv.dao.htmlobjects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created with IntelliJ IDEA.
 * User: Evg
 * Date: 23.01.17
 * Time: 21:41
 * To change this template use File | Settings | File Templates.
 */
public class LotForSale {

    private String lotId;
    private String name;
    private String description;
    private String startPrice;
    private String assetPublicPassport;

    public LotForSale(Element element){
        this.lotId = getTextFromTable(element, 0);
        this.name = getTextFromTable(element, 1);
        this.description = getTextFromTable(element, 2);
        this.startPrice = getTextFromTable(element, 3);
        this.assetPublicPassport = getTextFromTable(element, 4);
    }

    private String getTextFromTable(Element element, int index){
        try{
            return element.children().get(index).text();
        } catch (IndexOutOfBoundsException e){
            System.out.println("Something wrong on page");
        }
        return "No data found";
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getAssetPublicPassport() {
        return assetPublicPassport;
    }

    public void setAssetPublicPassport(String assetPublicPassport) {
        this.assetPublicPassport = assetPublicPassport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LotForSale)) return false;

        LotForSale that = (LotForSale) o;

        if (assetPublicPassport != null ? !assetPublicPassport.equals(that.assetPublicPassport) : that.assetPublicPassport != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (lotId != null ? !lotId.equals(that.lotId) : that.lotId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (startPrice != null ? !startPrice.equals(that.startPrice) : that.startPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lotId != null ? lotId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (startPrice != null ? startPrice.hashCode() : 0);
        result = 31 * result + (assetPublicPassport != null ? assetPublicPassport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LotForSale{" +  "\n" +
                "   lotId='" + lotId + ",\n" +
                "   name='" + name + ",\n" +
                "   description='" + description + ",\n" +
                "   startPrice='" + startPrice + ",\n" +
                "   assetPublicPassport='" + assetPublicPassport + "\n" +
                '}' + "\n";
    }
}
