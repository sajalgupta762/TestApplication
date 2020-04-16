package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "customers")
public class Customer {
    @PrimaryKey
    private String customerName;
    @ColumnInfo(name = "salary")
    private int salary;
    @ColumnInfo(name = "Loan")
    private int Loan;
    private static final  int  LoanfactoronSalary= 100;

    public Customer(String customerName, int salary) {
        this.customerName = customerName;
        this.salary = salary;

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getSalary() {
        return (salary*LoanfactoronSalary);
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getLoan() {

        return Loan;
    }

    public void setLoan(int loan) {
        Loan = loan;
    }


}
