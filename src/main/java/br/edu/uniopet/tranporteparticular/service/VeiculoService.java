package br.edu.uniopet.tranporteparticular.service;

import br.edu.uniopet.tranporteparticular.model.Veiculo;
import br.edu.uniopet.tranporteparticular.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService implements IVeiculoService {

    private final
    VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public Veiculo editVeiculo(Veiculo veiculo) {

        if (veiculoRepository.existsById(veiculo.getIdVeiculo())){

            veiculoRepository.save(veiculo);
        }
        return veiculo;
    }
}
