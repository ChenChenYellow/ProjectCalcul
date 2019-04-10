package mobile.example.com.projectcalcul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        QALog.Display((TextView)findViewById(R.id.textViewDisplay));

    }
    public void OnClick(View v){
        ResultActivity.this.finish();
    }
}
