package quizapp;

import java.util.Scanner;

public class AddQuestionFromFile {

    public static void add(String table) throws Exception {

        try {
            String fileName;
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter The File Name With Path To Be Read : ");

            fileName = sc.next();

            FileReading file = new FileReading(fileName);

            String[] fileData = file.OpenFile();

            databaseResult db = new databaseResult(table);
            for (int i = 0; i < fileData.length / 6; i++) {
                String q = fileData[0 + (6 * i)];
                String a = fileData[1 + (6 * i)];
                String option_1 = fileData[2 + (6 * i)];
                String option_2 = fileData[3 + (6 * i)];
                String option_3 = fileData[4 + (6 * i)];
                String option_4 = fileData[5 + (6 * i)];
                String pass = "INSERT INTO " + table + "(`ID`,`QUESTION`,`ANSWER`,`OPTION 1`,`OPTION 2`,`OPTION 3`,`OPTION 4`) VALUES(NULL,'" + q + "','" + a + "'," + "'," + option_1 + "','" + option_2 + "','" + option_3 + "','" + option_4 + "')";
                db.getStatement().executeUpdate(pass);
            }


        } catch (Exception e) {
        }
    }
}
