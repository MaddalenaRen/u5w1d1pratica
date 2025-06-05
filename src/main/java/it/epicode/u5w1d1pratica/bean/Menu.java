package it.epicode.u5w1d1pratica.bean;

import it.epicode.u5w1d1pratica.bean.Drink;
import it.epicode.u5w1d1pratica.bean.Pizza;
import it.epicode.u5w1d1pratica.bean.Prodotto;
import it.epicode.u5w1d1pratica.bean.Topping;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenu;

    //metodo per la stampa di tutti i prodotti del menu
    public static void stampaMenu(List<Prodotto> prodotti){
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
