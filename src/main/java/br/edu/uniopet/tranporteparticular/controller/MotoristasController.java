package br.edu.uniopet.tranporteparticular.controller;

import br.edu.uniopet.tranporteparticular.model.Motorista;
import br.edu.uniopet.tranporteparticular.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/motoristas")
public class MotoristasController {

    @Autowired
    MotoristaRepository motoristaRepository;

    @GetMapping
    public List<Motorista> list(){return motoristaRepository.findAll();}

    // Mapeia um Motorista pelo seu ID
    @GetMapping("/{idMotorista}")
    public Motorista findById(@PathVariable Long idMotorista){
        return motoristaRepository.findById(idMotorista).get();
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public ResponseEntity<Motorista> cadastrarCleinte(@RequestBody Motorista motorista){

        motoristaRepository.save(motorista);

        return ResponseEntity.created(null).body(motorista);

    }
}
