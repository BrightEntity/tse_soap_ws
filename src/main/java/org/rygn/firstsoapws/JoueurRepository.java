package org.rygn.firstsoapws;

import io.spring.guides.gs_producing_web_service.Joueur;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class JoueurRepository {
    private static final Map<String, Joueur> joueurs = new HashMap<>();

    @PostConstruct
    public void initData() {
        Joueur j1 = new Joueur();
        j1.setPrenom("Neymar");
        j1.setNom("da Silva Santos Junior");

        joueurs.put("Neymar", j1);
    }

    public Joueur findJoueur(String nom) {
        return joueurs.get(nom);
    }
}
