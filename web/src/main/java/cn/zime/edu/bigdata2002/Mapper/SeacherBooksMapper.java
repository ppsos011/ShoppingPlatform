package cn.zime.edu.bigdata2002.Mapper;
import cn.zime.edu.bigdata2002.Model.Cart;
import cn.zime.edu.bigdata2002.Model.SeacherBooks;
import cn.zime.edu.bigdata2002.Model.SeacherTg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Mapper
public interface SeacherBooksMapper {

    @Select("select * from seacherbook")
    public List<SeacherBooks> selectBooks();

    @Select("select * from seachertg")
    public List<SeacherTg> selectTg();


    @Select("select * from seacherbook where title like '%#｛title｝%'")
    public List<SeacherBooks> selectBooks2(String title);

    @Insert("insert into cartble values(#{cid},#{checkok},#{imgURL},#{info},#{price},#{count},#{total})")
    public int insertCart(Cart cart);


}
