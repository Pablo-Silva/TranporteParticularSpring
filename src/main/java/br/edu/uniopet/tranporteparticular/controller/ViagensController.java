package br.edu.uniopet.tranporteparticular.controller;

import br.edu.uniopet.tranporteparticular.model.Cliente;
import br.edu.uniopet.tranporteparticular.model.Motorista;
import br.edu.uniopet.tranporteparticular.model.Viagem;
import br.edu.uniopet.tranporteparticular.payload.BuscarViagem;
import br.edu.uniopet.tranporteparticular.payload.FazerViagem;
import br.edu.uniopet.tranporteparticular.repository.ViagemRepository;
import br.edu.uniopet.tranporteparticular.service.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/viagens")
public class ViagensController {

    @Autowired
    ViagemRepository viagemRepository;

    @GetMapping
    public List<Viagem> list(){return viagemRepository.findAll();}

    // Mapeia uma Viagem pelo seu ID
    @GetMapping("/{idViagem}")
    public Viagem findById(@PathVariable Long idViagem){
        return viagemRepository.findById(idViagem).get();
    }

    @GetMapping("/nome/{buscarViagem}")
    public Viagem findById(@PathVariable BuscarViagem buscarViagem){
        return viagemRepository.findViagemByEnderecoChegadaLikeAndEnderecoSaidaLike(buscarViagem.getEnderecoChegada(), buscarViagem.getEnderecoSaida());
    }

    @RequestMapping(value = "/fazer-viagem", method = RequestMethod.POST, headers = {"content-type=application/json"})
    public ResponseEntity<Viagem> cadastrarCleinte(@RequestBody FazerViagem fazerViagem){

        Motorista motorista = new Motorista();
        Cliente cliente = new Cliente();

        motorista.setIdMotorista(fazerViagem.getIdMotorista());
        cliente.setIdCliente(fazerViagem.getIdCliente());

        Viagem viagem = new Viagem(motorista, cliente, fazerViagem.getEnderecoSaida(), fazerViagem.getEnderecoChegada(),fazerViagem.getDataFim(), fazerViagem.getDataInicio());
        viagemRepository.save(viagem);

        return ResponseEntity.created(null).body(viagem);

    }

    @RequestMapping(value = "/editar", method = RequestMethod.PUT, headers = {"content-type=application/json"})
    public ResponseEntity<Viagem> editarViagem(@RequestBody Viagem viagem){

        ViagemService viagemService = new ViagemService(viagemRepository);

        Viagem viagemEditada = viagemService.editViagem(viagem);

        return ResponseEntity.created(null).body(viagemEditada);

    }
}
