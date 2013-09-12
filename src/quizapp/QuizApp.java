package quizapp;

import java.util.Calendar;
import java.util.Scanner;
import static quizapp.GeneralQuestions.general;
import static quizapp.CategoryQuestions.category;

class QuizApp {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int choice;
        long time1,time2;
        QuestionGeneration question[] = new QuestionGeneration[10];
        Calendar c1,c2;
        
        c1 = Calendar.getInstance();

        System.out.print("Press '1' for Category Quiz \n'2' For Random Quiz : ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Category : ");
                String category = sc.next();

                question = category(category);

                time1 = c1.getTimeInMillis();
                for (int i = 0; i < question.length; i++) {
                    System.out.println("" + (i + 1) + question[i]);
                }
                int iii = sc.nextInt();
                c2 = Calendar.getInstance();
                time2 = c2.getTimeInMillis();
                System.out.println((time2 - time1) / 1000 + "Seconds");

                break;

            case 2:
                question= general();

                time1 = c1.getTimeInMillis();
                for (int i = 0; i < question.length; i++) {
                    System.out.println("\n" + (i + 1) + question[i]);
                }
                int iiii = sc.nextInt();
                c2 = Calendar.getInstance();
                time2 = c2.getTimeInMillis();

                System.out.println((time2 - time1) / 1000 + " Seconds");

                break;
        }
    }
}
