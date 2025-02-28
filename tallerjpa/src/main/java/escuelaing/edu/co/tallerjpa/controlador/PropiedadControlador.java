package escuelaing.edu.co.tallerjpa.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import escuelaing.edu.co.tallerjpa.modelo.Propiedad;
import escuelaing.edu.co.tallerjpa.servicio.TallerjpaServicio;

import java.util.List;

@RestController
@RequestMapping("/api/propiedades")
public class PropiedadControlador {

    @Autowired
    private TallerjpaServicio propiedadServicio;

    @GetMapping
    public List<Propiedad> getAllPropiedades() {
        return propiedadServicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propiedad> getPropiedadById(@PathVariable Long id) {
        return propiedadServicio.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Propiedad createPropiedad(@RequestBody Propiedad propiedad) {
        return propiedadServicio.save(propiedad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Propiedad> updatePropiedad(@PathVariable Long id, @RequestBody Propiedad propiedad) {
        return propiedadServicio.update(id, propiedad)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePropiedad(@PathVariable Long id) {
        propiedadServicio.delete(id);
        return ResponseEntity.noContent().build();
    }
}