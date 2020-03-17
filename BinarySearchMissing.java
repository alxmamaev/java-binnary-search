package search;

import java.util.*;
import java.lang.*;
import java.io.*;


public class BinarySearchMissing{
    
    // Pre: a.size == r - l; 0 < l <= r
    // Post: a[R] <= x
    private static int recursiveSearch(ArrayList<Integer> a, Integer x, Integer l, Integer r){
        // 0 <= l <= r <= a.size
        if(r == l)
            return -1;

        // 0 <= l < r <= a.size
        Integer m = (l + r) / 2;
        // 0 <= l <= m < r <= a.size; m = (l + r) / 2;

        
        if(r - l <= 2){
            // r - l <= 2

            if(a.get(l).equals(x))
                // a[l] == x; l <= m < r;
                return l;
            
            if(a.get(m).equals(x))
                // a[m] == x; l < m < r;
                return m;

            if(a.get(l) < x)
                // x > a[l] > a[m]; r=m+1
                return l * (-1) - 1;
            else if(a.get(m) < x) 
                // a[l] > x > a[m]; r=m+1
                return m * (-1) - 1;
            else
                // a[l] > a[m]  > x; r=m+1
                return r * (-1) - 1;
        }


        if(a.get(m) > x){
            // l = m; m - middle of r-l range
            return recursiveSearch(a, x, m, r);
        }
        else{
            // r = m+1; m - middle of r-l range
            return recursiveSearch(a, x, l, m + 1);
        }
    }

    // Pre: a.size == r - l; 0 < l <= r
    // Post: a[R] <= x
    private static int itterativeSearch(ArrayList<Integer> a, Integer x, Integer l, Integer r){
        // 0 <= l <= r <= a.size
        if(r == l)
            return -1;
        //  0 <= l < r <= a.size
        
        // r-l > 2
        while(r - l > 2){
            Integer m = (l + r) / 2;
            // 0 <= l <= m < r <= a.size; m = (l + r) / 2;

            if(a.get(m) > x){
                // a[m] > x;
                // l = m;  l < r
                l = m;
            }
            else{
                // a[m] <= x;
                // r = m+1;  l < r
                r = m + 1;
            }
        }
        // r-l <= 2;

        Integer m = (l + r) / 2;
        // l <= m < r

        if(a.get(l).equals(x))
            // a[l] == x; l <= m < r;
            return l;
            
        if(a.get(m).equals(x))
            // a[m] == x; l < m < r;
            return m;

        if(a.get(l) < x)
            // x > a[l] > a[m]; r=m+1
            return l * (-1) - 1;
        else if(a.get(m) < x) 
            // a[l] > x > a[m]; r=m+1
            return m * (-1) - 1;
        else
            // r = m+1; m - middle of r-l range
            return r * (-1) - 1;
            
    }

    public static void main(String[] args) throws java.lang.Exception{
        Integer x = Integer.parseInt(args[0]);
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=1; i<args.length; i++)
            a.add(Integer.parseInt(args[i]));

        System.out.println(itterativeSearch(a, x, 0, a.size()));
    }
}