package quizapp;

import java.util.Scanner;

public class AddQuestion {

    static Scanner sc = new Scanner(System.in);

    public static void add(String table) throws Exception {
        
        databaseResult db = new databaseResult(table);
        String question, answer;
        String options[] = new String[4];


        System.out.print("Enter The Question To Be Added : ");
        question = sc.nextLine();

        System.out.print("Enter The Answer To Be Added : ");
        answer = sc.nextLine();

        System.out.print("Enter The Options To Be Added : ");
        for (int i = 0; i < 4; i++) {
            System.out.print("Option " + (i + 1) + " : ");
            options[i] = sc.next();
        }
        
           String pass = "INSERT INTO " + table + "(`ID`,`QUESTION`,`ANSWER`,`OPTION 1`,`OPTION 2`,`OPTION 3`,`OPTION 4`) VALUES(NULL,'" + question + "','" + answer + "'," + "'" + options[0] + "','" + options[1] + "','" + options[2] + "','" + options[3] + "')";
           db.getStatement().executeUpdate(pass);
    }
}
