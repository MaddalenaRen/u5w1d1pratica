package it.epicode.u5w1d1pratica.configuration;

import it.epicode.u5w1d1pratica.bean.Prodotto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class MenuConfig {

    @Autowired
    List<Prodotto> prodotti;
}
