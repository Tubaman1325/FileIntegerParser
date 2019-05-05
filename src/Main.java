import java.io.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class FileIntegerParser {

    public static void main(String[] args) throws IOException {

        //Create file
        File file;
        //file location
        file = new File("C:\\Users\\Kylef\\Desktop\\integerValues.txt");

        //Generate integers to file
        try {

            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            Random generator = new Random();

            for (int i = 0; i <= 9999; i++) {
                int num = generator.nextInt(999) + 1;
                pw.println(num);
            }
            //stop writing to file
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Read data from file
        //Do maths of each number
        Scanner scanner = new Scanner(file);
        double sum = 0.0;
        double count = 0.0;
        int maxValue = 0;

        //Do maths of each number
        while (scanner.hasNext()) {

            //adding
            int nextInt = scanner.nextInt();
            sum = sum + nextInt;

            //max
            if (nextInt > maxValue) {
                maxValue = nextInt;
            }
            //count of lines of integers
            count++;
        }

        //average
        float avg = (float) (sum / count);


        //print the results
        System.out.println("The sum of the integers in this file is " + sum);
        System.out.println("The largest integer in the file is " + maxValue);
        System.out.println("This file contains " + count + " records.");
        System.out.printf("The average of the integers is %.2f\n", avg);
    }
}



