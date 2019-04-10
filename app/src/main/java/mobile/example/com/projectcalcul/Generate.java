package mobile.example.com.projectcalcul;

import android.widget.TextView;
import android.widget.Toast;

public class Generate {
    public static String GenerateQuestion(){
        int first = Rand.GetInstance().nextInt() % 30;
        int last = Rand.GetInstance().nextInt() % 30;
        int midle = Rand.GetInstance().nextInt() % 4;
        String middle = "+";
        switch (midle){
            case 1:
                middle = "-";
                break;
            case 2:
                middle = "*";
                break;
            case 3:
                middle = "/";
                while(last == 0){
                    last = Rand.GetInstance().nextInt() % 30;
                }
                break;
        }
        return String.valueOf(first) + " " + middle + " " + String.valueOf(last);
    }
    public static int GenerateAnswer(String input){
        String[] text  = input.split(" ");
        int first = Integer.valueOf(text[0]);
        int last = Integer.valueOf(text[2]);
        int result = 0;
        switch (text[1]){
            case "+":
                result = first + last;
                break;
            case "-":
                result = first - last;
                break;
            case "*":
                result = first * last;
                break;
            case "/":
                result = first / last;
                break;
        }
        return result;
    }
}
