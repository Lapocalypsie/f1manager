package com.f1manager.demo.Formula1.wheels;

import com.f1manager.demo.Formula1.F1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface wheelsRepository extends JpaRepository<F1, Integer> {
}
