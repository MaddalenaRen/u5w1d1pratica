package it.epicode.u5w1d1pratica.bean;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.awt.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PRODOTTI", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@ToString
public abstract class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private double prezzo;
    private int calorie;


}
