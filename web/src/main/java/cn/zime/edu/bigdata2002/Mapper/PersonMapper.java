package cn.zime.edu.bigdata2002.Mapper;

import cn.zime.edu.bigdata2002.Model.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonMapper {
    //查询地址语句
    @Select("select * from person")
    public List<Person> selectPerson();

    //插入地址语句
    @Insert("insert into person values(#{id},#{name},#{role},#{number},#{favor},#{favorAuthor},#{genda},#{input},#{autograph},#{fullAddress})")
    public int insertPerson(Person person);

    //删除地址语句
    @Delete("delete from person where name=#{name} and number=#{number} and genda=#{genda} and fullAddress=#{fullAddress}")
    public int deletePerson(String name,String number,String genda,String fullAddress);

    //更新地址语句
    @Update("update person set id=#{id},name=#{name},role=#{role},number=#{number},favor=#{favor},favorAuthor=#{favorAuthor},genda=#{genda},input=#{input},autograph=#{autograph},fullAddress=#{fullAddress} where id=#{id}")
    public int updatePerson(Person person);
    //    @Delete("delete from address where name=#{name}")
//    public int deleteAddress(String name);
}
