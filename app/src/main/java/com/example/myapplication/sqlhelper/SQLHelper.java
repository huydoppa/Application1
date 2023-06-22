package com.example.myapplication.sqlhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.Lop;
import com.example.myapplication.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SQLHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME= "kiemtra";
    private static final int DATABASE_VERSION= 1;

    private static final String TABLE_SV= "`student`";
    private static final String SV_ID= "id";
    private static final String SV_NAME= "ten";
    private static final String SV_MSV= "masinhvien";
    private static final String SV_NAMSINH= "namsinh";
    private static final String SV_NAMHOC= "namhoc";
    private static final String SV_QUE= "que";

    private static final String TABLE_CLASS= "`class`";
    private static final String CLASS_ID= "id";
    private static final String CLASS_NAME= "name";
    private static final String CLASS_DESC= "desc";

    private static final String TABLE_CLASSSV= "`classSV`";
    private static final String CLASSSV_ID= "id";
    private static final String CLASSSV_MSV= "msv";
    private static final String CLASSSV_MCLASS= "malop";

    public SQLHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(String.valueOf(
            "CREATE TABLE "+TABLE_CLASS+" ( "+
                    CLASS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    CLASS_NAME + " TEXT, "+
                    CLASS_DESC + " TEXT)")
        );
        sqLiteDatabase.execSQL(String.valueOf(
                "CREATE TABLE "+TABLE_SV+" ( "+
                        SV_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        SV_NAME + " TEXT, "+
                        SV_MSV + " TEXT, "+
                        SV_NAMSINH + " TEXT, "+
                        SV_NAMHOC + " TEXT, "+
                        SV_QUE + " TEXT)")
        );
        sqLiteDatabase.execSQL(String.valueOf(
                "CREATE TABLE "+TABLE_CLASSSV+" ( "+
                        CLASSSV_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        CLASSSV_MSV + " TEXT, "+
                        CLASSSV_MCLASS + " TEXT, "+
                        "FOREIGN KEY ( "+ CLASSSV_MSV +" ) REFERENCES "+ TABLE_SV + " ( "+SV_ID +" ), "+
                        "FOREIGN KEY ( "+ CLASSSV_MCLASS +" ) REFERENCES "+ TABLE_CLASS + " ( "+CLASS_ID +" ) ) "
                )
        );
    }

    public boolean addSinhVien(SinhVien sinhvien){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(SV_NAME, sinhvien.getName());
        contentValues.put(SV_MSV, sinhvien.getMsv());
        contentValues.put(SV_NAMSINH, sinhvien.getNamsinh());
        contentValues.put(SV_NAMHOC, sinhvien.getNamhoc());
        contentValues.put(SV_QUE, sinhvien.getQue());
        long result = db.insert(TABLE_SV,null,contentValues);
        return result != -1;

    }
    public boolean addLop(Lop lop){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(CLASS_NAME, lop.getTenlop());
        contentValues.put(CLASS_DESC, lop.getMota());
        long result = db.insert(TABLE_CLASS,null,contentValues);
        return result != -1;

    }
    public List<SinhVien> getSinhVien(){
        List<SinhVien> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM "+TABLE_SV,null);
        while (cursor.moveToNext()){
            list.add(new SinhVien(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)));
        }
        return list;
    }
    public List<Lop> getLop(){
        List<Lop> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM "+TABLE_CLASS,null);
        while (cursor.moveToNext()){
            list.add(new Lop(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
        }
        return list;
    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
