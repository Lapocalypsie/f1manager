package com.f1manager.demo.Formula1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface F1Repository extends JpaRepository<F1, Integer> {
    @Query("SELECT f.id FROM F1 f")
    List<Integer> findAllF1Ids();
}
