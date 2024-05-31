package com.f1manager.demo.Personnel.Mecanicien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MecanicienRepository extends JpaRepository<Mecanicien, Integer> {
}