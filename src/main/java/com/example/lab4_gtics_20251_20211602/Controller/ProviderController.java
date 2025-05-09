package com.example.lab4_gtics_20251_20211602.Controller;

import com.example.lab4_gtics_20251_20211602.Entity.Provider;
import com.example.lab4_gtics_20251_20211602.Repository.ProviderRepository;
import com.example.lab4_gtics_20251_20211602.Repository.EquipmentTypeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    ProviderRepository providerRepo;

    @Autowired
    EquipmentTypeRepository equipmentRepo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaProveedores", providerRepo.findAll());
        return "providers/list";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("proveedor", new Provider());
        model.addAttribute("tipos", equipmentRepo.findAll());
        return "providers/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("proveedor") @Valid Provider proveedor, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("tipos", equipmentRepo.findAll());
            return "providers/form";
        }
        providerRepo.save(proveedor);
        return "redirect:/providers";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        Optional<Provider> opt = providerRepo.findById(id);
        if (opt.isPresent()) {
            model.addAttribute("proveedor", opt.get());
            model.addAttribute("tipos", equipmentRepo.findAll());
            return "providers/form";
        } else {
            return "redirect:/providers";
        }
    }

    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable("id") int id) {
        providerRepo.deleteById(id);
        return "redirect:/providers";
    }
}
