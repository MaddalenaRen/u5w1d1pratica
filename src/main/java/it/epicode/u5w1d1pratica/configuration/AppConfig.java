package it.epicode.u5w1d1pratica.configuration;

import it.epicode.u5w1d1pratica.bean.Drink;
import it.epicode.u5w1d1pratica.bean.Pizza;
import it.epicode.u5w1d1pratica.bean.Tavolo;
import it.epicode.u5w1d1pratica.bean.Topping;
import it.epicode.u5w1d1pratica.enumaration.StatoTavolo;
import it.epicode.u5w1d1pratica.enumaration.TipoDrink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration//classe di configurazione, spring la utilizza per configurae il cntesto
public class AppConfig {

    @Bean("water")//serve per far capire a Spring che questo metodo
    //deve essere chiamato automaticamente da Spring e che
    //l'oggetto restituito deve essere salvato nel container di Spring
    public Drink getWater(){
        Drink water = new Drink();
        water.setTipoDrink(TipoDrink.ANALCOLICO);
        water.setCalorie(0);
        water.setPrezzo(1);
        water.setNome("Water");
        return water;
    }

    @Bean(name = "tomato")
    @Primary//serve per dare precedenza a questo bean nel caso ce ne siano più di uno dello stesso tipo
    public Topping getTomato(){
        Topping tomato = new Topping();
        tomato.setNome("Tomato");
        tomato.setPrezzo(1);
        tomato.setCalorie(100);
        tomato.setGlutenfree(true);
        return tomato;
    }

    @Bean(name = "mozzarella")
    public Topping getMozzarella(){
        Topping mozzarella = new Topping();
        mozzarella.setNome("Mozzarella");
        mozzarella.setPrezzo(1);
        mozzarella.setCalorie(200);
        mozzarella.setGlutenfree(true);
        return mozzarella;
    }
    @Bean("cocaCola")
    public Drink getCocaCola(){
        Drink cocaCola = new Drink();
        cocaCola.setNome("coca cola");
        cocaCola.setCalorie(400);
        cocaCola.setPrezzo(2);
        cocaCola.setTipoDrink(TipoDrink.ANALCOLICO);
        return cocaCola;
    }
    @Bean("prosciuttoCotto")
    public Topping getProsciuttoCotto(){
        Topping prosciuttoCotto = new Topping();
        prosciuttoCotto.setNome("prosciutto cotto");
        prosciuttoCotto.setGlutenfree(true);
        prosciuttoCotto.setCalorie(200);
        prosciuttoCotto.setPrezzo(2);
        return prosciuttoCotto;
    }

    @Bean("margherita")
    public Pizza getMargherita(){
        Pizza margherita = new Pizza();
        margherita.setNome("margherita");
        margherita.setCalorie(500);
        margherita.setPrezzo(5);
        margherita.setToppings(List.of(getMozzarella(), getTomato()));
        return margherita;
    }
    @Bean("primavera")
    public Pizza getPrimavera(){
        Pizza primavera = new Pizza();
        primavera.setNome("primavera");
        primavera.setPrezzo(6);
        primavera.setCalorie(600);
        primavera.setToppings(List.of(getMozzarella(),getTomato(),getProsciuttoCotto()));
        return primavera;
    }

    @Bean("t1")
    public Tavolo getTavolo1(){
        Tavolo t1 = new Tavolo();
        t1.setCostoCoperto(1.5);
        t1.setStatoTavolo(StatoTavolo.LIBERO);
        t1.setNumero(1);
        t1.setNumeroMaxCoperti(6);
        return t1;
    }
    @Bean("t2")
    public Tavolo getTavolo2(){
        Tavolo t2 = new Tavolo();
        t2.setNumero(2);
        t2.setNumeroMaxCoperti(4);
        t2.setStatoTavolo(StatoTavolo.LIBERO);
        t2.setCostoCoperto(2);
        return t2;
    }
}
