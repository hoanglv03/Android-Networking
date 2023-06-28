package hoanglvph27356.fpoly.lap1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bai4 extends AppCompatActivity implements View.OnClickListener {
    private EditText edtTime;
    private TextView tvMsg;
    private Button btnLoadEx4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        edtTime = (EditText) findViewById(R.id.edtTime);
        tvMsg = (TextView) findViewById(R.id.tvMsg);
        btnLoadEx4 = (Button) findViewById(R.id.btnLoadEx4);

        btnLoadEx4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLoadEx4){
            AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(tvMsg,edtTime,this);
            String sleeptime = edtTime.getText().toString();
            asyncTaskRunner.execute(sleeptime);
        }
    }
}