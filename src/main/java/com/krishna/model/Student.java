package com.krishna.model;

import java.util.Objects;
import java.util.Random;

public class Student {

    String name;
    String rollNumber;
    String className;
    String foodPref;


    public Student(String name, String className, String foodPref){
        this.name = name;
        this.className = className;
        this.foodPref = foodPref;
        this.rollNumber = generateRollNo();
    }

    public static String generateRollNo() {
        Random r = new Random();
        String randomNumber = String.format("%04d", r.nextInt(1001));
        return randomNumber;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getClassName() {
        return className;
    }

    public String getFoodPref() {
        return foodPref;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(rollNumber, student.rollNumber) &&
                Objects.equals(className, student.className) &&
                Objects.equals(foodPref, student.foodPref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rollNumber, className, foodPref);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", foodPref='" + foodPref + '\'' +
                '}';
    }
}
