package moke.mokeprojectone.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moke.mokeprojectone.service.UserService;
import moke.mokeprojectone.vo.UserVo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    private final SessionController sessionController;

    // 회원가입 페이지 호출 - 안태빈
    @RequestMapping("/signUp")
    public ModelAndView signup() throws Exception{

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signUp");
        modelAndView.addObject("reponse", "signUp");

        return modelAndView;
    }

    // 회원가입 구현 - 안태빈
    @PostMapping("/signUp")
    public String joinUser(UserVo userVo){
        userService.joinUser(userVo);
        
        // 회원 가입이 끝나면 로그인 페이지를 호출하도록 수정
        return "redirect:/login";
    }

    // 회원가입 중 ID 중복체크 기능
    @ResponseBody
    @GetMapping("/idCheck")
    public int idCheck(@RequestParam("userId") String userId){

        int result = userService.idCheck(userId);

        return result;
    }

    //로그인 페이지 호출 - 안태빈
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("response","login");

        return modelAndView;
    }


    @RequestMapping("/loginUser")
    public String loginUser(@RequestBody UserVo userVo) throws Exception {

       userVo = userService.userLogin(userVo);
       log.info("userVo ID =====> ", userVo.getUserId());
       if (userVo != null) {
           return "redirect:/main";
       } else {
           return "redirect:/login";
       }
    }

/*    @RequestMapping(value = "/loginUser", method = {RequestMethod.POST})
    public String loginUser(UserVo userVo, HttpServletRequest request, RedirectAttributes redirectAttributes){

        HttpSession session = request.getSession();

        try {
            //userVo = "";
            if(userVo.getUserId() == null) {
                session.setAttribute("userId",null);
            } else {
                session.setAttribute("userID",userVo);
            }

        } catch (Exception e){

            log.info("로그인이 실패하였습니다." + e);
        }
        return "redirect:/login";
    }*/

    @PostMapping("/logOut")
    public String logOutUser(HttpServletRequest request){
        sessionController.expired(request);
        return "redirect:/main";
    }
}
