package quizapp;

import java.util.Random;

public class QuestionGeneration {

    String question, answer;
    String option[] = new String[4];
    static Random random = new Random();

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 4; i++) {
            s += option[i] + "  ";
        }
        return "\nQuestion : " + question + "\nOptions :" + s + "\nAnswer : " + answer;
    }
}
