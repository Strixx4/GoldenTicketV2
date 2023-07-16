package com.study.gtnext.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.study.gtnext.entity.Evento;

public interface EventoRepo extends JpaRepository<Evento,Long>{
    
    @Query("SELECT e FROM Evento e ORDER BY RAND()")
    public List<Evento> FindWithLimit();

    @Query("SELECT e FROM Evento e WHERE e.localita.citta= :citta")
    public Page<Evento> findByCitta(Pageable pageable,@Param("citta") String citta);
}
