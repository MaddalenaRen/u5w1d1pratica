package it.epicode.u5w1d1pratica.bean;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PRODOTTI", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@ToString
public abstract class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double prezzo;
    private int calorie;
}
