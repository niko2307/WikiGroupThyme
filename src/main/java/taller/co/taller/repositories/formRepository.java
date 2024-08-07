package taller.co.taller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taller.co.taller.model.Form;

@Repository
public interface formRepository extends JpaRepository<Form, Long>{
    
}
