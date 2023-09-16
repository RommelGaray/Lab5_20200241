package com.example.lab5gtics.controller;


import com.example.lab5gtics.entity.Mascota;
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
@RequestMapping("/mascota")
public class MascotaController {

    final ViajeRepository viajeRepository;
    final PersonaRepository personaRepository;
    final MascotaRepository mascotaRepository;
    final LugarRepository lugarRepository;

    public MascotaController(ViajeRepository viajeRepository, PersonaRepository personaRepository, MascotaRepository mascotaRepository, LugarRepository lugarRepository) {
        this.viajeRepository = viajeRepository;
        this.personaRepository = personaRepository;
        this.mascotaRepository = mascotaRepository;
        this.lugarRepository = lugarRepository;
    }




    @GetMapping(value = {"/", ""})
    public String listaMascota(Model model) {
        model.addAttribute("listaMascotas", mascotaRepository.findAll());
        return "mascota/listMascota";
    }

    @GetMapping("/newForm")
    public String newFormMascota(Model model) {
        model.addAttribute("listaPersonas",personaRepository.findAll());
        return "mascota/newFrmMascota";
    }


    @PostMapping("/save")
    public String guardarMascota(Mascota mascota, RedirectAttributes attr) {
        mascotaRepository.save(mascota);
        return "redirect:/mascota";
    }


    @GetMapping("/delete")
    public String borrarMascota(Model model,
                              @RequestParam("id") int id,
                              RedirectAttributes attr) {
        Optional<Mascota> mascota = mascotaRepository.findById(id);
        if (mascota.isPresent()) {
            mascotaRepository.deleteById(id);
        }
        return "redirect:/mascota";
    }



}
