package Lessons10.HomeWork1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFilePhone {
    //test fsdfsdfsdfs
    public static void main(String[] args) {
        File PhoneNumber=new File("src/Lessons10/HomeWork1/NumberPhones.txt");
        if (PhoneNumber.exists()){
            try {
                System.out.println("File NumberPhones = " + PhoneNumber.exists());
                Scanner scanner=new Scanner(PhoneNumber);

                while (scanner.hasNext()){
                    Pattern pattern=Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[-]?\\d{4}$");
                    String number=scanner.nextLine();
                    Matcher matcher = pattern.matcher(number);
                    if (matcher.matches()){
                        System.out.println("Phone number Valid = " + number);
                    }
                    if (!matcher.matches()){

                        System.out.println("Phone number does not match = " + number);
                    }
                    System.out.println("-------------------------------------------");
                }
                scanner.close();
            }catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (!PhoneNumber.exists()){
            System.out.println("File NumberPhones = " + PhoneNumber.exists());
        }

    }

}
