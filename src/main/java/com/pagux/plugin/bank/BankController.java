package com.pagux.plugin.bank;

import com.pagux.plugin.ApiInterface;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gauravp on 18/08/15.
 */
public class BankController implements ApiInterface {

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
        if(hm.containsKey("period")){
            String period = (String) hm.get("period");
            String duration = (String) hm.get("intDuration");

            //{montht=august, dayt=26, destCity=delhi, mimetype=im, sourceCity=mumbai, adultst=2}
            String transDesc= "\n"+"Your "+hm.get("accType")+"  account  Statement:  for last "+period+" available as download link (too big to be displayed here)"
                    +"\n\n\n";


            String msg=description +transDesc ;

          msg = msg+  "Click here download your statement  : "+link+buyLink.get(getRandom(buyLink.size()) ) ;

            msg = msg+  "\n\nIf you want to send it registered email address : "+link+buyLink.get(getRandom(buyLink.size()) ) ;

            String linkExpiry="\n\nBased on your spending pattern I found some great deals for you!  You can save up "  + cost.get(getRandom(time.size()))  ;


           msg =msg+linkExpiry;

            msg = msg+  "\n\nClick here to view/avail exclusive deals : "+link+buyLink.get(getRandom(buyLink.size()) ) ;
            return msg;
        }



        //{montht=august, dayt=26, destCity=delhi, mimetype=im, sourceCity=mumbai, adultst=2}
        String transDesc= "\n"+"Your "+hm.get("accType")+"  account  Statement: last 5 transaction , I am also adding some amazing coupons for you "
                +"\n";
                log.info(" Got hashmap ->" + hm);


        String msg=description +transDesc ;


        int max= getRandom(resultsMax)  ;
        String item;

        for (int i=1 ;i<=5;i++)  {



            item= i+".) " + pos.get(getRandom(pos.size())) +
                    itemSep+"Item  "  + time.get(getRandom(time.size()))
                    +itemSep+"Time : "+time.get(getRandom(time.size()))
                    +itemSep+"Amount: "+cost.get(getRandom(time.size()))  ;
            int random =   getRandom(coupons.size());
            log.info(" Value of randon  is : " + random)   ;
                    if(random<=2)   {
                        item=     item+   itemSep+"Deal: "+coupons.get(getRandom(coupons.size())) +" , click here to redeem : "+link+buyLink.get(getRandom(buyLink.size()))  ;
                    }




            ;

            msg= msg +item +"\n";

        }
        log.info(" msg now->" + msg);

        //    String date =hm.get("dayt").toString() +"   " + hm.get("montht");

        int dealNo=2;
        int ran= getRandom(5);
        if(ran <=2) {
            dealNo=ran;
        }
        String linkExpiry="\n\nBased on your spending pattern I found some great deals for you!  You can save up "  + cost.get(getRandom(time.size()))  ;
     //   String upSell="\n\n We have  "+ran+",  great   saving deals for   , click here to know more  ";
        return msg +linkExpiry ;
    }

    int getRandom(int size)  {
       return  ((int )(Math.random() * size)  )  ;
    }
}
