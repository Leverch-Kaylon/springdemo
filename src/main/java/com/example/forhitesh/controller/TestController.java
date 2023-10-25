package com.example.forhitesh.controller;

import com.example.forhitesh.dto.TestDTO;
import com.example.forhitesh.mapping.TestMapping;
import com.example.forhitesh.model.TestModel;
import com.example.forhitesh.service.TestService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    //Inject service using DP
    //What is reason for injecting the interface instead
    // of inject actual implementation class??
    @Autowired
    TestService service;

    @GetMapping("/helloTest")
    String helloWorldTest(){
        return "Hi There latest version of spring is SPRING 6, Spring boot is Spring boot 3 :)";
    }

    //Non DTO version of endpoint
    @GetMapping("/getData")
    ResponseEntity<TestModel> getTestData(){
        //Call service here to do logic
        TestModel dataHere =  service.getDefaultData();
        return new ResponseEntity<>(dataHere,HttpStatus.OK);
    }

    //LOMBOK example
    @GetMapping("/getDataLOMBOK")
    ResponseEntity<TestDTO> getTestDataLOMBOK(){
        //Call service here to do logic
        TestDTO dataHere =  service.getDefaultDataLOMBOK();
        return new ResponseEntity<>(dataHere,HttpStatus.OK);
    }

    //LOMBOK example
    @GetMapping("/getDataFromDB")
    ResponseEntity<List<TestModel>> getTestDataFromDB(){
        //Call service here to do logic
        List<TestModel> dataHere =  service.getDefaultDataFromDB();
        return new ResponseEntity<>(dataHere,HttpStatus.OK);
    }


    //Why does at RequestParam throw a badrequest error investigate
    @PostMapping("/enterData")
    String enterTestData(@Valid @RequestBody TestModel enteredData){
      //  String enterTestData(@RequestParam TestModel enteredData){
        //Is it good to map it here or map it in the service class DO I even need to map it?
        TestDTO theInput = TestMapping.MAPPED.mapThis(enteredData);
        //return service.enterData(theInput);
        return service.enterDataToPostgres(theInput);
    }

    //Path Variable example
    @GetMapping("/getThis/{parameterMe}")
    ResponseEntity<TestDTO> pathVariableRequest(@PathVariable int parameterMe){
        return new ResponseEntity<>(service.getSpecificTestData(parameterMe),HttpStatus.OK);
    }

    //Put mapping
    //What exactly happens if put data does not match for some reason??
    //How does update/put work? Do you need to push the whole body or just updated bits??
    //From what I understand, this if resource is found just entirely replaces it otherwise
    //just add new one if not, becomes POST if resource does not exist
    @PutMapping(value = "/updateUser/{userID}")
    TestDTO updateSomething(@PathVariable Integer userID,@RequestBody TestModel data){
        //Push to service where to check if the user exists first then update it, note put updates the whole thing
        return service.updateTestData(userID,TestMapping.MAPPED.mapThis(data));
    }

    //Only updates what is sent???But in terms of actual mapping how will that work if you do not know what is sent??
    @PatchMapping("/updateFewThings")
    void updateOnlyFewThings(){

    }

}
