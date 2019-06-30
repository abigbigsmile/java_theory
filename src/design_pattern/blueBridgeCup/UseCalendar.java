package design_pattern.blueBridgeCup;

import java.util.Calendar;
import java.util.Date;

public class UseCalendar {

    public static void main(String[] args) {

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.set(2000,1,1);
        c2.set(2000,5,4);
        Date d1 = c1.getTime();
        Date d2 = c2.getTime();
        long l = d2.getTime()-d1.getTime();
        long diff = l/(24*60*60*1000);
        System.out.println(diff+1);



    }
}
