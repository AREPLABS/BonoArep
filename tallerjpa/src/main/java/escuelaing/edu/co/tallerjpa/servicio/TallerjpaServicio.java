package escuelaing.edu.co.tallerjpa.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import escuelaing.edu.co.tallerjpa.modelo.Propiedad;
import escuelaing.edu.co.tallerjpa.repositorio.PropiedadRepositorio;

import java.util.Optional;

@Service
public class TallerjpaServicio {

    @Autowired
    private PropiedadRepositorio propiedadRepositorio;

    public Iterable<Propiedad> findAll() {
        return propiedadRepositorio.findAll();
    }

    public Optional<Propiedad> findById(Long id) {
        return propiedadRepositorio.findById(id);
    }

    public Propiedad save(Propiedad propiedad) {
        return propiedadRepositorio.save(propiedad);
    }

    public Optional<Propiedad> update(Long id, Propiedad nuevaPropiedad) {
        return propiedadRepositorio.findById(id).map(propiedad -> {
            propiedad.setAddress(nuevaPropiedad.getAddress());
            propiedad.setPrice(nuevaPropiedad.getPrice());
            propiedad.setSize(nuevaPropiedad.getSize());
            propiedad.setDescription(nuevaPropiedad.getDescription());
            return propiedadRepositorio.save(propiedad);
        });
    }

    public void delete(Long id) {
        propiedadRepositorio.deleteById(id);
    }
}
