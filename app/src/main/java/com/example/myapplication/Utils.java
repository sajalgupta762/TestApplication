package com.example.myapplication;

import java.util.Comparator;

public class Utils {

    public class CustomComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            if(c1.getSalary()>c2.getSalary()){
                return 1;
            }else if(c2.getSalary()>c1.getSalary()){
                return -1;
            }else{
               return 0;
            }

        }
    }
}
