package cn.zime.edu.bigdata2002.Mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapperXML {
    public List<cn.edu.zime.bigdata2002.appdemo.dao.model.BookDetail> selectBook();
}
