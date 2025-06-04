package it.epicode.u5w1d1pratica;

import it.epicode.u5w1d1pratica.bean.Drink;
import it.epicode.u5w1d1pratica.bean.Menu;
import it.epicode.u5w1d1pratica.bean.Pizza;
import it.epicode.u5w1d1pratica.bean.Tavolo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class U5w1d1praticaApplicationTests {

	private static AnnotationConfigApplicationContext ctx;

	@BeforeAll
	public static void creaContesto() {
		ctx = new AnnotationConfigApplicationContext(U5w1d1praticaApplication.class);
	}

	@BeforeEach
	public void primaDelTest() {
		System.out.println("inizio test");
	}

	@Test
	public void verificaCostoCopertoTavolo1() {
		Tavolo t1 = ctx.getBean("t1", Tavolo.class);
		assertEquals(1.5, t1.getCostoCoperto());
	}

	@Test
	public void verificaNumeroPizzeEDrink() {
		Menu menu = ctx.getBean(Menu.class);

		long countPizze = menu.getProdotti().stream().filter(prodotto -> prodotto instanceof Pizza).count();
		long countDrink = menu.getProdotti().stream().filter(prodotto -> prodotto instanceof Drink).count();

		Assertions.assertAll(
				() -> assertEquals(2, countDrink),
				() -> assertEquals(2, countPizze)
		);
	}

	@AfterEach
	public void dopoIlTest() {
		System.out.println("fine test");
	}

	@AfterAll
	public static void chiudiContesto() {
		ctx.close();
	}

	@ParameterizedTest
	@ValueSource(strings = {"tomato", "mozzarella", "salame"})
	public void verificaBeanEsistenti(String topping) {
		Menu menu = ctx.getBean(Menu.class);
		boolean exist = menu.getProdotti().stream().anyMatch(prodotto -> prodotto.getNome().equalsIgnoreCase(topping));
		Assertions.assertTrue(exist);
	}

	@ParameterizedTest
	@CsvSource({"tomato,1", "mozzarella,1", "salame,0"})
	public void verificaToppingMenu(String topping, int atteso) {
		Menu menu = ctx.getBean(Menu.class);
		long count = menu.getProdotti().stream()
				.filter(prodotto -> prodotto.getNome().equalsIgnoreCase(topping))
				.count();
		assertEquals(atteso, count);
	}



	///Test 1 verifica il numero dei tavolid dinamicamente
	// creo un array di stringhe al cui interno ci saranno tutti i Bean di tipo Tavolo presi dal contesto
	//lo salvo in una variabile "numeroTavoli" e utilizzo assertEquals
	@Test
	public void verificaNumeroTavoli() {
		String[] tavoloBeanNames = ctx.getBeanNamesForType(Tavolo.class);
		int numeroTavoli = tavoloBeanNames.length;
		assertEquals(2, numeroTavoli);
	}


	@Test
	public void tuttiIToppingMargheritaGlutenFree() {
		Pizza margherita = ctx.getBean("margherita", Pizza.class);
		boolean tuttiGlutenFree = margherita.getToppings().stream().allMatch(topping -> topping.isGlutenfree());
		assertTrue(tuttiGlutenFree);
	}

	//creo un arrey di Stringhe di nome pizze, al suo interno mettiamo tutti i bean presi dal contesto
	//di tipo pizza.class
	@Test
	public void pizzaAlmenoUnTopping() {
		String[] pizze = ctx.getBeanNamesForType(Pizza.class);
		for (String nome : pizze) {
			Pizza p = ctx.getBean(nome, Pizza.class);
			assertFalse(p.getToppings().isEmpty());
		}
	}




	@ParameterizedTest
	@ValueSource(strings = {"water", "cocaCola"})
	public void drinkPrezzoMaggioreDiZero(String drinkName) {
		Drink drink = ctx.getBean(drinkName, Drink.class);
		assertTrue(drink.getPrezzo() > 0);
	}

	//Test parametrizzato che verifica se alcuni topping specifici sono su una specifica pizza
	//passo i parametri nel metodo
	//in una variabile di tipo Pizza che chiamo "pizza"
	//salvo i nomi delle pizze
	//in una variabile di tipo booleaan che chiamo "esiste" prendo tutti i topping della pizza
	//con anymatch controllo se aleno uno dei topping e presente attravberso il nome
	//.trim elimino gli spazi
	//con equalsIgnoreCase confronto senza tener conto delle maiuscole
	@ParameterizedTest
	@CsvSource({
			"primavera, prosciutto cotto, true",
			"primavera, salame, false",
			"margherita, mozzarella, true",
			"margherita, prosciutto cotto, false"
	})
	public void verificaToppingPresenteInPizze(String pizzaName, String topping, boolean previsto) {
		Pizza pizza = ctx.getBean(pizzaName, Pizza.class);
		boolean esiste = pizza.getToppings().stream()
				.anyMatch(t -> t.getNome().trim().equalsIgnoreCase(topping.trim()));
		assertEquals(previsto, esiste);
	}

}
