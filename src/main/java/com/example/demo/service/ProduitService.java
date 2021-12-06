package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produit;
import com.example.demo.repository.ProduitRepository;

@Service
public class ProduitService {

	@Autowired
	private ProduitRepository produitRepository;

	public void saveAll(List<Produit> produits) {
		for(Produit produit:produits) {
			produitRepository.save(produit);
		}
	}

	public List<Produit> findAll() {
		List<Produit> produits = produitRepository.findAll();
		return produits;
	}

	public Produit findOne(long id) {
		Optional<Produit> produit = produitRepository.findById(id);
		return produit.get();
	}

	public List<Produit> findByLibelle(String lib) {
		List<Produit> produits = produitRepository.findByLibelle(lib);
		return produits;
	}

	public void update(Produit prd) {
		produitRepository.save(prd);
	}

	public void delete(Long id) {
		produitRepository.deleteById(id);
	}

	public void deleteByIds(ArrayList<Long> ids) {
		for (Long id : ids) {
			produitRepository.deleteById(id);
		}

	}

}
