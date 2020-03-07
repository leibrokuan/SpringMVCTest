package controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("/login")
    public String login(@RequestParam("uname") String uname,
                        @RequestParam("pwd") String pwd,
                        HttpSession session,
                        HttpServletRequest request) {
        User user = userServiceImpl.checkUserLoginService(uname, pwd);
        if (user == null) {
            request.setAttribute("flag", 0);
            return "forward:login.jsp";
        } else {
            session.setAttribute("user", user);
            return "main/main";
        }
    }

    @RequestMapping("/changePwd")
    public String changePwd(@RequestParam("newPwd") String newPwd,
                            HttpServletRequest req,
                            HttpSession session) {
        User user = (User) session.getAttribute("user");
        int id = user.getUid();

        int i = userServiceImpl.updPwd(newPwd, id);
        if (i > 0) {
            session.setAttribute("flag", 1);
            return "forward:login.jsp";
        } else {
            return "redirect:html/error.html";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login.jsp";
    }


    @RequestMapping("/showUsers")
    public  String showUser(HttpServletRequest request){
        List<User> list =  userServiceImpl.getUserList();
        request.setAttribute("lu",list);
        return "forward:user/showUser.jsp";
    }

    @RequestMapping("/reg")
    public String reg(HttpServletRequest req ,HttpSession session){
        int i = userServiceImpl.insUser(req);
        if (i>0){
            session.setAttribute("flag",2);
            return "forward:login.jsp";
        }else {
            return "redirect:html/error.html";
        }
    }

}
