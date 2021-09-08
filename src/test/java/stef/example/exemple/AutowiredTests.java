package stef.example.exemple;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import stef.example.exemple.strategie.soap.ServiceSoap;
import stef.example.exemple.strategie.soap.adresse.*;
import stef.example.exemple.strategie.soap.personne.PersonneInput;
import stef.example.exemple.strategie.soap.personne.PersonneOuput;
import stef.example.exemple.strategie.soap.personne.PersonneService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AutowiredTests {
    @Autowired
    @Qualifier("personne")
    ServiceSoap<PersonneInput, PersonneOuput> personneService;


    @Autowired
    @Qualifier("adresse")
    ServiceSoap<AdresseInput, AdresseOuput> adresseService;

    @Test
    void personneService_isAutowired() {
        PersonneOuput send = personneService.send(new PersonneInput());
        assertThat(send).isNotNull();
    }

    @Test
    void adresseService_isAutowired() {
        AdresseInput input = AdresseInput.builder()
                .adr1("Shirlee")
                .adr2("Suite 801 287")
                .adr3("Jospeh Springs")
                .codePostal("26100")
                .ville("Romans sur isere").build();


        AdresseOuput ouput = adresseService.send(input);
        assertThat(ouput).isNotNull();
        assertThat(ouput.getAdr()).isEqualTo(input.getAdr1() + " " + input.getAdr2() + " " + input.getAdr3());
        assertThat(ouput.getCodePostal()).isEqualTo(input.getCodePostal());
        assertThat(ouput.getVille()).isEqualTo(input.getVille());

    }
}
