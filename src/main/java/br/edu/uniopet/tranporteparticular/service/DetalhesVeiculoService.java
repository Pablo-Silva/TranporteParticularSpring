package br.edu.uniopet.tranporteparticular.service;

import br.edu.uniopet.tranporteparticular.model.DetalhesVeiculos;
import br.edu.uniopet.tranporteparticular.repository.DetalhesVeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalhesVeiculoService implements IDetalhesVeiculo {

    private final
    DetalhesVeiculosRepository detalhesVeiculosRepository;

    @Autowired
    public DetalhesVeiculoService(DetalhesVeiculosRepository detalhesVeiculosRepository){
        this.detalhesVeiculosRepository = detalhesVeiculosRepository;
    }

    @Override
    public DetalhesVeiculos editDetalhesVeiculo(DetalhesVeiculos detalhesVeiculos) {
        if (detalhesVeiculosRepository.existsById(detalhesVeiculos.getIdDetalhesVeiculo())){

            detalhesVeiculosRepository.save(detalhesVeiculos);
        }
        return detalhesVeiculos;
    }
}
