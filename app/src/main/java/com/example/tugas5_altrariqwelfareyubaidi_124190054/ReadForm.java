package com.example.tugas5_altrariqwelfareyubaidi_124190054;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class ReadForm extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button bt1, bt2;
    TextView tvnomor, tvnama, tvtelp, tvemail, tvalamat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_form);
        dbHelper = new DataHelper(this);
        tvnomor = (TextView) findViewById(R.id.tv_nomor);
        tvnama = (TextView) findViewById(R.id.tv_nama);
        tvtelp = (TextView) findViewById(R.id.tv_telp);
        tvemail = (TextView) findViewById(R.id.tv_email);
        tvalamat = (TextView) findViewById(R.id.tv_alamat);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM formulir WHERE nama = '" + getIntent().getStringExtra("nama")
        + "'", null);
        cursor.moveToFirst();

        if (cursor.getCount()>0){
        cursor.moveToPosition(0);
        tvnomor.setText(cursor.getString(0).toString());
        tvnama.setText(cursor.getString(1).toString());
        tvtelp.setText(cursor.getString(2).toString());
        tvemail.setText(cursor.getString(3).toString());
        tvalamat.setText(cursor.getString(4).toString());
        }
        bt2 = (Button) findViewById(R.id.bt_back);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}