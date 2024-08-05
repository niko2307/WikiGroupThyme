package taller.co.taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.co.taller.model.Formulario;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Long>{
    
}
