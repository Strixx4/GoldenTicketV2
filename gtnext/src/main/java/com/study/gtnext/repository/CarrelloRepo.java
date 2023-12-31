package com.study.gtnext.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.study.gtnext.entity.Carrello;

public interface CarrelloRepo extends JpaRepository<Carrello,Long> {

    @Query("Select c FROM Carrello c where c.customer.id = :id")
    public List<Carrello> findByUserName(@Param("id")Long id);
}
