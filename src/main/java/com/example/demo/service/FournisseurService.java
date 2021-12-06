package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Fournisseur;
import com.example.demo.repository.FournisseurRepository;

@Service
public class FournisseurService {

	@Autowired
	private FournisseurRepository fournisseurRepository;

	public void saveAll(List<Fournisseur> fournisseurs) {
		for(Fournisseur fournisseur:fournisseurs) {
			fournisseurRepository.save(fournisseur);
		}
	}

	public List<Fournisseur> findAll() {
		List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
		return fournisseurs;
	}

	public Fournisseur findOne(Long id) {
		Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
		return fournisseur.get();
	}

	public List<Fournisseur> findByAddress(String address) {
		List<Fournisseur> fournisseurs = fournisseurRepository.findByAddress(address);
		return fournisseurs;
	}

	public void update(Fournisseur fournisseur) {
		fournisseurRepository.save(fournisseur);
	}

	public void delete(Long id) {
		fournisseurRepository.deleteById(id);
	}

}
