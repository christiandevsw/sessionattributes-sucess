package com.dojo.sessionattributes.controller;

import com.dojo.sessionattributes.model.Person;
import com.dojo.sessionattributes.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/persons")
@SessionAttributes("person")
public class ViewController {
    private PersonRepository personRepository;

    @GetMapping
    public String listAll(Model model){
        model.addAttribute("persons",personRepository.findAll());
        return "listAll";
    }

    @GetMapping("/form")
    public String showForm(Model model){
        Person person=new Person();
        person.setCode(UUID.randomUUID().toString());
        model.addAttribute("person",person);
        return "form";
    }

    @PostMapping
    public String process(Person onePerson, SessionStatus status){
        status.setComplete();
        personRepository.save(onePerson);
        return "redirect:/persons";
    }
}
