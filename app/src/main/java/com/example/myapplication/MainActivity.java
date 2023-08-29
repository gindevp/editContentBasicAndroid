package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int RESULT_UPDATE_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.noidung);
        Button editbutton = findViewById(R.id.editbutton);
        editbutton.setOnClickListener(v -> {
            Intent intent = new Intent();

            //Gán context và tên lớp Activity cần chạy
            intent.setClass(v.getContext(), UpdateActivity.class);

            //Nếu có truyền tham số cho Activity
            intent.putExtra("noidung", textView.getText());

            //Gửi Intent cho hệ thống Android để kích hoạt Activity
            startActivityForResult(intent,RESULT_UPDATE_ACTIVITY);
            //Muốn Activity thứ nhất kết thúc thì thêm finish();
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_UPDATE_ACTIVITY:
                String noidung = data.getStringExtra("noidung");
                TextView textView = findViewById(R.id.noidung);
                textView.setText(noidung);
                break;
            default: break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}