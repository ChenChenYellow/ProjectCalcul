package mobile.example.com.projectcalcul;

import android.util.Log;
import android.widget.TextView;

import java.nio.FloatBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QALog {
    private static Queue<String> Q = new LinkedList<>();
    private static Queue<String> A = new LinkedList<>();
    private QALog(){}
    public static Queue<String> GetQ(){
        return Q;
    }
    public static Queue<String> GetA(){
        return A;
    }
    public static void AddToQ(String text, boolean flag){
        if (!flag){
            AddToA(" ", flag);
        }
        Q.add(text);
    }
    public static boolean AddToA(String text, boolean flag){
        if(!flag) {
            A.add(text);
            return true;
        }
        return false;
    }
    public static void Display(TextView tv){
        tv.setText("");
        int count = 0;
        int right = 0;
        while (A.peek() != null){
            Log.e("myErr", "1");
            String q = Q.poll();
            String a = A.poll();
            Log.e("myErr", q);
            String ret = "\n" + q + " = " + a;
            int ans = Generate.GenerateAnswer(q);
            Log.e("myErr", String.valueOf(ans));
            Log.e("myErr", "a = " + a);
            boolean pass = true;
            try{
                int af = Integer.valueOf(a);
            }catch (Exception e){
                pass = false;
            }
            String extra = "";
            if (q.split(" ")[1].equals("/")){
                int temp = Integer.valueOf(q.split(" ")[0]) % Integer.valueOf(q.split(" ")[2]);
                extra = "\nThe Reminder is " + String.valueOf(temp);
            }
            if (pass && ans == Integer.valueOf(a)){
                Log.e("myErr", "Correct1");
                ret += "\nYour Answer Is Correct" + extra;
                count++;
                right++;
                Log.e("myErr", "Correct");
            }else{
                Log.e("myErr", "Wrong1");
                ret += "\nYour Answer is Wrong!!!";
                ret += "\nThe Right Answer is " + String.valueOf(ans) + extra;
                count++;
                Log.e("myErr", "Wrong");
            }
            ret += "\n-------------------------";
            tv.setText(tv.getText() + ret);
            Log.e("myErr", "2");
        }

        Log.e("myErr", "3");
        if (count != 0){
            String fText = String.valueOf(Math.round(10000 * (float)right/(float)count)/100) + "%";
            String textF = String.valueOf(Math.round(10000 * (1 - (float)right/(float)count))/100) + "%";
            tv.setText(tv.getText() + "\n" + fText + " Correct Answer" + "\n" + textF + " Wrong Answer");
        }

        Log.e("myErr", "4");
    }
}
