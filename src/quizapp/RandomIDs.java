package quizapp;

import static quizapp.QuestionGeneration.random;
import static quizapp.TableLength.tableLength;

public class RandomIDs {

    public static int[] randomGeneration(String table) throws Exception {
        int rep[] = new int[10];
        rep[0] = random.nextInt(tableLength(table)) + 1;
        for (int i = 1; i < 10;) {
            int qt = random.nextInt(tableLength(table)) + 1;
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
        return rep;
    }

    public static int randomInt(String table) throws Exception {
        return random.nextInt(tableLength(table)) + 1;
    }

    public static int[] randomRepeat(int length) throws Exception {
        int rep[] = new int[10];

        for (int i = 0; i < 10; i++)
                rep[i] = random.nextInt(length);
        return rep;
    }


public static void main(String args[])throws Exception{
    String s="music history geography";
    String arr[] = s.split(" ");
    
    for(int i=0 ; i<arr.length ; i++)
        System.out.print(arr[i]+"  ");
    
    int [] ID = randomRepeat(arr.length);
        for(int i=0 ; i<ID.length ; i++)
            System.out.print(ID[i]+" ");
    
}
}