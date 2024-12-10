package com.microservice.commande.service;

import com.microservice.commande.entity.Commande;

import java.util.List;
import java.util.Optional;

public interface CommandeService {
    List<Commande> getAllCommandes();
    Optional<Commande> getCommandeById(Long id);
    Commande createCommande(Commande commande);
    Commande updateCommande(Long id, Commande commande);
    void deleteCommande(Long id);
}
