package com.devtalles.tu_cv_spring_boot.cv.controller;

import com.devtalles.tu_cv_spring_boot.cv.model.Skill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/skills")
public class SkillsController {

    private final List<Skill> skills = new ArrayList<>();

    @GetMapping
    public String showSkills(@RequestParam(defaultValue = "", required = false) String filter, Model model) {
        List<Skill> skillsFilter = skills.stream().filter(skill -> skill.getName().toLowerCase().contains(filter.toLowerCase())).toList();

        model.addAttribute("skills", skillsFilter);
        model.addAttribute("filter", filter);
        return "skills";
    }

    @GetMapping("/{index}")
    public String showSkillDetail(@PathVariable int index, Model model) {
        if (index >= 0 && index < skills.size()) {
            Skill skill = skills.get(index);
            model.addAttribute("skill", skill);

            return "skill-detail";
        }

        return "redirect:/skills";

    }

    @GetMapping("/new")
    public String showForm(Model model) {

        model.addAttribute("skill", new Skill());
        return "add-skill";
    }

    @PostMapping("/add")
    public String addSkill(@ModelAttribute Skill skill) {
        skills.add(skill);
        return "redirect:/skills";
    }


}
