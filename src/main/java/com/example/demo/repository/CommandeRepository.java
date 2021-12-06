package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
