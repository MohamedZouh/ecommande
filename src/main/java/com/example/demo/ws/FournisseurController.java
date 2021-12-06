package com.example.demo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Fournisseur;
import com.example.demo.service.FournisseurService;

@RequestMapping("/api/fournisseur")
@RestController
public class FournisseurController {

	@Autowired
	private FournisseurService fournisseurService;

	@GetMapping("/")
	public ResponseEntity<List<Fournisseur>> findAll() {
		List<Fournisseur> fournisseurs = fournisseurService.findAll();
		return new ResponseEntity<>(fournisseurs, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Fournisseur> findById(@PathVariable Long id) {
		Fournisseur fournisseur = fournisseurService.findOne(id);
		return new ResponseEntity<>(fournisseur, HttpStatus.OK);
	}

	@GetMapping("/adress/{addresse}")
	public ResponseEntity<List<Fournisseur>> findByAdress(@PathVariable String addresse) {
		List<Fournisseur> fournisseur = fournisseurService.findByAddress(addresse);
		return new ResponseEntity<>(fournisseur, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<String> save(@RequestBody List<Fournisseur> fournisseurs) {
		fournisseurService.saveAll(fournisseurs);
		return new ResponseEntity<>("Produit ajouter avec succès", HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<String> update(@RequestBody Fournisseur fournisseur) {
		fournisseurService.update(fournisseur);
		return new ResponseEntity<>("Produit modifié avec succès", HttpStatus.OK);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		fournisseurService.delete(id);
		return new ResponseEntity<>("Produit supprimé avec succès", HttpStatus.OK);
	}

}
