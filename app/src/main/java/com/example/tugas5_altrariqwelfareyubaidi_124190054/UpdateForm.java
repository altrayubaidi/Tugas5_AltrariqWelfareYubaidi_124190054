package com.example.tugas5_altrariqwelfareyubaidi_124190054;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class UpdateForm extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button bt1, bt2;
    EditText textnomor, textnama, texttelp, textemail, textalamat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_form);
        dbHelper = new DataHelper(this);
        textnomor = (EditText) findViewById(R.id.et_nomor);
        textnama = (EditText) findViewById(R.id.et_nama);
        texttelp = (EditText) findViewById(R.id.et_telp);
        textemail = (EditText) findViewById(R.id.et_email);
        textalamat = (EditText) findViewById(R.id.et_alamat);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM formulir WHERE nama = '" + getIntent().getStringExtra("nama")
                + "'", null);
        cursor.moveToFirst();

        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            textnomor.setText(cursor.getString(0).toString());
            textnama.setText(cursor.getString(1).toString());
            texttelp.setText(cursor.getString(2).toString());
            textemail.setText(cursor.getString(3).toString());
            textalamat.setText(cursor.getString(4).toString());
        }
        bt1 = (Button) findViewById(R.id.bt_save);
        bt2 = (Button) findViewById(R.id.bt_back);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update formulir set nama ='" +
                        textnama.getText().toString() + "', telp = '" +
                        texttelp.getText().toString() + "', email = '" +
                        textemail.getText().toString() + "', alamat = '" +
                        textalamat.getText().toString() + "' where no = '" +
                        textnomor.getText().toString() + "'");
                Toast.makeText(getApplicationContext(), "Berhasil!", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public boolean onCreateOptionMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}