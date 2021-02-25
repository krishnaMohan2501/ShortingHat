package com.krishna.exception;

import com.krishna.Student;
import com.krishna.service.RegistrationService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        RegistrationService registrationService = new RegistrationService(12);

        registrationService.registerStudents(new Student("1","B","V"));
        registrationService.registerStudents(new Student("2","A","V"));
        registrationService.registerStudents(new Student("3","A","V"));
        registrationService.registerStudents(new Student("4","B","NV"));
        registrationService.registerStudents(new Student("5","B","V"));
        registrationService.registerStudents(new Student("6","A","NV"));
        registrationService.registerStudents(new Student("7","A","V"));
        registrationService.registerStudents(new Student("8","A","NV"));
        registrationService.registerStudents(new Student("9","B","NV"));
        registrationService.registerStudents(new Student("10","B","V"));
        registrationService.registerStudents(new Student("11","A","NV"));
        registrationService.registerStudents(new Student("12","B","NV"));
        registrationService.registerStudents(new Student("13","A","NV"));

        registrationService.assignHouseToStudents();
        List<String> results = registrationService.getResultAfterOnboarding();
        for(String result: results){
            System.out.println(result);
        }
    }
}