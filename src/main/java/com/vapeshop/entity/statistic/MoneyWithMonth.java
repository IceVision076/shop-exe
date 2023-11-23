package com.vapeshop.entity.statistic;

import java.util.ArrayList;

public class MoneyWithMonth {
    private  ArrayList<EachMonth>  eachMonths=new ArrayList<>();


    public MoneyWithMonth() {

        for (int i = 1; i <13 ; i++) {
         EachMonth eachMonth=new EachMonth("MONTH_"+i,0);
         eachMonths.add(eachMonth);
        }
    }

    public class EachMonth{
       private String month;
       private double totalMoney;

        public EachMonth(String month, double totalMoney) {
            this.month = month;
            this.totalMoney = totalMoney;
        }

        public String getMonth() {
           return month;
       }

       public void setMonth(String month) {
           this.month = month;
       }

       public double getTotalMoney() {
           return totalMoney;
       }

       public void setTotalMoney(double totalMoney) {
           this.totalMoney = totalMoney;
       }

        @Override
        public String toString() {
            return "EachMonth{" +
                    "month='" + month + '\'' +
                    ", totalMoney=" + totalMoney +
                    '}';
        }
    }

    public ArrayList<EachMonth> getEachMonths() {
        return eachMonths;
    }

    public void setEachMonths(ArrayList<EachMonth> eachMonths) {
        this.eachMonths = eachMonths;
    }

    @Override
    public String toString() {
        return "MoneyWithMonth{" +
                "eachMonths=" + eachMonths +
                '}';
    }
}
