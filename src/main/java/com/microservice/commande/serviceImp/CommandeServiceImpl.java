package com.microservice.commande.serviceImp;
import com.microservice.commande.entity.Commande;
import com.microservice.commande.repository.CommandeRepository;
import com.microservice.commande.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService { // Implement the interface
    @Autowired
    private CommandeRepository commandeRepository;
    private int commandesLast;

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }       

    @Override
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Long id, Commande commande) {
        if (commandeRepository.existsById(id)) {
            commande.setId(id);
            return commandeRepository.save(commande);
        } else {
            throw new RuntimeException("Commande non trouvée");
        }
    }

    @Override
    public void deleteCommande(Long id) {
        if (commandeRepository.existsById(id)) {
            commandeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Commande non trouvée");
        }
    }
    @Override
    public List<Commande> getCommandeRecues(){
    LocalDate dateLimit = LocalDate.now().minusDays(commandesLast);
    return commandeRepository.findByDateAfter(dateLimit);
    }
}
