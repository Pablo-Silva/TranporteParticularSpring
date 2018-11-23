package br.edu.uniopet.tranporteparticular.controller;
import br.edu.uniopet.tranporteparticular.model.Veiculo;
import br.edu.uniopet.tranporteparticular.repository.VeiculoRepository;
import br.edu.uniopet.tranporteparticular.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

    @Autowired
    VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Veiculo> list(){return veiculoRepository.findAll();}

    /// Mapeia um Veiculo pelo seu ID
    @GetMapping("/{idVeiculo}")
    public Veiculo findById(@PathVariable Long idVeiculo){
        return veiculoRepository.findById(idVeiculo).get();
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo){

        veiculoRepository.save(veiculo);

        return ResponseEntity.created(null).body(veiculo);

    }

    @RequestMapping(value = "/editar", method = RequestMethod.PUT, headers = {"content-type=application/json"})
    public ResponseEntity<Veiculo> editarVeiculo(@RequestBody Veiculo veiculo){

        VeiculoService veiculoService = new VeiculoService(veiculoRepository);

        Veiculo veiculoEditado = veiculoService.editVeiculo(veiculo);

        return ResponseEntity.created(null).body(veiculo);

    }

    @DeleteMapping("/{idVeiculo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long idVeiculo){ veiculoRepository.deleteById(idVeiculo); }
}
