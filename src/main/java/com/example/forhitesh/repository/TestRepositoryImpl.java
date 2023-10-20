package com.example.forhitesh.repository;

import com.example.forhitesh.dto.TestDTO;
import com.example.forhitesh.model.TestModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TestRepositoryImpl implements TestRepository{
    @Override
    public TestModel getTheData() {
        //For demonstration purpose data static
        TestModel modelTest = new TestModel();
        modelTest.setName("Leverch");
        modelTest.setAge(19);
        modelTest.setCountryOrigin("ZA");
        modelTest.setOccupation("Snr Developer");
        return modelTest;
    }

    @Override
    public String enterData(TestDTO dataToEnter){
        System.out.println("THE DATA MADE IT TO THE REPO FOR ENTRY");
        System.out.println(dataToEnter.getName());
    return "Data Successfully added -- Once DB is set up it will be Anyway, the dev is "
             + dataToEnter.getName() +
            "\n" + " The Position is " + dataToEnter.getOccupation() + "\n" +
            " From Country " + dataToEnter.getCountryOrigin()
            ;

    }

    public TestModel getSpecificTestData(int whichData){
        List<TestModel> allDataStoredInDB = new ArrayList<>();
        allDataStoredInDB.add(new TestModel(2,"James",20,"Zim","Tester"));
        allDataStoredInDB.add(new TestModel(3,"Marco",22,"Angola","Pilot"));

    return allDataStoredInDB.get(whichData);
    };
}
