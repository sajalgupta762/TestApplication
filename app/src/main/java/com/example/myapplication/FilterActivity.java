package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FilterActivity extends AppCompatActivity {
    public AppDatabase db;
    public EditText searchCustomerName;
    public TextView salaryDetail,loanAmountTv;
    public Button filter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        searchCustomerName = (EditText) findViewById(R.id.searchCustomerName);
        salaryDetail = (TextView) findViewById(R.id.salaryDetail);
        loanAmountTv = (TextView) findViewById(R.id.loanAmountTv);
        filter = (Button) findViewById(R.id.filter);

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromDatabase();
            }
        });
    }

    private void  getDataFromDatabase(){
        db = ((MyApplication) this.getApplication()).getDb();
        Customer customer= db.databseDao().getCustomer(searchCustomerName.getText().toString().trim());
        salaryDetail.setText(customer.getSalary()+"");
        loanAmountTv.setText(customer.getLoan()+"");



    }




}
