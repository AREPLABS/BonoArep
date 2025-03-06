package escuelaing.edu.co.tallerjpa.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "propiedades") 
public class Propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double size;

    @Column(nullable = false) 
    private String description; 

    public Propiedad(){
    }

    public Propiedad(String address,Double price, Double size, String description){
        this.address = address;
        this.price=price;
        this.size = size;
        this.description= description;
    }
}