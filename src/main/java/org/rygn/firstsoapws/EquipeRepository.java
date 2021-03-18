package org.rygn.firstsoapws;

import io.spring.guides.gs_producing_web_service.Equipe;
import io.spring.guides.gs_producing_web_service.Joueur;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class EquipeRepository {
    private static final Map<String, Equipe> equipes = new HashMap<>();

    @PostConstruct
    public void initData() {
        Joueur j1 = new Joueur();
        j1.setPrenom("Neymar");
        j1.setNom("da Silva Santos Junior");

        Equipe psg = new Equipe();
        psg.setName("PSG");
        psg.getJoueurs().add(j1);

        equipes.put("PSG", psg);
    }

    public Equipe findEquipe(String name) {
        return equipes.get(name);
    }
}
