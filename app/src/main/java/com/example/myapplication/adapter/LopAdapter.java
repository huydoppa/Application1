package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Lop;

import java.util.ArrayList;
import java.util.List;

public class LopAdapter extends RecyclerView.Adapter<LopAdapter.LopViewHolder> {
    private List<Lop> LopList = new ArrayList<>();

    @NonNull
    @Override
    public LopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lop,parent,false);
        return new LopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LopViewHolder holder, int position) {
            Lop item = LopList.get(position);
            holder.textmalop.setText(String.valueOf(item.getId()));
            holder.texttenlop.setText(item.getTenlop());
            holder.textmota.setText(item.getMota());
    }

    @Override
    public int getItemCount() {
        return LopList.size();
    }
    public void setData(List<Lop> list){
        this.LopList = list;
        notifyDataSetChanged();
    }
    class LopViewHolder extends RecyclerView.ViewHolder{
            TextView textmalop,texttenlop , textmota ;
            public LopViewHolder(@NonNull View itemview){
                 super(itemview);
                textmalop = itemview.findViewById(R.id.malop);
                texttenlop = itemview.findViewById(R.id.tenlop);
                textmota = itemview.findViewById(R.id.mota);

            }
    }
}
