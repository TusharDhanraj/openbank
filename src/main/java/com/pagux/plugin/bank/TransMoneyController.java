package com.pagux.plugin.bank;

import com.pagux.plugin.ApiInterface;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gauravp on 18/08/15.
 */
public class TransMoneyController implements ApiInterface {

    static Logger log = Logger.getLogger("com.pagux.plugin.travel.BankController");

    List<String> pos = new ArrayList<String>();
    List<String> coupons = new ArrayList<String>();
    List<String>  time = new ArrayList<String>();

    List<Integer>  cost = new ArrayList<Integer>();
    String description=   "Thanks for waiting ..... :\n " ;

    List<String>  buyLink = new ArrayList<String>();
    String link="https://bnkr.io/"  ;




    int resultsMax= 7;
    String itemSep=  "\n\t\t" ;



    void populate(){
        pos.add("Salary YES BNK") ;
        pos.add("Big Bazr") ;
        pos.add("ATM Mall") ;

        pos.add("Amazon order 187") ;
        pos.add("Cheque clearance") ;
        pos.add("HSBC Credit Card ") ;

        coupons.add("Domino 1 + 1 free") ;
        coupons.add("Big bazzar 20% off") ;
        coupons.add("Amazon fashion sale 15% off ")  ;
        coupons.add("Sanpdeal  season sale 15% off ")  ;



        time.add("9:10 am") ;
        time.add("11:30 am") ;
        time.add("20:00 pm") ;


        time.add("9:10 pm") ;
        time.add("11:30 pm") ;
        time.add("09:00 pm") ;


        buyLink.add("q76d");
        buyLink.add("8ytrG") ;
        buyLink.add("99ytd") ;

        buyLink.add("q7fe");
        buyLink.add("8htd") ;
        buyLink.add("gggt") ;



        cost.add(2000) ;

        cost.add(5400) ;
        cost.add(4800) ;

        cost.add(3200) ;
        cost.add(6252) ;

        cost.add(4320) ;

    }

    public String getResults(HashMap hm) {
        populate();
        log.info(" Got hashmap ->" + hm);

        return " Transferred   Rs "  +hm.get("amount")   +" to " +hm.get("friendName") + " on :" +new Date() + "  your reference id is : " + buyLink.get(getRandom(buyLink.size()));

    }

    int getRandom(int size)  {
       return  ((int )(Math.random() * size)  )  ;
    }
}
