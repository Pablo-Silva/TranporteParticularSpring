package br.edu.uniopet.tranporteparticular.repository;

import br.edu.uniopet.tranporteparticular.model.Cartoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartoesRepository extends JpaRepository<Cartoes, Long> {
}
