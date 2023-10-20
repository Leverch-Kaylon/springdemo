package com.example.forhitesh.mapping;


import com.example.forhitesh.dto.TestDTO;
import com.example.forhitesh.model.TestModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//To use this with LOMBOK need to add added config to POM
//Why does this not auto generate implementation class for me??! Eish
@Mapper(componentModel = "spring")
public interface TestMapping {
    TestMapping MAPPED = Mappers.getMapper(TestMapping.class);

    TestDTO mapThis(TestModel modelInstance);

    TestModel unmapThis(TestDTO dtoInstance);
}
