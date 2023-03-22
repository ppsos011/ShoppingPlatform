package cn.zime.edu.bigdata2002.Mapper;

import cn.zime.edu.bigdata2002.Model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface BookNewsMapper {
    //查询地址语句
    @Select("select * from booknews")
    public List<Book> selectBookNews();
}
