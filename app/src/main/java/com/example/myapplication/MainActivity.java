package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Customer>  customerList = new ArrayList<>();
    RecyclerView recyclerView;
    Button searchActivityBtn;
     public  AppDatabase db;

    MyWebService mWebService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.customerlist);
        searchActivityBtn = (Button) findViewById(R.id.search_activity_btn);
        //This is how we can data from server *just prototype
       // getDataFromServer()
        doListSorting(getCustomerData());
        setrecyclerData();
        submitDatatoDatabase();
        searchActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, FilterActivity.class);
                startActivity(intent);
            }
        });


    }

    private void  submitDatatoDatabase(){


        db = ((MyApplication) this.getApplication()).getDb();

        db.databseDao().insertAllOrders(customerList);

    }
    private void setrecyclerData(){
        CustomerListAdapter adapter = new CustomerListAdapter(customerList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }


    public void doListSorting(List<Customer> unsortedCustomerList) {

        Collections.sort(customerList, new Comparator<Customer>() {
            public int compare(Customer c1, Customer c2) {
                if (c1.getSalary() > c2.getSalary()) {
                    return 1;
                } else if (c2.getSalary() > c1.getSalary()) {
                    return -1;
                } else {
                    return 0;
                }

            }
        });


    }

    private List<Customer> getCustomerData(){



        Customer customer1 = new Customer("Aman",15000);
        customer1.setLoan(customer1.getSalary());
        Customer customer2 = new Customer("Varu",2000);
        customer1.setLoan(customer1.getSalary());
        Customer customer3 = new Customer("Suman",25000);
        customer1.setLoan(customer1.getSalary());
        Customer customer4 = new Customer("yash",14000);
        customer1.setLoan(customer1.getSalary());
        Customer customer5 = new Customer("vijay",50000);
        customer1.setLoan(customer1.getSalary());
        Customer customer6 = new Customer("suresh",1000);
        customer1.setLoan(customer1.getSalary());


        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);
        customerList.add(customer6);
        return customerList;
    }

  private void   getDataFromServer(){

//This is how we can data From Server


      Call<List<Customer>> postCall = mWebService.getCustomer();

          postCall.enqueue(new Callback<List<Customer>>() {
              @Override
              public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                  if (response.isSuccessful()) {
                     // mLog.setText(String.valueOf(response.code()));
                      //showPost(response.body());
                  }
              }

              @Override
              public void onFailure(Call<List<Customer>> call, Throwable throwable) {

              }
          });

      }


}
