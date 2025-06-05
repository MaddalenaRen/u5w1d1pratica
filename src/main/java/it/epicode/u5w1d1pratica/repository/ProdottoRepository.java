package it.epicode.u5w1d1pratica.repository;

import it.epicode.u5w1d1pratica.bean.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
}
