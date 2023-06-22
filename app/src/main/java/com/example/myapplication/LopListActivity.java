package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.LopAdapter;
import com.example.myapplication.adapter.LopAdapter;
import com.example.myapplication.model.Lop;
import com.example.myapplication.sqlhelper.SQLHelper;

import java.util.ArrayList;
import java.util.List;

public class LopListActivity extends AppCompatActivity {
    private LopAdapter adapter = new LopAdapter();
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop_list);
        recyclerView = findViewById(R.id.recycle_view_lop);
        recyclerView.setAdapter(adapter);
        SQLHelper sqlHelper = new SQLHelper(LopListActivity.this);
        for(Lop Lop: getData()){
            sqlHelper.addLop(Lop);
        }
        adapter.setData(sqlHelper.getLop());
    }

    private List<Lop> getData() {
        List<Lop> list = new ArrayList<>();
        list.add(new Lop(123,"toan","khong hay"));
        list.add(new Lop(123,"toan","khong hay"));
        list.add(new Lop(123,"toan","khong hay"));
        list.add(new Lop(123,"toan","khong hay"));
        return list;
    }
}