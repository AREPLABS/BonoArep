package escuelaing.edu.co.tallerjpa.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import escuelaing.edu.co.tallerjpa.modelo.Propiedad;
import escuelaing.edu.co.tallerjpa.repositorio.PropiedadRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class TallerjpaServicio {
    private static final Logger logger = LoggerFactory.getLogger(TallerjpaServicio.class);

    @Autowired
    private PropiedadRepositorio propiedadRepositorio;

    public Propiedad save(Propiedad property) {
        logger.info("Saving property: {}", property);
        return propiedadRepositorio.save(property);
    }

    public List<Propiedad> findAll() {
        logger.info("Fetching all properties");
        return (List<Propiedad>) propiedadRepositorio.findAll();
    }

    public Optional<Propiedad> findById(Long id) {
        logger.info("Fetching property with id: {}", id);
        return propiedadRepositorio.findById(id);
    }

    public Optional<Propiedad> update(Long id, Propiedad propiedad) {
        if (propiedadRepositorio.existsById(id)) {
            propiedad.setId(id);
            logger.info("Updating property with id: {}", id);
            return Optional.of(propiedadRepositorio.save(propiedad));
        }
        logger.warn("Property with id: {} not found for update", id);
        return Optional.empty();
    }

    public void delete(Long id) {
        logger.info("Deleting property with id: {}", id);
        propiedadRepositorio.deleteById(id);
    }
}