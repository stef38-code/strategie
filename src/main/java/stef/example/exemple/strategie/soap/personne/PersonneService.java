package stef.example.exemple.strategie.soap.personne;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import stef.example.exemple.strategie.soap.ServiceSoap;

@Component
@Qualifier("personne")
@Slf4j
public class PersonneService implements ServiceSoap<PersonneInput,PersonneOuput> {
    @Override
    public PersonneOuput send(PersonneInput personneInput) {
        log.info("----- PersonneService.send ---------");
        return new PersonneOuput();
    }
}
