package quizapp;

import java.util.Calendar;

public class TheTimer {

    Calendar c1, c2;

    public void setTimer1() {
        c1.getInstance();
    }

    public void setTimer2() {
        c2.getInstance();
    }

    /*public long getTime1(){
     return c1.getTimeInMillis();
     }
   
     public long getTime2(){
     return c2.getTimeInMillis();
     }
     */
    public double Time() {
        return (c2.getTimeInMillis() - c1.getTimeInMillis()) / 1000;
    }
}
