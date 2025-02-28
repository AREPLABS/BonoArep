package escuelaing.edu.co.tallerjpa.repositorio;

import org.springframework.data.repository.CrudRepository;

import escuelaing.edu.co.tallerjpa.modelo.Propiedad;


public interface PropiedadRepositorio extends CrudRepository<Propiedad, Long> {

    Propiedad save(Propiedad propiedad);
}