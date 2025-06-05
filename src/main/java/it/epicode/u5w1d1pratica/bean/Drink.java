package it.epicode.u5w1d1pratica.bean;


import it.epicode.u5w1d1pratica.enumaration.TipoDrink;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("DRINKS")
@Data
@NoArgsConstructor
@ToString(callSuper = true) // serve a chiamare il ToSTring della superclasse
public class Drink extends Prodotto {
    @Enumerated(EnumType.STRING)
    private TipoDrink tipoDrink;
}
