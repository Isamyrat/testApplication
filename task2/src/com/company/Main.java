package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {

        firstTask();

        int sum = numbers.get(0) * numbers.get(1) * numbers.get(2);

        String tmp = secondTask();

        if (!thirdTask(tmp, sum)) {
            System.out.println("The first number was be 1!!!");
            System.out.println("The last number was be 2!!!");
            System.out.println("The count of elements was be " + sum + "!!!");
            System.out.println("Please check one more!!!");
        }

    }

    public static void firstTask() {
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

    public static String secondTask() {
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

        return ss.replaceAll("\\s+", "");
    }

    public static Boolean thirdTask(String tmp, Integer sum) {
        char[] chars = tmp.toCharArray();


        for (int i = 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
            chars[i] = 0;
        }
        for (int i = 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
            chars[i] = 0;
        }
        for (int i = 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
            chars[i] = 0;
        }

        char[] chars1 = new char[chars.length - 3];

        for (int i = 0; i < chars.length - 3; i++) {
            chars1[i] = chars[i];
        }

        if (chars1[0] != '1') {
            return false;
        }
        if (chars1[chars1.length - 1] != '2') {
            return false;
        }
        if (chars1.length != sum) {
            return false;
        }
        int steps = numbers.get(1) * numbers.get(2);

        int flag = 0;

        int i = 0;

        while (i < chars1.length) {
            int count = 0, count1, t = 1;
            if (chars1[i] == '1' || chars1[i] == '.' || chars1[i] == '2') {
                if ((i + steps) < chars1.length) {
                    if (chars1[i + steps] == '.') {
                        int k = 1;

                        while (true) {
                            if ((i + steps + t) % steps != 0) {
                                t++;
                                count++;
                            } else break;
                        }
                        count1 = count;

                        while (k <= count) {
                            if (i + steps + k <= sum) {
                                if (chars1[i + steps + k] == '.') {
                                    flag++;
                                    i = i + steps;
                                    break;
                                } else if (chars1[i + steps + k] == '0') {
                                    if (k == count1) {
                                        i = i + k;
                                        flag++;
                                        break;
                                    } else k++;
                                } else if (chars1[i + steps + k] == '2') {
                                    i = i + steps;
                                    flag++;
                                    break;

                                }
                            } else {
                                flag++;
                                i = i + steps;
                                break;
                            }
                        }

                    } else if (chars1[i + steps] == '2') {
                        i = i + steps;
                        flag++;
                    }else {
                        i++;
                        flag++;
                    }
                } else if (chars1[i] == '2') {
                    flag++;
                    break;
                } else {
                    i++;
                    flag++;
                }
            } else i++;
        }

        System.out.println("Prince need "  + (flag - 1) + " moves for find princess!!!");
        System.out.println();
        System.out.println("Prince need "  + (flag - 1) * 5 + " seconds for find princess!!!");
        return true;
    }

}
