package cn.zime.edu.bigdata2002.Service;


import cn.zime.edu.bigdata2002.Mapper.BookMapper;
import cn.zime.edu.bigdata2002.Model.Bookc;
import cn.zime.edu.bigdata2002.Model.Bookd;
import cn.zime.edu.bigdata2002.Model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;
    public List<cn.edu.zime.bigdata2002.appdemo.dao.model.BookDetail> selectBooks(String book_id){return bookMapper.selectBooks(book_id);}

    public int inserCart(Cart cart){
        return bookMapper.insertCart(cart);}

    public List<Bookd> selectBookd(String book_id){return bookMapper.selectBookd(book_id);}

    public List<Bookc> selectBookc(String book_id){return bookMapper.selectBookc(book_id);}

}
