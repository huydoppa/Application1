package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.SinhVienViewHolder> {
    private List<SinhVien> sinhvienList = new ArrayList<>();

    @NonNull
    @Override
    public SinhVienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sinhvien,parent,false);
        return new SinhVienViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienViewHolder holder, int position) {
            SinhVien item = sinhvienList.get(position);
            holder.textName.setText(item.getName());
            holder.textMSV.setText(item.getMsv());
            holder.textQueQuan.setText(item.getQue());
            holder.textNamsinh.setText(item.getNamsinh());
            holder.textNamhoc.setText(item.getNamhoc());


    }

    @Override
    public int getItemCount() {
        return sinhvienList.size();
    }
    public void setData(List<SinhVien> list){
        this.sinhvienList = list;
        notifyDataSetChanged();
    }
    class SinhVienViewHolder extends RecyclerView.ViewHolder{
            TextView textName,textMSV , textQueQuan , textNamsinh, textNamhoc;
            public SinhVienViewHolder(@NonNull View itemview){
                 super(itemview);
                 textName = itemview.findViewById(R.id.tensv);
                 textMSV = itemview.findViewById(R.id.masv);
                 textQueQuan = itemview.findViewById(R.id.quequan);
                 textNamsinh = itemview.findViewById(R.id.namsinh);
                 textNamhoc = itemview.findViewById(R.id.namhoc);
            }
    }
}
