package it.epicode.u5w1d1pratica.bean;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@DiscriminatorValue("TOPPINGS")
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Topping extends Prodotto{
    private boolean glutenfree;



    @ManyToMany
    @JoinTable(name = "topping_pizza",
            joinColumns = @JoinColumn(name = "topping_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id"))
    private List<Pizza> pizze;

}
