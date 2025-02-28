package escuelaing.edu.co.tallerjpa.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Propiedades")
public class Propiedad{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    String address;
    Double price;
    Double size;
    String Description;


}