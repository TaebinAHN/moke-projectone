package moke.mokeprojectone.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MokeController {

    @RequestMapping("/main")
    public String main() {

        return "index";
    }

    @RequestMapping("/signup")
    public String signup(){

        return "signup";
    }

}
