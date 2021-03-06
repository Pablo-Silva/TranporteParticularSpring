package br.edu.uniopet.tranporteparticular.repository;

import br.edu.uniopet.tranporteparticular.model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViagemRepository extends JpaRepository<Viagem, Long> {

    Viagem findViagemByEnderecoChegadaLikeAndEnderecoSaidaLike(String enderecoChegada, String enderecoSaida);
}
