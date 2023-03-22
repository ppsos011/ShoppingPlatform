package cn.zime.edu.bigdata2002.Service;

import cn.zime.edu.bigdata2002.Mapper.BookNewsMapper;
import cn.zime.edu.bigdata2002.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookNewsService {
    @Autowired
    BookNewsMapper bookNewsMapper;
    public List<Book> selectBookNews(){
        return bookNewsMapper.selectBookNews();
    }
}

