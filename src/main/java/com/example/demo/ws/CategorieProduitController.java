package com.example.demo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CategorieProduit;
import com.example.demo.service.CategorieProduitService;

@RequestMapping("/api/categorie")
@RestController
public class CategorieProduitController {

	@Autowired
	private CategorieProduitService categorieProduitService;

	@GetMapping("/")
	public ResponseEntity<List<CategorieProduit>> findAll() {
		List<CategorieProduit> categories = categorieProduitService.findAll();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<CategorieProduit> findById(@PathVariable Long id) {
		CategorieProduit categorie = categorieProduitService.findOne(id);
		return new ResponseEntity<>(categorie, HttpStatus.OK);
	}

	@GetMapping("/libelle/{libelle}")
	public ResponseEntity<List<CategorieProduit>> findByLibelle(@PathVariable String libelle) {
		List<CategorieProduit> categories = categorieProduitService.findByLibelle(libelle);
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

	@PostMapping(value = "/")
	public String save(@RequestBody List<CategorieProduit> categories) {
		categorieProduitService.saveAll(categories);
		return "Produit ajouter avec succès";
	}

	@PutMapping(value = "/")
	public String update(@RequestBody CategorieProduit cat) {
		categorieProduitService.update(cat);
		return "Produit modifié avec succès";
	}

	@DeleteMapping(value = "/id/{id}")
	public String delete(@PathVariable Long id) {
		categorieProduitService.delete(id);
		return "Produit supprimé avec succès";
	}

}
