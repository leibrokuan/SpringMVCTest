package service;

import org.springframework.stereotype.Service;
import pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    public User checkUserLoginService(String uname,String pwd);

    int updPwd(String newPwd, int id);

    List<User> getUserList();

    int insUser(HttpServletRequest req);
}
