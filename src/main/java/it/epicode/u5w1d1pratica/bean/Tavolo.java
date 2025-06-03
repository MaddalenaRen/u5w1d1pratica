package it.epicode.u5w1d1pratica.bean;

import it.epicode.u5w1d1pratica.enumaration.StatoTavolo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Tavolo {
    private int numero;
    private int numeroMaxCoperti;
    private StatoTavolo statoTavolo;
    private double costoCoperto;
}