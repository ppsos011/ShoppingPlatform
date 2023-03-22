package cn.zime.edu.bigdata2002.Mapper;

import cn.zime.edu.bigdata2002.Model.RecomendBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecomendBookMapper {
    //查询地址语句
    @Select("select * from recomendbook")
    public List<RecomendBook> selectRecomendBook();
}
