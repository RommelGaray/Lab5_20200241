package com.example.lab5gtics.controller;

import com.example.lab5gtics.entity.Viaje;
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
@RequestMapping("/viaje")
public class ViajeController {

    final ViajeRepository viajeRepository;
    final PersonaRepository personaRepository;
    final MascotaRepository mascotaRepository;
    final LugarRepository lugarRepository;

    public ViajeController(ViajeRepository viajeRepository, PersonaRepository personaRepository, MascotaRepository mascotaRepository, LugarRepository lugarRepository) {
        this.viajeRepository = viajeRepository;
        this.personaRepository = personaRepository;
        this.mascotaRepository = mascotaRepository;
        this.lugarRepository = lugarRepository;
    }


    @GetMapping(value = {"/", ""})
    public String listaViajes(Model model) {
        model.addAttribute("listaViajes", viajeRepository.findAll());
        return "viaje/listViaje";
    }

    @GetMapping("/newForm")
    public String newFormViaje(Model model) {
        model.addAttribute("listaPersonas",personaRepository.findAll());
        model.addAttribute("listaLugares",lugarRepository.findAll());
        return "viaje/newFrmViaje";
    }


    @PostMapping("/save")
    public String guardarViaje(Viaje viaje, RedirectAttributes attr) {
        viajeRepository.save(viaje);
        return "redirect:/viaje";
    }


    @GetMapping("/delete")
    public String borrarViaje(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {
        Optional<Viaje> optProduct = viajeRepository.findById(id);
        if (optProduct.isPresent()) {
            viajeRepository.deleteById(id);
        }
        return "redirect:/viaje";
    }



}
