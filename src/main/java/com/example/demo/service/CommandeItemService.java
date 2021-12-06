package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Commande;
import com.example.demo.model.CommandeItem;
import com.example.demo.repository.CommandeItemRepository;
import com.example.demo.repository.CommandeRepository;

@Service
public class CommandeItemService {

	@Autowired
	private CommandeItemRepository commandeItemRepository;
	@Autowired
	private CommandeRepository commandeRepository;

	public void save(CommandeItem commandeItem) {
		commandeItemRepository.save(commandeItem);
	}

	public List<CommandeItem> findAllByCommande(long commandeId) {
		Commande commande = commandeRepository.getById(commandeId);
		List<CommandeItem> commandeItems = commande.getCommandeItems();
		return commandeItems;
	}

	public CommandeItem find(long id) {
		CommandeItem commandeItem = commandeItemRepository.getById(id);

		return commandeItem;
	}

	public void update(CommandeItem commandeItem) {
		commandeItemRepository.save(commandeItem);
	}

	public void delete(long id) {
		commandeItemRepository.deleteById(id);
	}
}
