package com.example.lab4_gtics_20251_20211602.Controller;

import com.example.lab4_gtics_20251_20211602.Entity.Tower;
import com.example.lab4_gtics_20251_20211602.Repository.TowerRepository;
import com.example.lab4_gtics_20251_20211602.Repository.TowerStateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/torres")
public class TowerController {

    @Autowired
    TowerRepository towerRepository;

    @Autowired
    TowerStateRepository towerStateRepository;

    @GetMapping("")
    public String listar(Model model) {
        model.addAttribute("listaTorres", towerRepository.findAll());
        return "tower/list";
    }

    @GetMapping("/nuevo")
    public String nuevaTorreForm(Model model) {
        model.addAttribute("tower", new Tower());
        model.addAttribute("listaEstados", towerStateRepository.findAll());
        return "tower/form";
    }

    @PostMapping("/guardar")
    public String guardarTorre(@ModelAttribute("tower") @Valid Tower tower,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listaEstados", towerStateRepository.findAll());
            return "tower/form";
        }
        towerRepository.save(tower);
        return "redirect:/torres";
    }

    @GetMapping("/editar/{id}")
    public String editarTorre(@PathVariable("id") int id, Model model) {
        model.addAttribute("tower", towerRepository.findById(id).orElse(null));
        model.addAttribute("listaEstados", towerStateRepository.findAll());
        return "tower/form";
    }

    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable("id") int id) {
        towerRepository.deleteById(id);
        return "redirect:/torres";
    }
}
