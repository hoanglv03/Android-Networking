package hoanglvph27356.fpoly.lap1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private Button btnEx1;
    private Button btnEx2;
    private Button btnEx3;
    private Button btnEx4;

    static ImageView ivBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnEx1 = (Button) findViewById(R.id.btnEx1);
        btnEx2 = (Button) findViewById(R.id.btnEx2);
        btnEx3 = (Button) findViewById(R.id.btnEx3);
        btnEx4 = (Button) findViewById(R.id.btnEx4);

        ivBanner = findViewById(R.id.iv);
    }

    public static Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle bundle = msg.getData();
            Bitmap bitmap = bundle.getParcelable("bitmap");
            if (bitmap != null) {
                ivBanner.setImageBitmap(bitmap);
            }

        }
    };

    public  void Bai1 (View view){
        Intent intent = new Intent(MainActivity2.this,hoanglvph27356.fpoly.lap1.MainActivity.class);
        startActivity(intent);
    }
    public  void Bai2 (View view){
        Intent intent = new Intent(MainActivity2.this, hoanglvph27356.fpoly.lap1.Bai2.class);
        startActivity(intent);
    }
    public  void Bai3 (View view){
        Intent intent = new Intent(MainActivity2.this, hoanglvph27356.fpoly.lap1.Bai3.class);
        startActivity(intent);
    }
    public  void Bai4 (View view){
        Intent intent = new Intent(MainActivity2.this, hoanglvph27356.fpoly.lap1.Bai4.class);
        startActivity(intent);
    }
}