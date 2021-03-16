package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Routes;
@Repository
public interface RotuesRepo extends JpaRepository<Routes, Integer> {

}
