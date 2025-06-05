package it.epicode.u5w1d1pratica.bean;

import it.epicode.u5w1d1pratica.enumaration.StatoOrdine;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numOrdine;
    private LocalTime oraOrdine;

    private int numCoperti;

    private StatoOrdine statoOrdine;

    @ManyToOne
    @JoinColumn(name = "tavolo_id")
    private Tavolo tavolo;

    @ManyToMany
    @JoinTable(
            name = "ordine_prodotto",
            joinColumns = @JoinColumn(name = "ordine_id"),
            inverseJoinColumns = @JoinColumn(name = "prodotto_id")
    )
    private List<Prodotto> prodotti;

    public double totaleOrdine() {
        return numCoperti * tavolo.getCostoCoperto() +
                prodotti.stream().mapToDouble(Prodotto::getPrezzo).sum();
    }
}
