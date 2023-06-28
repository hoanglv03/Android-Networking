package hoanglvph27356.fpoly.lap1;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bai3 extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgLoad;
    private TextView tvMsg;
    private Button btnLoadEx3;
    private static final String IMAGE_URL = "https://ap.poly.edu.vn/images/logo.png";
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        imgLoad = (ImageView) findViewById(R.id.imgLoad);
        tvMsg = (TextView) findViewById(R.id.tvMsg);
        btnLoadEx3 = (Button) findViewById(R.id.btnLoadEx3);

        btnLoadEx3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //new LoadImageTask(this, this).execute(IMAGE_URL);

        new LoadImageTask().execute(IMAGE_URL);
    }

    class LoadImageTask extends AsyncTask<String, Void, Bitmap> {


        @Override
        protected Bitmap doInBackground(String... strings) {

            Bitmap bitmap = hoanglvph27356.fpoly.lap1.Bai2.downloadBitmap(strings[0]);

            return bitmap;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(Bai3.this);
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

            imgLoad.setImageBitmap(bitmap);
        }
    }

//    @Override
//    public void onImageLoaded(Bitmap bitmap) {
//        imgLoad.setImageBitmap(bitmap);
//        tvMsg.setText("Image Downloaded!");
//    }

//    @Override
//    public void onError() {
//        tvMsg.setText("Error download image!");
//    }
}