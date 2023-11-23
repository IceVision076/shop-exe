package com.vapeshop.entity.statistic;

import java.util.ArrayList;

public class MoneyWithWeek {
    private ArrayList<EachDay> eachDays=new ArrayList<>();


    public MoneyWithWeek() {
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (int i = 0; i <7 ; i++) {
            EachDay eachDay=new EachDay(daysOfWeek[i],0);
            eachDays.add(eachDay);
        }
    }

    public class EachDay{
        private String day;
        private double totalMoney;

        public EachDay(String day, double totalMoney) {
            this.day = day;
            this.totalMoney = totalMoney;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public double getTotalMoney() {
            return totalMoney;
        }

        public void setTotalMoney(double totalMoney) {
            this.totalMoney = totalMoney;
        }

        @Override
        public String toString() {
            return "EachDay{" +
                    "day='" + day + '\'' +
                    ", totalMoney=" + totalMoney +
                    '}';
        }
    }

    public ArrayList<EachDay> getEachDays() {
        return eachDays;
    }

    public void setEachDays(ArrayList<EachDay> eachDays) {
        this.eachDays = eachDays;
    }

    @Override
    public String toString() {
        return "MoneyWithWeek{" +
                "eachDays=" + eachDays +
                '}';
    }
}
