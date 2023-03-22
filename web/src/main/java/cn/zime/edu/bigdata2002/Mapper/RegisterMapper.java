package cn.zime.edu.bigdata2002.Mapper;



import cn.zime.edu.bigdata2002.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
    /**
     * 注册
     */

    @Insert("insert into user1 values(#{id},#{username},#{password},#{phonenum},#{profession})")
    public int insertUser(User user);
}
