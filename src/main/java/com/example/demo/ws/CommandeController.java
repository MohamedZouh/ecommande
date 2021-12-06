package com.example.demo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Commande;
import com.example.demo.service.CommandeService;

@RequestMapping("/api/commande")
@RestController
public class CommandeController {

	@Autowired
	private CommandeService commandeService;

	@GetMapping("/")
	public ResponseEntity<List<Commande>> findAll() {
		List<Commande> commandes = commandeService.findAll();
		return new ResponseEntity<>(commandes, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Commande> findById(@RequestParam Long id) {
		Commande commande = commandeService.findOne(id);
		return new ResponseEntity<>(commande, HttpStatus.OK);
	}

	@PostMapping("/")
	public String save(@RequestBody Commande cmd) {
		commandeService.save(cmd);
		return "commande ajoutée avec succès";
	}

	@PutMapping("/")
	public String update(@RequestBody Commande cmd) {
		commandeService.update(cmd);
		return "Commande modifié avec succès";
	}

	@DeleteMapping("/id/{id}")
	public String delete(@RequestParam Long id) {
		commandeService.delete(id);
		return "Commande modifié avec succès";
	}

}
