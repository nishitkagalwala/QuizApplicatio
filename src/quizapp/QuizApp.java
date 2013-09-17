package quizapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Scanner;
import static quizapp.CategoryQuestions.category;
import static quizapp.GeneralQuestions.general;

class QuizApp {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int choice;
        long time1, time2;
        QuestionGeneration question[] = new QuestionGeneration[10];
        Calendar c1, c2;

        c1 = Calendar.getInstance();

        System.out.print("Press '1' for Category Quiz '2' For Random Quiz : ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Category : ");
                String category = scanner.next();

                question = category(category);

                time1 = c1.getTimeInMillis();
                for (int i = 0; i < question.length; i++) {
                    System.out.println("\nQuestion " + (i + 1) + question[i]);
                }
                int iii = scanner.nextInt();
                c2 = Calendar.getInstance();
                time2 = c2.getTimeInMillis();
                System.out.println((time2 - time1) / 1000 + " Seconds");

                break;

            case 2:
                question = general();

                time1 = c1.getTimeInMillis();
                for (int i = 0; i < question.length; i++) {
                    System.out.println("\nQuestion " + (i + 1) + question[i]);
                }
                int iiii = scanner.nextInt();
                c2 = Calendar.getInstance();
                time2 = c2.getTimeInMillis();
                System.out.println((time2 - time1) / 1000 + " Seconds");

                break;
        }
        
        /*
        System.out.println("Enter Category in which questions are to be added from file");
        String cat = scanner.next();
        AddQuestionFromFile.add(cat);
        AddQuestion.add(cat);
        */
        
        System.out.println("Enter The Categories : ");
        String s = br.readLine();
        question = MultipleCategoryQuestions.multipleCategory(s);
        
        for(int i=0 ; i<question.length ; i++)
            System.out.println("\nQuestion " + (i + 1) + question[i]);
    }
}
