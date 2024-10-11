package delifood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import delifood.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
