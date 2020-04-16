package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.MyViewHolder> {
     private List<Customer> customerList;

    public CustomerListAdapter(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.customer_list, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

     holder.CustomerName.setText(customerList.get(position).getCustomerName());
     holder.Salary.setText(customerList.get(position).getSalary()+"");
     holder.loanAmountTv.setText(customerList.get(position).getLoan()+"");

    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView CustomerName, Salary, loanAmountTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.CustomerName = (TextView) itemView.findViewById(R.id.CustomerName);
            this.Salary = (TextView) itemView.findViewById(R.id.Salry);
            this.loanAmountTv = (TextView) itemView.findViewById(R.id.loanAmountTv);
        }
    }
}