package com.example.lab5gtics.controller;

import com.example.lab5gtics.entity.Mascota;
import com.example.lab5gtics.entity.Persona;
import com.example.lab5gtics.repository.LugarRepository;
import com.example.lab5gtics.repository.MascotaRepository;
import com.example.lab5gtics.repository.PersonaRepository;
import com.example.lab5gtics.repository.ViajeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
        return "persona/newFrmPersona";
    }

    @PostMapping("/save")
    public String guardarPersona(Persona persona, RedirectAttributes attr) {
        personaRepository.save(persona);
        return "redirect:/persona";
    }


    @GetMapping("/delete")
    public String borrarPersona(Model model,
                                @RequestParam("id") int id,
                                RedirectAttributes attr) {
        Optional<Persona> persona = personaRepository.findById(id);
        if (persona.isPresent()) {
            personaRepository.deleteById(id);
        }
        return "redirect:/persona";
    }


}
