package com.study.gtnext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.study.gtnext.entity.Localita;

public interface LocalitaRepo extends JpaRepository<Localita, Long>{
    
    @Query("SELECT l FROM Localita l WHERE l.posti>700")
    public List<Localita> findBigPosti();
}
