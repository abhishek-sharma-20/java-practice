package com.lld.splitwise;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    class User {

        private final long id;
        private String name;

        private float balance;

        User(long id, String name){
            this.id = id;
            this.name = name;
            this.balance = 0;
        }

        void updateBalance(int amount) {
            this.balance += amount;
        }

        public float getBalance() {
            return balance;
        }

        public String getName() {
            return name;
        }

        public long getId() {
            return id;
        }
    }


    class Activity{

        private final long id;
        private final long userId1;
        private final long userId2;
        private final float amount;

        Activity(long id, long userId1, long userId2, float amount){
            this.id = id;
            this.userId1 = userId1;
            this.userId2 = userId2;
            this.amount = amount;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Activity))
                return false;
            Activity activity = (Activity) o;
            return id == activity.id && userId1 == activity.userId1 && userId2 == activity.userId2 && Float.compare(activity.amount, amount) == 0;
        }

        @Override public int hashCode() {
            return Objects.hash(id, userId1, userId2, amount);
        }

    }

    class ActivityRegistry{
        HashSet<Activity> activityHashSet = new HashSet<>();

        public boolean addExpense(float amount, long useerWhoPaid, SplitStrateogy splitStrateogy , List<Long> userList , String[] splitValues){
//            Activity user1 = new Activity(useerWhoPaid,userList.get(0),)

           return true;
        }

        public List<Activity> showAllBalances(){
            return new ArrayList<>(activityHashSet);
        }

        public List<Activity> showBalancesForAUser(long userId){
            if(UserManagementService.getUserForId(userId) == null)
                return new ArrayList<>();
            return activityHashSet.stream().filter( activity -> activity.userId1 == userId || activity.userId2 == userId).collect(Collectors.toList());
        }



    }

    class FormattingService{
        public void formatActivity( List<Activity> activityList){
            for(Activity activity : activityList){
                System.out.println(UserManagementService.getUserForId(activity.userId1).getName() +" owes "+UserManagementService.getUserForId(activity.userId2)+" amount "+ activity.amount);
            }
        }
    }
    public static void main(String[] args) {


    }
}
