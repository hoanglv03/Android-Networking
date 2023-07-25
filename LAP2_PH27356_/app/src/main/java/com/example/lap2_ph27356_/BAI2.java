package com.example.lap2_ph27356_;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BAI2 extends AppCompatActivity {
    private Button btnSend;
    private TextView tvResult;
    private EditText edWidth,edLength;


    public static final String SERVER_NAME = "http://192.168.0.101/luongviethoang_ph27356/rectangle_POST.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai2);
        init();
btnSend.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String length = edLength.getText().toString();
        String width = edWidth.getText().toString();
        BackgroundTask_POST get = new BackgroundTask_POST(tvResult,width,length, BAI2.this);

        get.execute();

    }
});
    }
    private void init(){
        btnSend = findViewById(R.id.btnSend2);
        tvResult = findViewById(R.id.tvResult2);
        edLength = findViewById(R.id.edLength);
        edWidth = findViewById(R.id.edWidth);
    }


}