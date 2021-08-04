package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static  List<Integer> numbers = new ArrayList<>();
    public static void main(String[] args) {

        firstTask();

        int sum = numbers.get(0) * numbers.get(1) * numbers.get(2);

        String tmp = secondTask();

        if(!thirdTask(tmp, sum)){
            System.out.println("The first number was be 1!!!");
            System.out.println("The last number was be 2!!!");
            System.out.println("The count of elements was be " + sum + "!!!");
            System.out.println("Please check one more!!!");
        }

    }

    public static void firstTask(){
        String value = null;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("prince.txt"))) {
            value = reader.readLine();
        } catch (IOException e) {
            System.out.println("File dont found");
            e.printStackTrace();
        }
        String[] firstLine = value.split("\\s+");

        for (String a : firstLine) {
            numbers.add(Integer.valueOf(a));
        }
    }
    public static String  secondTask() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("prince.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File dont found");
        }
        String ss = sb.toString();

        String tmp = ss.replaceAll("\\s+", "");
        return tmp;
    }

    public static Boolean thirdTask(String tmp, Integer sum) {
        char[] chars = tmp.toCharArray();

        if(chars[3] != '1'){
            return false;
        }
        if(chars[chars.length-1] != '2'){
            return false;
        }

        chars[0] = 0; chars[1] = 0; chars[2]=0;
        int opo = chars.length-1;
        if(chars.length-3 != sum){
            return false;
        }

        int flag =0;
        for (Character character : chars) {
            if(character.equals('.')){
                flag++;
            }
        }
        System.out.println("Prince need "  + flag*5 + " for find princess!!!");
        return true;
    }

}
