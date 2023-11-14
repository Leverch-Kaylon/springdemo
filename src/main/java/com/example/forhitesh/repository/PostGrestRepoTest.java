package com.example.forhitesh.repository;

import com.example.forhitesh.model.TestModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PostGrestRepoTest extends JpaRepository<TestModel,Integer> {

    //Custom Query creation to search results based on age
    @Query(value = "SELECT * FROM testtable where age =:age",nativeQuery = true)
    Optional<List<TestModel>> getUsersWithSpecificAge(@Param("age") int age);
}
