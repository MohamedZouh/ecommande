package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

	List<Fournisseur> findByAddress(String address);

}