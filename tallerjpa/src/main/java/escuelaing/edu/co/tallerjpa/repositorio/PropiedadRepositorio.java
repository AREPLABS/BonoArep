package escuelaing.edu.co.tallerjpa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import escuelaing.edu.co.tallerjpa.modelo.Propiedad;

@Repository
public interface PropiedadRepositorio extends JpaRepository<Propiedad, Long> {
}