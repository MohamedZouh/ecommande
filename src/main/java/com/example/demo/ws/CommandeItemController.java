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

import com.example.demo.model.CommandeItem;
import com.example.demo.service.CommandeItemService;

@RestController
@RequestMapping("/api/commandeitems")
public class CommandeItemController {

	@Autowired
	private CommandeItemService commandeItemService;

	@GetMapping("/idCommande/{commandeId}/items/")
	public ResponseEntity<List<CommandeItem>> findAllByCommande(@RequestParam long commandeId) {
		List<CommandeItem> commandeItems = commandeItemService.findAllByCommande(commandeId);
		return new ResponseEntity<>(commandeItems, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<CommandeItem> findOne(@RequestParam long id) {
		CommandeItem commandeItem = commandeItemService.find(id);
		return new ResponseEntity<>(commandeItem, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<String> save(@RequestBody List<CommandeItem> commandeItems) {
		for(CommandeItem commandeItem:commandeItems) {
		commandeItemService.save(commandeItem);
		}
		return new ResponseEntity<>("commande ajoutée avec succès", HttpStatus.OK);
	}

	@PutMapping("/")
	public String update(@RequestBody CommandeItem cmdItem) {
		commandeItemService.update(cmdItem);
		return "Commande modifié avec succès";
	}

	@DeleteMapping("/id/{id}")
	public String delete(@RequestParam int id) {
		commandeItemService.delete(id);
		return "Commande modifié avec succès";
	}

}
