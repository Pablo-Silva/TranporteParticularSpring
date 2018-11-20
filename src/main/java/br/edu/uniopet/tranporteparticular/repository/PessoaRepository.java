package br.edu.uniopet.tranporteparticular.repository;

import br.edu.uniopet.tranporteparticular.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
