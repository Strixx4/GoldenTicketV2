package com.study.gtnext.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.gtnext.entity.Artista;

public interface ArtistaRepo extends JpaRepository<Artista,Long>{
    
}
