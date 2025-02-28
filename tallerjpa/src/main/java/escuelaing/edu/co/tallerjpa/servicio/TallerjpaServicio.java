package escuelaing.edu.co.tallerjpa.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escuelaing.edu.co.tallerjpa.modelo.Propiedad;
import escuelaing.edu.co.tallerjpa.repositorio.PropiedadRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class TallerjpaServicio {
    @Autowired
    private PropiedadRepositorio propiedadRepositorio;

    public Propiedad save(Propiedad property) {
        return propiedadRepositorio.save(property);
    }

    public List<Propiedad> findAll() {
        return propiedadRepositorio.findAll();
    }

    public Optional<Propiedad> findById(Long id) {
        return propiedadRepositorio.findById(id);
    }

    public Optional<Propiedad> update(Long id, Propiedad propiedad) {
        if (propiedadRepositorio.existsById(id)) {
            propiedad.setId(id);
            return Optional.of(propiedadRepositorio.save(propiedad));
        }
        return Optional.empty();
    }

    public void delete(Long id) {
        propiedadRepositorio.deleteById(id);
    }
}