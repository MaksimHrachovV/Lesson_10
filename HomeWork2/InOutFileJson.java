package src.Lessons10.HomeWork2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InOutFileJson {
    public static void main(String[] args) throws IOException {
        InputStream file= new FileInputStream("src/Lessons10/HomeWork2/file.txt");
        Map<String,String> base=new HashMap<>();
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        Scanner scanner = new Scanner(file);
        String[] caption=scanner.nextLine().split(" ");
        String nameCaption=caption[0];
        String ageCaption=caption[1];
        FileWriter fileclear = new FileWriter("src/Lessons10/HomeWork2/user.json.txt");
        fileclear.close();

        while (scanner.hasNext()) {

            String line=scanner.nextLine();
            String[] arr=line.split(" ");
            String nameArr=arr[0];
            String ageArr=arr[1];

            base.put(nameCaption,nameArr);
            base.put(ageCaption,ageArr);

            String toJson=gson.toJson(base);

            FileWriter fileWriter = new FileWriter("src/Lessons10/HomeWork2/user.json.txt",true);
            gson.toJson(base, fileWriter);
            fileWriter.close();


        }
        scanner.close();

        }

    }








