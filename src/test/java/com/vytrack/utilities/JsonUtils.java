package com.vytrack.utilities;

import com.google.gson.Gson;
import com.vytrack.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    public static  List<Student> getStudentsData(String path){
        Gson gson = new Gson();

        Student[] students = new Student[0];
        try {
            students = gson.fromJson(new FileReader(path), Student[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return Arrays.asList(students);
    }

    public static void main(String[] args) {
        System.out.println(getStudentsData("src/test/resources/test_data/students.json"));
    }
}
