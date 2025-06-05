package it.epicode.u5w1d1pratica.bean;

import it.epicode.u5w1d1pratica.enumaration.StatoTavolo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Tavolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private int numeroMaxCoperti;
    private StatoTavolo statoTavolo;
    private double costoCoperto;

    @OneToMany(mappedBy = "tavolo")
    private List<Ordine> ordini;
}