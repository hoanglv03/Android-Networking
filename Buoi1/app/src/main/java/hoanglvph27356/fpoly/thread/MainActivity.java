package hoanglvph27356.fpoly.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // long task
        TextView tv1 = findViewById(R.id.tv1);
        ProgressBar progess = findViewById(R.id.progess);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100000;i++){
                    Log.d("Long task",i +"");
                }

                // cách để cật nhật UI trong thread
                // TIP: Nếu bạn không có runOnUiThread thì sẽ bị kill app
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progess.setVisibility(View.INVISIBLE);
                        tv1.setText("MD173131-32323");
                    }
                });
                //order
//                tv1.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        tv1.setText("MD173131-32323");
//                    }
//                });

            }
        });

        AsyncTask<Void,Integer,String> async = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                for(int i = 0; i < 100000;i++){
                    Log.d("Long task",i +"");
                }
                if(i % 100000 == 0){
                    publishProgress();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progess.setVisibility(View.INVISIBLE);
                tv1.setText("MD173131-32323");
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }
        };
        async.execute();
       // thread.start();

    }
}