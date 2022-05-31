package com.example.clinic_kursach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyPolyclinicAdapter extends RecyclerView.Adapter<MyPolyclinicAdapter.MyViewHolder> {

    Context context;
    List<Polyclinic> polyclinicList;

    public MyPolyclinicAdapter (Context context, List<Polyclinic> polyclinicList) {
        this.context = context;
        this.polyclinicList = polyclinicList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_polyclinic, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt_poly_name.setText(polyclinicList.get(position).getName());
        holder.txt_poly_address.setText(polyclinicList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return polyclinicList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_poly_name, txt_poly_address;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_poly_name = (TextView) itemView.findViewById(R.id.txt_poly_name);
            txt_poly_address = (TextView) itemView.findViewById(R.id.txt_poly_address);
        }
    }
}
