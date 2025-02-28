package escuelaing.edu.co.tallerjpa.controlador;

import escuelaing.edu.co.tallerjpa.modelo.Propiedad;
import escuelaing.edu.co.tallerjpa.servicio.TallerjpaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propiedades")
public class TallerJpaControlador {
    @Autowired
    private TallerjpaServicio TallerjpaServicio;

    @PostMapping
    public ResponseEntity<Propiedad> createPropiedad(@RequestBody Propiedad Propiedad) {
        return new ResponseEntity<>(TallerjpaServicio.save(Propiedad), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Propiedad> irTodasProperties() {
        return TallerjpaServicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propiedad> irPropiedadPorId(@PathVariable Long id) {
        return TallerjpaServicio.findById(id)
                .map(Propiedad -> new ResponseEntity<>(Propiedad, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Propiedad> actualizarPropiedad(@PathVariable Long id, @RequestBody Propiedad Propiedad) {
        return TallerjpaServicio.update(id, Propiedad)
                .map(updatedPropiedad -> new ResponseEntity<>(updatedPropiedad, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPropiedad(@PathVariable Long id) {
        TallerjpaServicio.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

