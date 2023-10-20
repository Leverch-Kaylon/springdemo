package com.example.forhitesh.model;

//Can I use LOMBOK Proj here for getters/setters what is drawback to using this??

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

//To use Mapping with LOMBOK need to add added config to POM
//Why @data does not have no args constructor attached or allArgsCon -- Investigate here
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "testtable")
public class TestModel {
//Be advised that these will only work if @Valid annotation
//is added to incoming request body
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "identity")
     @Id
     int identity;

     @Column(name = "username")
     @NotNull
     String  name;

     @Column(name = "age")
     @Min(5)
     int age;

     @Column(name = "origin_country")
     String countryOrigin;

     @Column(name = "occupation")
     String occupation;


//    public String getOccupation() {
//        return occupation;
//    }
//
//    public void setOccupation(String occupation) {
//        this.occupation = occupation;
//    }
//
//
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

}
