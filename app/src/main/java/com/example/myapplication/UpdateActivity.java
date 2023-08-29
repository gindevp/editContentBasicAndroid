package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    private final String TAG = "UpdateActivity";
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
        Log.d(TAG, "onCreate");
    }

    private void setResultData() {
        Intent data= new Intent();
        EditText editText= findViewById(R.id.noidung_edit);
        String noidung= editText.getText().toString();
        data.putExtra("noidung", noidung);

        int code_result= 1;
        setResult(1,data);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }
}