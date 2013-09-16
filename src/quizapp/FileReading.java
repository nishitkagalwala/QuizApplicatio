package quizapp;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileReading {

    private static String file_path;
    private static int no_of_lines;

    public FileReading(String path) {
        file_path = path;
    }

    public static String[] OpenFile() throws IOException {

        FileReader fr = new FileReader(file_path);  //Initiates The File Reader Using The Path 
        String[] data;
        try (BufferedReader textReader = new BufferedReader(fr)) {
            no_of_lines = noOfLines();
            data = new String[no_of_lines];
            for (int i = 0; i < data.length; i++) {
                data[i] = textReader.readLine();
            }
        }
        return data;
    }

    public static int noOfLines() throws IOException {

        FileReader lines = new FileReader(file_path);  //Initiates The File Reader Using The Path
        int line_count;
        try (BufferedReader bf = new BufferedReader(lines)) {
            line_count = 0;
            String line;
            while ((line = bf.readLine()) != null) {
                line_count++;
            }
        }
        return line_count;
    }
}
