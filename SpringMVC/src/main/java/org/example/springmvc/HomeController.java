package org.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @ModelAttribute("course")
    public String course(@RequestParam(value = "course", required = false) String course) {
        return course;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/addProg")
    public String add(@ModelAttribute("prog1") Programmer programmer) {
        return "prog";
    }
}
