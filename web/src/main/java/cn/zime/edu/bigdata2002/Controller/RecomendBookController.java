package cn.zime.edu.bigdata2002.Controller;

import cn.zime.edu.bigdata2002.Model.RecomendBook;
import cn.zime.edu.bigdata2002.Service.RecomendBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecomendBookController {
    @Autowired
    RecomendBookService recomendBookService;

    //获取图书
    @GetMapping("/recomendbook")
    public List<RecomendBook> selectRecomendBook(){
        return recomendBookService.selectRecomendBook();
    }
}
