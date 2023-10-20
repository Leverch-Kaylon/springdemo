package com.example.forhitesh.repository;

import com.example.forhitesh.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostGrestRepoTest extends JpaRepository<TestModel,Integer> {
}
