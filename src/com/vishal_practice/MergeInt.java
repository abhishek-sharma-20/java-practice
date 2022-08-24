package com.vishal_practice;

import java.util.ArrayList;
import java.util.List;

/*
Problem : Merge Overlapping Intervals
Input: [[1,4], [2,5], [7,9]] not sorted
Output: [[1,5], [7,9]]
 */
public class MergeInt {
    public static void main(String[] args) {
        List<Interval> input = getIntervals();
        for(Interval interval : input){
            System.out.println(interval.getStartTime()+" "+ interval.getEndTime());
        }
        System.out.println("------------------------------------");
        input.sort((interval1, interval2) -> {
            return interval1.getStartTime() - interval2.getStartTime();
        });

        for(int i =0;i<input.size()-1;){
            Interval temp = input.get(i);
            if(temp.getEndTime() > input.get(i+1).getStartTime()){
                temp.setStartTime( Math.min(temp.startTime,input.get(i+1).getStartTime()));
                temp.setEndTime( Math.max(temp.endTime,input.get(i+1).getEndTime()));
                input.remove(i+1);
            }
            else
                i++;
        }

        for(Interval interval : input){
            System.out.println(interval.getStartTime()+" "+ interval.getEndTime());
        }

    }
    public static List<Interval> getIntervals(){
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 2));
        input.add(new Interval(3, 4));
        input.add(new Interval(4, 6));
        input.add(new Interval(7, 9));
        return input;
    }

    static class Interval {
        private int startTime ;
        private int endTime;
        Interval(int startTime,int endTime){
            this.startTime= startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }
}

/*
 BookMyShow =>
 usecase => book a ticket for a movie in a city
 select a movie and book a ticket;



 select a theater or select a city to get all movies running


 Tables : City
          Theaters => Movies , Seats , Prices , Seat Types

          Movies => title , cast , time etc
          Schedular => movie , timeslots , scren
          TimeSlots => id , time
          Screens => id , seats , seattypes , price , status

          Ticket => id , seatnumber[], screenid , amount => price * number of tickets , movieId , timeslots .


data models

          City 1.. n => Theaters
          Theaters 1..n => Movies
          Theaters 1..n => Schedular
          Theaters 1..n => TimeSlots
          Theaters 1..n => Screens














 */









/*

Node node1 = new Node();
----
NOde node2 = node1;

------


node2

while(true){
Node node1 = new Node();
}


 */


































