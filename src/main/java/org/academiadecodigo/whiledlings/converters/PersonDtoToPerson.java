package org.academiadecodigo.whiledlings.converters;

import org.academiadecodigo.whiledlings.commands.PersonDTO;
import org.academiadecodigo.whiledlings.persistence.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonDtoToPerson implements Converter<Person, PersonDTO> {

    @Override
    public Person convert(PersonDTO personDTO) {

        Person person = new Person();
        person.setId(personDTO.getId());
        person.setAnswers(personDTO.getAnswers());
        person.setName(personDTO.getName());

        return person;
    }
}
