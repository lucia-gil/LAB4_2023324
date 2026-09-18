package com.example.petadoption.controller;

import com.example.petadoption.model.Pet;
import com.example.petadoption.repository.PetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping
    public String listado(Model model) {
        model.addAttribute("pets", petRepository.listarDisponibles());
        return "pets/listado";
    }
    @GetMapping("/editar")
    public String editar(@RequestParam("id") Integer id, Model model) {
        Pet pet = petRepository.buscarPorId(id);
        model.addAttribute("pet", pet);
        return "pets/editar";
    }

    @PostMapping("/actualizar")
    public String actualizar(Pet pet) {
        petRepository.actualizarDatosBasicos(
                pet.getPetId(), pet.getName(), pet.getBreed(), pet.getAge(), pet.getSex(), pet.getSize());
        return "redirect:/pets";
    }

}
