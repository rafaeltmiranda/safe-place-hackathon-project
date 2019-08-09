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

        return "newHome";
    }

    @RequestMapping("/who-are-you")
    public String name(Model model) {

        return "yourName";
    }

    @RequestMapping("/start/{id}")
    public String valuesMapping(@PathVariable Integer id, Model model) {

        model.addAttribute("id_Person", id);
        return "questions";
    }

    @RequestMapping("/thank-you")
    public String profile(Model model) {

        return "thank-you";
    }

}
