package mobile.example.com.projectcalcul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private boolean confirmedFlag = true;
    public void OnClick(View v){
        switch (v.getId()){
            case R.id.buttonDot:
            case R.id.buttonMinus:
            case R.id.button0:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
                ((TextView)findViewById(R.id.textViewAns)).setText(((TextView) findViewById(R.id.textViewAns)).getText().toString() + ((Button)v).getText().toString());
                break;
            case R.id.buttonClear:
                ((TextView)findViewById(R.id.textViewAns)).setText("");
                break;
            case R.id.buttonGenerate:
                ((TextView)findViewById(R.id.textViewQues)).setText(Generate.GenerateQuestion());
                QALog.AddToQ(((TextView) findViewById(R.id.textViewQues)).getText().toString(), confirmedFlag);
                ((TextView)findViewById(R.id.textViewAns)).setText("");
                confirmedFlag = false;
                break;
            case R.id.buttonEqual:
                if(QALog.AddToA(((TextView)findViewById(R.id.textViewAns)).getText().toString(), confirmedFlag)){
                    Toast.makeText(getApplicationContext(),"Got Your Answer", Toast.LENGTH_SHORT).show();
                }
                confirmedFlag = true;
                break;
            case R.id.buttonShowAll:
                MainActivity.this.startActivity(new Intent(MainActivity.this, ResultActivity.class));
                break;
            case R.id.buttonQuit:
                finish();
                break;

        }
    }
}
