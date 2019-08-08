package org.academiadecodigo.whiledlings.converters;

import org.academiadecodigo.whiledlings.commands.PersonDTO;
import org.academiadecodigo.whiledlings.persistence.model.Person;

public class PersonToPersonDTO extends AbstractConverter<PersonDTO, Person> {

    @Override
    public PersonDTO convert(Person person) {

        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());

        return personDTO;
    }
}
