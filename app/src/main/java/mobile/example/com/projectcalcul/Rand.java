package mobile.example.com.projectcalcul;

import java.util.Random;

public class Rand {
    private static Random random = new Random();
    private Rand(){}
    public static Random GetInstance(){
        return random;
    }
}
