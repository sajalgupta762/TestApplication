package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface DatabaseDao {

    @Query("SELECT * FROM customers")
    List<Customer> getAll();

    @Query("SELECT * FROM customers WHERE customerName LIKE :customerName")
    Customer getCustomer(String customerName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllOrders(List<Customer> customerList);

    @Insert
    void insert(Customer task);

    @Delete
    void delete(Customer task);

    @Update
    void update(Customer task);

}
