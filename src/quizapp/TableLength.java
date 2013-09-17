package quizapp;

public class TableLength {

    public static int tableLength(String table) throws Exception {

        DatabaseResult db = new DatabaseResult(table);
        int count = 0;

        while (db.getResult().next()) {
            count++;
        }
        return count;
    }
}
