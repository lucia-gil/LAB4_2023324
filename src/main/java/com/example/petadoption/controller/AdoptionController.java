package com.example.petadoption.controller;

import com.example.petadoption.model.Adoption;
import com.example.petadoption.repository.AdopterRepository;
import com.example.petadoption.repository.AdoptionRepository;
import com.example.petadoption.repository.PetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/adoptions")
public class AdoptionController {

    private final AdoptionRepository adoptionRepository;
    private final PetRepository petRepository;
    private final AdopterRepository adopterRepository;

    public AdoptionController(AdoptionRepository adoptionRepository,
                               PetRepository petRepository,
                               AdopterRepository adopterRepository) {
        this.adoptionRepository = adoptionRepository;
        this.petRepository = petRepository;
        this.adopterRepository = adopterRepository;
    }

}
