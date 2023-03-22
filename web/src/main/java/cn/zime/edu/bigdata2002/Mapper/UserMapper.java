package cn.zime.edu.bigdata2002.Mapper;



import cn.zime.edu.bigdata2002.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 登录
     * @param
     * @return
     */
    @Select("select * from user1")
    public List<User> getUser();
}
