package cn.zime.edu.bigdata2002.Mapper;

import cn.zime.edu.bigdata2002.Model.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressMapper {
    //查询地址语句
    @Select("select * from address")
    public List<Address> selectAddress();

    //插入地址语句
    @Insert("insert into address values(#{id},#{name},#{number},#{favor},#{favorAuthor},#{genda},#{input},#{autograph},#{fullAddress})")
    public int insertAddress(Address address);

    //删除地址语句
    @Delete("delete from address where name=#{name} and number=#{number} and genda=#{genda} and fullAddress=#{fullAddress}")
    public int deleteAddress(String name,String number,String genda,String fullAddress);

    //更新地址语句
    @Update("update address set id=#{id},name=#{name},number=#{number},favor=#{favor},favorAuthor=#{favorAuthor},genda=#{genda},input=#{input},autograph=#{autograph},fullAddress=#{fullAddress} where id=#{id}")
    public int updateAddress(Address address);
    //    @Delete("delete from address where name=#{name}")
//    public int deleteAddress(String name);
}
