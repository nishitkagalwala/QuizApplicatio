package quizapp;

import static quizapp.RandomIDs.randomGeneration;
import static quizapp.RandomIDs.randomInt;

public class GeneralQuestions {
    public static QuestionGeneration[] general() throws Exception {

        int[] categoryID = randomGeneration("categories");
        String[] category = new String[10];
        databaseResult db;
        int[] quesID = new int[10];

        for (int i = 0; i < 10; i++) {
            db = new databaseResult("categories");
            while (db.getResult().next()) {
                if (db.getResult().getInt(1) == categoryID[i]) {
                    category[i] = db.getResult().getString(2);
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            quesID[i] = randomInt(category[i]);
        }


        QuestionGeneration[] questionTemp = new QuestionGeneration[10];
        for (int i = 0; i < 10; i++) {
            questionTemp[i] = new QuestionGeneration();
        }

        for (int i = 0; i < 10; i++) {
            db = new databaseResult(category[i]);

            while (db.getResult().next()) {
                if (db.getResult().getInt(1) == quesID[i]) {
                    questionTemp[i].question = db.getResult().getString(2);
                    questionTemp[i].answer = db.getResult().getString(3);
                    int j = 4;
                    for (int k = 0; k < 4; k++) {
                        questionTemp[i].option[k] = db.getResult().getString(j++);
                    }
                }
            }
        }
        return questionTemp;
    }
}
