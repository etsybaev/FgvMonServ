package com.fgvmonserv.controller;


import com.fgvmonserv.model.Calc;
import org.springframework.web.bind.annotation.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@RestController
@RequestMapping("/basetableconroller")
public class CalcController {

    private static DecimalFormat df2 = new DecimalFormat(".##");

    @RequestMapping(value = "/calc", method = RequestMethod.POST, produces = "application/json")
    public Calc greeting(@RequestBody Calc calc) {
        df2.setRoundingMode(RoundingMode.CEILING);

        double auctionStep = calc.getStartPrice() * ((double)calc.getAuctionStep() /100);
        auctionStep = Double.parseDouble(df2.format(auctionStep));

        double stockExchangeCommission = (calc.getStartPrice() + auctionStep) * ((double)calc.getStockExchangeCommission()/100);
        stockExchangeCommission = Double.parseDouble(df2.format(stockExchangeCommission));

        double finalPrice = Math.ceil(calc.getStartPrice() + auctionStep + stockExchangeCommission +
                calc.getNotaryCommission() + calc.getOurCommission());

        calc.setAuctionStepUAH(auctionStep)
            .setStockExchangeCommissionUAH(stockExchangeCommission)
            .setFinalPrice(finalPrice);
        return calc;
    }
}
