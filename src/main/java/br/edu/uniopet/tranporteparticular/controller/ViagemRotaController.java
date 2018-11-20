package br.edu.uniopet.tranporteparticular.controller;

import br.edu.uniopet.tranporteparticular.model.ViagemRota;
import br.edu.uniopet.tranporteparticular.repository.ViagemRotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/viagensRota")
public class ViagemRotaController {

    @Autowired
    ViagemRotaRepository viagemRotaRepository;

    @GetMapping
    public List<ViagemRota> list(){return viagemRotaRepository.findAll();}

    // Mapeia uma Rota de uma Viagem pelo seu ID
    @GetMapping("/{idViagemRota}")
    public ViagemRota findById(@PathVariable Long idViagemRota){
        return viagemRotaRepository.findById(idViagemRota).get();
    }

}
