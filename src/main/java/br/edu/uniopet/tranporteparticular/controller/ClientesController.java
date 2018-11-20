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
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping
    public List<Cliente> list(){
        return clienteRepository.findAll();
    }

    // Mapeia um Cliente pelo seu ID
    @GetMapping("/{idCliente}")
    public Cliente findById(@PathVariable Long idCliente){
        return clienteRepository.findById(idCliente).get();
    }

    @GetMapping("/nome/{nomeCliente}")
    public Cliente findById(@PathVariable String nomeCliente){
        return clienteRepository.findClienteByNomeCliente(nomeCliente);
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public ResponseEntity<Cliente> cadastrarCleinte(@RequestBody Cliente cliente){

        clienteRepository.save(cliente);

        return ResponseEntity.created(null).body(cliente);

    }
}
