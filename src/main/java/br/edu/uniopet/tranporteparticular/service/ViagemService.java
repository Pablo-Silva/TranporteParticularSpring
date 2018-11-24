package br.edu.uniopet.tranporteparticular.service;

import br.edu.uniopet.tranporteparticular.model.Viagem;
import br.edu.uniopet.tranporteparticular.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViagemService implements IViagem {

    private final
    ViagemRepository viagemRepository;

    @Autowired
    public ViagemService(ViagemRepository viagemRepository){
        this.viagemRepository = viagemRepository;
    }

    @Override
    public Viagem editViagem(Viagem viagem) {
        if (viagemRepository.existsById(viagem.getIdViagem())){

            viagemRepository.save(viagem);
        }
        return viagem;
    }
}
