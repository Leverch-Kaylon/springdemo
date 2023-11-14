package com.example.forhitesh.service;

import com.example.forhitesh.dto.TestDTO;
import com.example.forhitesh.model.TestModel;

import java.util.List;
import java.util.Optional;

public interface TestService {
    TestDTO getDefaultDataLOMBOK();
    TestModel getDefaultData();

    List<TestModel> getDefaultDataFromDB();

    String enterData(TestDTO dataToEnter);

    String enterDataToPostgres(TestDTO dataToEnter);

    TestDTO getSpecificTestData(int whichData);

    TestDTO updateTestData(int dataID, TestDTO updateData);

    TestDTO updateSpecificTestData(int dataID, TestDTO updateData);

    Optional<List<TestModel>> getUserWithSpecificAge(int age);

}
