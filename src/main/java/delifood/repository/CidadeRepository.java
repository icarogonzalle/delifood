package delifood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import delifood.entities.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
