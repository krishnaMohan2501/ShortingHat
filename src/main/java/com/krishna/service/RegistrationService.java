package com.krishna.service;

import com.krishna.exception.InvalidCapacityException;
import com.krishna.model.Student;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RegistrationService {

    int capacity;
    @Getter
    private Queue<Student> listOfStudents;
    private Queue<Student> listOfStudentsNotOnboarded;
    private HouseService houseService;
    public RegistrationService(int capacity){

        this.capacity = capacity;
        this.listOfStudents = new LinkedList<>();
        this.listOfStudentsNotOnboarded = new LinkedList<>();
        this.houseService = new HouseService();
        validate(capacity);
    }

    private void validate(int capacity) {

        if(capacity%4!=0){
            this.capacity = 0;
            System.out.println("Invalid capacity");
            throw new InvalidCapacityException();
        }
    }


    public void registerStudents(Student student) {

        if(this.capacity>0){
            listOfStudents.add(student);
            this.capacity--;
        }else{
            listOfStudentsNotOnboarded.add(student);
        }
    }

    public void assignHouseToStudents(){

        while(!listOfStudents.isEmpty()){

            Student student = listOfStudents.poll();
            String className = student.getClassName().toUpperCase();
            String foodPref = student.getFoodPref().toUpperCase();

            String key = className + foodPref;

            houseService.assignHouse(key, student.getName(), student);
        }

        while (!listOfStudentsNotOnboarded.isEmpty()){
            Student student = listOfStudentsNotOnboarded.poll();
            houseService.notAssignAnyHouse(student.getName(), student);
        }
    }

    public List<String> getResultAfterOnboarding(){

        return houseService.getResultBasedOnHouses();


    }


}
