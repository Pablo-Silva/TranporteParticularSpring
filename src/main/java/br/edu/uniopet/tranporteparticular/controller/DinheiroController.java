package br.edu.uniopet.tranporteparticular.controller;

import br.edu.uniopet.tranporteparticular.model.Dinheiro;
import br.edu.uniopet.tranporteparticular.repository.DinheiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dinheiros")
public class DinheiroController {

    @Autowired
    DinheiroRepository dinheiroRepository;

    @GetMapping
    public List<Dinheiro> list(){
        return dinheiroRepository.findAll();
    }

    // Mapeia um Dinheiro pelo seu ID
    @GetMapping("/{idDinheiro}")
    public Dinheiro findById(@PathVariable Long idDinheiro){
        return dinheiroRepository.findById(idDinheiro).get();
    }

}
