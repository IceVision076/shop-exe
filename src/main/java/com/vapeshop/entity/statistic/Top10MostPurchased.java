package com.vapeshop.entity.statistic;

import com.vapeshop.entity.User;

import java.util.ArrayList;

public class Top10MostPurchased {
    private ArrayList<UserPurchased> userPurchaseds = new ArrayList<>();

     public class UserPurchased {
        public UserPurchased(User user, double total) {
            this.user = user;
            this.total = total;
        }

        private User user;
        private double total;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

         @Override
         public String toString() {
             return "UserPurchased{" +
                     "user=" + user +
                     ", total=" + total +
                     '}';
         }
     }
    public void addUserPurchased(User user, double total) {
        userPurchaseds.add(new UserPurchased(user, total));
    }

    public ArrayList<UserPurchased> getUserPurchaseds() {
        return userPurchaseds;
    }

    public void setUserPurchaseds(ArrayList<UserPurchased> userPurchaseds) {
        this.userPurchaseds = userPurchaseds;
    }

    @Override
    public String toString() {
        return "Top10MostPurchased{" +
                "userPurchaseds=" + userPurchaseds +
                '}';
    }
}
