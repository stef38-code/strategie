package stef.example.exemple.strategie.soap.adresse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import stef.example.exemple.strategie.ServiceSoap;

@Component
@Qualifier("adresse")
@Slf4j
public class AdresseService implements ServiceSoap<AdresseInput,AdresseOuput> {
    @Override
    public AdresseOuput send(AdresseInput adresseInput) {
        log.info("----- AdresseService.send ---------");
        return new AdresseOuput();
    }
}
