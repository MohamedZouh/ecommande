package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CategorieProduit;
import com.example.demo.repository.CategorieProduitRepository;

@Service
public class CategorieProduitService {

	@Autowired
	private CategorieProduitRepository categorieProduitRepository;

	public void saveAll(List<CategorieProduit> categories) {
		for(CategorieProduit categorie:categories) {
			categorieProduitRepository.save(categorie);
		}
	}

	public List<CategorieProduit> findAll() {
		List<CategorieProduit> categories = categorieProduitRepository.findAll();
		return categories;
	}

	public CategorieProduit findOne(Long id) {
		Optional<CategorieProduit> categorie = categorieProduitRepository.findById(id);
		return categorie.get();
	}

	public List<CategorieProduit> findByLibelle(String libelle) {
		List<CategorieProduit> categories = categorieProduitRepository.findByLibelle(libelle);
		return categories;
	}

	public void update(CategorieProduit cat) {
		categorieProduitRepository.save(cat);
	}

	public void delete(Long id) {
		categorieProduitRepository.deleteById(id);
	}

}
