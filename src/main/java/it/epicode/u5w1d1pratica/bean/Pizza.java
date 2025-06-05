package it.epicode.u5w1d1pratica.bean;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
    @OneToMany(mappedBy = "pizza")
    private List<Topping> toppings;
}
