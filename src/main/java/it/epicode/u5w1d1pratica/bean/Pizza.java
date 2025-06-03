package it.epicode.u5w1d1pratica.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Pizza extends Prodotto{
    private List<Topping> toppings;
}
