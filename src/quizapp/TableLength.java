package quizapp;

public class TableLength {

    public static int tableLength(String table) throws Exception {

        databaseResult db = new databaseResult(table);
        int count = 0;

        while (db.getResult().next()) {
            count++;
        }
        return count;
    }
}
