package org.example.springbootmvc;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/add")
//    or, public String add(int num1, int num2, Model model){}
//    or, public String add(HttpServletRequest req, HttpSession session){session.setAttribute()}
    public ModelAndView add(@RequestParam("num1") int num, @RequestParam("num2") int num2, ModelAndView mv) {

        int result = num + num2;

        mv.addObject("result", result);
        mv.setViewName("result");

        return mv;
    }
}
