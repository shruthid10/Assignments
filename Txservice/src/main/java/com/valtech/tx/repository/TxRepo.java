package com.valtech.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.tx.entities.Tx;

public interface TxRepo extends JpaRepository<Tx, Long> {

}
