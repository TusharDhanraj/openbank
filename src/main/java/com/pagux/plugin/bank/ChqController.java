package com.pagux.plugin.bank;

import com.pagux.plugin.ApiInterface;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gauravp on 18/08/15.
 */
public class ChqController implements ApiInterface {

    static Logger log = Logger.getLogger("com.pagux.plugin.travel.BankController");

    List<String> pos = new ArrayList<String>();
    List<String> coupons = new ArrayList<String>();

    List<String> chkStatus = new ArrayList<String>();

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


        chkStatus.add("Cleared and credited to your account ") ;
        chkStatus.add("Is under processing , is expected to clear ") ;
        chkStatus.add("Its has been cancelled  ") ;

        coupons.add("Add aditional cover to high value transaction , try our comprehensive fraud and risk insurance   ") ;
        coupons.add("Try our escrow service for peaceful transaction") ;




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
        //{chqOpName=stop, chqNo=201301, mimetype=im}
        String operations   = (String) hm.get("chqOpName");
        String chqNo   = (String) hm.get("chqNo");

        log.info(" Got hashmap ->" + hm);
        String msg="";

       if(operations.equalsIgnoreCase("stop")||operations.equalsIgnoreCase("cancel")||operations.equalsIgnoreCase("block")) {

           msg= "\n"+"Your  Request for blocking cheque no "+chqNo+"  has been accepted reference no "+buyLink.get(getRandom(buyLink.size()))+
                   " and was blocked successfully )" +"\n\n\n";



       }

        if(operations.equalsIgnoreCase("status")) {


            String transDesc= "\n"+"Status for "+chqNo+
                    " is following)" +"\n\n\n";

            msg = msg+  chkStatus.get(getRandom(chkStatus.size()) ) +" on " +time.get(getRandom(time.size()) );

        }

        msg=    msg   +"Exclusive offer: "+coupons.get(getRandom(coupons.size())) +" , click here to redeem : "+link+buyLink.get(getRandom(buyLink.size()))  ;



        return msg ;
    }

    int getRandom(int size)  {
       return  ((int )(Math.random() * size)  )  ;
    }
}
