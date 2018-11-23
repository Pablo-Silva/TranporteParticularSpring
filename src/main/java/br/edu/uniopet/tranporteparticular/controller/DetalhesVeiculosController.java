package br.edu.uniopet.tranporteparticular.controller;

import br.edu.uniopet.tranporteparticular.model.DetalhesVeiculos;
import br.edu.uniopet.tranporteparticular.repository.DetalhesVeiculosRepository;
import br.edu.uniopet.tranporteparticular.service.DetalhesVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @RequestMapping(value = "/editar", method = RequestMethod.PUT, headers = {"content-type=application/json"})
    public ResponseEntity<DetalhesVeiculos> editarDetalhesVeiculo(@RequestBody DetalhesVeiculos detalhesVeiculos){

        DetalhesVeiculoService detalhesVeiculoService = new DetalhesVeiculoService(detalhesVeiculosRepository);

        DetalhesVeiculos detalhesVeiculoEditado = detalhesVeiculoService.editDetalhesVeiculo(detalhesVeiculos);

        return ResponseEntity.created(null).body(detalhesVeiculoEditado);

    }

    @DeleteMapping("/{idDetalhesVeiculo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long idDetalhesVeiculo){ detalhesVeiculosRepository.deleteById(idDetalhesVeiculo); }
}
