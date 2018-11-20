package br.edu.uniopet.tranporteparticular.repository;

import br.edu.uniopet.tranporteparticular.model.Dinheiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DinheiroRepository extends JpaRepository<Dinheiro, Long> {
}
