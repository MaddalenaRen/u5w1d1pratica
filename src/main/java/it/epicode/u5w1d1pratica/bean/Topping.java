package it.epicode.u5w1d1pratica.bean;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("TOPPINGS")
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Topping extends Prodotto{
    private boolean glutenfree;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

}
