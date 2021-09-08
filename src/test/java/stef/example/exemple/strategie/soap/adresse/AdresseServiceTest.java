package stef.example.exemple.strategie.soap.adresse;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AdresseService.class, AdresseMapper.class})
@ExtendWith(SpringExtension.class)
public class AdresseServiceTest {
    @MockBean
    private AdresseMapper adresseMapper;

    @Autowired
    private AdresseService adresseService;

    @Test
    public void testSend() {
        AdresseOuput adresseOuput = new AdresseOuput();
        adresseOuput.setVille("Ville");
        adresseOuput.setCodePostal("Code Postal");
        adresseOuput.setAdr("Adr");
        when(this.adresseMapper.toOutput((AdresseInput) any())).thenReturn(adresseOuput);
        assertSame(adresseOuput,
                this.adresseService.send(new AdresseInput("Adr1", "Adr2", "Adr3", "Code Postal", "Ville")));
        verify(this.adresseMapper).toOutput((AdresseInput) any());
    }
}

