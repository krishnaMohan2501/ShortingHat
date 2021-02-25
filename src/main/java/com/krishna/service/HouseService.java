package com.krishna;


import com.krishna.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
public class HouseService {

    Map<String, Map<String, Student>> av;
    Map<String, Map<String, Student>> anv;
    Map<String, Map<String, Student>> bv;
    Map<String, Map<String, Student>> bnv;
    Map<String, Map<String, Student>> na;

    public HouseService() {
        av = new HashMap<>();
        anv = new HashMap<>();
        bv = new HashMap<>();
        bnv = new HashMap<>();
        na = new HashMap<>();
        initializeHousesWithLabel();
    }

    private void initializeHousesWithLabel() {
        av.put("AV", new HashMap<String, Student>());
        anv.put("ANV", new HashMap<String, Student>());
        bv.put("BV", new HashMap<String, Student>());
        bnv.put("BNV", new HashMap<String, Student>());
        na.put("NA", new HashMap<String, Student>());

    }

    public void assignHouse(String key, String studentName, Student student){


        if(key.equals("AV")){
            av.get("AV").putIfAbsent(studentName, student);
        }else if(key.equals("ANV")){
            anv.get("ANV").putIfAbsent(studentName, student);
        }else if(key.equals("BV")){
            bv.get("BV").putIfAbsent(studentName, student);
        }else if(key.equals("BNV")){
            bnv.get("BNV").putIfAbsent(studentName, student);

        }

    }

    public List<String> getResultBasedOnHouses(){

        List<String> results = new ArrayList<>();
        updateResultForANV(results);
        updateResultForAV(results);
        updateResultForBNV(results);
        updateResultForBV(results);
        updateResultForNA(results);

        return results;


    }

    public void notAssignAnyHouse(String studentName, Student student) {
        na.get("NA").putIfAbsent(studentName, student);
    }

    private void updateResultForANV(List<String> results){
        String anvResult = "ANV: " + "[";
        for (Map.Entry<String,Student> entry : anv.get("ANV").entrySet()){
            anvResult = anvResult + entry.getValue().toString() + ",";
        }
        results.add(anvResult + "]");

    }
    private void updateResultForBV(List<String> results){
        String bvResult = "BV: " + "[";
        for (Map.Entry<String,Student> entry : bv.get("BV").entrySet()){
            bvResult = bvResult + entry.getValue().toString() + ",";
        }
        results.add(bvResult + "]");

    }
    private void updateResultForAV(List<String> results){
        String avResult = "AV: " + "[";
        for (Map.Entry<String,Student> entry : av.get("AV").entrySet()){
            avResult = avResult + entry.getValue().toString() + ",";
        }
        results.add(avResult+ "]");


    }
    private void updateResultForBNV(List<String> results){
        String bnvResult = "BNV: " + "[";
        for (Map.Entry<String,Student> entry : bnv.get("BNV").entrySet()){
            bnvResult = bnvResult + entry.getValue().toString() + ",";
        }
        results.add(bnvResult + "]");

    }

    private void updateResultForNA(List<String> results){
        String naResult = "NA: " + "[";
        for (Map.Entry<String,Student> entry : na.get("NA").entrySet()){
            naResult = naResult + entry.getValue().toString() + ",";
        }

        results.add(naResult + "]");

    }
}