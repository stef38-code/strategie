package stef.example.exemple;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import stef.example.exemple.strategie.soap.ServiceSoap;
import stef.example.exemple.strategie.soap.adresse.AdresseInput;
import stef.example.exemple.strategie.soap.adresse.AdresseOuput;
import stef.example.exemple.strategie.soap.personne.PersonneInput;
import stef.example.exemple.strategie.soap.personne.PersonneOuput;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TestsAutowired {
    @Autowired
    @Qualifier("personne")
    ServiceSoap<PersonneInput, PersonneOuput> personneService;


    @Autowired
    @Qualifier("adresse")
    ServiceSoap<AdresseInput, AdresseOuput> adresseService;

    @Test
    void personneService() {
        PersonneOuput send = personneService.send(new PersonneInput());
        assertThat(send).isNotNull();
    }
    @Test
    void adresseService() {
        AdresseInput input = new AdresseInput();
        input.setAdr1("Shirlee");
        input.setAdr2("Suite 801 287");
        input.setAdr3("Jospeh Springs");
        input.setCodePostal("26100");
        input.setVille("Romans sur isere");


        AdresseOuput ouput = adresseService.send(input);
        assertThat(ouput).isNotNull();
        assertThat(ouput.getAdr()).isEqualTo(input.getAdr1()+" "+input.getAdr2()+" "+input.getAdr3());
        assertThat(ouput.getCodePostal()).isEqualTo(input.getCodePostal());
        assertThat(ouput.getVille()).isEqualTo(input.getVille());

    }
}
