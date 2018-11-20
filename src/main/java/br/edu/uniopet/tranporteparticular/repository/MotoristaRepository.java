package br.edu.uniopet.tranporteparticular.repository;

import br.edu.uniopet.tranporteparticular.model.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    Motorista findMotoristaByNomeMotorista(String nomeMotorista);
}
