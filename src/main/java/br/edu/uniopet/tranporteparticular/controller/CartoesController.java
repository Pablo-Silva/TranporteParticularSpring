package br.edu.uniopet.tranporteparticular.controller;

import br.edu.uniopet.tranporteparticular.model.Cartoes;
import br.edu.uniopet.tranporteparticular.repository.CartoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartoesController {

    @Autowired
    CartoesRepository cartoesRepository;

    @GetMapping
    public List<Cartoes> list(){return cartoesRepository.findAll();}

    // Mapeia um Cartao pelo seu ID
    @GetMapping("/{idCartoes}")
    public Cartoes findById(@PathVariable Long idCartoes){
        return cartoesRepository.findById(idCartoes).get();
    }

}
