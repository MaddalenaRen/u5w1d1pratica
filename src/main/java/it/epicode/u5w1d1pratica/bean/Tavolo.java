package it.epicode.u5w1d1pratica.bean;

import it.epicode.u5w1d1pratica.enumaration.StatoTavolo;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Tavolo {
    private int numero;
    private int numeroMaxCoperti;
    private StatoTavolo statoTavolo;
    private double costoCoperto;
}