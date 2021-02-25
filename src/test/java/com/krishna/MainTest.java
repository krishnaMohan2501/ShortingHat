package com.krishna;

import com.krishna.model.Student;
import com.krishna.service.RegistrationService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {


    public RegistrationService registrationService;

    @BeforeMethod
    public void init(){
        registrationService = new RegistrationService(12);

    }


    public void registerStudentV1(){
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
    }

    public void registerStudentV2(){
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
    }

    @Test
    public void testOutPut1(){
        final  List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("ANV: [Student{name='11', className='A', foodPref='NV'},Student{name='6', className='A', " +
                "foodPref='NV'},Student{name='8', className='A', foodPref='NV'},]");
        expectedOutput.add("AV: [Student{name='2', className='A', foodPref='V'},Student{name='3', className='A', " +
                "foodPref='V'},Student{name='7', className='A', foodPref='V'},]");
        expectedOutput.add("BNV: [Student{name='12', className='B', foodPref='NV'},Student{name='4', className='B', " +
                "foodPref='NV'},Student{name='9', className='B', foodPref='NV'},]");
        expectedOutput.add("BV: [Student{name='1', className='B', foodPref='V'},Student{name='5', className='B', " +
                "foodPref='V'},Student{name='10', className='B', foodPref='V'},]");
        expectedOutput.add("NA: []");

        registerStudentV1();
        registrationService.assignHouseToStudents();
        List<String> resultAfterOnboarding = registrationService.getResultAfterOnboarding();
        Assert.assertEquals(resultAfterOnboarding, expectedOutput);

    }

    @Test
    public void testOutPut2(){
        final  List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("ANV: [Student{name='11', className='A', foodPref='NV'},Student{name='6', className='A', " +
                "foodPref='NV'},Student{name='8', className='A', foodPref='NV'},]");
        expectedOutput.add("AV: [Student{name='2', className='A', foodPref='V'},Student{name='3', className='A', " +
                "foodPref='V'},Student{name='7', className='A', foodPref='V'},]");
        expectedOutput.add("BNV: [Student{name='12', className='B', foodPref='NV'},Student{name='4', className='B', " +
                "foodPref='NV'},Student{name='9', className='B', foodPref='NV'},]");
        expectedOutput.add("BV: [Student{name='1', className='B', foodPref='V'},Student{name='5', className='B', " +
                "foodPref='V'},Student{name='10', className='B', foodPref='V'},]");
        expectedOutput.add("NA: [Student{name='13', className='A', foodPref='NV'},]");

        registerStudentV2();
        registrationService.assignHouseToStudents();
        List<String> resultAfterOnboarding = registrationService.getResultAfterOnboarding();
        Assert.assertEquals(resultAfterOnboarding, expectedOutput);

    }
}