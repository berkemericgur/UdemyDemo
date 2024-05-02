package com.example.udemydemo.repository;

import com.example.udemydemo.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {


}
