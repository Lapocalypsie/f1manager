package com.f1manager.demo.Personnel.pilote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiloteRepository extends JpaRepository<Pilote, Integer> {
}
