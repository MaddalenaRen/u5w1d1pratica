package it.epicode.u5w1d1pratica.bean;


import it.epicode.u5w1d1pratica.enumaration.TipoDrink;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true) // serve a chiamare il ToSTring della superclasse
public class Drink extends Prodotto {
    private TipoDrink tipoDrink;
}
