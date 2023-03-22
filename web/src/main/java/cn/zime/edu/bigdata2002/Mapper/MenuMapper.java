package cn.zime.edu.bigdata2002.Mapper;

import cn.zime.edu.bigdata2002.Model.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {
    @Select("select * from menu")
    public List<Menu> selectMenu();
}
