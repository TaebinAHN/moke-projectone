package moke.mokeprojectone.controller;


import lombok.RequiredArgsConstructor;
import moke.mokeprojectone.service.UserService;
import moke.mokeprojectone.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/signUp")
    public ModelAndView signup() throws Exception{

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signUp");
        modelAndView.addObject("reponse", "signUp");

        return modelAndView;
    }

    @PostMapping("/signUp")
    public String joinUser(UserVo userVo){
        userService.joinUser(userVo);
        return "index";
    }

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("response","login");

        return modelAndView;
    }

    @ResponseBody
    @GetMapping("/idCheck")
    public int idCheck(@RequestParam("userId") String userId){

       int result = userService.idCheck(userId);

       return result;
    }

}
