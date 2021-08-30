package stef.example.exemple.strategie.soap.adresse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {AdresseHelper.class})

public abstract class AdresseMapper {
    @Mapping(source = "input", target = "adr", qualifiedByName = "concatAdr")
    public abstract AdresseOuput toOutput(AdresseInput input);
}
