package stef.example.exemple.strategie.soap.adresse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import stef.example.exemple.strategie.soap.ServiceSoap;

@Component
@Qualifier("adresse")
@Slf4j
@RequiredArgsConstructor
public class AdresseService implements ServiceSoap<AdresseInput,AdresseOuput> {

    private final AdresseMapper map;
    @Override
    public AdresseOuput send(AdresseInput adresseInput) {
        log.info("----- AdresseService.send ---------");
        return map.toOutput(adresseInput);
    }
}
