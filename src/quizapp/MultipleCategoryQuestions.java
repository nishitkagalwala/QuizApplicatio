package quizapp;

import static quizapp.RandomIDs.randomInt;

public class MultipleCategoryQuestions {

    public static QuestionGeneration[] multipleCategory(String s) throws Exception {
        String categories[] = s.split(" ");
        int categoryId[] = new int[10];
        DatabaseResult db;
        int quesID[] = new int[10];

        categoryId = RandomIDs.randomRepeat(categories.length);

        for (int i = 0; i < 10; i++) {
            quesID[i] = randomInt(categories[categoryId[i]]);
        }

        QuestionGeneration[] questionTemp = new QuestionGeneration[10];
        for (int i = 0; i < 10; i++) {
            questionTemp[i] = new QuestionGeneration();
        }

        for (int i = 0; i < 10; i++) {
            db = new DatabaseResult(categories[categoryId[i]]);

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
        for(int i=0 ; i<10 ; i++)
            System.out.println(quesID[i]+ "  "+ categoryId[i]);
        return questionTemp;
    }
}