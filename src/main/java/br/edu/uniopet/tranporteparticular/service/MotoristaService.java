package br.edu.uniopet.tranporteparticular.service;

import br.edu.uniopet.tranporteparticular.model.Motorista;
import br.edu.uniopet.tranporteparticular.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoristaService implements IMotoristaService {

    private final
    MotoristaRepository motoristaRepository;

    @Autowired
    public MotoristaService(MotoristaRepository motoristaRepository){
        this.motoristaRepository = motoristaRepository;
    }

    @Override
    public Motorista editMotorista(Motorista motorista) {

        if (motoristaRepository.existsById(motorista.getIdMotorista())) {

            motoristaRepository.save(motorista);
        }
        return motorista;
    }
}
