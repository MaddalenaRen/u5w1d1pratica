package it.epicode.u5w1d1pratica;

import it.epicode.u5w1d1pratica.bean.Drink;
import it.epicode.u5w1d1pratica.bean.Pizza;
import it.epicode.u5w1d1pratica.bean.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import it.epicode.u5w1d1pratica.repository.ProdottoRepository;
import java.util.List;

@Component
public class RunnerDb implements CommandLineRunner {
    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired
    @Qualifier("cocaCola")
    private Drink cocaCola;

    @Autowired
    @Qualifier("water")
    private Drink water;

    @Autowired
    @Qualifier("tomato")
    private Topping tomato;

    @Autowired
    @Qualifier("mozzarella")
    private Topping mozzarella;

    @Autowired
    @Qualifier("prosciuttoCotto")
    private Topping prosciuttoCotto;

    @Autowired
    @Qualifier("margherita")
    private Pizza margherita;

    @Autowired
    @Qualifier("primavera")
    private Pizza primavera;


    @Override
    public void run(String... args) throws Exception {

        prodottoRepository.save(cocaCola);
        prodottoRepository.save(water);


        prodottoRepository.save(margherita);
        prodottoRepository.save(primavera);


        mozzarella.setPizze(List.of(margherita,primavera));
        tomato.setPizze(List.of(margherita,primavera));
        prosciuttoCotto.setPizze(List.of(primavera));

        prodottoRepository.save(mozzarella);
        prodottoRepository.save(tomato);
        prodottoRepository.save(prosciuttoCotto);



    }
}
