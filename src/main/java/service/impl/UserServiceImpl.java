package service.impl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserMapper userMapper;
    @Override
    public User checkUserLoginService(String uname,String pwd) {
        return userMapper.checkuserLoginDao(uname,pwd);
    }


    @Override
    public int updPwd(String newPwd, int id) {
        return userMapper.updPwd(newPwd,id);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int insUser(HttpServletRequest req) {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String ssex="";
        int sex = (Integer)Integer.parseInt(req.getParameter("sex"));
        if(sex==1){
            ssex ="男";
        }else{
            ssex="女";
        }
        int age;
        if (req.getParameter("age").equals("")){
            age = 0;
        }else {
            age = Integer.parseInt(req.getParameter("age"));
        }
        String birth = req.getParameter("birth");
        System.out.println(birth);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try {
            d = new Date((format.parse(birth)).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User u = new User(0,uname,pwd,ssex,age,d);


        return userMapper.insUser(u);
    }
}
