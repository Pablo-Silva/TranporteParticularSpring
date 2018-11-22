package br.edu.uniopet.tranporteparticular.controller;

import br.edu.uniopet.tranporteparticular.model.Motorista;
import br.edu.uniopet.tranporteparticular.payload.CadastroMotorista;
import br.edu.uniopet.tranporteparticular.repository.MotoristaRepository;
import br.edu.uniopet.tranporteparticular.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarMotorista(@Valid @RequestBody CadastroMotorista cadastroMotorista){

       Motorista motorista = new Motorista(cadastroMotorista.getNomeMotorista(),cadastroMotorista.getDataNascimento(),
               cadastroMotorista.getSexo(),cadastroMotorista.getCpf(),cadastroMotorista.getNumeroCelular(),
               cadastroMotorista.getEmail(),cadastroMotorista.getSenha(),cadastroMotorista.getDataCadastro(),
               cadastroMotorista.getStatus(),cadastroMotorista.getCarteiraMotorista());

       motoristaRepository.save(motorista);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/motorista/nome/{nomeMotorista}")
                .buildAndExpand(motorista.getNomeMotorista()).toUri();

        return ResponseEntity.created(uri).body("Cadastrado com sucesso!");

    }

    @RequestMapping(value = "/editar", method = RequestMethod.PUT, headers = {"content-type=application/json"})
    public ResponseEntity<Motorista> editarMotorista(@RequestBody Motorista motorista){

        MotoristaService motoristaService = new MotoristaService(motoristaRepository);

        Motorista motoristaEditado = motoristaService.editMotorista(motorista);

        return ResponseEntity.created(null).body(motoristaEditado);

    }

    @GetMapping("/nome/{nomeMotorista}")
    public Motorista findById(@PathVariable String nomeMotorista){
        return motoristaRepository.findMotoristaByNomeMotorista(nomeMotorista);
    }

    @DeleteMapping("/{idMotorista}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long idMotorista){ motoristaRepository.deleteById(idMotorista); }

}
