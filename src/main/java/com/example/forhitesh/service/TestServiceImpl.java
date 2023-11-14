package com.example.forhitesh.service;

import com.example.forhitesh.dto.TestDTO;
import com.example.forhitesh.errorhandling.UserNotFound;
import com.example.forhitesh.mapping.TestMapping;
import com.example.forhitesh.model.TestModel;
import com.example.forhitesh.repository.PostGrestRepoTest;
import com.example.forhitesh.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    //Inject the repo class using DI
    @Autowired
    TestRepository reposit;

    @Autowired
    PostGrestRepoTest actualDBInsert;
//    @Override
//    public TestDTO getDefaultData() {
//        //Mapping of entity to DTO takes place here and DTO is returned moved to level
//        //above.
//        TestModel theActualPayload = reposit.getTheData();
//        return TestMapping.MAPPED.mapThis(theActualPayload);
//    }

    @Override
    public TestModel getDefaultData() {
        //Mapping of entity to DTO takes place here and DTO is returned moved to level
        //above.
        TestModel theActualPayload = reposit.getTheData();
        return theActualPayload;
        //return TestMapping.MAPPED.mapThis(theActualPayload);
    }


    //LOMBOK implementation
    @Override
    public TestDTO getDefaultDataLOMBOK() {
        //Mapping of entity to DTO takes place here and DTO is returned moved to level
        //above.

        //TO Remove some data from payload individually map your model(Entity) to your
        //DTO
        TestModel theActualPayload = reposit.getTheData();
        System.out.println("Name " + theActualPayload.getName());
        return TestMapping.MAPPED.mapThis(theActualPayload);
    }

    @Override
    public String enterData(TestDTO dataToEnter){
    return reposit.enterData(dataToEnter);
    }

    @Override
    public String enterDataToPostgres(TestDTO dataToEnter){
       // System.out.println("ID IS "+ dataToEnter.getIdentity());
       // System.out.println("Name is " + dataToEnter.getName());
        actualDBInsert.save(TestMapping.MAPPED.unmapThis(dataToEnter));
       return "Successful";
    }

    public TestDTO getSpecificTestData(int whichData){
    return TestMapping.MAPPED.mapThis(reposit.getSpecificTestData(whichData));
    };


    public List<TestModel> getDefaultDataFromDB(){
        return actualDBInsert.findAll();
    }

    @Override
    public TestDTO updateTestData(int dataID, TestDTO theUpdatePayload){
        //Find first if the user exists, if not throw error and bounce out here,
        //otherwise if the user exists then do the things and update the user.
        //What happens to the ID retrieved payload instance, it needs to get pushed back with
        //new data yet keep the same ID????
        Optional<TestModel> value =  actualDBInsert.findById(dataID);
        TestModel toBeUpdated;
        if(!(value.isEmpty())){
            //actualDBInsert
            toBeUpdated= value.get();
            toBeUpdated.setName(theUpdatePayload.getName());
            toBeUpdated.setAge(theUpdatePayload.getAge());
            toBeUpdated.setOccupation(theUpdatePayload.getOccupation());
            toBeUpdated.setCountryOrigin(theUpdatePayload.getCountryOrigin());
            //toBeUpdated.setIdentity(toBeUpdated.getIdentity());
            actualDBInsert.save(toBeUpdated);
            return TestMapping.MAPPED.mapThis(toBeUpdated);
        }else {
            throw new UserNotFound("User Not Found For Editing");
        }
    };

    @Override
    public TestDTO updateSpecificTestData(int dataID, TestDTO updateData){

        return null;
    };

    @Override
    public Optional<List<TestModel>> getUserWithSpecificAge(int age){
        return actualDBInsert.getUsersWithSpecificAge(age);
    }


}
