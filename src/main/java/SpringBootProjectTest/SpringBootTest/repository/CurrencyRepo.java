package SpringBootProjectTest.SpringBootTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootProjectTest.SpringBootTest.model.InternationalCurrency;

@Repository
public interface CurrencyRepo extends JpaRepository<InternationalCurrency, String>{

}
