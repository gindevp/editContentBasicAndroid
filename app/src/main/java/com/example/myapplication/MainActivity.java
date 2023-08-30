package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    final int RESULT_UPDATE_ACTIVITY = 1;

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.noidung);
        Button editButton = findViewById(R.id.editbutton);

        editButton.setOnClickListener(v -> {
            Intent intent = new Intent();

            //Gán context và tên lớp Activity cần chạy
            intent.setClass(v.getContext(), UpdateActivity.class);

            //Nếu có truyền tham số cho Activity
            intent.putExtra("noidung", textView.getText());

            //Gửi Intent cho hệ thống Android để kích hoạt Activity
            //noinspection deprecation
            startActivityForResult(intent, RESULT_UPDATE_ACTIVITY);
            //Muốn Activity thứ nhất kết thúc thì thêm finish();
        });
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_UPDATE_ACTIVITY) {
            assert data != null;
            String noidung = data.getStringExtra("noidung");
            TextView textView = findViewById(R.id.noidung);
            textView.setText(noidung);
        }
        Log.d(TAG, "onResult");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView textView= findViewById(R.id.noidung);
        outState.putString("content",textView.getText().toString());
        Log.d("hihihi",textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView textView = findViewById(R.id.noidung);
        textView.setText(savedInstanceState.getString("content"));

    }
}