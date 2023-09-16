package com.example.lab5gtics.controller;

import com.example.lab5gtics.repository.LugarRepository;
import com.example.lab5gtics.repository.MascotaRepository;
import com.example.lab5gtics.repository.PersonaRepository;
import com.example.lab5gtics.repository.ViajeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persona")
public class PersonaController {

    final ViajeRepository viajeRepository;
    final PersonaRepository personaRepository;
    final MascotaRepository mascotaRepository;
    final LugarRepository lugarRepository;

    public PersonaController(ViajeRepository viajeRepository, PersonaRepository personaRepository, MascotaRepository mascotaRepository, LugarRepository lugarRepository) {
        this.viajeRepository = viajeRepository;
        this.personaRepository = personaRepository;
        this.mascotaRepository = mascotaRepository;
        this.lugarRepository = lugarRepository;
    }


    @GetMapping(value = {"/", ""})
    public String listaPersona(Model model) {
        model.addAttribute("listaPersonas", personaRepository.findAll());
        return "persona/listPersona";
    }

    @GetMapping("/newForm")
    public String newFormPersona(Model model) {
        model.addAttribute("listaPersonas",personaRepository.findAll());
        return "mascota/newFrmMascota";
    }




}
