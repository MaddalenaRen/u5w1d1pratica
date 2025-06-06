package it.epicode.u5w1d1pratica;

import it.epicode.u5w1d1pratica.bean.*;
import it.epicode.u5w1d1pratica.configuration.AppConfig;
import it.epicode.u5w1d1pratica.configuration.MenuConfig;
import it.epicode.u5w1d1pratica.enumaration.StatoOrdine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;


//@Component//serve per permettere a Spring di gestire completamente la classe
//tutte le classi con Component vengono istanziate direttamente da Spring e gli
//oggetti creati vengono salvati nel contesto
@Order(1)//deve essere il primo runner ad essere lanciato
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        //serve per accedere al contesto di Spring
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(U5w1d1praticaApplication.class);
        //abbiamo recuperato dal contesto di Spring un oggetto di tipo Drink
        MenuConfig menu = ctx.getBean(MenuConfig.class);
        Menu.stampaMenu(menu.getProdotti());

        Ordine o1 = new Ordine();
        o1.setNumOrdine(1);
        o1.setNumCoperti(4);
        o1.setOraOrdine(LocalTime.of(21,0,0));
        o1.setStatoOrdine(StatoOrdine.IN_CORSO);
        o1.setTavolo(ctx.getBean("t1", Tavolo.class));
        o1.setProdotti(List.of(ctx.getBean("water", Drink.class),
                ctx.getBean("cocaCola", Drink.class),
                ctx.getBean("margherita", Pizza.class),
                ctx.getBean("primavera", Pizza.class),
                ctx.getBean("primavera", Pizza.class)));

        System.out.println(o1);

        System.out.println(o1.totaleOrdine());







    }
}
