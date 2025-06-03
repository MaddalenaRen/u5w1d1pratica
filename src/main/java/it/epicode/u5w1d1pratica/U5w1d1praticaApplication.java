package it.epicode.u5w1d1pratica;

import it.epicode.u5w1d1pratica.bean.Drink;
import it.epicode.u5w1d1pratica.bean.Topping;
import it.epicode.u5w1d1pratica.configuration.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class U5w1d1praticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(U5w1d1praticaApplication.class, args);


		// serve per accedere al contesto di Spring
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		Drink water = ctx.getBean(Drink.class); // dal contesto fatti dare un Bean di tipo Drink

		System.out.println(water);

		Topping t1 = ctx.getBean("mozzarella", Topping.class);
		// avendo più topping non sa quale scegliere e va in errore
		 // possiamo aggiungere la annotazione @primary per dare la priorità a quel bean
		// può esserci solo un primary
		//un'altra modalitò è quella di dare un nome al bean così si ha una possibilità in più
		// per distinguerli

		System.out.println(t1);
	}

}
