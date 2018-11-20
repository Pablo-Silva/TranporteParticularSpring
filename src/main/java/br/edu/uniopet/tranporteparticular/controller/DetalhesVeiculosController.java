package br.edu.uniopet.tranporteparticular.controller;

import br.edu.uniopet.tranporteparticular.model.DetalhesVeiculos;
import br.edu.uniopet.tranporteparticular.repository.DetalhesVeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalhesVeiculos")
public class DetalhesVeiculosController {

    @Autowired
    DetalhesVeiculosRepository detalhesVeiculosRepository;

    @GetMapping
    public List<DetalhesVeiculos> list(){return detalhesVeiculosRepository.findAll();}

    /// Mapeia Detalhes de um Veiculo pelo seu ID
    @GetMapping("/{idDetalhesVeiculo}")
    public DetalhesVeiculos findById(@PathVariable Long idDetalhesVeiculo){
        return detalhesVeiculosRepository.findById(idDetalhesVeiculo).get();
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public ResponseEntity<DetalhesVeiculos> cadastrarDetalhesVeiculos(@RequestBody DetalhesVeiculos detalhesVeiculos){

        detalhesVeiculosRepository.save(detalhesVeiculos);

        return ResponseEntity.created(null).body(detalhesVeiculos);

    }
}
