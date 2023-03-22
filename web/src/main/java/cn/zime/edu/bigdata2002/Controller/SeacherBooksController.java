package cn.zime.edu.bigdata2002.Controller;


import cn.zime.edu.bigdata2002.Model.Cart;
import cn.zime.edu.bigdata2002.Model.SeacherTg;
import cn.zime.edu.bigdata2002.Service.SeacherBooksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class SeacherBooksController {

    @Autowired
    SeacherBooksService seacherBooksService;



    @GetMapping("/seacherbooks")
    //从前端接收两个值，一个是页码一个是限制数
    public Object selectBooks(@RequestParam(value = "page")Integer page,
                               @RequestParam(value = "limit")Integer limit){
        System.out.println("selectBooks"+page+limit);
        return seacherBooksService.selectBooks(page,limit);
    }

    @GetMapping("/addtocart")
    public int insertCart(
            @RequestParam(value = "key0") int cid,
            @RequestParam(value = "key1") String checkok,
            @RequestParam(value = "key2") String imgURL,
            @RequestParam(value = "key3") String info,
            @RequestParam(value = "key4") String price,
            @RequestParam(value = "key5") String count,
            @RequestParam(value = "key6") String total

    ){
        return seacherBooksService.inserCart(new Cart(cid,checkok,imgURL,info,price,count,total));
    }


    @GetMapping("/seacherTg")
    public List<SeacherTg> selectTg(){
        return seacherBooksService.selectTg();
    }

//
//    @GetMapping("/getBooks")
//    public List<SeacherBooks> selectBooks2(@RequestParam(value = "key1") String key1){
//        System.out.println(key1);
//
//        return seacherBooksService.selectBooks2(key1);
//    }


}
