package stef.example.exemple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import stef.example.exemple.strategie.soap.ServiceSoap;
import stef.example.exemple.strategie.soap.StrategyFactoryServiceSoap;
import stef.example.exemple.strategie.soap.ListesServicesSoap;
import stef.example.exemple.strategie.soap.adresse.AdresseInput;
import stef.example.exemple.strategie.soap.adresse.AdresseOuput;
import stef.example.exemple.strategie.soap.personne.PersonneInput;
import stef.example.exemple.strategie.soap.personne.PersonneOuput;

@SpringBootTest
class StrategyFactoryServiceSoapTests {
    @Autowired
    private StrategyFactoryServiceSoap strategyFactory;

    @Test
    void strategyFactoryServiceSoap_isNotNull() {
        Assertions.assertThat(strategyFactory).isNotNull();
    }

    @Test
    void getImplementation_personneService() throws IllegalAccessException {
        ServiceSoap<PersonneInput, PersonneOuput> personneService = strategyFactory.getImplementation(ListesServicesSoap.PERSONNE.getQualifierName());
        PersonneOuput send = personneService.send(new PersonneInput());
        Assertions.assertThat(send).isNotNull();
    }
    @Test
    void getImplementation_adresseService() throws IllegalAccessException {
        ServiceSoap<AdresseInput, AdresseOuput> adresseService = strategyFactory.getImplementation(ListesServicesSoap.ADRESSE.getQualifierName());
        AdresseOuput send = adresseService.send(AdresseInput.builder().build());
        Assertions.assertThat(send).isNotNull();
    }
}
