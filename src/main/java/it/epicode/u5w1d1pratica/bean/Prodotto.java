package it.epicode.u5w1d1pratica.bean;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public abstract class Prodotto {
    private String nome;
    private double prezzo;
    private int calorie;
}
