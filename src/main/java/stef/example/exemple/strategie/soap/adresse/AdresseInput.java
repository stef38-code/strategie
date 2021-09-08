package stef.example.exemple.strategie.soap.adresse;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AdresseInput {
    private String adr1;
    private String adr2;
    private String adr3;
    private String codePostal;
    private String ville;
}
