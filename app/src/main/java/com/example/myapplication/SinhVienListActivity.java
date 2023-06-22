package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.adapter.SinhVienAdapter;
import com.example.myapplication.model.SinhVien;
import com.example.myapplication.sqlhelper.SQLHelper;

import java.util.ArrayList;
import java.util.List;

public class SinhVienListActivity extends AppCompatActivity {
    private SinhVienAdapter adapter = new SinhVienAdapter();
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien_list);
        recyclerView = findViewById(R.id.recycle_view_sinhvien);
        recyclerView.setAdapter(adapter);
        SQLHelper sqlHelper = new SQLHelper(SinhVienListActivity.this);
        for(SinhVien sinhvien: getData()){
            sqlHelper.addSinhVien(sinhvien);
        }
        adapter.setData(sqlHelper.getSinhVien());
    }

    private List<SinhVien> getData() {
        List<SinhVien> list = new ArrayList<>();
        list.add(new SinhVien("huy khac","b19dcat088","2022","2001","vinh phuc"));
        list.add(new SinhVien("huy khac","b19dcat088","2022","2001","vinh phuc"));
        list.add(new SinhVien("huy khac","b19dcat088","2022","2001","vinh phuc"));
        list.add(new SinhVien("huy khac","b19dcat088","2022","2001","vinh phuc"));
        return list;
    }
}