package com.f1manager.demo.Personnel.Mecanicien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MecanicienRepository extends JpaRepository<Mecanicien, Integer> {
    @Query("SELECT m.id FROM Mecanicien m")
    List<Integer> findAllMecanoIds();
}