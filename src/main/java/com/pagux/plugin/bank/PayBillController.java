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
//com.pagux.plugin.bank.PayBillController
public class PayBillController implements ApiInterface {

    static Logger log = Logger.getLogger("com.pagux.plugin.travel.BankController");

    List<String> cc = new ArrayList<String>();

    List<String> policy = new ArrayList<String>();
    List<String> coupons = new ArrayList<String>();
    List<String>  time = new ArrayList<String>();

    List<Integer>  cost = new ArrayList<Integer>();
    String description=   "Thanks for waiting ..... :\n " ;

    List<String>  buyLink = new ArrayList<String>();
    String link="https://bnkr.io/"  ;

    String gas ="" ;
    String dth ="" ;




    int resultsMax= 7;
    String itemSep=  "\n\t\t" ;



    void populate(){
        cc.add("HSBC Gold XXXXXXXX5976") ;
        cc.add("American Express Black XXXXXXXX296") ;
        ;
         policy.add("ICIC Save N Protect 8976XXXX67") ;
        policy.add("LIC Jeevan 576XXXX67") ;
        policy.add("Max new your 8976XXXX67") ;

        coupons.add("Domino 1 + 1 free") ;

        coupons.add("Big bazzar 20% off") ;
        coupons.add("Amazon fashion sale 15% off ")  ;
        coupons.add("Sanpdeal  season sale 15% off ")  ;

        gas=" Maha nagar gas Nigam"   ;
        dth="  Tata sky ac no XXXXXXXXXX987";



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


    private String getDetails(String type){
       if(type.equalsIgnoreCase("dth")){
           return dth;

       } else if(type.equalsIgnoreCase("policy")) {

           return  policy.get(getRandom(policy.size()))  ;

       } else if(type.equalsIgnoreCase("credit card")) {
           return  cc.get(getRandom(cc.size()))  ;
       }else{
           return  "" ;
       }
    }

    public String getResults(HashMap hm) {
        populate();
        log.info(" Got hashmap ->" + hm);

        return " Paid the bill of    Rs "  +hm.get("amount")   +" for your registered biller  " +getDetails((String)hm.get("serviceName")) + " on :" +new Date() + "  your reference id is : " + buyLink.get(getRandom(buyLink.size()));

    }


    int getRandom(int size)  {
       return  ((int )(Math.random() * size)  )  ;
    }
}
