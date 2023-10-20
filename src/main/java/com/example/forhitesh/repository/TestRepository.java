package com.example.forhitesh.repository;

import com.example.forhitesh.dto.TestDTO;
import com.example.forhitesh.model.TestModel;


//Returns entity direct from Repos
public interface TestRepository {

    TestModel getTheData();


    String enterData(TestDTO dataToEnter);

    TestModel getSpecificTestData(int whichData);
}
