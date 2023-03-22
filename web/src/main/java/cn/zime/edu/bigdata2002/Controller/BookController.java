package cn.zime.edu.bigdata2002.Controller;

import cn.zime.edu.bigdata2002.Model.Bookc;
import cn.zime.edu.bigdata2002.Model.Bookd;
import cn.zime.edu.bigdata2002.Model.Cart;
import cn.zime.edu.bigdata2002.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/bid")
    public List<cn.edu.zime.bigdata2002.appdemo.dao.model.BookDetail> sb (@RequestParam(value = "key1") String book_id){
        return bookService.selectBooks(book_id);
    }

    @GetMapping("/addtocartd")
    public int insertCart(
            @RequestParam(value = "key0") int cid,
            @RequestParam(value = "key1") String checkok,
            @RequestParam(value = "key2") String imgURL,
            @RequestParam(value = "key3") String info,
            @RequestParam(value = "key4") String price,
            @RequestParam(value = "key5") String count,
            @RequestParam(value = "key6") String total

    ){
        return bookService.inserCart(new Cart(cid,checkok,imgURL,info,price,count,total));
    }

    @GetMapping("/did")
    public List<Bookd> db (@RequestParam(value = "key1") String book_id){
        return bookService.selectBookd(book_id);
    }

    @GetMapping("/cid")
    public List<Bookc> cb (@RequestParam(value = "key1") String book_id){

        return bookService.selectBookc(book_id);
    }
}
