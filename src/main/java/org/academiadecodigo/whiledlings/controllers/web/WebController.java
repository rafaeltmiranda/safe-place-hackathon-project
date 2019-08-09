package org.academiadecodigo.whiledlings.controllers.web;

import org.academiadecodigo.whiledlings.converters.PersonToPersonDTO;
import org.academiadecodigo.whiledlings.persistence.model.Person;
import org.academiadecodigo.whiledlings.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
@RequestMapping("/")
public class WebController {

    PersonService personService;
    PersonToPersonDTO personToPersonDTO;

    @RequestMapping("/")
    public String home(Model model) {

        return "index";
    }

    @RequestMapping("/values-mapping")
    public String valuesMapping(Model model) {

        return "valuesMapping";
    }

    @RequestMapping("/feed")
    public String feed(Model model) {

        return "feed";
    }

    @RequestMapping("/profile/{id}")
    public String profile(@PathVariable Integer id, Model model) {

        Person person = personService.getById(id);

        model.addAttribute("person", personToPersonDTO.convert(person));

        return "profile";
    }

}
