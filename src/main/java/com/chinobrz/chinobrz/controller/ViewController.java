package com.chinobrz.chinobrz.controller;

import com.chinobrz.chinobrz.util.Constans;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ViewController {

    @GetMapping("")
    public String redirect() {
        return "redirect:/home";
    }

    @GetMapping("home")
    public ModelAndView home() {
        ModelAndView mov = new ModelAndView(Constans.VIEW_INDEX);
        mov.addObject("title", "Chino Brasa");
        return mov;
    }

    @GetMapping("about")
    public ModelAndView about() {
        ModelAndView mov = new ModelAndView(Constans.VIEW_ABOUT);
        mov.addObject("title", "Chino Brasa");
        return mov;
    }

    @GetMapping("service")
    public ModelAndView service() {
        ModelAndView mov = new ModelAndView(Constans.VIEW_SERVICE);
        mov.addObject("title", "Chino Brasa");
        return mov;
    }

    @GetMapping("contact")
    public ModelAndView contact() {
        ModelAndView mov = new ModelAndView(Constans.VIEW_CONTACT);
        mov.addObject("title", "Chino Brasa");
        return mov;
    }


}
