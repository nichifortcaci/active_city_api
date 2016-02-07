package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by nick on 2/7/16.
 */
public interface CatRepository extends JpaRepository<Cat,Long> {
    List<Cat> findByName(String name);
}
