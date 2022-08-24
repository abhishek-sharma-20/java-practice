package com.generic;
/* Throttling Gateway
Non-Critical requests for a transaction system are routed through a throttling
gateway to ensure that the network is not choked by non-essential requests.
The gateway has limits as follows:
1. The number of transactions in any given second cannot exceed 3.
2. The number of transactions in any given 10 second period cannot exceed 20. A
   10 seconds period would count all transactions arriving from any time T to
   T + 9 (inclusive of both) for any valid time T.
3. The number of transaction in any given minute cannot exceed 60 (similar to
   above, 1 minutes is from T to T + 59)
Any request that exceeds any of the above limits will be dropped by the gateway
Given the times at which different requests arrive (sorted in ascending order of
arrivals), find how many of them will be dropped.
Note: Even if a request is dropped it is till considered for future calculations.
Author: Weikun Han <weikunhan@g.ucla.edu>
Reference: https://www.1point3acres.com/bbs/thread-610975-1-1.html
Time complexity: O(n^2)
Space complexity: O(n)
Input:
n = 22
requestTime = [1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 11, 11, 11]
Output:
1
Explanation:
There are total 22 requset. 19 requset within 10 sec which no need to drop.
There are four requests in the first secound. One of them will be dropped as 4 > 3
*/
import java.util.Arrays;
import java.util.List;
public class ThrottlingGateway {
    public static void main(String[] args) {
        System.out.println(getDroppedRequests(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 11, 11, 11, 11)));
        System.out.println(getDroppedRequestsUsingPrefixSum(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 11, 11, 11, 11)));
    }
    static int getDroppedRequests(List<Integer> requests){
        int[] numbers = new int[requests.get(requests.size()-1)];
        int dropped =0;
        for(int i =0;i<requests.size();i++){
            numbers[requests.get(i)-1]+=1;
        }
        for(int i =0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
        System.out.println("----------------------------------");

        for(int i =0;i<numbers.length;i++){
            dropped+=ruleFor1(numbers,i)+ruleFor10(numbers,i);
        }
        return dropped;
    }
    static int ruleFor1(int[] array, int i){
        return array[i] > 3 ? array[i]-3 : 0;
    }
    static int ruleFor10(int[] array, int i){
        if(i < 10)
            return 0;
        int sum =0;
        for(int j=i-9;j<=i;j++){
            sum+=array[j];
        }
        return sum > 20 ? sum-20 : 0;
    }
    static int ruleFor60(int[] array, int i){
        if(i < 60)
            return 0;
        int sum =0;
        for(int j=i-59;j<=i;j++){
            sum+=array[j];
        }
        return sum > 60 ? sum-60 : 0;
    }
    static int getDroppedRequestsUsingPrefixSum(List<Integer> requests){
        int[] numbers = new int[requests.get(requests.size()-1)+1];
        int dropped =0;
        numbers[0]=1;
        for(int i =0;i<requests.size()-1;i++){
            numbers[requests.get(i)]= numbers[requests.get(i)-1]+1;

        }
        for(int i =0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
        System.out.println("----------------------------------");
        return dropped;
    }
}
