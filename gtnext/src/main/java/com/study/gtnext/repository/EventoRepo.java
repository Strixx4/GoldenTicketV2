package com.study.gtnext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.study.gtnext.entity.Evento;

public interface EventoRepo extends JpaRepository<Evento,Long>{
    
    @Query("SELECT e FROM Evento e ORDER BY RAND()")
    public List<Evento> FindWithLimit();
}
