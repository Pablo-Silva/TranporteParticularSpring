package br.edu.uniopet.tranporteparticular.controller;


import br.edu.uniopet.tranporteparticular.model.Cliente;
import br.edu.uniopet.tranporteparticular.model.Pessoa;
import br.edu.uniopet.tranporteparticular.repository.ClienteRepository;
import br.edu.uniopet.tranporteparticular.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    ClienteRepository clienteRepository;


    // Mapeia uma lista de Pessoas
    @GetMapping
    public List<Pessoa> list(){return pessoaRepository.findAll();}

    // Mapeia uma Pessoa pelo seu ID
    @GetMapping("/{idPessoa}")
    public Pessoa findById(@PathVariable Long idPessoa){
        return pessoaRepository.findById(idPessoa).get();
    }
}
