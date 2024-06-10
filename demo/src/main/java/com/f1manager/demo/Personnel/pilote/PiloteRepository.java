package com.f1manager.demo.Personnel.pilote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PiloteRepository extends JpaRepository<Pilote, Integer> {
    @Query("SELECT p.id FROM Pilote p")
    List<Integer> findAllPiloteIds();
}
