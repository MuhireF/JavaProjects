package com.hrishigadkari;

public class Main {
    public static String getDurationString(int minutes, int seconds){
        if(minutes >=0 && (seconds >=0 || seconds <=59)){
           int hours = minutes/60 + seconds/3600;
           int remainMin = minutes%60;
           String strHours, strMinutes, strSeconds;
           if (hours >= 0 && hours < 10){
               strHours =  "0"+ hours +"h ";
           }
           else{
               strHours =  hours + "h ";
           }
           if (remainMin >=0 && remainMin < 10){
               strMinutes = "0"+remainMin+"m ";
           }
           else{
               strMinutes = remainMin + "m ";
           }
           if(seconds >=0 && seconds < 10){
               strSeconds = "0"+seconds+"s";
           }
           else{
               strSeconds = seconds+"s";
           }
            return strHours + strMinutes + strSeconds;
        }
        return "Invalid Value";
    }

    public static String getDurationString(int seconds){
        if(seconds >= 0){
            return getDurationString(seconds/60, seconds%60);
        }
        return "Invalid Value";
    }
    public static void main(String[] args) {
        System.out.println(getDurationString(3660));
    }
}
