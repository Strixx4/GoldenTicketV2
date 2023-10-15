package com.study.gtnext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.study.gtnext.entity.Acquisto;

public interface AcquistoRepo extends JpaRepository<Acquisto, Long> {

    @Query("Select a FROM Acquisto a where a.customer.id = :id")
    public List<Acquisto> findByUserName(@Param("id") Long id);

}
