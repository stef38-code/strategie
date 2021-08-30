package stef.example.exemple.strategie.soap.adresse;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class  AdresseHelper {
    @Named("concatAdr")
    public String concatAdresse(AdresseInput input){
        return input.getAdr1()+" "+input.getAdr2()+" "+input.getAdr3();
    }
}
