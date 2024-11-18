package org.example.springbootmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @ModelAttribute("course")
    public String course(@RequestParam(value = "course") String course) {
        return course;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/addProg")
//    public ModelAndView add(@RequestParam("pid") int pid, @RequestParam("pname") String pname, ModelAndView mv) {
//
//        Programmer programmer = new Programmer();
//        programmer.setPid(pid);
//        programmer.setPname(pname);
//
//        mv.addObject("programmer", programmer);
//        mv.setViewName("prog");
//
//        return mv;
//    }
//    using ModelAttribute
    public String add(@ModelAttribute("prog1") Programmer programmer) {
        return "prog";
    }
}
