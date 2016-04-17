package com.pagux.plugin.travel;

import com.pagux.plugin.ApiInterface;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gauravp on 18/08/15.
 */
public class TravelController implements ApiInterface {

    static Logger log = Logger.getLogger("com.pagux.plugin.travel.TravelController");

    List<String>  airlines = new ArrayList<String>();
    List<String>  time = new ArrayList<String>();
    List<String>  buyLink = new ArrayList<String>();
    List<Integer>  cost = new ArrayList<Integer>();
    String description=   "We found some best deals for you , Simply click on link to buy :\n " ;


    String link="https://buy.oxigenwallet.com/"  ;



    String linkExpiry="\n\nPl note above link are valid for 15 minutes only , so hurry "   ;

    int resultsMax= 7;
    String itemSep=  "\n\t\t" ;



    void populate(){
        airlines.add("Air Asia 33D") ;
        airlines.add("Jet Airways 441") ;
        airlines.add("Indigo 186A") ;

        airlines.add("GoAir GA27A") ;
        airlines.add("Air India AAI2") ;
        airlines.add("SpiceJet SJ102") ;


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
        //{montht=august, dayt=26, destCity=delhi, mimetype=im, sourceCity=mumbai, adultst=2}
        String transDesc= "\n"+"From: "+hm.get("sourceCity") + "  to :" +hm.get("destCity")   +" on "
                +hm.get("dayt") +" " + hm.get("montht")+ " for "   +hm.get("adultst") + " persons"
                +"\n";
                log.info(" Got hashmap ->" + hm);
        populate();

        String msg=description +transDesc ;


        int max= getRandom(resultsMax)  ;
        String item;

        for (int i=1 ;i<=5;i++)  {

            item= i+".) " + airlines.get(getRandom(airlines.size())) +
                    itemSep+"Departure at "  + time.get(getRandom(time.size()))
                    +itemSep+"Arrival at: "+time.get(getRandom(time.size()))
                    +itemSep+"Total Cost: "+cost.get(getRandom(time.size()))
                    +itemSep+"Pay via wallet: " +link+buyLink.get(getRandom(buyLink.size())) +"\n"
            ;

            msg= msg +item;
            log.info(" msg now->" + msg);

        }
        String date =hm.get("dayt").toString() +"   " + hm.get("montht");

        int dealNo=2;
        int ran= getRandom(5);
        if(ran <=2) {
            dealNo=ran;
        }

        String upSell="\n\n We have  "+ran+",  great  hotel mega saving deals for  "+date+ " @" +hm.get("destCity") +" , click here to know more  " +link+buyLink.get(getRandom(buyLink.size()))  ;
        return msg +linkExpiry +upSell;
    }

    int getRandom(int size)  {
       return  ((int )(Math.random() * size)  )  ;
    }
}
