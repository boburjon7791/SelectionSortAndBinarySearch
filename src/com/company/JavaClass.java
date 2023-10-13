package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class JavaClass {
    public static void main(String[] args){
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i+" :");
            nums[i]=new Scanner(System.in).nextInt();
        }
        System.out.println(Arrays.toString(nums));
        int[] desc = selectionSortDesc(nums);
        System.out.println("Desc : "+Arrays.toString(desc));
        System.out.print("Search from descending order :");
        int as = new Scanner(System.in).nextInt();
        System.out.println("binarySearch(desc,"+as+") = " + binarySearch(desc, as));
        int[] asc = selectionSortAsc(nums);
        System.out.println("Asc : "+Arrays.toString(asc));
        System.out.print("Search from ascending order :");
        int des = new Scanner(System.in).nextInt();
        System.out.println("binarySearch(asc,"+des+") = " + binarySearch(asc, des));

    }
    public static int[] selectionSortAsc(int[] arr){
        int[] newArr = new int[arr.length];
        int[] copy = new int[arr.length];

        System.arraycopy(arr, 0, copy, 0, arr.length);

        for (int i = 0; i < copy.length; i++) {
            int max=copy[i];
            int point = i;
            for (int j=0; j<copy.length; j++) {
                if (max > copy[j]) {
                    max = copy[j];
                    point=j;
                }
            }
            newArr[i]=max;
            copy[point]=Integer.MAX_VALUE;
        }
        return newArr;
    }
    public static int[] selectionSortDesc(int[] arr){
        int[] newArr = new int[arr.length];
        int[] copy = new int[arr.length];

        System.arraycopy(arr, 0, copy, 0, arr.length);

        for (int i = 0; i < copy.length; i++) {
            int max=copy[i];
            int point = i;
            for (int j=0; j<copy.length; j++) {
                if (max < copy[j]) {
                    max = copy[j];
                    point=j;
                }
            }
            newArr[i]=max;
            copy[point]=Integer.MIN_VALUE;
        }
        return newArr;
    }
    public static Integer binarySearch(int[] arr, int n){
        Integer res = null;
        int count=1;
        if (arr[0]==n || arr[arr.length-1]==n) {
            res=n;
        }else {
            int start=0;
            int end=arr.length-1;
            while (start <= end) {
                int mid=start+((end-start)/2);
                if(n>arr[mid]) {
                    start=mid+1;
                }else if (n<arr[mid]) {
                    end=mid-1;
                }else {
                    res = n;
                    break;
                }
                count++;
            }
        }
        System.out.println("count = " + count);
        return res;
    }
}

