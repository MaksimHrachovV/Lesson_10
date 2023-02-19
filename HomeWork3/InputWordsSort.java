package Lessons10.HomeWork3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputWordsSort {

    public static void main(String[] args) {
        Map<String, Integer> wordTable=new HashMap<>();
        try (InputStream word=new FileInputStream("src/Lessons10/HomeWork3/words.txt");
             Scanner scanner = new Scanner(word)) {
        int count=1;

        while (scanner.hasNextLine()){
            String line=scanner.next();
            String[] splitedLine = line.split(" ");
            String name = splitedLine[0];

            if(wordTable.containsKey(name)) {
                int value =wordTable.get(name);

                wordTable.put(name, value+1);

           } else {
                wordTable.put(name, count);
           }

        }
            wordTable.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }





}
