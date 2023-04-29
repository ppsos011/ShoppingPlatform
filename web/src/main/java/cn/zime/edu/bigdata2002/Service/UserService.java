package cn.zime.edu.bigdata2002.Service;


import cn.zime.edu.bigdata2002.Mapper.UserMapper;
import cn.zime.edu.bigdata2002.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    /**
     * 登录
     */

    public List<User> getUser(){
        return userMapper.getUser();
    }



}
