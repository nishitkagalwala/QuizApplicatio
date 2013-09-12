
package quizapp;

import static quizapp.RandomIDs.randomGeneration;

public class CategoryQuestions {

    public static QuestionGeneration[] category(String table) throws Exception {

        int[] quesID = randomGeneration(table);

        QuestionGeneration[] questionTemp = new QuestionGeneration[10];
        for (int i = 0; i < 10; i++) {
            questionTemp[i] = new QuestionGeneration();
        }

        for (int i = 0; i < 10; i++) {
            databaseResult db = new databaseResult(table);
            
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
