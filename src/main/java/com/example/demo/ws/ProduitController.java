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

import com.example.demo.model.Produit;
import com.example.demo.service.ProduitService;

@RequestMapping("/api/produit")
@RestController
public class ProduitController {

	@Autowired
	private ProduitService ProduitService;

	@GetMapping("/")
	public ResponseEntity<List<Produit>> findAll() {
		List<Produit> produits = ProduitService.findAll();
		return new ResponseEntity<>(produits, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Produit> findById(@PathVariable int id) {
		Produit produit = ProduitService.findOne(id);
		return new ResponseEntity<>(produit, HttpStatus.OK);
	}

	@GetMapping("/libelle/{libelle}")
	public ResponseEntity<List<Produit>> findByLibelle(@PathVariable String libelle) {
		List<Produit> produit = ProduitService.findByLibelle(libelle);
		return new ResponseEntity<>(produit, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<String> save(@RequestBody List<Produit> produits) {
		ProduitService.saveAll(produits);
		return new ResponseEntity<>("Produit ajouter avec succès", HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<String> update(@RequestBody Produit produit) {
		ProduitService.update(produit);
		return new ResponseEntity<>("Produit modifié avec succès", HttpStatus.OK);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		ProduitService.delete(id);
		return new ResponseEntity<>("Produit supprimé avec succès", HttpStatus.OK);
	}

}
