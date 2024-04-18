package com.f1manager.demo.Formula1.Moteurs;

import com.f1manager.demo.Formula1.F1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoteursRepository extends JpaRepository<F1, Integer> {
}
