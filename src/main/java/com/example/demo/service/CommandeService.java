package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Commande;
import com.example.demo.model.CommandeItem;
import com.example.demo.repository.CommandeItemRepository;
import com.example.demo.repository.CommandeRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private CommandeItemRepository commandeItemRepository;

	public void save(Commande commande) {
		List<CommandeItem> commandeItems = commande.getCommandeItems();
		commandeRepository.save(commande);

		if (commandeItems != null)
			for (CommandeItem commandeItem : commandeItems) {
				commandeItemRepository.save(commandeItem);
			}
	}

	public List<Commande> findAll() {
		List<Commande> commandes = commandeRepository.findAll();
		return commandes;
	}

	public Commande findOne(Long id) {
		Optional<Commande> commande = commandeRepository.findById(id);
		return commande.get();
	}

	public void update(Commande commande) {
		commandeRepository.save(commande);
	}

	@Transactional
	public void delete(Long id) {
		Commande commande = commandeRepository.findById(id).get();
		List<CommandeItem> commandeItems = commande.getCommandeItems();
		for (CommandeItem commandeItem : commandeItems) {
			commandeItemRepository.delete(commandeItem);
		}
		commandeRepository.deleteById( id);
	}
}
