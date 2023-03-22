package cn.zime.edu.bigdata2002.Mapper;

import cn.zime.edu.bigdata2002.Model.Bookc;
import cn.zime.edu.bigdata2002.Model.Bookd;
import cn.zime.edu.bigdata2002.Model.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("select * from book where book_id=#{book_id}")
    public List<cn.edu.zime.bigdata2002.appdemo.dao.model.BookDetail> selectBooks(String book_id);

    @Insert("insert into cartble values(#{cid},#{checkok},#{imgURL},#{info},#{price},#{count},#{total})")
    public int insertCart(Cart cart);
    @Select("select * from book_detailed where book_id=#{book_id}")
    public List<Bookd> selectBookd(String book_id);

    @Select("select * from comment where book_id=#{book_id}")
    public List<Bookc> selectBookc(String book_id);




}
