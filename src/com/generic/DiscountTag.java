package com.generic;

public class DiscountTag {
    public static void main(String[] args) {
        int[] nums = {6,3,4,-1,9,17};

        int max=nums[0],cMax =nums[0],maxEven = 0;
        for(int i =1;i<nums.length;i++){
            if(cMax<0)
                cMax=0;
            cMax+=nums[i];
            max = Math.max(max,cMax);
        }
System.out.println(maxEven);
    }
}
