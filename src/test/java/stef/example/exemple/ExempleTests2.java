package stef.example.exemple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import stef.example.exemple.strategie.ServiceSoap;
import stef.example.exemple.strategie.StrategyFactoryServiceSoap;
import stef.example.exemple.strategie.soap.ListesServicesSoap;
import stef.example.exemple.strategie.soap.personne.PersonneInput;
import stef.example.exemple.strategie.soap.personne.PersonneOuput;

@SpringBootTest
class ExempleTests2 {
    @Autowired
    @Qualifier("personne")
    ServiceSoap<PersonneInput, PersonneOuput> personneService;

    @Test
    void contextLoads() {
    }

    @Test
    void test1() throws IllegalAccessException {
        PersonneOuput send = personneService.send(new PersonneInput());
        Assertions.assertThat(send).isNotNull();
    }
}
