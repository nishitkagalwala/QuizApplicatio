
import java.util.Random;
import java.sql.*;
import java.util.Scanner;

class QuestionGeneration {

    String question, answer;
    String option[] = new String[4];
    static Random random = new Random();

    public static int tableLength(String table) throws Exception {

        String pass = "SELECT * FROM " + table;

        int count = 0;
        Class.forName("com.mysql.jdbc.Driver"); //Starts the driver class that initiates connector statements
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", ""); //connects to the root of database MYSQL
        PreparedStatement statement = con.prepareStatement(pass); //Statemnt that converts java code to mysqlcode (QUERY)
        ResultSet result = statement.executeQuery(); //result taken from mysql database 

        while (result.next()) {
            count++;
        }
        return count;
    }

    public static QuestionGeneration[] category(String category) throws Exception {
        int rep[] = new int[10];
        rep[0] = random.nextInt(tableLength(category)) + 1;
        for (int i = 1; i < 10;) {
            int qt = random.nextInt(tableLength(category)) + 1;
            int j = 0, flag = 0;
            while (j < i) {
                if (qt == rep[j++]) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                rep[i++] = qt;
            }
        }

        for (int i = 0; i < 10; i++) {
            //System.out.println(rep[i]);
        }

        String pass = "SELECT * FROM " + category;

        Class.forName("com.mysql.jdbc.Driver"); //Starts the driver class that initiates connector statements
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", ""); //connects to the root of database MYSQL
        PreparedStatement statement = con.prepareStatement(pass); //Statemnt that converts java code to mysqlcode (QUERY)
        ResultSet result = statement.executeQuery(); //result taken from mysql database 

        QuestionGeneration[] questionTemp = new QuestionGeneration[10];
        for (int i = 0; i < 10; i++) {
            questionTemp[i] = new QuestionGeneration();
        }

        for (int i = 0; i < 10; i++) {
            int ID = rep[i];
            //System.out.println("ID:" + ID);
            ResultSet result1 = statement.executeQuery();
            //int flag = 0;
            while (result1.next()) {
               // System.out.println("s");
                if (result1.getInt(1) == ID) {
                    questionTemp[i].question = result1.getString(2);
                    questionTemp[i].answer = result1.getString(3);
                    int j = 4;
                    for (int k = 0; k < 4; k++) {
                        questionTemp[i].option[k] = result1.getString(j++);
                    }

                }

            }

        }

        return questionTemp;


    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 4; i++) {
            s += option[i] + "  ";
        }

        return "\nQuestion : " + question + "\nOptions :" + s + "\nAnswer : " + answer;
    }
}

class Test extends QuestionGeneration {

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);

        QuestionGeneration question[] = QuestionGeneration.category("literature");

        for (int i = 0; i < question.length; i++) {
            System.out.println(question[i]);
        }

    }
}
