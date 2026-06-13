package com.devtalles.tu_cv_spring_boot.cv.controller;

import com.devtalles.tu_cv_spring_boot.cv.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cv")
@RequiredArgsConstructor
public class CvController {

    private final Person person;

    @GetMapping({"/index", "", "/"})
    public String index(Model model){
//        Person person = new Person("Erick", "Hernández", "Dev");
//        model.addAttribute("name", "Erick");
//        model.addAttribute("persona", person);
        model.addAttribute("property", person.getFirstName());
        return "index";
    }


}
