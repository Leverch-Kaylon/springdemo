package com.example.forhitesh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
//What is drawback to using LOMBOK Project? it DOES NOT WORK HOW EVER, ROUGH
@Data
@AllArgsConstructor
public class TestDTO {
    String name;
    int identity;
    int age;
    String countryOrigin;
    String occupation;
    //String dtoTest = "This is the DTO Being returned";


//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getCountryOrigin() {
//        return countryOrigin;
//    }
//
//    public void setCountryOrigin(String countryOrigin) {
//        this.countryOrigin = countryOrigin;
//    }
//
//    public String getOccupation() {
//        return occupation;
//    }
//
//    public void setOccupation(String occupation) {
//        this.occupation = occupation;
//    }

}
