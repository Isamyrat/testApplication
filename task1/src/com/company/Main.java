package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static List<String> lines = new ArrayList<>();
    public static List<String> lines1 = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("story.txt");

        try (Stream<String> lineStream = Files.lines(path)) {
            lines = lineStream.collect(Collectors.toList());

        } catch (IOException ignored) {
            System.out.println("File dont found");
        }

        firstTask();

        secondTask();

        thirdTask();

        fourthTask();


        System.out.println(lines);

        Files.write(Paths.get("story.txt"), lines);

    }

    public static void firstTask(){
        for(String ss : lines){
            lines1.add(ss.replace("ce", "se"));
        }

        lines.clear();

        for(String ss : lines1){
            lines.add(ss.replace("ci", "si"));
        }
        lines1.clear();

        for(String ss : lines){
            lines1.add(ss.replace("ck", "k"));
        }
        lines.clear();

        for(String ss : lines1){
            lines.add(ss.replace("c", "k"));
        }
    }

    public static void secondTask() {
        lines1.clear();

        for(String ss : lines){
            lines1.add(ss.replace("ee", "i"));
        }

        lines.clear();

        for(String ss : lines1){
            lines.add(ss.replace("oo", "u"));
        }

        lines1.clear();

        for(String ss : lines){
            lines1.add(ss.replaceAll("([A-Za-z])\\1+", "$1"));
        }
    }

    public static void thirdTask() {
        lines.clear();

        for(String ss : lines1){
            lines.add(ss.replaceAll("e\\b", ""));
        }
    }

    public static void fourthTask() {
        lines.clear();

        for(String ss : lines1){
            lines.add(ss.replaceAll("e\\b", ""));
        }


        lines1.clear();

        for(String ss : lines){
            lines1.add(ss.replaceAll("\\ban?\\b", ""));
        }


        lines.clear();

        for(String ss : lines1){
            lines.add(ss.replaceAll("\\bth\\b", ""));
        }
    }
}
