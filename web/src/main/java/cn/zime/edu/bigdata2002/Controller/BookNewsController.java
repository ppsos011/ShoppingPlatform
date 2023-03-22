package cn.zime.edu.bigdata2002.Controller;
import cn.zime.edu.bigdata2002.Model.Book;
import cn.zime.edu.bigdata2002.Service.BookNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BookNewsController {
    @Autowired
    BookNewsService bookNewsService;

    //获取图书
    @GetMapping("/book")
    public List<Book> selectBookNews(){
        return bookNewsService.selectBookNews();
    }

}
