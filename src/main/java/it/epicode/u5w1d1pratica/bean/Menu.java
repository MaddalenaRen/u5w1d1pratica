package it.epicode.u5w1d1pratica.bean;

import it.epicode.u5w1d1pratica.bean.Drink;
import it.epicode.u5w1d1pratica.bean.Pizza;
import it.epicode.u5w1d1pratica.bean.Prodotto;
import it.epicode.u5w1d1pratica.bean.Topping;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@NoArgsConstructor
@Component
public class Menu {
    @Autowired
    private List<Prodotto> prodotti;

    //metodo per la stampa di tutti i prodotti del menu
    public void stampaMenu(){
        System.out.println("Drink");
        prodotti.stream().filter(prodotto -> prodotto instanceof Drink).forEach(System.out::println);

        System.out.println();
        System.out.println("Toppings");
        prodotti.stream().filter(prodotto -> prodotto instanceof Topping).forEach(System.out::println);

        System.out.println();
        System.out.println("Pizze");
        prodotti.stream().filter(prodotto -> prodotto instanceof Pizza).forEach(System.out::println);
    }
}
