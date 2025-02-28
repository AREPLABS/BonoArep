package escuelaing.edu.co.tallerjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import escuelaing.edu.co.tallerjpa.modelo.Propiedad;
import escuelaing.edu.co.tallerjpa.repositorio.PropiedadRepositorio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class TallerjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerjpaApplication.class, args);
	}

	public CommandLineRunner demo(PropiedadRepositorio repository) {
    return (args) -> {
      	// save a few Propiedads
      	repository.save(new Propiedad("Direccion prueba",2.0,1.5,"Descripción"));
		repository.save(new Propiedad("Direccion prueba2",2.0,1.5,"Descripción2"));
     
  
		};
	}
}
