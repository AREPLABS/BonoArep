package escuelaing.edu.co.tallerjpa.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import escuelaing.edu.co.tallerjpa.modelo.Propiedad;

@Repository
public interface PropiedadRepositorio extends CrudRepository<Propiedad, Long> {
}
