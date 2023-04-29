package cn.zime.edu.bigdata2002.Service;


import cn.zime.edu.bigdata2002.Mapper.RegisterMapper;
import cn.zime.edu.bigdata2002.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterService {

    @Autowired
    RegisterMapper registerMapper;
    /**
     * 注册
     */

    public int insertUser(User user){
        return registerMapper.insertUser(user);
    }
}
