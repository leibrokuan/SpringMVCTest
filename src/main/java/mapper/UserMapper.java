package mapper;

import pojo.User;

import java.util.List;

public interface UserMapper {
    public User checkuserLoginDao(String uname, String pwd);

    int updPwd(String newPwd, int id);

    List<User> getUserList();

    int insUser(User u);
}
