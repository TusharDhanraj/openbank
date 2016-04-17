package com.pagux.plugin.recharge;

import com.pagux.plugin.ApiInterface;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gauravp on 18/08/15.
 */
public class RechargeController implements ApiInterface {

    static Logger log = Logger.getLogger("com.pagux.plugin.travel.RechargeController");

    List<String> threeG = new ArrayList<String>();
    List<String> twoG = new ArrayList<String>();
    List<String> talk = new ArrayList<String>();

    List<String> telco = new ArrayList<String>();

    List<String> coupons = new ArrayList<String>();
    List<String>  time = new ArrayList<String>();

    List<Integer>  cost = new ArrayList<Integer>();
    String description=   "Thanks for waiting ..... :\n " ;

    List<String>  buyLink = new ArrayList<String>();
    String link="https://bnkr.io/"  ;




    int resultsMax= 7;
    String itemSep=  "\n\t\t" ;



    void populate(){



        threeG.add("Recharge amount : 17 \nBenefit : 50 MB 3G/4G data \n Validity : 28 Days  ");


        threeG.add("Recharge amount : 49  \nBenefit : 150 MB 3G/4G \nValidity : 21 Days  " );


        threeG.add("Recharge amount : 149 \nBenefit :  149 MB 3G/4G	\nValidity : 21 Days  " );




        threeG.add("Recharge amount : 200 \n Benefit : 1.25 GB 3G/4G data \n Validity : 28 Days  ");


        threeG.add("Recharge amount : 309  \nBenefit : 1.3GB 3G/4G	\nValidity : 21 days " );


        threeG.add("Recharge amount : 329	\nBenefit : 1.4GB 3G/4G	\nValidity : 21 Days  " );


        threeG.add("Recharge amount : 349	\nBenefit : 1.4GB  \nValidity : 28 Days   " );


        threeG.add("Recharge amount : 355 \nBenefit : 1.5GB 3G/4G \nValidity : 21 Days ");




        /***********/

        talk.add("Recharge amount : 150  \nTalk time : 150  \nValidity : 28 Days days ");
        talk.add("Recharge amount : 250  \nTalk time : 250  \nValidity : 28 Days days ");
        talk.add("Recharge amount : 350  \nTalk time : 350  \nValidity : 28 Days days ");


        talk.add("Recharge amount : 550  \nTalk time :550  \nValidity : 30 Days days ");
        talk.add("Recharge amount : 650  \nTalk time : 650  \nValidity : 30 Days days ");


         telco.add("airtel");
        telco.add("vodaphone");
        telco.add("idea");
        telco.add("bsnl");
        telco.add("mts");



        coupons.add("Free 120  4G") ;
        coupons.add("Free 4g Sim") ;
        coupons.add("Ulimited national calling Rs  999 ")  ;




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
        //{mobRchrgType=3g, mimetype=im, phoneNo=9717200735}
        populate();
        log.info(" Got hashmap ->" + hm);
        //mobRchrgType
        String rechargeType = (String) hm.get("mobRchrgType");

        log.info(" Got rechargeType ->" + rechargeType);
        if(!hm.containsKey("mobRchrgType")) {
            return "No matching plans found ";

        }
        if(rechargeType.equalsIgnoreCase("3g")||rechargeType.equalsIgnoreCase("2g")){



            String transDesc= "\n"+"Please select from following data plans for:  "+hm.get("phoneNo")+"  ("  +telco.get(getRandom(telco.size()))  +")"
                    +"\n\n\n";
            String item    ;
            String msg=description +transDesc ;
            for (int i=1 ;i<=5;i++)  {



                item= i+".) " + threeG.get(getRandom(threeG.size()))   + " click here to buy ->"  +
                link+buyLink.get(getRandom(buyLink.size()))
                       ;
                int random =   getRandom(coupons.size());
                log.info(" Value of randon  is : " + random)   ;
                if(random<=2)   {
                    item=     item+   itemSep+"\nDeal: "+coupons.get(getRandom(coupons.size())) +" , click here to redeem : "+link+buyLink.get(getRandom(buyLink.size())) +"\n" ;
                }






                msg= msg +item +"\n";

            }

            return msg;
        }
        if(rechargeType.equalsIgnoreCase(("talktime"))){
            String period = (String) hm.get("period");
            String duration = (String) hm.get("intDuration");

            //{montht=august, dayt=26, destCity=delhi, mimetype=im, sourceCity=mumbai, adultst=2}
            String transDesc= "\n"+"Please select from following  voice/talktime plans , will add it to :  "+hm.get("phoneNo")+"  ("  +telco.get(getRandom(telco.size()))  +")"
                    +"\n\n\n";
            String item    ;
            String msg=description +transDesc ;
            for (int i=1 ;i<=5;i++)  {



                item= i+".) " + talk.get(getRandom(talk.size()))   + " click here to buy ->"  +
                        link+buyLink.get(getRandom(buyLink.size()))
                ;
                int random =   getRandom(coupons.size());
                log.info(" Value of randon  is : " + random)   ;
                if(random<=2)   {
                    item=     item+   itemSep+"\nDeal: "+coupons.get(getRandom(coupons.size())) +" , click here to redeem : "+link+buyLink.get(getRandom(buyLink.size()))  ;
                }

                msg= msg +item +"\n";

            }

            return msg;
        }

        if(rechargeType.equalsIgnoreCase(("roaming"))){
            String period = (String) hm.get("period");
            String duration = (String) hm.get("intDuration");

            //{montht=august, dayt=26, destCity=delhi, mimetype=im, sourceCity=mumbai, adultst=2}
            String transDesc= "\n"+"Please select from following  roaming plans for  "+hm.get("phoneNo")  +"  ("  +telco.get(getRandom(telco.size()))  +")"
                    +"\n\n\n";
            String item    ;
            String msg=description +transDesc ;
            for (int i=1 ;i<=5;i++)  {



                item= i+".) " + talk.get(getRandom(talk.size()))   + " click here to buy ->"  +
                        link+buyLink.get(getRandom(buyLink.size()))
                ;
                int random =   getRandom(coupons.size());
                log.info(" Value of randon  is : " + random)   ;
                if(random<=2)   {
                    item=     item+   itemSep+"\nDeal: "+coupons.get(getRandom(coupons.size())) +" , click here to redeem : "+link+buyLink.get(getRandom(buyLink.size()))  ;
                }

                msg= msg +item +"\n";

            }

            return msg;
        }


        return "No matching plans found ";



    }

    int getRandom(int size)  {
       return  ((int )(Math.random() * size)  )  ;
    }
}
