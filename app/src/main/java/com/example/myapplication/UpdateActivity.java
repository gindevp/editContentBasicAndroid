package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        EditText noidung_edit = findViewById(R.id.noidung_edit);

        Intent intent = getIntent();
        String noidung = intent.getStringExtra("noidung");
        noidung_edit.setText(noidung);

        Button ok_button = findViewById(R.id.ok_button);
        ok_button.setOnClickListener(v -> {
            setResultData();
            finish();
            Toast.makeText(v.getContext(), "SAVED", Toast.LENGTH_SHORT).show();
        });

    }

    private void setResultData() {
        Intent data= new Intent();
        EditText editText= findViewById(R.id.noidung_edit);
        String noidung= editText.getText().toString();
        data.putExtra("noidung", noidung);

        int code_result= 1;
        setResult(1,data);
    }
}