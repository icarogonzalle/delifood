package delifood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import delifood.entities.Cozinha;

@Repository
public interface CozinhaRepository  extends JpaRepository<Cozinha, Long>{

}
