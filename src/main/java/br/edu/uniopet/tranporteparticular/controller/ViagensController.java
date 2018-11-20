package br.edu.uniopet.tranporteparticular.controller;

import br.edu.uniopet.tranporteparticular.model.Viagem;
import br.edu.uniopet.tranporteparticular.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/viagens")
public class ViagensController {

    @Autowired
    ViagemRepository viagemRepository;

    @GetMapping
    public List<Viagem> list(){return viagemRepository.findAll();}

    // Mapeia um Motorista pelo seu ID
    @GetMapping("/{idViagem}")
    public Viagem findById(@PathVariable Long idViagem){
        return viagemRepository.findById(idViagem).get();
    }
}
