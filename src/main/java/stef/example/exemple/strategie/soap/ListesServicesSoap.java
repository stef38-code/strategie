package stef.example.exemple.strategie.soap;

import lombok.Getter;

public enum ListesServicesSoap {
    PERSONNE("personneService"),
    ADRESSE("adresseService");
    @Getter
    String qualifierName;

    ListesServicesSoap (String qualifierName) {
        this.qualifierName = qualifierName;
    }

}
