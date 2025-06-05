package it.epicode.u5w1d1pratica.bean;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@DiscriminatorValue("PIZZE")
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Pizza extends Prodotto{

    @ManyToMany(mappedBy = "pizze", fetch = FetchType.EAGER)
    private List<Topping> toppings;

}
