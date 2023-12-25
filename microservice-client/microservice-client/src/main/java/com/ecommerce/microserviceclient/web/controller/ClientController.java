package com.ecommerce.microserviceclient.web.controller;

import com.ecommerce.microserviceclient.beans.VoitureBean;
import com.ecommerce.microserviceclient.proxies.MicroserviceProduitsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private MicroserviceProduitsProxy ProduitsProxy;

    @RequestMapping("/")
    public String accueil(Model model){
        List<VoitureBean> voitures =  ProduitsProxy.getAllVoitures();

        model.addAttribute("voitures", voitures);

        return "Accueil";
    }


    @RequestMapping("/details-voiture/{id}")
    public String ficheVoiture(@PathVariable int id, Model model){

        VoitureBean voiture = ProduitsProxy.getVoitureById(id);

        model.addAttribute("voiture", voiture);

        return "FicheVoiture";
    }
    @PostMapping("/ajoutervoiture")
    public String commande( @Valid @RequestBody VoitureBean voiture){
        VoitureBean voitureBeanResponseEntity=ProduitsProxy.createVoiture(voiture);

        return null;
}}
