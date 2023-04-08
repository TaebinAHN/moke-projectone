package moke.mokeprojectone.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MokeController {

    @RequestMapping("/main")
    public ModelAndView main () throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("reponse", "index");

        return modelAndView;
    }

    @RequestMapping("signUp")
    public ModelAndView signup() throws Exception{

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signUp");
        modelAndView.addObject("reponse", "signUp");

        return modelAndView;
    }

}
